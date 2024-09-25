package com.example.demo;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(HelloController.class)
public class HelloControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private MathOperationsService mathOperationsService;

    private ObjectMapper objectMapper;

    @BeforeEach
    public void setUp() {
        objectMapper = new ObjectMapper();
    }

    @Test
    public void testHello() throws Exception {
        mockMvc.perform(get("/hello"))
                .andExpect(status().isOk())
                .andExpect(content().string("Hello there, World!!!"));
    }

    @Test
    public void testSumList() throws Exception {
        List<Integer> numList = Arrays.asList(1, 2, 3);
        when(mathOperationsService.sumList(numList)).thenReturn(6);

        mockMvc.perform(post("/sum")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(numList)))
                .andExpect(status().isOk())
                .andExpect(content().string("6"));
    }

    @Test
    public void testDivideList() throws Exception {
        List<Integer> numList = Arrays.asList(100, 5, 2);
        when(mathOperationsService.divideList(numList)).thenReturn(10.0);

        mockMvc.perform(post("/divide")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(numList)))
                .andExpect(status().isOk())
                .andExpect(content().string("10.0"));
    }


    @Test
    public void testSubList() throws Exception {
        List<Integer> numList = Arrays.asList(10, 3, 2);
        when(mathOperationsService.subtractList(numList)).thenReturn(5);

        mockMvc.perform(post("/subract")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(numList)))
                .andExpect(status().isOk())
                .andExpect(content().string("5.0"));
    }

    @Test
    public void testMulList() throws Exception {
        List<Integer> numList = Arrays.asList(2, 3, 4);
        when(mathOperationsService.multipleList(numList)).thenReturn(24);

        mockMvc.perform(post("/multiple")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(numList)))
                .andExpect(status().isOk())
                .andExpect(content().string("24.0"));
    }
}
