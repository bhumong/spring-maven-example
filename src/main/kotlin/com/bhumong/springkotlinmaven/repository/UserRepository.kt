package com.bhumong.springkotlinmaven.repository

import com.bhumong.springkotlinmaven.model.User
import org.springframework.data.repository.CrudRepository

interface UserRepository: CrudRepository<User, Integer> {
}