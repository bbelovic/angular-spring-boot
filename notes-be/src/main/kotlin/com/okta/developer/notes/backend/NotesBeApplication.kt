package com.okta.developer.notes.backend

import com.fasterxml.jackson.annotation.JsonIgnore
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.boot.web.servlet.FilterRegistrationBean
import org.springframework.context.annotation.Bean
import org.springframework.core.Ordered
import org.springframework.web.cors.CorsConfiguration
import org.springframework.web.cors.UrlBasedCorsConfigurationSource
import org.springframework.web.filter.CorsFilter
import javax.persistence.*
import javax.persistence.GenerationType.SEQUENCE

@SpringBootApplication
class NotesBeApplication {
	@Bean
	fun simpleCorsFilter(): FilterRegistrationBean<CorsFilter> {
		val source = UrlBasedCorsConfigurationSource()
		val config = CorsConfiguration()
		config.allowCredentials = true
		config.allowedOrigins = listOf("http://localhost:4200")
		config.allowedHeaders = listOf("*")
		config.allowedMethods = listOf("*")
		source.registerCorsConfiguration("/**", config)
		val bean = FilterRegistrationBean<CorsFilter>(CorsFilter(source))
		bean.order = Ordered.HIGHEST_PRECEDENCE
		return bean
	}
}

fun main(args: Array<String>) {
	runApplication<NotesBeApplication>(*args)
}

@Entity
data class Note(@Id @GeneratedValue(strategy = SEQUENCE, generator = "note_id_seq")
				@SequenceGenerator(name = "note_id_seq", sequenceName = "note_id_seq", allocationSize = 1)
				var id: Long? = null,
				var title: String? = null,
				var text: String? = null,
				@JsonIgnore @Column(name = "username") var user: String? = null)