package br.com.alura.forum.controller

import br.com.alura.forum.dto.TopicForm
import br.com.alura.forum.dto.TopicView
import br.com.alura.forum.dto.UpdateTopicForm
import br.com.alura.forum.service.TopicService
import jakarta.validation.Valid
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/topicos")
class TopicController(private val service: TopicService) {
    
    @GetMapping
    fun list(): List<TopicView> = service.list()
    
    @GetMapping("/{id}")
    fun getById(@PathVariable id: Long): TopicView = service.getById(id)
    
    @PostMapping
    fun create(@RequestBody @Valid topicForm: TopicForm) = service.create(topicForm)
    
    @PutMapping
    fun update(@RequestBody @Valid topicForm: UpdateTopicForm) = service.update(topicForm)
}