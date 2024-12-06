package com.example.androidcomposeselectable

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.androidcomposeselectable.ui.theme.ResultActivity

class TrirdQuestion : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val points = intent.getIntExtra("points", 0)
            val mContext = LocalContext.current
            val checkers = arrayListOf(
                R.drawable.not1 to remember {
                    mutableStateOf(false)
                },
                R.drawable.accept to remember {
                    mutableStateOf(false)
                },
                R.drawable.not2 to remember {
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
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    checkers.forEach { pair ->
                        Box(
                            modifier = Modifier
                                .padding(5.dp)
                                .size(60.dp)
                                .selectable(
                                    selected = pair.second.value,
                                    onClick = {
                                        pair.second.value = !pair.second.value
                                    })
                                .clip(RoundedCornerShape(20.dp))
                                .background(Color.White)
                                .border(
                                    width = 2.dp,
                                    color = if (pair.second.value) Color.Green
                                    else Color.Black
                                )
                        ) {
                            Image(
                                painter = painterResource(pair.first),
                                contentDescription = "option",
                                modifier = Modifier
                                    .padding(5.dp)
                            )
                        }
                    }
                }
                Button(
                    onClick = {
                        val intent = Intent(
                            mContext,
                            ResultActivity::class.java
                        )
                        if (
                            !checkers[0].second.value &&
                            checkers[1].second.value &&
                            !checkers[2].second.value
                        ) {
                            intent.putExtra("points", 1 + points)
                        } else {
                            intent.putExtra("points", 0 + points)
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