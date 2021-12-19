package com.farart.snippy.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class SnippetNotFoundException extends RuntimeException {
    private String message;
}
