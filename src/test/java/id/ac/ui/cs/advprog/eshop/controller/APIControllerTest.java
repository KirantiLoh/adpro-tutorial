package id.ac.ui.cs.advprog.eshop.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import org.apache.hc.core5.http.HttpStatus;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.AutoConfigureJsonTesters;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import static org.junit.jupiter.api.Assertions.assertEquals;

@AutoConfigureJsonTesters
@WebMvcTest(APIController.class)
class APIControllerTest {

        @Autowired
        private MockMvc mockMvc;

        @Test
        void canGetHomePage() throws Exception {
                MockHttpServletResponse response = mockMvc.perform(
                                get("/"))
                                .andReturn().getResponse();
                assertEquals(HttpStatus.SC_OK, response.getStatus());
        }
}