package com.example.ssedemo

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class WebsocketApplication

fun main(args: Array<String>) {
	runApplication<WebsocketApplication>(*args)
}