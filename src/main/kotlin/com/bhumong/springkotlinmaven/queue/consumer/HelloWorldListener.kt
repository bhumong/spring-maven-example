package com.bhumong.springkotlinmaven.queue.consumer

import com.bhumong.springkotlinmaven.constant.QueueChannel
import org.springframework.amqp.core.Message
import org.springframework.amqp.rabbit.annotation.RabbitListener
import org.springframework.stereotype.Component
import java.nio.charset.Charset

@Component
class HelloWorldListener {

    /**
     * this method receive message and execute.
     */
    @RabbitListener(queues = [QueueChannel.helloWorld])
    fun listenHelloWorld(message: Message) {
        val parseMessage = String(message.body, Charset.defaultCharset())
        println("listener helloWorldMessage =  $parseMessage")
    }
}