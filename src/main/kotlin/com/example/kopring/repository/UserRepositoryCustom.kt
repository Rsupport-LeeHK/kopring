package com.example.kopring.repository

import com.example.kopring.domain.User

interface UserRepositoryCustom {
    fun selectAllUsers(): List<User>
}