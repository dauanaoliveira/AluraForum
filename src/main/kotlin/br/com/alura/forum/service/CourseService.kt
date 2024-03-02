package br.com.alura.forum.service

import br.com.alura.forum.model.Course
import org.springframework.stereotype.Service

@Service
class CourseService(
    private var courses: List<Course> = emptyList()
) {

    init {
        val course = Course(
            id = 1,
            name = "Kotlin",
            category = "Programação"
        )
        
        courses = listOf(course)
    }
    
    fun getById(id: Long): Course = courses.stream().filter{ course ->
        course.id == id
    }.findFirst().get()
}
