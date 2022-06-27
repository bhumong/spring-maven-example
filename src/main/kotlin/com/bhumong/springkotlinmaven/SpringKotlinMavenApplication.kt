package com.bhumong.springkotlinmaven

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class SpringKotlinMavenApplication

fun main(args: Array<String>) {
	runApplication<SpringKotlinMavenApplication>(*args)
}
