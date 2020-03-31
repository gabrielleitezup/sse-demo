package com.example.websocket

import com.example.websocket.repository.entity.Customer
import org.springframework.context.event.EventListener
import org.springframework.scheduling.annotation.EnableScheduling
import org.springframework.stereotype.Service
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter
import java.util.ArrayList


@Service
@EnableScheduling
class SSEService {
    private val emitters: ArrayList<SseEmitter> = ArrayList()

    fun addEmitter(emitter: SseEmitter) {
        emitters.add(emitter)
    }

    fun removeEmitter(emitter: SseEmitter) {
        emitters.remove(emitter)
    }

//    fun doNotify() {
//        val deadEmmiters = emitters.map { emitter ->
//            try {
//                emitter.send(SseEmitter.event().data(LocalDate.now()))
//            } catch (e: Exception) {
//                emitter
//            }
//        }
//    }

//    SseEmitter.event()
//    .data(Customer(
//    id = UUID.randomUUID().toString(),
//    date = LocalDateTime.now()
//    ))

    @EventListener
    fun doNotify(customer: Customer) {
        val deadEmitters: MutableList<SseEmitter> = ArrayList()

        emitters.forEach { emitter ->
            try {
                emitter.send(customer)
            } catch (e: Exception) {
                deadEmitters.add(emitter)
            }
        }

        emitters.removeAll(deadEmitters)
    }
}