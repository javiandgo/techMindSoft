package com.techmind.project_enterprise.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProfileDTO {
    private Integer idProfile;
    private String image;
    private String phone;
    private Date createdAt;
    private LocalDateTime updateAt;
}
