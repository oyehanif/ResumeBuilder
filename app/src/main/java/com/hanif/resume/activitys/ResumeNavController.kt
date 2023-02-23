package com.hanif.resume.activitys

import android.util.Log
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import com.hanif.resume.R
import com.hanif.resume.activitys.bottom_nav_composible.BottomNavigationItems
import com.hanif.resume.activitys.bottom_nav_composible.Constants
import com.hanif.resume.activitys.home.HomeScreen
import com.hanif.resume.activitys.template.TemplateScreen
import com.hanif.resume.common.ResumeRoutes

@Composable
fun ResumeNavController(navController: NavHostController) {


    NavHost(
        navController = navController,
        startDestination = ResumeRoutes.HomeScreenRoute.routes,
    ) {
        /*composable(ResumeRoutes.SplashScreenRoute.routes) {
            SplashScreen(navController)
        }*/
        composable(ResumeRoutes.HomeScreenRoute.routes) {
            HomeScreen(navController)
        }
        composable(BottomNavigationItems.ResumeTemplate.route) {
            TemplateScreen()
        }
    }
}


@Composable
fun HomeTopBar() {
    TopAppBar(title = {
        Text(
            text = stringResource(R.string.resume_builder),
        )
    }, navigationIcon = { Icon(Icons.Default.Menu, contentDescription = "menu") })
}


@Composable
fun BottomNavBar(navController: NavHostController) {

    BottomAppBar(
        modifier = androidx.compose.ui.Modifier
            .fillMaxWidth()
            .clip(
                RoundedCornerShape(16.dp, 16.dp)
            ), cutoutShape = CircleShape
    ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()

        val currentRoute = navBackStackEntry?.destination?.route

        Constants.BottomNavigationItemsList.forEach { item ->
            BottomNavigationItem(
                selected = currentRoute == item.route,
                onClick = {
                    Log.e("TAG", "BottomNavBar: ${item.name}")
                    navController.navigate(item.route)
                },
                icon = {
                    Icon(painterResource(id = item.icon), contentDescription = "")
                },
                label = {
                    Text(
                        text = item.name
                    )
                },
                alwaysShowLabel = false
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun TopBarPrev() {
    HomeTopBar()
}