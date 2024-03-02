package br.com.alura.forum.controller

import br.com.alura.forum.dto.AnswerForm
import br.com.alura.forum.dto.AnswerView
import br.com.alura.forum.service.AnswerService
import jakarta.validation.Valid
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/respostas")
class AnswerController(private val service: AnswerService) {
    
    @GetMapping
    fun list(): List<AnswerView> = service.list()
    
    @GetMapping("/topico/{topicId}")
    fun getAnswersById(@PathVariable topicId: Long): List<AnswerView> = service.getAnswersByTopicId(topicId)
    
    @PostMapping
    fun create(@RequestBody @Valid answerForm: AnswerForm): AnswerView = service.create(answerForm)
}