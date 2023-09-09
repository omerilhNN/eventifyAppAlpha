import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.BottomNavigation
import androidx.compose.material.ScaffoldState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.outlined.CalendarMonth
import androidx.compose.material.icons.outlined.CardGiftcard
import androidx.compose.material.icons.outlined.DateRange
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.StarHalf
import androidx.compose.material.icons.outlined.Stars
import androidx.compose.material.rememberScaffoldState
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FabPosition
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.omrilhn.eventifyappalpha.R
import com.omrilhn.eventifyappalpha.presentation.components.BottomNavItem
import com.omrilhn.eventifyappalpha.presentation.components.StandardBottomNavItem
import com.omrilhn.eventifyappalpha.utils.Screen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun StandardScaffold(
    navController: NavController,
    modifier: Modifier = Modifier,
    showBottomBar: Boolean = true,
    state: SnackbarHostState,
    bottomNavItems: List<BottomNavItem> = listOf(
        BottomNavItem(
            route = Screen.NotificationsScreen.route,
            icon = Icons.Outlined.Notifications,
            contentDescription = "Home"
        ),
        BottomNavItem(
            route = Screen.CampaignScreen.route,
            icon = Icons.Outlined.CardGiftcard,
            contentDescription = "Message"
        ),
        //FAB
        BottomNavItem(
            route = "-"),

        BottomNavItem(
            route = Screen.MyActivitiesScreen.route,
            icon = Icons.Outlined.DateRange,
            contentDescription = "Activity"
        ),
        BottomNavItem(
            route = Screen.ProfileScreen.route,
            icon = Icons.Outlined.Person,
            contentDescription = "Profile"
        ),
    ),
    onFabClick: () -> Unit = {},
    content: @Composable () -> Unit
) {
//    val state = remember{SnackbarHostState()}
    Scaffold(
        bottomBar = {
            if (showBottomBar) {
                BottomAppBar(
                    modifier = Modifier.fillMaxWidth(),
                    containerColor = MaterialTheme.colorScheme.surface,
                    tonalElevation = 5.dp,
                    contentPadding = PaddingValues(start = 8.dp,end = 8.dp)
                ) {
                    BottomNavigation(modifier = Modifier.fillMaxWidth()) {
                        bottomNavItems.forEachIndexed { i, bottomNavItem ->
                            StandardBottomNavItem(
                                icon = bottomNavItem.icon,
                                contentDescription = bottomNavItem.contentDescription,
                                selected = navController.currentDestination?.route?.startsWith(bottomNavItem.route) == true,
                                enabled = bottomNavItem.icon != null
                            ) {
                                if (navController.currentDestination?.route != bottomNavItem.route) {
                                    navController.navigate(bottomNavItem.route)
                                }
                            }
                        }
                    }
                }
            }
        },
        snackbarHost ={SnackbarHost(state)}, //GET PARAMETER VAL by remember WHERE YOU USE THAT val snackbarHostState = remember { SnackbarHostState() }
        floatingActionButton = {
            if (showBottomBar) {
                FloatingActionButton(
                    containerColor = MaterialTheme.colorScheme.primary,
                    onClick = onFabClick,
                    shape = CircleShape
                ) {
                    Icon(
                        imageVector = Icons.Outlined.Stars,
                        contentDescription = stringResource(id = R.string.main_feed)
                    )
                }
            }
        },
        floatingActionButtonPosition = FabPosition.Center,
        modifier = modifier
        , content = { padding->
                Box(modifier = Modifier.padding(padding)){
                    content()
                }
        })
}
