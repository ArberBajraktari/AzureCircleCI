package com.example.unitconversionapi.conversion;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class KgToGServiceTest {

    @Autowired
    KgToGService kgToGService;

    @Test
    void testConvert() {
        assertEquals(1000f, kgToGService.convert(1f));
    }
}