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
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
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
    val result = remember { mutableStateOf("") }
    var operation = remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.Black),
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .height(screenHeight() * 0.35.dp)
                .padding(screenHeight() * 0.025.dp),
            horizontalAlignment = Alignment.End,
            verticalArrangement = Arrangement.Bottom,
        ) {
            Text(
                text = operation.value,
                color = Color.Gray,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                fontSize = screenHeight() * 0.059.sp,
            )

            Text(
                text = result.value,
                color = Color.White,
                fontSize = screenHeight() * 0.059.sp,
                modifier = Modifier.padding(8.dp),
            )
        }

        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Row(modifier = Modifier.padding(8.dp)) {
                Button(
                    onClick = {
                        operation.value = ""
                        result.value = ""
                    },
                    modifier = Modifier
                        .size((screenHeight() * 0.11).dp)
                        .padding(5.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = colorResource(id = R.color.orange))
                ) {
                    Text(text = "AC", fontSize = (screenHeight() * 0.03).sp)
                }

                Button(
                    onClick = {
                        onClickEvent("DEL", operation, result)
                    },
                    modifier = Modifier
                        .size((screenHeight() * 0.11).dp)
                        .padding(5.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = colorResource(id = R.color.orange))
                ) {
                    Image(painter = painterResource(id = R.drawable.delete_svgrepo_com), contentDescription = "Delete")
                }

                Button(
                    onClick = { onClickEvent("%", operation, result) },
                    modifier = Modifier
                        .size((screenHeight() * 0.11).dp)
                        .padding(5.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = colorResource(id = R.color.orange))
                ) {
                    Text(text = "%", fontSize = (screenHeight() * 0.04).sp)
                }

                Button(
                    onClick = { onClickEvent("/", operation, result) },
                    modifier = Modifier
                        .size((screenHeight() * 0.11).dp)
                        .padding(5.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = colorResource(id = R.color.orange))
                ) {
                    Text(text = "/", fontSize = (screenHeight() * 0.04).sp)
                }
            }

            Row(modifier = Modifier.padding(8.dp)) {
                Button(
                    onClick = { onClickEvent("1", operation, result) },
                    modifier = Modifier
                        .size((screenHeight() * 0.11).dp)
                        .padding(5.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = colorResource(id = R.color.orange))
                ) {
                    Text(text = "1", fontSize = (screenHeight() * 0.04).sp)
                }

                Button(
                    onClick = { onClickEvent("2", operation, result) },
                    modifier = Modifier
                        .size((screenHeight() * 0.11).dp)
                        .padding(5.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = colorResource(id = R.color.orange))
                ) {
                    Text(text = "2", fontSize = (screenHeight() * 0.04).sp)
                }

                Button(
                    onClick = { onClickEvent("3", operation, result) },
                    modifier = Modifier
                        .size((screenHeight() * 0.11).dp)
                        .padding(5.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = colorResource(id = R.color.orange))
                ) {
                    Text(text = "3", fontSize = (screenHeight() * 0.04).sp)
                }

                Button(
                    onClick = { onClickEvent("x", operation, result) },
                    modifier = Modifier
                        .size((screenHeight() * 0.11).dp)
                        .padding(5.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = colorResource(id = R.color.orange))
                ) {
                    Text(text = "x", fontSize = (screenHeight() * 0.04).sp)
                }
            }

            Row(modifier = Modifier.padding(8.dp)) {
                Button(
                    onClick = { onClickEvent("4", operation, result) },
                    modifier = Modifier
                        .size((screenHeight() * 0.11).dp)
                        .padding(5.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = colorResource(id = R.color.orange))
                ) {
                    Text(text = "4", fontSize = (screenHeight() * 0.04).sp)
                }

                Button(
                    onClick = { onClickEvent("5", operation, result) },
                    modifier = Modifier
                        .size((screenHeight() * 0.11).dp)
                        .padding(5.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = colorResource(id = R.color.orange))
                ) {
                    Text(text = "5", fontSize = (screenHeight() * 0.04).sp)
                }

                Button(
                    onClick = { onClickEvent("6", operation, result) },
                    modifier = Modifier
                        .size((screenHeight() * 0.11).dp)
                        .padding(5.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = colorResource(id = R.color.orange))
                ) {
                    Text(text = "6", fontSize = (screenHeight() * 0.04).sp)
                }

                Button(
                    onClick = { onClickEvent("-", operation, result) },
                    modifier = Modifier
                        .size((screenHeight() * 0.11).dp)
                        .padding(5.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = colorResource(id = R.color.orange))
                ) {
                    Text(text = "-", fontSize = (screenHeight() * 0.04).sp)
                }
            }

            Row(modifier = Modifier.padding(8.dp)) {
                Button(
                    onClick = { onClickEvent("7", operation, result) },
                    modifier = Modifier
                        .size((screenHeight() * 0.11).dp)
                        .padding(5.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = colorResource(id = R.color.orange))
                ) {
                    Text(text = "7", fontSize = (screenHeight() * 0.04).sp)
                }

                Button(
                    onClick = { onClickEvent("8", operation, result) },
                    modifier = Modifier
                        .size((screenHeight() * 0.11).dp)
                        .padding(5.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = colorResource(id = R.color.orange))
                ) {
                    Text(text = "8", fontSize = (screenHeight() * 0.04).sp)
                }

                Button(
                    onClick = { onClickEvent("9", operation, result) },
                    modifier = Modifier
                        .size((screenHeight() * 0.11).dp)
                        .padding(5.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = colorResource(id = R.color.orange))
                ) {
                    Text(text = "9", fontSize = (screenHeight() * 0.04).sp)
                }

                Button(
                    onClick = { onClickEvent("+", operation, result) },
                    modifier = Modifier
                        .size((screenHeight() * 0.11).dp)
                        .padding(5.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = colorResource(id = R.color.orange))
                ) {
                    Text(text = "+", fontSize = (screenHeight() * 0.04).sp)
                }
            }

            Row(
                modifier = Modifier
                    .padding(8.dp)
                    .offset(x = -screenWidth() * 0.12.dp),
            ) {
                Button(
                    onClick = { onClickEvent(".", operation, result) },
                    modifier = Modifier
                        .size((screenHeight() * 0.11).dp)
                        .padding(5.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = colorResource(id = R.color.orange))
                ) {
                    Text(text = ".", fontSize = (screenHeight() * 0.04).sp)
                }

                Button(
                    onClick = { onClickEvent("0", operation, result) },
                    modifier = Modifier
                        .size((screenHeight() * 0.11).dp)
                        .padding(5.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = colorResource(id = R.color.orange))
                ) {
                    Text(text = "0", fontSize = (screenHeight() * 0.04).sp)
                }

                Button(
                    onClick = {
                        updateResult(operation, result)
                        operation = result
                        result.value = ""
                    },
                    modifier = Modifier
                        .size((screenHeight() * 0.11).dp)
                        .padding(5.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = colorResource(id = R.color.orange))
                ) {
                    Text(text = "=", fontSize = (screenHeight() * 0.04).sp)
                }
            }
        }
    }
}

