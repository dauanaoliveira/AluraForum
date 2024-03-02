package br.com.alura.forum.service

import br.com.alura.forum.dto.AnswerForm
import br.com.alura.forum.dto.AnswerView
import br.com.alura.forum.mapper.AnswerFormMapper
import br.com.alura.forum.mapper.AnswerViewMapper
import br.com.alura.forum.model.Answer
import br.com.alura.forum.model.TopicStatus
import org.springframework.stereotype.Service
import java.util.stream.Collectors

@Service
class AnswerService(
    private var answers: List<Answer> = emptyList(),
    private val answerFormMapper: AnswerFormMapper,
    private val answerViewMapper: AnswerViewMapper,
    private val topicService: TopicService
) {
    
    fun list(): List<AnswerView> = answers.stream().map { answer -> answerViewMapper.map(answer) }.collect(Collectors.toList())
    
    fun getAnswersByTopicId(topicId: Long): List<AnswerView> = answers.stream().filter { answer ->
        answer.topic.id == topicId
    }.map { answer -> answerViewMapper.map(answer) }.toList()
    
    fun create(answerForm: AnswerForm): AnswerView =
        topicService.updateStatus(answerForm.topicId, TopicStatus.ANSWERED).let {
            val answer = answerFormMapper.map(answerForm.copy(id = answers.size.toLong() + 1))
            answers = answers.plus(answer)
            answerViewMapper.map(answer)
        }
}