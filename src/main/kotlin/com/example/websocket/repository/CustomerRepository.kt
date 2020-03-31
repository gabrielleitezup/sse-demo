package com.example.websocket.repository

import com.example.websocket.repository.entity.Customer
import org.springframework.data.repository.PagingAndSortingRepository
import org.springframework.stereotype.Repository

@Repository
interface CustomerRepository: PagingAndSortingRepository<Customer, String> {
}