@Composable
private fun screenHeight(): Int = LocalConfiguration.current.screenHeightDp

@Composable
private fun screenWidth(): Int = LocalConfiguration.current.screenWidthDp

private fun updateResult(operation: MutableState<String>, result: MutableState<String>) {
    result.value = if (operation.value.isEmpty()) {
        ""
    } else {
        calculate(operation, result.value)
    }

    if (result.value == "Infinity") {
        result.value = "Sıfırla Bölünme Hatası"
    }
}

private fun calculate(operation: MutableState<String>, realResult: String): String {
    try {
        var calculationResult = 0.0
        var currentOperator = '+'
        var currentNumber = ""

        for (char in operation.value) {
            if (char.isDigit() || char == '.') {
                currentNumber += char
            } else if (currentNumber.isEmpty() && char == '-') {
                currentNumber += char
            } else {
                when (currentOperator) {
                    '+' -> calculationResult += currentNumber.toDouble()
                    '-' -> calculationResult -= currentNumber.toDouble()
                    'x' -> calculationResult *= currentNumber.toDouble()
                    '/' -> calculationResult /= currentNumber.toDouble()
                    '%' -> calculationResult %= currentNumber.toDouble()
                }
                currentOperator = char
                currentNumber = ""
            }
        }

        when (currentOperator) {
            '+' -> calculationResult += currentNumber.toDouble()
            '-' -> calculationResult -= currentNumber.toDouble()
            'x' -> calculationResult *= currentNumber.toDouble()
            '/' -> calculationResult /= currentNumber.toDouble()
            '%' -> calculationResult %= currentNumber.toDouble()
        }

        return calculationResult.toString()
    } catch (e: Exception) {
        return realResult
    }
}

private fun onClickEvent(s: String, operation: MutableState<String>, result: MutableState<String>) {
    if (s == "AC") {
        operation.value = ""
        result.value = ""
    } else if (s == "DEL") {
        if (operation.value.isNotEmpty()) {
            operation.value = operation.value.dropLast(1)
            updateResult(operation, result)
        }
    } else {
        operation.value += s
        updateResult(operation, result)
    }
}
