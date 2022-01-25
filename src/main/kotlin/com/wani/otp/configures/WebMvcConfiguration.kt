package com.wani.otp.configures

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.converter.HttpMessageConverter
import org.springframework.web.servlet.config.annotation.EnableWebMvc
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer
import org.springframework.web.servlet.view.json.MappingJackson2JsonView

@Configuration
@EnableWebMvc
class WebMvcConfiguration : WebMvcConfigurer {

    @Bean(name = ["jsonView"])
    fun mappingJackson2JsonView(): MappingJackson2JsonView {
        val mappingJackson2JsonView = MappingJackson2JsonView()
        mappingJackson2JsonView.contentType = "application/json;charset=UTF-8"
        return mappingJackson2JsonView
    }

    override fun addResourceHandlers(registry: ResourceHandlerRegistry) {
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/")
        registry.addResourceHandler("/css/**").addResourceLocations("classpath:/static/css/")
        registry.addResourceHandler("/js/**").addResourceLocations("classpath:/static/js/")
        registry.addResourceHandler("/images/**").addResourceLocations("classpath:/static/images/")
    }

    override fun configureMessageConverters(converters: MutableList<HttpMessageConverter<*>>) {
        super.configureMessageConverters(converters)
    }
}