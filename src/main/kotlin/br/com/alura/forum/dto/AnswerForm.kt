package br.com.alura.forum.dto

data class AnswerForm (
    val id: Long? = null,
    val message: String,
    val authorId: Long,
    val topicId: Long,
    val solved: Boolean
)