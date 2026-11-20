package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(HelloController.class)
@Import(GreetingService.class)
class HelloControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    void helloDefault() throws Exception {
        mvc.perform(get("/hello"))
           .andExpect(status().isOk())
           .andExpect(jsonPath("$.message").value("Hello, Raman Gaikwad!"));
    }

    @Test
    void helloWithName() throws Exception {
        mvc.perform(get("/hello").param("name", "Pune"))
           .andExpect(status().isOk())
           .andExpect(jsonPath("$.message").value("Hello, Pune!"));
    }

    @Test
    void versionEndpoint() throws Exception {
        mvc.perform(get("/version"))
           .andExpect(status().isOk())
           .andExpect(jsonPath("$.version").value("dev"));
    }
}