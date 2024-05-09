package com.korugan.calculatorapp

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.unit.times
import com.korugan.calculatorapp.ui.theme.CalculatorAppTheme


@Composable
fun MainScreen() {
    var islemDur by remember {
        mutableStateOf("")
    }

    @Composable
    fun height(): Int {
        val configuration = LocalConfiguration.current
        return configuration.screenHeightDp
    }

    @Composable
    fun width(): Int {
        val configuration = LocalConfiguration.current
        return configuration.screenWidthDp
    }

    var sonuc by remember {
        mutableStateOf("48")
    }

    var islem by remember {
        mutableStateOf("21+27")
    }




    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.Black)
    ) {
        Column(
            horizontalAlignment = Alignment.End,
            modifier = Modifier
                .fillMaxWidth()
                .height(height() * 0.35.dp)
                .padding(height()*0.025.dp),
           verticalArrangement = Arrangement.Bottom
        ) {
            Text(
                text = islem,
                color = Color.Gray,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                fontSize = height() * 0.059.sp,
            )
            Text(
                text = sonuc,
                color = Color.White,
                fontSize = height() * 0.059.sp,
                modifier = Modifier.padding(8.dp),

            )
        }
        Column(
            modifier = Modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally

        ) {
            Row(
                modifier = Modifier
                    .padding(8.dp)

            ) {
                Button(
                    onClick = { Math().clear() }, modifier = Modifier
                        .height((height() * 0.11).dp)
                        .width((height() * 0.11).dp)
                        .padding(5.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = colorResource(id = R.color.orange))
                ) {
                    Text(text = "AC", fontSize = (height() * 0.03).sp)
                }
                Button(
                    onClick = { /*TODO*/ }, modifier = Modifier
                        .height((height() * 0.11).dp)
                        .width((height() * 0.11).dp)
                        .padding(5.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = colorResource(id = R.color.orange))
                ) {
                    Text(text = "*", fontSize = (height() * 0.04).sp)
                }
                Button(
                    onClick = { }, modifier = Modifier
                        .height((height() * 0.11).dp)
                        .width((height() * 0.11).dp)
                        .padding(5.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = colorResource(id = R.color.orange))
                ) {
                    Text(text = "%", fontSize = (height() * 0.04).sp)
                }
                Button(
                    onClick = { Math().divide() }, modifier = Modifier
                        .height((height() * 0.11).dp)
                        .width((height() * 0.11).dp)
                        .padding(5.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = colorResource(id = R.color.orange))
                ) {
                    Text(text = "/", fontSize = (height() * 0.04).sp)
                }


            }
            Row(
                modifier = Modifier
                    .padding(8.dp)
            ) {
                Button(
                    onClick = { islemDur + "1" }, modifier = Modifier
                        .height((height() * 0.11).dp)
                        .width((height() * 0.11).dp)
                        .padding(5.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = colorResource(id = R.color.orange))
                ) {
                    Text(text = "1", fontSize = (height() * 0.04).sp)
                }
                Button(
                    onClick = { Math().addNumber("2") }, modifier = Modifier
                        .height((height() * 0.11).dp)
                        .width((height() * 0.11).dp)
                        .padding(5.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = colorResource(id = R.color.orange))
                ) {
                    Text(text = "2", fontSize = (height() * 0.04).sp)
                }
                Button(
                    onClick = { Math().addNumber("3") },
                    modifier = Modifier
                        .height((height() * 0.11).dp)
                        .width((height() * 0.11).dp)
                        .padding(5.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = colorResource(id = R.color.orange))
                ) {
                    Text(text = "3", fontSize = (height() * 0.04).sp)
                }
                Button(
                    onClick = { /*TODO*/ },
                    modifier = Modifier
                        .height((height() * 0.11).dp)
                        .width((height() * 0.11).dp)
                        .padding(5.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = colorResource(id = R.color.orange))
                ) {
                    Text(text = "X", fontSize = (height() * 0.04).sp)
                }


            }
            Row(
                modifier = Modifier
                    .padding(8.dp)
            ) {
                Button(
                    onClick = { Math().addNumber("4") },
                    modifier = Modifier
                        .height((height() * 0.11).dp)
                        .width((height() * 0.11).dp)
                        .padding(5.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = colorResource(id = R.color.orange))
                ) {
                    Text(text = "4", fontSize = (height() * 0.04).sp)
                }
                Button(
                    onClick = { Math().addNumber("5") },
                    modifier = Modifier
                        .height((height() * 0.11).dp)
                        .width((height() * 0.11).dp)
                        .padding(5.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = colorResource(id = R.color.orange))
                ) {
                    Text(text = "5", fontSize = (height() * 0.04).sp)
                }
                Button(
                    onClick = { Math().addNumber("6") },
                    modifier = Modifier
                        .height((height() * 0.11).dp)
                        .width((height() * 0.11).dp)
                        .padding(5.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = colorResource(id = R.color.orange))
                ) {
                    Text(text = "6", fontSize = (height() * 0.04).sp)
                }
                Button(
                    onClick = { Math().check = false },
                    modifier = Modifier
                        .height((height() * 0.11).dp)
                        .width((height() * 0.11).dp)
                        .padding(5.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = colorResource(id = R.color.orange))
                ) {
                    Text(text = "-", fontSize = (height() * 0.04).sp)
                }


            }
            Row(
                modifier = Modifier
                    .padding(8.dp)
            ) {
                Button(
                    onClick = { Math().addNumber("7") },
                    modifier = Modifier
                        .height((height() * 0.11).dp)
                        .width((height() * 0.11).dp)
                        .padding(5.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = colorResource(id = R.color.orange))
                ) {
                    Text(text = "7", fontSize = (height() * 0.04).sp)
                }
                Button(
                    onClick = { Math().addNumber("8") },
                    modifier = Modifier
                        .height((height() * 0.11).dp)
                        .width((height() * 0.11).dp)
                        .padding(5.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = colorResource(id = R.color.orange))
                ) {
                    Text(text = "8", fontSize = (height() * 0.04).sp)
                }
                Button(
                    onClick = { Math().addNumber("9") },
                    modifier = Modifier
                        .height((height() * 0.11).dp)
                        .width((height() * 0.11).dp)
                        .padding(5.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = colorResource(id = R.color.orange))
                ) {
                    Text(text = "9", fontSize = (height() * 0.04).sp)
                }
                Button(
                    onClick = { /*TODO*/ },
                    modifier = Modifier
                        .height((height() * 0.11).dp)
                        .width((height() * 0.11).dp)
                        .padding(5.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = colorResource(id = R.color.orange))
                ) {
                    Text(text = "+", fontSize = (height() * 0.04).sp)
                }


            }
            Row(
                modifier = Modifier
                    .padding(8.dp)
                    .offset(x = -width() * 0.12.dp)
            ) {
                Button(
                    onClick = { /*TODO*/ },
                    modifier = Modifier
                        .height((height() * 0.11).dp)
                        .width((height() * 0.11).dp)
                        .padding(5.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = colorResource(id = R.color.orange))
                ) {
                    Text(text = ",", fontSize = (height() * 0.04).sp)
                }
                Button(
                    onClick = { Math().addNumber("0") },
                    modifier = Modifier
                        .height((height() * 0.11).dp)
                        .width((height() * 0.11).dp)
                        .padding(5.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = colorResource(id = R.color.orange))
                ) {
                    Text(text = "0", fontSize = (height() * 0.04).sp)
                }
                Button(
                    onClick = { },
                    modifier = Modifier
                        .height((height() * 0.11).dp)
                        .width((height() * 0.11).dp)
                        .padding(5.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = colorResource(id = R.color.orange))
                ) {
                    Text(text = "=", fontSize = (height() * 0.04).sp)
                }


            }

        }


    }


}

@Composable
@Preview(showBackground = true)
fun GreetingPreview() {
    CalculatorAppTheme {
        MainScreen()
    }
}