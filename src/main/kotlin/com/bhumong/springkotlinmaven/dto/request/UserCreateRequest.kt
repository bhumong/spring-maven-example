package com.bhumong.springkotlinmaven.dto.request

import com.fasterxml.jackson.annotation.JsonProperty
import javax.validation.constraints.Email
import javax.validation.constraints.NotBlank

data class UserCreateRequest constructor(
    @field:Email(message = "invalid email")
    @JsonProperty(value = "email")
    val email: String?,

    @field:NotBlank
    @JsonProperty(value = "name")
    val name: String?,

    @field:NotBlank
    @JsonProperty(value = "password")
    val password: String?
)