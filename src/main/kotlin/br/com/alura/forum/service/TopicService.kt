package br.com.alura.forum.service

import br.com.alura.forum.dto.TopicForm
import br.com.alura.forum.dto.TopicView
import br.com.alura.forum.dto.UpdateTopicForm
import br.com.alura.forum.mapper.TopicFormMapper
import br.com.alura.forum.mapper.TopicViewMapper
import br.com.alura.forum.model.Topic
import br.com.alura.forum.model.TopicStatus
import org.springframework.stereotype.Service
import java.util.stream.Collectors

@Service
class TopicService(
    private var topics: List<Topic> = emptyList(),
    private val topicViewMapper: TopicViewMapper,
    private val topicFormMapper: TopicFormMapper
) {
  
    fun list(): List<TopicView> = topics.stream().map { topic -> topicViewMapper.map(topic) }.collect(Collectors.toList())
    
    fun getById(id: Long): TopicView = getTopicById(id).let { topic -> topicViewMapper.map(topic) }
    
    fun getTopicById(id: Long): Topic = topics.stream().filter { topic ->
        topic.id == id
    }.findFirst().get()
    
    fun create(topicForm: TopicForm) {
        topics = topics.plus(topicFormMapper.map(topicForm.copy(id = topics.size.toLong()+1)))
    }
    
    fun updateStatus(id: Long, status: TopicStatus): Topic =
        getTopicById(id).let { topic ->
            val topicToUpdate = topic.copy(status = status)
            topics = topics.minus(topic).plus(topicToUpdate)
            topicToUpdate
        }
    
    fun update(topicForm: UpdateTopicForm): TopicView =
        getTopicById(topicForm.id).let { topic ->
            val topicToUpdate = topic.copy(
                title = topicForm.title,
                message = topicForm.message
            )
            topics = topics.minus(topic).plus(topicToUpdate)
            topicViewMapper.map(topicToUpdate)
        }
}