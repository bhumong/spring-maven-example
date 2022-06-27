package com.bhumong.springkotlinmaven.model

import org.hibernate.annotations.*
import javax.persistence.*
import javax.persistence.Entity
import javax.persistence.Table

@Entity // This tells Hibernate to make a table out of this class
@Table(name = "users")
@DynamicInsert
@DynamicUpdate
data class User constructor(
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id", nullable = false, insertable = false, updatable = false)
    val id: String? = null,

    @Column(name = "name")
    var name: String? = null,

    @Column(name = "email")
    var email: String? = null,

    @Column(name = "password")
    var password: String? = null,

    @Column(name = "created_at")
    var createdAt: Long? = null,

    @Column(name = "updated_at")
    var updatedAt: Long? = null,

    @Column(name = "deleted_at")
    var deletedAt: Long? = null,
)
