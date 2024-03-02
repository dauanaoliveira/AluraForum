package br.com.alura.forum.service

import br.com.alura.forum.dto.TopicForm
import br.com.alura.forum.dto.TopicView
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
        topics.find { it.id == id }?.let { topic ->
            val index = topics.indexOfFirst { it.id == id }
            val mutableTopic = topics.toMutableList()
            mutableTopic[index] = topic.copy(status = status)
            topics = mutableTopic.toList()
            return topics[index]
        } ?: throw Exception("topic not found")
}