package com.example.ssedemo.controller

import com.example.ssedemo.repository.entity.Customer
import com.example.ssedemo.service.CustomerService
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
    fun create(): Customer {
        return customerService.create()
    }
}