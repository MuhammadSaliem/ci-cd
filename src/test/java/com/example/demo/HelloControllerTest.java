package com.example.demo;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(HelloController.class)
@SpringBootTest
public class HelloControllerTest {

    @Autowired
    private MockMvc mockMvc;

   // Mock the MathOperationsService
    @MockBean
    private MathOperationsService mathOperationsService;

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

    @Test
    public void testSumList_withPositiveNumbers() throws Exception {
        mockMvc.perform(post("/subract")
                .contentType(MediaType.APPLICATION_JSON)
                .content("[1, 2, 3, 4, 5]"))
                .andExpect(status().isOk())
                .andExpect(content().string("15.0"));
    }

    @Test
    public void testSumList_withNegativeNumbers() throws Exception {
        mockMvc.perform(post("/subract")
                .contentType(MediaType.APPLICATION_JSON)
                .content("[-1, -2, -3, -4, -5]"))
                .andExpect(status().isOk())
                .andExpect(content().string("-15.0"));
    }

    @Test
    public void testSumList_withMixedNumbers() throws Exception {
        mockMvc.perform(post("/subract")
                .contentType(MediaType.APPLICATION_JSON)
                .content("[10, -5, 3, -2]"))
                .andExpect(status().isOk())
                .andExpect(content().string("6.0"));
    }

    @Test
    public void testSumList_withEmptyList() throws Exception {
        mockMvc.perform(post("/subract")
                .contentType(MediaType.APPLICATION_JSON)
                .content("[]"))
                .andExpect(status().isOk())
                .andExpect(content().string("0.0"));
    }

    @Test
    public void testSumList_withSingleElement() throws Exception {
        mockMvc.perform(post("/subract")
                .contentType(MediaType.APPLICATION_JSON)
                .content("[5]"))
                .andExpect(status().isOk())
                .andExpect(content().string("5.0"));
    }
}
