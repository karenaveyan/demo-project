package com.epam.demoproject.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ErrorResponse {

    private String timestamp;

    private Integer status;

    private String type;

    private String message;
}
