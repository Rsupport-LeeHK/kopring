package com.example.kopring.repository

import com.example.kopring.domain.QUser.user
import com.example.kopring.domain.User
import com.querydsl.jpa.impl.JPAQueryFactory

class UserRepositoryImpl(
    private val jpaQueryFactory: JPAQueryFactory
): UserRepositoryCustom {

    override fun selectAllUsers(): List<User> {
        return jpaQueryFactory.selectFrom(user)
            .orderBy(user.name.asc())
            .fetch()
    }

}