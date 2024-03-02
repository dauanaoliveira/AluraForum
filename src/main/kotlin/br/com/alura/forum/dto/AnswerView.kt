package br.com.alura.forum.dto

import br.com.alura.forum.model.User

data class AnswerView (
    val id: Long?,
    val message: String,
    val author: User,
    val topic: TopicView,
    val solved: Boolean
)