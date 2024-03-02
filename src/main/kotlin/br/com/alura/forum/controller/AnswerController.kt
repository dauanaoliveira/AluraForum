package br.com.alura.forum.controller

import br.com.alura.forum.model.Answer
import br.com.alura.forum.service.AnswerService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/respostas")
class AnswerController(private val service: AnswerService) {
    
    @GetMapping("/topico/{topicId}")
    fun getAnswersById(@PathVariable topicId: Long): List<Answer> = service.getAnswersByTopicId(topicId)
}