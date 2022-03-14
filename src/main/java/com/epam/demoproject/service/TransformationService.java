package com.epam.demoproject.service;

import com.epam.demoproject.dto.TransformationRequestDto;
import com.epam.demoproject.dto.TransformationResponseDto;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

@Component
public class TransformationService {
    private static final Pattern PATTERN = Pattern.compile("_[a-z]");
    private static final String UNDERSCORE = "_";

    public TransformationResponseDto transform(TransformationRequestDto requestDto) {
        Set<String> items = requestDto.getItems().stream()
                .map(this::snakeToCamel)
                .collect(Collectors.toSet());

        return new TransformationResponseDto(requestDto.getName(), items, System.currentTimeMillis());
    }

    private String snakeToCamel(String item) {

        while (item.contains(UNDERSCORE)) {
            item = item.replaceFirst(PATTERN.pattern(),
                    String.valueOf(Character.toUpperCase(item.charAt(item.indexOf(UNDERSCORE) + 1))));
        }

        return item;
    }
}
