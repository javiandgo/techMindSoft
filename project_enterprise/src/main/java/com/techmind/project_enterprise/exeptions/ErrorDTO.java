package com.techmind.project_enterprise.exeptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ErrorDTO {
    private LocalDateTime dateTime;
    private String message;
    private String path;
}
