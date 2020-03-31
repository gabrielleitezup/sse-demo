package com.example.websocket.service

import com.example.websocket.repository.entity.Customer
import com.example.websocket.repository.CustomerRepository
import org.springframework.context.ApplicationEventPublisher
import org.springframework.stereotype.Service
import java.time.LocalDateTime
import java.util.UUID

@Service
class CustomerService(
    private val customerRepository: CustomerRepository,
    private val eventPublisher: ApplicationEventPublisher
) {

    fun create(): Customer {

        val customer = Customer(
            id = UUID.randomUUID().toString(),
            date = LocalDateTime.now()
        )

        return customerRepository.save(customer)
            .also { eventPublisher.publishEvent(it) }
    }
}