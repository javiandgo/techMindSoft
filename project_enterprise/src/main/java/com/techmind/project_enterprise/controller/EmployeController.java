package com.techmind.project_enterprise.controller;

import com.techmind.project_enterprise.dto.EmployeeDTO;
import com.techmind.project_enterprise.dto.EnterpriseDTO;
import com.techmind.project_enterprise.dto.ProfileDTO;
import com.techmind.project_enterprise.exeptions.ModelNotFoundException;
import com.techmind.project_enterprise.model.Employee;
import com.techmind.project_enterprise.model.Enterprise;
import com.techmind.project_enterprise.service.IEmployeService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/employees")
public class EmployeController {
    @Autowired
    private IEmployeService service;

    @Autowired
    @Qualifier("employeeMapper")
    private ModelMapper mapper;

    @GetMapping
    public ResponseEntity<List<EmployeeDTO>> readAll() throws Exception {
        List<EmployeeDTO> list = service.readAll().stream()
                .map(c -> mapper.map(c, EmployeeDTO.class))
                .collect(Collectors.toList());
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<EmployeeDTO> create(@Valid @RequestBody EmployeeDTO employeeDto) throws Exception{
        Employee emp = service.create(mapper.map(employeeDto, Employee.class));
        EmployeeDTO dto = mapper.map(emp,EmployeeDTO.class);
        return new ResponseEntity<>(dto,HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmployeeDTO> readById(@PathVariable("id")Integer id) throws Exception {
        Employee emp = service.readById(id);
        if(emp==null){
            throw new ModelNotFoundException("Id no encontrado " + id );
        }
        EmployeeDTO dto = mapper.map(emp,EmployeeDTO.class);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }
    @PutMapping
    public ResponseEntity<EmployeeDTO> update(@Valid@RequestBody EmployeeDTO employeeDto) throws Exception{
        Employee emp = service.readById(employeeDto.getIdEmploye());
        if (emp==null){
            throw new ModelNotFoundException("Id no encontrado " + employeeDto.getIdEmploye());
        }
        Employee employee= service.update(mapper.map(employeeDto, Employee.class));
        EmployeeDTO dto = mapper.map(emp,EmployeeDTO.class);
        return new ResponseEntity<>(dto,HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) throws Exception{
        Employee employee = service.readById(id);
        if(employee==null){
            throw new ModelNotFoundException("Id no encontrado. " + id);
        }
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }
}
