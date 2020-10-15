package com.okta.developer.notes.backend

import com.fasterxml.jackson.annotation.JsonIgnore
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import javax.persistence.*
import javax.persistence.GenerationType.SEQUENCE

@SpringBootApplication
class NotesBeApplication

fun main(args: Array<String>) {
	runApplication<NotesBeApplication>(*args)
}

@Entity @Table(name = "notes")
data class Note(@Id @GeneratedValue(strategy = SEQUENCE, generator = "notes_id_seq")
				@SequenceGenerator(name = "notes_id_seq", sequenceName = "notes_id_seq", allocationSize = 1)
				var id: Long? = null,
				var title: String? = null,
				var text: String? = null,
				@JsonIgnore @Column(name = "username") var user: String? = null)