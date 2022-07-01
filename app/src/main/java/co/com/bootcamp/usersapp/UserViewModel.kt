package co.com.bootcamp.usersapp

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class UserViewModel: ViewModel() {
    var users: StateFlow<List<User>> = MutableStateFlow(emptyList())
        private set

    fun fetchUsers(){
        val usersFromSource = listOf(
            User("Pepito Perez 1","Android Developer","Usuario Pepito Perez"),
            User("Pepito Perez 2","Android Developer","Usuario Pepito Perez"),
            User("Pepito Perez 3","Android Developer","Usuario Pepito Perez"),
            User("Pepito Perez 4","Android Developer","Usuario Pepito Perez"),
            User("Pepito Perez 5","Android Developer","Usuario Pepito Perez"),
            User("Pepito Perez 6","Android Developer","Usuario Pepito Perez"),
            User("Pepito Perez 7","Android Developer","Usuario Pepito Perez"),
            User("Pepito Perez 8","Android Developer","Usuario Pepito Perez"),
            User("Pepito Perez 9","Android Developer","Usuario Pepito Perez"),
            User("Pepito Perez 10","Android Developer","Usuario Pepito Perez"),
        )

        users = MutableStateFlow(usersFromSource)
    }
}
