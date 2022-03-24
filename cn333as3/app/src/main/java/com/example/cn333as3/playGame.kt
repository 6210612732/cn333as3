package com.example.cn333as3

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.cn333as3.ui.theme.Cn333as3Theme
import kotlin.random.Random

var minn: Int = 0
var maxn: Int = 1001
var randomn: Int = 0
var guess: Int = 0

class playGame : ComponentActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        var intent = intent
        randomn = intent.getStringExtra("Random").toString().toInt()
        super.onCreate(savedInstanceState)
        setContent {
            Cn333as3Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Greeting1("Android")
                }
            }
        }
    }
}

@Composable
fun Greeting1(name: String){
    val head = remember { mutableStateOf("start!!!") }
    val text = remember { mutableStateOf("try your best") }
    val text2 = remember { mutableStateOf("Min : 0   || Max : 1001") }
    val enter = remember { mutableStateOf("") }
    val answer = remember { mutableStateOf(TextFieldValue()) }

    val context2 = LocalContext.current
    val intent2 = Intent(context2,endGame::class.java)

/*
    fun reset() {
        randomn = Random.nextInt(1, 1000)
        text.value = ""
        start = true
        click = 0
    }*/

    fun inGame() {
        if(guess==0) head.value = ""

        if (true) {
            if (answer.value.text.isNotEmpty()) {
                guess++
                if (answer.value.text.toInt() < randomn) {
                    text.value = "the number is higher than !"
                    minn = answer.value.text.toInt()
                }
                else if (answer.value.text.toInt() > randomn) {
                    text.value = "the number is lower than !"
                    maxn = answer.value.text.toInt()
                }
               else {
                    intent2.putExtra("Random",randomn.toString())
                    intent2.putExtra("Guess",guess)
                    context2.startActivity(intent2)
                }
                text2.value = "Min : $minn   || Max : $maxn"
            }
            else {
                text.value = "enter number"
            }
        }
    }


    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    )

    {   Text( head.value,
        fontSize = 20.sp,
        textAlign = TextAlign.Center,
        modifier = Modifier
            .padding(20.dp)
            .fillMaxWidth()
    )
        Text( text.value,
            fontSize = 18.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .padding(20.dp)
                .fillMaxWidth()
        )

        Text( text2.value,
            fontSize = 18.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .padding(20.dp)
                .fillMaxWidth()
        )



        TextField(
            value = answer.value,
            onValueChange = {answer.value = it },
            singleLine = true,
            placeholder = { Text("Enter Your guess")},
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )

        Text( "",
            fontSize = 18.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .padding(20.dp)
                .fillMaxWidth()
        )


        Button( onClick = { inGame() } ) {
                enter.value = "check"
                Text(enter.value)
        }




    }
}

/*
@Preview(showBackground = true)
@Composable
fun DefaultPreview1() {
    Cn333as3Theme {
        Greeting("Android")
    }
}*/