package com.example.kopring

import mu.KotlinLogging
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class KopringApplication

val logger = KotlinLogging.logger {}

fun main(args: Array<String>) {
    runApplication<KopringApplication>(*args)
}
