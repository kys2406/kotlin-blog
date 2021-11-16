package me.kys2406.kotlinblog.hello

import com.fasterxml.jackson.databind.ObjectMapper
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("local")
internal class HelloControllerTest {

    companion object {
        const val TEST_URL = "http://localhost:8080/api/v1/hello"
    }

    @Autowired
    lateinit var mockMvc: MockMvc

    @Autowired
    lateinit var objectMapper: ObjectMapper

    @Test
    fun `API 테스트`() {
        mockMvc.perform(
            get(TEST_URL + "/kotlin")
                .param("name", "test")
        ).andExpect(status().is2xxSuccessful)
            .andExpect {
                println(it.response.contentAsString)
//                val response = objectMapper.readValue(
//                    it.response.contentAsString,
//                    HelloDTO.Response::class.java
//                )
//                assert(response.data == "Hello test")
            }
    }
}
