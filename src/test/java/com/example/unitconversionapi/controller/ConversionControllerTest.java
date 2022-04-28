package com.example.unitconversionapi.controller;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@AutoConfigureMockMvc
class ConversionControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    void shouldReturnOk() throws Exception {

        String content = "{\"fromValue\":1.0,\"fromType\":\"kg\",\"toType\":\"g\"}";

        this.mockMvc
                .perform(
                        post("/api/convert")
                                .content(content)
                                .header(HttpHeaders.CONTENT_TYPE, "application/json")
                )
                .andExpect(status().isOk());
    }

    @Test
    void shouldReturnValidTrue() throws Exception {

        String content = "{\"fromValue\":1.0,\"fromType\":\"kg\",\"toType\":\"g\"}";

        this.mockMvc
                .perform(
                        post("/api/convert")
                                .content(content)
                                .header(HttpHeaders.CONTENT_TYPE, "application/json")
                )
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("\"valid\":true")));
    }

    @Test
    void shouldReturnResult() throws Exception {

        String content = "{\"fromValue\":1.0,\"fromType\":\"kg\",\"toType\":\"g\"}";

        this.mockMvc
                .perform(
                        post("/api/convert")
                                .content(content)
                                .header(HttpHeaders.CONTENT_TYPE, "application/json")
                )
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("\"result\":1000.0")));
    }
}