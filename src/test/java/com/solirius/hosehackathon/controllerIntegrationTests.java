package com.solirius.hosehackathon;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(classes = HoSeHackathonApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
class controllerIntegrationTests {

    private static final String ROOT_CONTROLLER_RESPONSE = "Welcome to the office locator service";

    @Autowired
    private transient MockMvc mockMvc;

    @DisplayName("Should send a message upon root request with 200 response code")
    @Test
    void welcomeRootEndpoint() throws Exception {
        MvcResult response = mockMvc.perform(get("/"))
                .andExpect(status().isOk()).andReturn();
        assertEquals(ROOT_CONTROLLER_RESPONSE, response.getResponse().getContentAsString());
    }

    @DisplayName("Should return not and 404 when sent to find endpoint with no data in it")
    @Test
    void findEndpoint() throws Exception{
        MvcResult response = mockMvc.perform(get("/offices/find/")
                .param("latitude", "55.4432")
                .param("longitude", "-1.3453"))
                .andExpect(status().isNotFound()).andReturn();
        assertTrue(response.getResponse().getContentAsString().contains("No offices have been found"));
    }
}
