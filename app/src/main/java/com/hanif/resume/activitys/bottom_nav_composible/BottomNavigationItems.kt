package com.hanif.resume.activitys.bottom_nav_composible

import com.hanif.resume.R
import com.hanif.resume.activitys.HOME_SCREEN_ROUTES
import com.hanif.resume.activitys.RESUME_TEMPLATE_BOTTOM_NAVIGATION_ROUTE

sealed class BottomNavigationItems(val name: String, val icon: Int, val route: String) {
    object Home : BottomNavigationItems("Home", R.drawable.home, HOME_SCREEN_ROUTES)
    object ResumeTemplate : BottomNavigationItems(
        "Templates",
        R.drawable.template,
        RESUME_TEMPLATE_BOTTOM_NAVIGATION_ROUTE
    )
}


data class BottomNavigationDataClass(val name: String, val icon: Int, val route: String)

object Constants{
val BottomNavigationItemsList = listOf(
    BottomNavigationDataClass("Home", R.drawable.home, HOME_SCREEN_ROUTES),
    BottomNavigationDataClass("Templates", R.drawable.template, RESUME_TEMPLATE_BOTTOM_NAVIGATION_ROUTE)
)
}
