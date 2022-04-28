package com.example.unitconversionapi.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class Request {

    @NotNull
    public float fromValue;

    @NotBlank
    public String fromType;

    @NotBlank
    public String toType;
}
