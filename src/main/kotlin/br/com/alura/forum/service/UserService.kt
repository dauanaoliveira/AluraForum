package br.com.alura.forum.service

import br.com.alura.forum.model.User
import org.springframework.stereotype.Service

@Service
class UserService(
    private var users: List<User> = emptyList()
) {
    
    init {
        val user = User(
            id = 1,
            name = "Maria Rita",
            email = "maria.rita@email.com"
        )
        
        users = listOf(user)
    }
    
    fun getById(id: Long): User = users.stream().filter{ user ->
        user.id == id
    }.findFirst().get()
}
