package me.kys2406.kotlinblog.hello

import io.swagger.v3.oas.annotations.Parameter
import javax.validation.constraints.Max
import javax.validation.constraints.Min
import javax.validation.constraints.Size

class HelloKotlinDTO {
    data class Request(
        @field:Parameter(
            description = "이름",
            example = "MUSINSA",
            required = true
        )
        @field:Size(min = 1, max = 10)
        val name: String,

        @field:Parameter(
            description = "나이",
            example = "10",
        )
        @field:Min(1)
        @field:Max(100)
        val age: Int?,
    )

    data class Response(
        val data: String
    )
}