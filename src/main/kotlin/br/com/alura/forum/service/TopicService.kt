package br.com.alura.forum.service

import br.com.alura.forum.dto.TopicForm
import br.com.alura.forum.dto.TopicView
import br.com.alura.forum.mapper.TopicFormMapper
import br.com.alura.forum.mapper.TopicViewMapper
import br.com.alura.forum.model.Topic
import org.springframework.stereotype.Service
import java.util.stream.Collectors

@Service
class TopicService(
    private var topics: List<Topic> = emptyList(),
    private val topicViewMapper: TopicViewMapper,
    private val topicFormMapper: TopicFormMapper
) {
  
    fun list(): List<TopicView> = topics.stream().map { topic -> topicViewMapper.map(topic) }.collect(Collectors.toList())
    
    fun getById(id: Long): TopicView = topics.stream().filter { topic ->
        topic.id == id
    }.findFirst().get().let { topic -> topicViewMapper.map(topic) }
    
    fun create(topicForm: TopicForm) {
        
        topics = topics.plus(topicFormMapper.map(topicForm.copy(id = topics.size.toLong()+1)))
    }
}