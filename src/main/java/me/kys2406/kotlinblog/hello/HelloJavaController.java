package me.kys2406.kotlinblog.hello;

import io.swagger.v3.oas.annotations.Operation;
import org.springdoc.api.annotations.ParameterObject;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Optional;

@Validated
@RestController
@RequestMapping("/api/v1")
public class HelloJavaController {
    @Operation(
            summary = "Hello xxxx",
            description = "Hello xxxx"
    )
    @GetMapping("/hello/java")
    public HelloJavaDTO.Response hello(@ParameterObject @Valid HelloJavaDTO.Request request) {
        String result = String.format("name : %s / age : %d", request.getName(), calculateAge(request));
        return new HelloJavaDTO.Response(result);
    }

    //if 문을 활용한 Nullable Variable 다루기
    private int calculateAge(HelloJavaDTO.Request request) {
        if (request.getAge() == null) {
            return 0;
        } else {
            return request.getAge();
        }
    }

    //Optional 활용한 Nullable Variable 다루기
    private int calculateAgeWithOptional(HelloJavaDTO.Request request) {
        return Optional.ofNullable(request.getAge()).orElse(0);
    }
}
