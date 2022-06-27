package com.bhumong.springkotlinmaven.dto.userDto

import com.bhumong.springkotlinmaven.dto.interfaces.ToJson

class UserQueueDto: ToJson {
    override fun toJson(): String {
        return "{user: \"john\", message: \"hello world\"}"
    }
}