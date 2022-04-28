package com.example.unitconversionapi.conversion;

import org.springframework.stereotype.Service;

@Service
public class FToCService implements ConversionService {

    @Override
    public float convert(float fromValue) {
        return 5f/9f * (fromValue - 32);
    }

    @Override
    public String getConversionString() {
        return "F-to-C";
    }
}
