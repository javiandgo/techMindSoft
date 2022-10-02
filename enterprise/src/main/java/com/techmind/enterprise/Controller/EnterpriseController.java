package com.techmind.enterprise.Controller;

import com.techmind.enterprise.Services.ServiceEnterprise;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EnterpriseController {


    @GetMapping("/enterprise")
    public String enterprisesInfo() {
        return "Hola Mundo";
    }
}
