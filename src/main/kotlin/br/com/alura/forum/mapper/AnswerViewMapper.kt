package br.com.alura.forum.mapper

import br.com.alura.forum.dto.AnswerView
import br.com.alura.forum.model.Answer
import org.springframework.stereotype.Component

@Component
class AnswerViewMapper(
    private val topicMapper: TopicViewMapper
): Mapper<Answer, AnswerView> {
    override fun map(t: Answer): AnswerView =
        AnswerView(
            id = t.id,
            message = t.message,
            author = t.author,
            topic = topicMapper.map(t.topic),
            solved = t.solved
        )
}