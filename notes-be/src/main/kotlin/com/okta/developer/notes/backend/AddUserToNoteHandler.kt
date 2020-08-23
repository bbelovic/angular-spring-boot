package com.okta.developer.notes.backend

import org.springframework.data.rest.core.annotation.HandleBeforeCreate
import org.springframework.data.rest.core.annotation.RepositoryEventHandler
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.stereotype.Component

@Component
@RepositoryEventHandler(Note::class)
class AddUserToNoteHandler {

    @HandleBeforeCreate
    fun handleCreate(note: Note) {
        val name = SecurityContextHolder.getContext().authentication.name
        note.user = name
    }
}