package ru.morkovka.openapi.test

import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer

@Configuration
@ComponentScan(basePackages = ["ru.morkovka.openapi.gen.*", "ru.morkovka.openapi.test"])
open class AppConfiguration(
) : WebMvcConfigurer {

}