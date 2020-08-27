package com.okta.developer.notes.backend

import org.springframework.security.core.annotation.AuthenticationPrincipal
import org.springframework.security.oauth2.core.oidc.user.OidcUser
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import java.security.Principal

@RestController
class UserController(val notesRepository: NotesRepository) {
    @GetMapping("/user/notes")
    fun userNotes(principal: Principal): List<Note> {
        return notesRepository.findAllByUser(principal.name)
    }

    @GetMapping("/user")
    fun user(@AuthenticationPrincipal user: OidcUser) = user
}