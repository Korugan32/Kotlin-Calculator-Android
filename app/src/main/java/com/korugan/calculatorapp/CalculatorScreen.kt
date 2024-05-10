@file:Suppress("NAME_SHADOWING")

package com.korugan.calculatorapp
import androidx.compose.foundation.Image
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.unit.times



@Composable
fun MainScreen() {

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

    var result by remember {
        mutableStateOf("")
    }

    var operation by remember {
        mutableStateOf("")
    }

    fun calculate(operation: String): String {
        try {
            var result = 0.0
            var currentOperator = '+'
            var currentNumber = ""

            for (char in operation) {
                if (char.isDigit() || char == '.') {
                    currentNumber += char
                } else if (currentNumber.isEmpty() && char == '-') {
                    currentNumber += char
                } else{
                    when (currentOperator) {
                        '+' -> result += currentNumber.toDouble()
                        '-' -> result -= currentNumber.toDouble()
                        'x' -> result *= currentNumber.toDouble()
                        '/' -> result /= currentNumber.toDouble()
                        '%' -> result %= currentNumber.toDouble()
                    }
                    currentOperator = char
                    currentNumber = ""
                }
            }

            when (currentOperator) {
                '+' -> result += currentNumber.toDouble()
                '-' -> result -= currentNumber.toDouble()
                'x' -> result *= currentNumber.toDouble()
                '/' -> result /= currentNumber.toDouble()
                '%' -> result %= currentNumber.toDouble()
            }

            return result.toString()

        } catch (e: Exception) {
            return result
        }
    }

    fun updateResult(operation: String) {
        result = if (operation.isEmpty()) {
            ""
        } else {
            calculate(operation)
        }
        if (result == "Infinity") {
            result = "Sıfırla Bölünme Hatası"
        }
    }

    fun onClickEvent(s:String){
        if (s == "AC") {
            operation = ""
            result = ""
        } else if (s == "DEL") {
            if (operation.isNotEmpty()) {
                operation = operation.dropLast(1)
                updateResult(operation)
            }
        } else {
            operation += s
            updateResult(operation)
        }
    }

//Tasarım(Design) ve Eventler(Events)
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
                .padding(height() * 0.025.dp),
            verticalArrangement = Arrangement.Bottom
        ) {
            Text(
                text = operation,
                color = Color.Gray,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                fontSize = height() * 0.059.sp,
            )
            Text(
                text = result,
                color = Color.White,
                fontSize = height() * 0.059.sp,
                modifier = Modifier.padding(8.dp),)
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
                    onClick = {
                        fun clear() {
                            operation = ""
                            result = ""
                        }
                        clear()
                    }, modifier = Modifier
                        .height((height() * 0.11).dp)
                        .width((height() * 0.11).dp)
                        .padding(5.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = colorResource(id = R.color.orange))
                ) {
                    Text(text = "AC", fontSize = (height() * 0.03).sp)
                }
                Button(
                    onClick = {
                        onClickEvent("DEL")
                    }, modifier = Modifier
                        .height((height() * 0.11).dp)
                        .width((height() * 0.11).dp)
                        .padding(5.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = colorResource(id = R.color.orange))
                ) {
                    Image(painter = painterResource(id = R.drawable.delete_svgrepo_com), contentDescription = "Delete")
                }
                Button(
                    onClick = { onClickEvent("%")}, modifier = Modifier
                        .height((height() * 0.11).dp)
                        .width((height() * 0.11).dp)
                        .padding(5.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = colorResource(id = R.color.orange))
                ) {
                    Text(text = "%", fontSize = (height() * 0.04).sp)
                }
                Button(
                    onClick = { onClickEvent("/") }, modifier = Modifier
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
                    onClick = { onClickEvent("1")}, modifier = Modifier
                        .height((height() * 0.11).dp)
                        .width((height() * 0.11).dp)
                        .padding(5.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = colorResource(id = R.color.orange))
                ) {
                    Text(text = "1", fontSize = (height() * 0.04).sp)
                }
                Button(
                    onClick = { onClickEvent("2") }, modifier = Modifier
                        .height((height() * 0.11).dp)
                        .width((height() * 0.11).dp)
                        .padding(5.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = colorResource(id = R.color.orange))
                ) {
                    Text(text = "2", fontSize = (height() * 0.04).sp)
                }
                Button(
                    onClick = { onClickEvent("3") },
                    modifier = Modifier
                        .height((height() * 0.11).dp)
                        .width((height() * 0.11).dp)
                        .padding(5.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = colorResource(id = R.color.orange))
                ) {
                    Text(text = "3", fontSize = (height() * 0.04).sp)
                }
                Button(
                    onClick = { onClickEvent("x") },
                    modifier = Modifier
                        .height((height() * 0.11).dp)
                        .width((height() * 0.11).dp)
                        .padding(5.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = colorResource(id = R.color.orange))
                ) {
                    Text(text = "x", fontSize = (height() * 0.04).sp)
                }


            }
            Row(
                modifier = Modifier
                    .padding(8.dp)
            ) {
                Button(
                    onClick = { onClickEvent("4") },
                    modifier = Modifier
                        .height((height() * 0.11).dp)
                        .width((height() * 0.11).dp)
                        .padding(5.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = colorResource(id = R.color.orange))
                ) {
                    Text(text = "4", fontSize = (height() * 0.04).sp)
                }
                Button(
                    onClick = { onClickEvent("5") },
                    modifier = Modifier
                        .height((height() * 0.11).dp)
                        .width((height() * 0.11).dp)
                        .padding(5.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = colorResource(id = R.color.orange))
                ) {
                    Text(text = "5", fontSize = (height() * 0.04).sp)
                }
                Button(
                    onClick = { onClickEvent("6") },
                    modifier = Modifier
                        .height((height() * 0.11).dp)
                        .width((height() * 0.11).dp)
                        .padding(5.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = colorResource(id = R.color.orange))
                ) {
                    Text(text = "6", fontSize = (height() * 0.04).sp)
                }
                Button(
                    onClick = { onClickEvent("-") },
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
                    onClick = { onClickEvent("7") },
                    modifier = Modifier
                        .height((height() * 0.11).dp)
                        .width((height() * 0.11).dp)
                        .padding(5.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = colorResource(id = R.color.orange))
                ) {
                    Text(text = "7", fontSize = (height() * 0.04).sp)
                }
                Button(
                    onClick = { onClickEvent("8") },
                    modifier = Modifier
                        .height((height() * 0.11).dp)
                        .width((height() * 0.11).dp)
                        .padding(5.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = colorResource(id = R.color.orange))
                ) {
                    Text(text = "8", fontSize = (height() * 0.04).sp)
                }
                Button(
                    onClick = { onClickEvent("9") },
                    modifier = Modifier
                        .height((height() * 0.11).dp)
                        .width((height() * 0.11).dp)
                        .padding(5.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = colorResource(id = R.color.orange))
                ) {
                    Text(text = "9", fontSize = (height() * 0.04).sp)
                }
                Button(
                    onClick = { onClickEvent("+") },
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
                    onClick = { onClickEvent(".") },
                    modifier = Modifier
                        .height((height() * 0.11).dp)
                        .width((height() * 0.11).dp)
                        .padding(5.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = colorResource(id = R.color.orange))
                ) {
                    Text(text = ".", fontSize = (height() * 0.04).sp)
                }
                Button(
                    onClick = { onClickEvent("0") },
                    modifier = Modifier
                        .height((height() * 0.11).dp)
                        .width((height() * 0.11).dp)
                        .padding(5.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = colorResource(id = R.color.orange))
                ) {
                    Text(text = "0", fontSize = (height() * 0.04).sp)
                }
                Button(
                    onClick = {
                        updateResult(operation)
                        operation = result
                        result =""
                    },
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
