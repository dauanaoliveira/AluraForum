package br.com.alura.forum.mapper

import br.com.alura.forum.dto.AnswerForm
import br.com.alura.forum.model.Answer
import br.com.alura.forum.service.TopicService
import br.com.alura.forum.service.UserService
import org.springframework.stereotype.Component

@Component
class AnswerFormMapper(
    private val userService: UserService,
    private val topicService: TopicService,
    private val topicViewMapper: TopicViewMapper
): Mapper<AnswerForm, Answer> {
    
    override fun map(t: AnswerForm): Answer =
        Answer(
            id = t.id,
            message = t.message,
            author = userService.getById(t.authorId),
            topic = topicService.getTopicById(t.topicId),
            solved = t.solved
        )
    
}