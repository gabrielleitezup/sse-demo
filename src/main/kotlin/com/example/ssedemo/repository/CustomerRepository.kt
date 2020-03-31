package com.example.ssedemo.repository

import com.example.ssedemo.repository.entity.Customer
import org.springframework.data.repository.PagingAndSortingRepository
import org.springframework.stereotype.Repository

@Repository
interface CustomerRepository: PagingAndSortingRepository<Customer, String> {
}