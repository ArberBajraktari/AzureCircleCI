package com.example.unitconversionapi.conversion;

import org.springframework.stereotype.Service;

@Service
public class KgToGService implements ConversionService {

    @Override
    public float convert(float fromValue) {
        return fromValue * 1000f;
    }

    @Override
    public String getConversionString() {
        return "kg-to-g";
    }
}
