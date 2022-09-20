package com.techmind.project_enterprise.dto;

import com.techmind.project_enterprise.model.RoleName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDTO {
    private Integer idEmploye;
    private  String name_employee;
    private String email_employee;
    private Integer idProfile;
    private RoleName roleName;
    private Long idEnterprise;
    private Long idTransaction;
    private Date createdAt;
    private LocalDateTime updatedAt;



}
