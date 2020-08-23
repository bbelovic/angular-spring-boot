package com.okta.developer.notes.backend

import com.fasterxml.jackson.annotation.JsonIgnore
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import javax.persistence.GeneratedValue
import javax.persistence.Id

@SpringBootApplication
class NotesBeApplication

fun main(args: Array<String>) {
	runApplication<NotesBeApplication>(*args)
}


data class Note(@Id @GeneratedValue var id: Long? = null,
				var title: String? = null,
				var text: String? = null,
				@JsonIgnore var user: String? = null)