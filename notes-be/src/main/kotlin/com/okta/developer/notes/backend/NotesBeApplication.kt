package com.okta.developer.notes.backend

import com.fasterxml.jackson.annotation.JsonIgnore
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.boot.web.servlet.FilterRegistrationBean
import org.springframework.context.annotation.Bean
import org.springframework.core.Ordered
import org.springframework.core.annotation.Order
import org.springframework.web.cors.CorsConfiguration
import org.springframework.web.cors.UrlBasedCorsConfigurationSource
import org.springframework.web.filter.CorsFilter
import javax.persistence.GeneratedValue
import javax.persistence.Id

@SpringBootApplication
class NotesBeApplication

fun main(args: Array<String>) {
	runApplication<NotesBeApplication>(*args)

	@Bean
	fun simpleCorsFilter(): FilterRegistrationBean<CorsFilter> {
		val source = UrlBasedCorsConfigurationSource()
		val config = CorsConfiguration()

		val bean = FilterRegistrationBean<CorsFilter>(CorsFilter(source))
		bean.order = Ordered.HIGHEST_PRECEDENCE
		return bean
	}

}


data class Note(@Id @GeneratedValue var id: Long? = null,
				var title: String? = null,
				var text: String? = null,
				@JsonIgnore var user: String? = null)