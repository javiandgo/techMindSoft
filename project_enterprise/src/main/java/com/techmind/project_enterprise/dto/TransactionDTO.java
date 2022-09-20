package com.techmind.project_enterprise.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransactionDTO {
    private Long idTransaction;
    private String concept_transaction;
    private Float amount_transaction;
    private Long idEnterprise;
    private Date createdAt;
    private LocalDateTime updatedAt;

}
