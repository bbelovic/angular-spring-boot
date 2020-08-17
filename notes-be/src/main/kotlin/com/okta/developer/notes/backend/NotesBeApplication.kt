package com.okta.developer.notes.backend

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class NotesBeApplication

fun main(args: Array<String>) {
	runApplication<NotesBeApplication>(*args)
}
