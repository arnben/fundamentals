package com.vim.fundamentals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import static org.hamcrest.core.Is.is;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@SpringBootTest
class FundamentalsApplicationTests {

    private MockMvc mvc;

    @Autowired
    private WebApplicationContext webAppContext;

    @BeforeEach
    public void setUp() {
        mvc = MockMvcBuilders.webAppContextSetup(webAppContext).build();
    }

	@Test
	void testHello() throws Exception {
        mvc.perform(
                MockMvcRequestBuilders.get("/api/home").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.message", is("Hello")));
	}

	@Test
    void testAddUser() throws Exception {
        mvc.perform(
                MockMvcRequestBuilders.post("/api/user").contentType(MediaType.APPLICATION_JSON)
                        .content("{\n" +
                            "\t\"firstName\" : \"Rob\",\n" +
                            "\t\"lastName\" : \"Stark\",\n" +
                            "\t\"email\" : \"rob.stark@winterfel.com\"\n" +
                            "}"))
                .andExpect(status().isAccepted());
    }

    @Test
    void testGetAllUser() throws Exception {
        mvc.perform(
                MockMvcRequestBuilders.get("/api/user").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.users.length()" , is(1)))
                .andExpect(jsonPath("$.users[0].firstName", is("Rob")));
    }
}
