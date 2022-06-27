package com.bhumong.springkotlinmaven.config

import com.bhumong.springkotlinmaven.constant.QueueChannel
import org.springframework.amqp.core.QueueBuilder
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class QueueConfig {
    /**
     * this bean is create new Queue Channel by using QueueBuilder.durable().
     * same as New Queue("channel name")
     */
    @Bean
    fun helloWorldQueue() = QueueBuilder
        .durable(QueueChannel.helloWorld)
        .build()
}