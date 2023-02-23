package com.hanif.resume.common


import com.hanif.resume.activitys.*

sealed class ResumeRoutes(val routes: String) {
    object SplashScreenRoute : ResumeRoutes(SPLASH_SCREEN_ROUTES)
    object HomeScreenRoute : ResumeRoutes(HOME_SCREEN_ROUTES)
    object AddResumeDetailRoute : ResumeRoutes(ADD__RESUME_DETAIL_SCREEN_ROUTES)
    object TemplateScreenRoute : ResumeRoutes(TEMPLATE_SCREEN_ROUTES)
}