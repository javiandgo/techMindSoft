package com.techmind.project_enterprise.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EnterpriseDTO {
    private Long idEnterprise;
    private String name_enterprise;
    private Integer nit_enterprise;
    private String address_enterprise;
    private Integer phone_enterprise;
    private Date createdAt;
    private LocalDateTime updatedAt;
}
