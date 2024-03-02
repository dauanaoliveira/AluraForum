package br.com.alura.forum.service

import br.com.alura.forum.model.Answer
import br.com.alura.forum.model.Course
import br.com.alura.forum.model.Topic
import br.com.alura.forum.model.User
import org.springframework.stereotype.Service

@Service
class AnswerService(
    private var answers: List<Answer>
) {
    init {
        val topic = Topic(
            id = 1,
            title = "Duvida Kotlin",
            message = "Variaveis no Kotlin",
            course = Course(
                id = 1,
                name = "Kotlin",
                category = "Programação"
            ),
            author = User(
                id = 1,
                name = "Ana da Silva",
                email = "ana@email.com"
            )
        )
        val answer = Answer(
            id = 1,
            message = "teste",
            author = User(
                id = 1,
                name = "Ana da Silva",
                email = "ana@email.com"
            ),
            solved = false,
            topic = topic
        )
        
        val answer2 = Answer(
            id = 2,
            message = "teste 2",
            author = User(
                id = 1,
                name = "Ana da Silva",
                email = "ana@email.com"
            ),
            solved = false,
            topic = topic
        )
        
        val answer3 = Answer(
            id = 3,
            message = "teste 3",
            author = User(
                id = 1,
                name = "Ana da Silva",
                email = "ana@email.com"
            ),
            solved = false,
            topic = topic
        )
        
        answers = listOf(answer, answer2, answer3)
    }
    
    fun getAnswersByTopicId(topicId: Long): List<Answer> = answers.stream().filter { answer ->
        answer.topic.id == topicId
    }.toList()
}