package com.example.websocket

import com.example.websocket.repository.entity.Customer
import com.example.websocket.service.CustomerService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
class CustomerController(
    private val customerService: CustomerService
) {

    @PostMapping("/customer")
    @ResponseStatus(HttpStatus.CREATED)
    fun create(): Customer{
        return customerService.create()
    }
}