package com.example.androidcomposeselectable

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val mContext = LocalContext.current
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    "Исторический тест",
                    fontSize = 30.sp,
                    modifier = Modifier
                        .padding(20.dp)
                )
                Button(onClick = {
                    mContext.startActivity(
                        Intent(
                            mContext,
                            FirstQuestion::class.java
                        )
                    )
                },
                    modifier = Modifier
                        .padding(20.dp)) {
                    Text(
                        "Начать",
                        fontSize = 24.sp
                    )
                }
            }
        }
    }
}
