package com.epam.demoproject.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Set;

@AllArgsConstructor
@Data
public class TransformationResponseDto {

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String name;

    private Set<String> items;

    private Long timeStamp;
}
