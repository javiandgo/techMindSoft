package com.techmind.enterprise.Services;

import com.techmind.enterprise.Model.Employee;
import com.techmind.enterprise.Model.Profile;
import com.techmind.enterprise.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<Employee> getEmployees() {
        return userRepository.findAll();
    }

    public Employee getEmployee(Long id) throws Exception {
        Optional<Employee> employeeOptional = userRepository.findById(id);
        if(employeeOptional.isPresent()) {
            return employeeOptional.get();
        }else {
            throw new Exception("Empleado No Existe");
        }
    }

    public Employee getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public Employee saveEmployee(Employee employee_param) {

        return userRepository.save(employee_param);
    }

    public Employee putEmployee(Employee employee_param) {
        return userRepository.save(employee_param);
    }

    public Employee patchEmployee(Employee employee_param, Long id) throws Exception {
        try {
            Employee employeeBD = getEmployee(id);

            if(employee_param.getName() != null) {
                employeeBD.setName(employee_param.getName());
            }

            if (employee_param.getEmail() != null){
                employeeBD.setEmail(employee_param.getEmail());
            }

            if (employee_param.getRoleName()!= null) {
                employeeBD.setRoleName(employee_param.getRoleName());
            }

            if (employee_param.getEnterprise() != null) {
                employeeBD.setEnterprise(employee_param.getEnterprise());
            }

            if (employee_param.getProfile().getPassword() != null) {
                employeeBD.setProfilePassword(employee_param.getProfilePassword());
            }

            if (employee_param.getProfile().getUsername() != null) {
                employeeBD.setProfileUsername(employee_param.getProfileUsername());
            }

            return saveEmployee(employeeBD);

        } catch (Exception e) {
            throw new Exception("Usuario no se actualizo, porque no existe");
        }
    }

    public String deleteEmployee(Long id) {
        userRepository.deleteById(id);
        return "Usuario Eliminado Exitosamente";
    }
}
