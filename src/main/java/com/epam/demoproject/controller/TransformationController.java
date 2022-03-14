package com.epam.demoproject.controller;

import com.epam.demoproject.dto.ErrorResponse;
import com.epam.demoproject.dto.TransformationRequestDto;
import com.epam.demoproject.dto.TransformationResponseDto;
import com.epam.demoproject.service.TransformationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.time.LocalDateTime;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1")
public class TransformationController {

    private final TransformationService transformationService;

    @PostMapping("/transform")
    public ResponseEntity<TransformationResponseDto> transformJson(@Valid @RequestBody TransformationRequestDto requestDto) {

        TransformationResponseDto transformationResponseDto = transformationService.transform(requestDto);

        return new ResponseEntity<>(transformationResponseDto, HttpStatus.OK);
    }

    @ExceptionHandler(value = {MethodArgumentNotValidException.class})
    public ResponseEntity<ErrorResponse> handleValidationException(MethodArgumentNotValidException ex) {
        ex.printStackTrace();
        ErrorResponse errorResponse = new ErrorResponse(LocalDateTime.now().toString(), HttpStatus.BAD_REQUEST.value(),
                HttpStatus.BAD_REQUEST.getReasonPhrase(), "Items should be words in snake_case!");
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }
}
