package com.example.kopring.domain

import au.com.console.kassava.kotlinEquals
import au.com.console.kassava.kotlinHashCode
import au.com.console.kassava.kotlinToString
import com.example.kopring.domain.base.AbstractCreateTraceableEntity
import com.example.kopring.domain.constants.ColumnSizeConstants
import org.hibernate.annotations.GenericGenerator
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity(name = "mt_company")
class Company(
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid2")
    @Column(name = "id", length = ColumnSizeConstants.UUID)
    var id: String? = null,

    @Column(length = ColumnSizeConstants.NAME)
    var name: String
): AbstractCreateTraceableEntity() {
    //json
    override fun toString() = kotlinToString(properties = toStringProperties)

    override fun equals(other: Any?) = kotlinEquals(other = other, properties = equalsAndHashCodeProperties)

    override fun hashCode() = kotlinHashCode(properties = equalsAndHashCodeProperties)

    companion object {
        private val equalsAndHashCodeProperties = arrayOf(Company::id)

        private val toStringProperties = arrayOf(
            Company::id,
            Company::name,
            Company::createdBy,
            Company::createdDate
        )
    }
}
