package com.hanif.resume.activitys.resumedetails

import android.icu.text.CaseMap.Title
import androidx.compose.foundation.clickable
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.rounded.Person
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import com.hanif.resume.R

@Composable
fun ResumeTopBar() {
    TopAppBar(title = {
    }, navigationIcon = { Icon(Icons.Default.ArrowBack, contentDescription = "menu") }, actions = { Icon(
        Icons.Rounded.Person,
        contentDescription = ""
    )})
}