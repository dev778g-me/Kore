package com.dev.codesamples

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.dev.codesamples.samples.buttons.CounterButtonSample
import com.dev.codesamples.samples.buttons.GhostButtonSample
import com.dev.codesamples.samples.buttons.OutlinedButtonSample
import com.dev.codesamples.samples.buttons.PrimaryButtonSample
import com.dev.codesamples.samples.buttons.PrimaryButtonWithIcon
import com.dev.codesamples.samples.buttons.PrimaryButtonWithCustomPaddingAndColors
import com.dev.codesamples.samples.buttons.SecondaryButtonSample
import com.dev.kore.components.scaffold.Scaffold
import com.dev.kore.themes.KoreTheme

@Composable
fun CodeSampleApp(){

    KoreTheme {
        Scaffold(
            modifier = Modifier.fillMaxSize()

        ){
            Column(modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(it)
                .padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp, Alignment.CenterVertically),
                horizontalAlignment = Alignment.CenterHorizontally){

                CounterButtonSample()
                PrimaryButtonSample()
                PrimaryButtonWithIcon()
                PrimaryButtonWithCustomPaddingAndColors()
                SecondaryButtonSample()
                OutlinedButtonSample()
                GhostButtonSample()
            }
        }
    }

}