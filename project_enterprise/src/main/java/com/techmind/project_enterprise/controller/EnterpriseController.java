package com.techmind.project_enterprise.controller;

import com.techmind.project_enterprise.dto.EnterpriseDTO;
import com.techmind.project_enterprise.dto.ProfileDTO;
import com.techmind.project_enterprise.exeptions.ModelNotFoundException;
import com.techmind.project_enterprise.model.Enterprise;
import com.techmind.project_enterprise.model.Profile;
import com.techmind.project_enterprise.service.IEnterpriseService;
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
@RequestMapping("/enterprises")
public class EnterpriseController {
    @Autowired
    private IEnterpriseService service;
    @Autowired
    @Qualifier("enterpriseMapper")
    private ModelMapper mapper;

    @GetMapping
    public ResponseEntity<List<EnterpriseDTO>> readAll() throws Exception {
        List<EnterpriseDTO> list = service.readAll().stream()
                .map(c -> mapper.map(c, EnterpriseDTO.class))
                .collect(Collectors.toList());
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<EnterpriseDTO> created(@Valid @RequestBody EnterpriseDTO enterpriseDto) throws Exception {
        Enterprise ent = service.create(mapper.map(enterpriseDto, Enterprise.class));
        EnterpriseDTO dto = mapper.map(ent,EnterpriseDTO.class);
        return new ResponseEntity<>(dto,HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EnterpriseDTO> readById(@PathVariable("id") Long id) throws Exception {
        Enterprise ent = service.readById(id);
        if (ent == null) {
            throw new ModelNotFoundException("id N°" + id + "No fue encontrado");
        }
        EnterpriseDTO dto = mapper.map(ent, EnterpriseDTO.class);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }
    @PutMapping
    public ResponseEntity<EnterpriseDTO> update(@Valid @RequestBody EnterpriseDTO enterpriseDto) throws Exception{
        Enterprise ent = service.readById(enterpriseDto.getIdEnterprise());
        if(ent== null){
            throw new ModelNotFoundException(" id no encontrado: "  +enterpriseDto.getIdEnterprise());
        }
        Enterprise enterprise = service.update(mapper.map(enterpriseDto, Enterprise.class));
        EnterpriseDTO dto = mapper.map(enterprise, EnterpriseDTO.class);
        return  new ResponseEntity<>(dto,HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void>delete(@PathVariable("id")Long id) throws Exception{
        Enterprise ent =service.readById(id);
        if(ent==null) {
            throw new ModelNotFoundException("id no encontrado " + id);
        }
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
