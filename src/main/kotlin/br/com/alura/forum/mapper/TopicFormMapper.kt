package br.com.alura.forum.mapper

import br.com.alura.forum.dto.TopicForm
import br.com.alura.forum.model.Topic
import br.com.alura.forum.service.CourseService
import br.com.alura.forum.service.UserService
import org.springframework.stereotype.Component

@Component
class TopicFormMapper(
    private val courseService: CourseService,
    private val userService: UserService,
): Mapper<TopicForm, Topic> {
    
    override fun map(t: TopicForm): Topic =
        Topic(
            id = t.id,
            title = t.title,
            message = t.message,
            course = courseService.getById(t.idCourse),
            author = userService.getById(t.idAuthor)
        )
}
