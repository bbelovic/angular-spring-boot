package com.okta.developer.notes.backend

import org.springframework.boot.ApplicationArguments
import org.springframework.boot.ApplicationRunner
import org.springframework.stereotype.Component

@Component
class DataInitializer(val notesRepository: NotesRepository) : ApplicationRunner {
    @Throws
    override fun run(args: ApplicationArguments?) {
        listOf("note 1", "note 2", "note 3").forEach {
            notesRepository.save(Note(title = it, user = "user"))
        }
        notesRepository.findAll().forEach { println(it) }
    }
}