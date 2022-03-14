package com.epam.demoproject.dto;

import com.epam.demoproject.validator.ItemsWrittenInSnakeCase;
import lombok.Data;

import java.util.Set;

@Data
public class TransformationRequestDto {

    private String name;

    @ItemsWrittenInSnakeCase
    private Set<String> items;
}