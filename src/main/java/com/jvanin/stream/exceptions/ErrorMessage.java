package com.jvanin.stream.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class ErrorMessage {
    private final String error;
    private final String message;
}
