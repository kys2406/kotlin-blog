package me.kys2406.kotlinblog.hello.kotlin

import io.swagger.v3.oas.annotations.Operation
import org.springdoc.api.annotations.ParameterObject
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid

@Validated
@RestController
@RequestMapping("/api/v1")
class HelloKotlinController {

    @Operation(
        summary = "Hello xxxx",
        description = "Hello xxxx"
    )
    @GetMapping("/hello/kotlin")
    fun hello(
        @ParameterObject
        @Valid request: HelloKotlinDTO.Request
    ): HelloKotlinDTO.Response {
        val result = "name : ${request.name} / age : ${request.calculateAge()}"
        return HelloKotlinDTO.Response(result)
    }

    //Elvis Operator를 활용한 age 계산하는 Extension Function
    fun HelloKotlinDTO.Request.calculateAge() = age ?: 0
}

