package com.bhumong.springkotlinmaven.controller

import com.bhumong.springkotlinmaven.constant.QueueChannel
import com.bhumong.springkotlinmaven.dto.request.UserCreateRequest
import com.bhumong.springkotlinmaven.dto.userDto.UserQueueDto
import com.bhumong.springkotlinmaven.model.User
import com.bhumong.springkotlinmaven.queue.QueuePushService
import com.bhumong.springkotlinmaven.repository.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.*
import java.util.*
import javax.validation.Valid


@Controller // This means that this class is a Controller
@RequestMapping(path = ["/users"]) // This means URL's start with /demo (after Application path)
class UserController @Autowired constructor(
    private val queuePushService: QueuePushService
) {
    @Autowired // This means to get the bean called userRepository
    // Which is auto-generated by Spring, we will use it to handle the data
    private lateinit var userRepository: UserRepository

    @PostMapping // Map ONLY POST Requests
    @ResponseBody
    fun add(
        @Valid @RequestBody userCreateRequest: UserCreateRequest
    ): String {
        if (userCreateRequest.email?.isBlank() == true) {
            return "gagal validasi"
        }
        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request
        val user = User(
            name = userCreateRequest.name,
            email = userCreateRequest.email,
            password = userCreateRequest.password,
            createdAt = Date().time
        )
        userRepository.save<User>(user)
        // this trigger message by pushing message to channel
        queuePushService.push(QueueChannel.helloWorld, UserQueueDto())
        return "Saved"
    }

    // This returns a JSON or XML with the users
    @ResponseBody
    @GetMapping
    fun all(): Iterable<Any> = userRepository.findAll()
}