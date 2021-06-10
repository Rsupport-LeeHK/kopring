package com.example.kopring.repository

import com.example.kopring.domain.User
import com.example.kopring.logger
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.data.repository.findByIdOrNull

@DataJpaTest
internal class UserRepositoryTest @Autowired constructor(
    val userRepository: UserRepository
) {
    @Test
    fun save() {
        //given
        val user = User(username = "user-001", password = "password", name = "USER 001")

        //when
        val saveUser = userRepository.saveAndFlush(user)
        logger.debug("saveUser: $saveUser")

        //then
        Assertions.assertNotNull(saveUser.id)
    }

    @Disabled("데이터 없음")
    @Test
    fun findById() {
        //given
        val id = "user-001"

        //when
        val user = userRepository.findByIdOrNull(id)

        //then
        Assertions.assertEquals(user!!.id, id)
    }

}