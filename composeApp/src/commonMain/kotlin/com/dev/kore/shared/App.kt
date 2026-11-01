package com.dev.kore.shared

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.dev.kore.components.avatar.Avatar
import com.dev.kore.components.badge.PrimaryBadge
import com.dev.kore.components.icon.Icon
import com.dev.kore.components.scaffold.Scaffold
import com.dev.kore.components.text.Text
import com.dev.kore.shared.theme.AppTheme
import com.phosphor.icons.PhIcons
import com.phosphor.icons.bold.AtBold

@Composable
fun App() {
    var currentScreen by remember { mutableStateOf(0) } // 0: Remote, 1: Dashboard

    AppTheme {
       Scaffold {
           Column(modifier = Modifier.fillMaxWidth().padding(it), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally){
               Avatar(
                   badge = {
                       PrimaryBadge(content = {Text("0")}, shape = CircleShape, contentPadding = PaddingValues(1.dp))
                   },
                   onClick = {},
                   content = {
                       Icon(imageVector = PhIcons.Bold.AtBold, contentDescription = "")
                   }
               )
           }
       }
    }
}

@Composable
private fun CarouselItemContainer(
    id: Int,
    color: Color,
    title : String
){
    Box(
        modifier = Modifier
            .fillMaxWidth(0.5f)
            .height(200.dp).background(
            color = color,
            shape = RoundedCornerShape(16.dp)
        ),
        contentAlignment = Alignment.Center
    ){
        Text(title)
    }
}

data class carouselItem(
    val id : Int,
    val color: Color,
    val name : String,
)