package com.example.androidcomposeselectable

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Text
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


class FirstQuestion : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val sizeChar = 18.sp
            val mContext = LocalContext.current
            val checkers = arrayListOf(
                "Дмитрий Медведев" to remember {
                    mutableStateOf(false)
                },
                "Леонид Брежнев" to remember {
                    mutableStateOf(false)
                },
                "Владимир Путин" to remember {
                    mutableStateOf(false)
                },
                "Михаил Горбачев" to remember {
                    mutableStateOf(false)
                }
            )

            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Text(
                    "Выберите из списка всех президентов России",
                    fontSize = 24.sp,
                    modifier = Modifier
                        .padding(20.dp)
                )
                checkers.forEach { pair ->
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(5.dp)
                    ) {
                        Checkbox(
                            checked = pair.second.value,
                            onCheckedChange = { pair.second.value = it }
                        )
                        Text(
                            text = pair.first,
                            fontSize = sizeChar
                        )
                    }
                }
                Button(
                    onClick = {
                        val intent = Intent(
                            mContext,
                            SecondQuestion::class.java
                        )
                        if (
                            checkers[0].second.value &&
                            !checkers[1].second.value &&
                            checkers[2].second.value &&
                            !checkers[3].second.value
                        ) {
                            intent.putExtra("points", 1)
                        } else {
                            intent.putExtra("points", 0)
                        }
                        mContext.startActivity(
                            intent
                        )
                    },
                    modifier = Modifier
                        .padding(20.dp)
                ) {
                    Text(
                        "Ответить",
                        fontSize = 24.sp
                    )
                }
            }
        }
    }
}