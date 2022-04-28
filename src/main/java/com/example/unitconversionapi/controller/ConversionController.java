package com.example.unitconversionapi.controller;

import com.example.unitconversionapi.conversion.ConversionService;
import com.example.unitconversionapi.dto.Request;
import com.example.unitconversionapi.dto.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@RestController
public class ConversionController {

    private final Map<String, ConversionService> servicesByConversion;

    public ConversionController(List<ConversionService> conversionServices) {
        servicesByConversion = conversionServices.stream()
                .collect(Collectors.toMap(ConversionService::getConversionString, Function.identity()));
    }

    @PostMapping("/api/convert")
    public ResponseEntity<?> convert(@Valid @RequestBody Request request) {
        ConversionService service = servicesByConversion.get(
                getConversionString(request.fromType, request.toType)
        );

        if (null == service) {
            Response response = new Response(false, 0f, request.fromValue, request.fromType, request.toType);

            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }

        Response response = new Response(true, service.convert(request.fromValue), request.fromValue, request.fromType, request.toType);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    private String getConversionString(String fromType, String toType) {
        return String.format("%s-to-%s", fromType, toType);
    }
}
