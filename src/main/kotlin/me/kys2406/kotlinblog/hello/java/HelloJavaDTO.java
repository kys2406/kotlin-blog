package me.kys2406.kotlinblog.hello.java;

import io.swagger.v3.oas.annotations.Parameter;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

public class HelloJavaDTO {
    public static class Request {
        @Parameter(
                description = "이름",
                example = "MUSINSA",
                required = true
        )
        @Size(min = 1, max = 10)
        private String name;

        @Parameter(
                description = "나이",
                example = "10"
        )
        @Min(1)
        @Max(100)
        private Integer age;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }
    }

    public static class Response {
        private String data;

        public Response(String data) {
            this.data = data;
        }

        public String getData() {
            return data;
        }

        public void setData(String data) {
            this.data = data;
        }
    }
}
