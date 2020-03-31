package com.example.ssedemo.controller

import com.example.ssedemo.service.SSEService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter


@Controller
class SSEController(
    private val sseService: SSEService
) {

    @GetMapping("/notification")
    fun doNotify(): ResponseEntity<SseEmitter> {
        val emitter =  SseEmitter(900_000L)

        sseService.addEmitter(emitter)

        emitter.onCompletion { sseService.removeEmitter(emitter) }
        emitter.onTimeout { sseService.removeEmitter(emitter) }

        return ResponseEntity(emitter, HttpStatus.OK)
    }
}