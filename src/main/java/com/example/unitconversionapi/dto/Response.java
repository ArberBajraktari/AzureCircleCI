package com.example.unitconversionapi.dto;

public class Response {

    public boolean valid;

    public float result;

    public float fromValue;

    public String fromType;

    public String toType;

    public Response() {
    }

    public Response(boolean valid, float result, float fromValue, String fromType, String toType) {
        this.valid = valid;
        this.result = result;
        this.fromValue = fromValue;
        this.fromType = fromType;
        this.toType = toType;
    }
}
