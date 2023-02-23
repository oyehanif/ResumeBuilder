package com.hanif.resume.activitys.splash

import android.view.animation.OvershootInterpolator
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.hanif.resume.BuildConfig
import com.hanif.resume.R
import com.hanif.resume.activitys.HOME_SCREEN_ROUTES
import com.hanif.resume.activitys.SPLASH_SCREEN_ROUTES
import com.hanif.resume.common.ResumeRoutes
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(navController: NavController) {
    val scale = remember {
        androidx.compose.animation.core.Animatable(0.0f)
    }

    Box(Modifier.fillMaxSize()) {
        LaunchedEffect(key1 = true) {
            scale.animateTo(
                targetValue = 0.7f,
                animationSpec = tween(800, easing = {
                    OvershootInterpolator(4f).getInterpolation(it)
                })
            )
            delay(3000)
            navController.navigate(HOME_SCREEN_ROUTES) {
                popUpTo(SPLASH_SCREEN_ROUTES) {
                    inclusive = true
                }
            }
        }

        Image(
            painter = painterResource(id = R.drawable.ic_launcher_background),
            contentDescription = "",
            alignment = Alignment.Center, modifier = Modifier
                .fillMaxSize()
                .padding(40.dp)
                .scale(scale.value)
        )

        Text(
            text = "Version - ${BuildConfig.VERSION_NAME}",
            textAlign = TextAlign.Center,
            fontSize = 24.sp,
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(16.dp)
        )
    }
}