package com.example.cn333as3

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat.startActivity
import com.example.cn333as3.ui.theme.Cn333as3Theme

var randomn2: Int = 0
var guess2: Int = 0

class endGame : ComponentActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        guess = 0
        var minn: Int = 0
        var maxn: Int = 1001
        var intent = intent
        randomn2 = intent.getStringExtra("Random").toString().toInt()
        guess2 = intent.getStringExtra("Guess").toString().toInt()
        super.onCreate(savedInstanceState)
        setContent {
            Cn333as3Theme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background) {
                    Greeting4("Android")
                }
            }
        }
    }
}

@Composable
fun Greeting4(name: String) {

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text( "You Win !!!",
            fontSize = 18.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .padding(20.dp)
                .fillMaxWidth()
        )
        Text( "the number is : $randomn2",
            fontSize = 18.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .padding(20.dp)
                .fillMaxWidth()
        )
        Text( "and you guess $guess2 times.",
            fontSize = 18.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .padding(20.dp)
                .fillMaxWidth()
        )

        val rand = (1..1000).random()
        val context = LocalContext.current
        val intent = Intent(context,playGame::class.java)
        intent.putExtra("Random",rand.toString())
        intent.putExtra("guess","0")

        Button(onClick = { context.startActivity(intent) }) {
            Text("play again",
                fontSize = 20.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .padding(5.dp))

        }
    }

}
/*
@Preview(showBackground = true)
@Composable
fun DefaultPreview4() {
    Cn333as3Theme {
        Greeting4("Android")
    }
}*/