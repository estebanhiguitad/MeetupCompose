package co.com.bootcamp.usersapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import co.com.bootcamp.usersapp.ui.theme.UsersAppTheme

@Composable
internal fun UsersTopBar() {
    TopAppBar {
        Text("Aplicación Usuarios Meetup")
    }
}

@Composable
internal fun HomeScreen(userViewModel: UserViewModel = viewModel()) {
    userViewModel.fetchUsers()
    val users by userViewModel.users.collectAsState()

    LazyColumn(verticalArrangement = Arrangement.spacedBy(10.dp)) {
        items(users.size) {
            UsersMenuContent(user = users[it])
        }
    }
}

@Preview(showBackground = true)
@Composable
fun UsersListPreview() {
    UsersAppTheme {
        HomeScreen()
    }
}

@Composable
private fun UsersMenuContent(user: User) {
    Row {
        Image(
            painter = painterResource(id = R.drawable.ic_user),
            contentDescription = user.contentDescription
        )
        Column(modifier = Modifier.padding(horizontal = 20.dp)) {
            Text(user.name, style = MaterialTheme.typography.h6)
            Text(user.role, style = MaterialTheme.typography.caption)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun UsersMenuContentPreview() {
    UsersAppTheme {
        UsersMenuContent(User("", "", ""))
    }
}