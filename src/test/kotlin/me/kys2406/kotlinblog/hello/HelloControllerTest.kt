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
    fun `java_API 테스트`() {
        mockMvc.perform(
            get("$TEST_URL/java")
                .param("name", "MUSINSA")
        ).andExpect(status().is2xxSuccessful)
            .andExpect {
                println(it.response.contentAsString)
                val response = objectMapper.readValue(
                    it.response.contentAsString,
                    HelloKotlinDTO.Response::class.java
                )
                assert(response.data.isNotEmpty())
            }
    }

    @Test
    fun `kotlin_API 테스트`() {
        mockMvc.perform(
            get("$TEST_URL/kotlin")
                .param("name", "MUSINSA")
        ).andExpect(status().is2xxSuccessful)
            .andExpect {
                println(it.response.contentAsString)
                val response = objectMapper.readValue(
                    it.response.contentAsString,
                    HelloKotlinDTO.Response::class.java
                )
                assert(response.data.isNotEmpty())
            }
    }

    @Test
    fun `java_API 실패_테스트`() {
        mockMvc.perform(
            get("$TEST_URL/java")
                .param("name", "MUSINSA KOTLIN")
        ).andExpect(status().is4xxClientError)
    }

    @Test
    fun `kotlin_API 실패_테스트`() {
        mockMvc.perform(
            get("$TEST_URL/kotlin")
                .param("name", "MUSINSA KOTLIN")
        ).andExpect(status().is4xxClientError)
    }
}
