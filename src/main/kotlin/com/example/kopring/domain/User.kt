package com.example.kopring.domain

import au.com.console.kassava.kotlinEquals
import au.com.console.kassava.kotlinHashCode
import au.com.console.kassava.kotlinToString
import com.example.kopring.domain.base.AbstractCreateTraceableEntity
import com.example.kopring.domain.constants.ColumnSizeConstants
import com.fasterxml.jackson.databind.ObjectMapper
import org.hibernate.annotations.GenericGenerator
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity(name = "mt_user")
class User(
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid2")
    @Column(name = "id", length = ColumnSizeConstants.UUID)
    var id: String? = null,

    @Column(name = "username", length = ColumnSizeConstants.USERNAME, unique = true)
    var username: String,

    @Column(length = ColumnSizeConstants.PASSWORD)
    var password: String,

    @Column(length = ColumnSizeConstants.NAME)
    var name: String,

    @Column(name = "enabled")
    var enabled: Boolean? = true
): AbstractCreateTraceableEntity() {
    @Column(length = ColumnSizeConstants.PHONE)
    var mobile: String? = null

    @Column(name="init_password")
    var initPassword: Boolean? = false

    //json
    override fun toString() = kotlinToString(properties = toStringProperties)

    override fun equals(other: Any?) = kotlinEquals(other = other, properties = equalsAndHashCodeProperties)

    override fun hashCode() = kotlinHashCode(properties = equalsAndHashCodeProperties)

    companion object {
        private val equalsAndHashCodeProperties = arrayOf(User::id)

        private val toStringProperties = arrayOf(
            User::id,
            User::username,
            User::name,
            User::enabled,
            User::mobile,
            User::initPassword,
            User::createdBy,
            User::createdDate
        )
    }
}