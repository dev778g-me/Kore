package com.dev.themebuilder.ui.view.components

import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.dev.korelibrary.components.card.Card
import com.dev.korelibrary.components.loadingIndicator.LinearLoadingIndicator
import com.dev.korelibrary.components.progress.LinearProgressIndicator
import com.dev.korelibrary.components.separators.HorizontalSeparator
import com.dev.korelibrary.components.Text
import com.dev.korelibrary.themes.KoreTheme
import kotlinx.coroutines.delay

@Composable
fun FileUploadUiShowcase(modifier: Modifier = Modifier) {
    var uploadProgress by remember { mutableFloatStateOf(0f) }

    val animatedProgress by animateFloatAsState(
        targetValue = uploadProgress,
        animationSpec = tween(durationMillis = 500, easing = FastOutSlowInEasing),
        label = "upload_progress"
    )

    LaunchedEffect(Unit) {
        while (uploadProgress < 1f) {
            delay(800)
            uploadProgress += 0.15f
            if (uploadProgress > 1f) uploadProgress = 1f
        }
    }

    Card(
        modifier = modifier
            .fillMaxWidth()
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth(),

            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Text(
                text = "Active Uploads",
                fontWeight = FontWeight.Bold,
                textStyle = KoreTheme.typography.title2
            )

            Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "holiday_video_export.mp4",
                        textStyle = KoreTheme.typography.body2,
                        fontWeight = FontWeight.SemiBold
                    )
                    Text(
                        text = "${(animatedProgress * 100).toInt()}%",
                        textStyle = KoreTheme.typography.label2,
                        color = KoreTheme.colorScheme.primary
                    )
                }

                LinearProgressIndicator(
                    progress = animatedProgress,
                )
            }

            HorizontalSeparator()

            Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "system_backup_data.zip",
                        textStyle = KoreTheme.typography.body2,
                        fontWeight = FontWeight.SemiBold
                    )
                    Text(
                        text = "Preparing...",
                        textStyle = KoreTheme.typography.label2,
                        color = KoreTheme.colorScheme.onBackGroundVariant
                    )
                }

                LinearLoadingIndicator()
            }
        }
    }
}