package com.example.kopring.domain

import com.example.kopring.logger
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class UserTest {

    @Test
    fun toStringTest() {
        //given
        val user = User(username = "user-001", password = "password", name = "USER 001")

        //when
        logger.debug(user.toString())

        //expect
        assertEquals(user.toString(),
            "User(id=${user.id}, username=${user.username}, name=${user.name}, enabled=${user.enabled}, mobile=${user.mobile}, initPassword=${user.initPassword}, createdBy=${user.createdBy}, createdDate=${user.createdDate}, company=${user.company})")
    }

    @Test
    fun `equalsTest - id가 같으면 같은 객체`() {
        //given
        val userId = "user-001"

        val user1 = User(userId, "USER-001", "password1", "USER 001")
        val user2 = User(userId, "USER-002", "password2", "USER 002")

        //expect
        assertEquals(user1, user2)
    }

}