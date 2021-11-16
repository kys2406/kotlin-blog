package me.kys2406.kotlinblog.hello

import io.swagger.v3.oas.annotations.Parameter
import javax.validation.constraints.Max
import javax.validation.constraints.Min
import javax.validation.constraints.Size

class HelloKotlinDTO {
    data class Request(
        @Parameter(
            description = "이름",
            example = "MUSINSA",
            required = true
        )
        @Size(min = 1, max = 10)
        val name: String,

        @Parameter(
            description = "나이",
            example = "10",
        )
        @Min(1)
        @Max(100)
        val age: Int?,
    )

    data class Response(
        val data: String
    )
}