package com.example.demo;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(HelloController.class)
public class HelloControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testHello() throws Exception {
        // Test the /hello endpoint
        mockMvc.perform(get("/hello"))
                .andExpect(status().isOk())
                .andExpect(content().string("Hello there, World!!!"));
    }

    @Test
    public void testSumList() throws Exception {
        // Test with a normal list of integers
        String requestBody = "[1, 2, 3, 4, 5]";
        mockMvc.perform(post("/sum")
                .contentType(MediaType.APPLICATION_JSON)
                .content(requestBody))
                .andExpect(status().isOk())
                .andExpect(content().string("15")); // Expected sum: 1 + 2 + 3 + 4 + 5

        // Test with an empty list
        requestBody = "[]";
        mockMvc.perform(post("/sum")
                .contentType(MediaType.APPLICATION_JSON)
                .content(requestBody))
                .andExpect(status().isOk())
                .andExpect(content().string("0")); // Expected sum: 0

        // Test with a list containing negative numbers
        requestBody = "[-1, -2, -3]";
        mockMvc.perform(post("/sum")
                .contentType(MediaType.APPLICATION_JSON)
                .content(requestBody))
                .andExpect(status().isOk())
                .andExpect(content().string("-6")); // Expected sum: -1 + -2 + -3

        // Test with a list containing mixed numbers
        requestBody = "[-1, 2, 3]";
        mockMvc.perform(post("/sum")
                .contentType(MediaType.APPLICATION_JSON)
                .content(requestBody))
                .andExpect(status().isOk())
                .andExpect(content().string("4")); // Expected sum: -1 + 2 + 3
    }
}
