package com.example.sidarta.at.poc.res_tutorial

import org.springframework.context.annotation.Configuration
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer

@Configuration
class ApplicationWebConfig : WebMvcConfigurer {

    override fun addViewControllers(registry: ViewControllerRegistry) {
        registry!!.addViewController("/graphiql").setViewName(
                "forward:/graphiql/index.html")
    }
}