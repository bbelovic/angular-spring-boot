package com.okta.developer.notes.backend

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.rest.core.annotation.RepositoryRestResource

@RepositoryRestResource
interface NotesRepository : JpaRepository<Note, Long>