package com.bhumong.springkotlinmaven.queue

import com.bhumong.springkotlinmaven.dto.interfaces.ToJson
import org.springframework.amqp.core.Message
import org.springframework.amqp.rabbit.core.RabbitTemplate
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class QueuePushService @Autowired constructor(
    private val rabbitTemplate: RabbitTemplate
) {
    /**
     * this method push message to channel
     */
    fun push(queueName: String, data: ToJson): Boolean {
        return try {
            rabbitTemplate.convertAndSend(queueName, data.toJson())
            true
        } catch (ex: Exception) {
            false
        }
    }

    fun pushByExchange(exchangeName: String, data: ToJson, routingKey: String): Boolean {
        return try {
            rabbitTemplate.convertAndSend(exchangeName, routingKey, data.toJson())
            true
        } catch (ex: Exception) {
            false
        }
    }

    fun sendMessage(exchangeName: String, routingKey: String, message: Message): Boolean {
        return try {
            rabbitTemplate.send(exchangeName, routingKey, message)
            true
        } catch (ex: Exception) {
            false
        }
    }
}