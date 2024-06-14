package com.unlam.sensor

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.unlam.sensor.ui.theme.SensorTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SensorTheme {
                val viewModel = viewModel<MainViewModel>()
                val isDark = viewModel.isDark
                Box(modifier = Modifier
                    .fillMaxSize()
                    .background(
                        if (isDark) Color.DarkGray else Color.White
                    ),
                    contentAlignment = Alignment.Center
                ){
                    Text(
                        text = if(isDark) {
                            "it´s dark outside"
                        } else {
                            "it´s bright outside"
                        },
                        color = if(isDark) Color.White else Color.DarkGray
                        )
                }
              
                }
            }
        }
    }
