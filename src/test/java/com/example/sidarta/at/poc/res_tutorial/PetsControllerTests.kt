package com.example.sidarta.at.poc.res_tutorial

import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.context.junit4.SpringRunner
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders

import org.springframework.test.web.servlet.result.MockMvcResultMatchers.content
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

@RunWith(SpringRunner::class)
@SpringBootTest
@AutoConfigureMockMvc
class PetsControllerTests {
    @Autowired
    private val mvc: MockMvc? = null

    @Test
    @Throws(Exception::class)
    fun getPets() {
        mvc!!.perform(MockMvcRequestBuilders.get("/pets").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk)
    }

    @Test
    @Throws(Exception::class)
    fun getPetById() {
        mvc!!.perform(MockMvcRequestBuilders.get("/pets/{id}", "5bae7685ae0bb91171219a06")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk)
                //better ways to check for json responses
                .andExpect(content().string("{\"_id\":\"5bae7685ae0bb91171219a06\",\"name\":\"spot\",\"species\":\"dog\",\"breed\":\"pitbull\"}"))
    }

    /**
     * plenty of other important checks to do. This is just a POC to demostrate the basics
     */
}
