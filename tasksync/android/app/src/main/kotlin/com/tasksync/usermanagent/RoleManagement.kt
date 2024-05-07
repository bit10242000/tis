import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

// Enum representing different user roles
enum class UserRole {
    ADMIN, USER, MANAGER
}

@Composable
fun RoleManagementScreen() {
    var selectedRole by remember { mutableStateOf(UserRole.USER) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Role Management") }
            )
        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Text("Select a role:")
            UserRole.values().forEach { role ->
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.clickable {
                        selectedRole = role
                    }
                ) {
                    RadioButton(
                        selected = selectedRole == role,
                        onClick = { selectedRole = role }
                    )
                    Text(text = role.name)
                }
            }
            Spacer(modifier = Modifier.height(16.dp))
            Button(onClick = { /* Handle role selection */ }) {
                Text("Select Role")
            }
        }
    }
}

@Preview
@Composable
fun PreviewRoleManagementScreen() {
    RoleManagementScreen()
}
