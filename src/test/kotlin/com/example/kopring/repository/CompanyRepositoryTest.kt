package com.example.kopring.repository

import com.example.kopring.config.JpaConfig
import com.example.kopring.domain.Company
import com.example.kopring.logger
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.context.annotation.Import

@DataJpaTest
@Import(JpaConfig::class)
internal class CompanyRepositoryTest @Autowired constructor(
    val companyRepository: CompanyRepository
){

    @Test
    fun save() {
        //given
        val company = Company(name = "company")

        //when
        val saveCompany = companyRepository.saveAndFlush(company)
        logger.debug("saveCompany: $saveCompany")

        //then
        Assertions.assertNotNull(saveCompany.id)
    }

}