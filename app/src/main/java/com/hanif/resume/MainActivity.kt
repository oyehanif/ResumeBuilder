package com.hanif.resume

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Add
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.hanif.resume.activitys.ADD__RESUME_DETAIL_SCREEN_ROUTES
import com.hanif.resume.activitys.BottomNavBar
import com.hanif.resume.activitys.HomeTopBar
import com.hanif.resume.activitys.ResumeNavController
import com.hanif.resume.ui.theme.ResumeTheme

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ResumeTheme {
                val navController = rememberNavController()
                Surface(color = Color.White) {
                    Scaffold(
                        bottomBar = {
                            BottomNavBar(navController = navController)
                        }, topBar = { HomeTopBar()},
                        content = {
                            ResumeNavController(navController = navController)
                        },
                        isFloatingActionButtonDocked = true,
                        floatingActionButtonPosition = FabPosition.Center,
                        floatingActionButton = {
                            FloatingActionButton(
                                onClick = {
                                    //navController.navigate(ADD__RESUME_DETAIL_SCREEN_ROUTES)
                                    startActivity(
                                        Intent(
                                            applicationContext,
                                            AddResumeDetailsActivity::class.java
                                        )
                                    )
                                },
                                backgroundColor = Color.White,
                                contentColor = Color.Black,
                                elevation = FloatingActionButtonDefaults.elevation(
                                    defaultElevation = 10.dp
                                )
                            ) {
                                Icon(Icons.Rounded.Add, contentDescription = "")
                            }
                        }
                    )
                }
            }
        }
    }
}
//https://enhancv.com/resume-examples/ui-designer/
//https://www.androidauthority.com/best-resume-builder-apps-android-1058201/
//https://dribbble.com/shots/20675925-CVMaker-CV-Builder-2