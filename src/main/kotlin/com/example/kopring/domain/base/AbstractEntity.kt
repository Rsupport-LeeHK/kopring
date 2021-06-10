package com.example.kopring.domain.base

import com.example.kopring.domain.constants.ColumnSizeConstants
import org.springframework.data.annotation.CreatedBy
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.jpa.domain.support.AuditingEntityListener
import java.time.LocalDateTime
import javax.persistence.Column
import javax.persistence.EntityListeners
import javax.persistence.MappedSuperclass

@MappedSuperclass
@EntityListeners(AuditingEntityListener::class)
abstract class AbstractEntity {
    abstract override fun toString(): String
    abstract override fun equals(other: Any?): Boolean
    abstract override fun hashCode(): Int
}

@MappedSuperclass
@EntityListeners(AuditingEntityListener::class)
abstract class AbstractCreateTimestampEntity: AbstractEntity() {
    @Column(name = "created_date", insertable = true, updatable = false)
    @CreatedDate
    var createdDate: LocalDateTime? = null
}

@MappedSuperclass
@EntityListeners(AuditingEntityListener::class)
abstract class AbstractCreateTraceableEntity: AbstractCreateTimestampEntity() {
    @Column(name = "created_by", insertable = true, updatable = false, length = ColumnSizeConstants.UUID)
    @CreatedBy
    var createdBy: String? = null
}

