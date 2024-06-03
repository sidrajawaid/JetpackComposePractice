package com.example.jetpackcomposetutorial

import android.os.Bundle
import android.util.Log.d
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetpackcomposetutorial.ui.theme.JetpackComposeTutorialTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeTutorialTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.onSecondary,

                    ) {
                    UserList()
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {

    Card(
        elevation = CardDefaults.cardElevation(4.dp),
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(6.dp)
    ) {


        Row(
            modifier = modifier
                .fillMaxWidth()
                .wrapContentHeight()
        ) {

            Column(
                modifier = modifier
                    .wrapContentHeight()
                    .wrapContentWidth()
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_launcher_background),
                    contentDescription = "",
                    contentScale = ContentScale.Crop,
                    modifier = modifier
                        .size(80.dp)
                        .clip(CircleShape)
                        .padding(6.dp)
                )
            }


            Column(
                modifier = modifier
                    .wrapContentHeight()
                    .wrapContentWidth()
            ) {

                Text(
                    text = "Hello $name!",
                    fontSize = 18.sp,
                    fontStyle = FontStyle.Italic,
                    fontFamily = FontFamily.Serif,
                    modifier = Modifier
                        .padding(6.dp)
                        .border(2.dp, MaterialTheme.colorScheme.background, RectangleShape)
                        .clickable {
                            generateToast()
                        }

                )

                Text(
                    text = "Hello $name!",
                    fontSize = 12.sp,
                    fontFamily = FontFamily.Serif,
                    modifier = Modifier
                        .padding(6.dp)
                        .border(2.dp, MaterialTheme.colorScheme.onSecondary, RectangleShape)
                        .clickable {
                            generateToast()
                        }

                )

            }

        }
    }

}

data class User( val id: Int )

val userList= listOf(
    User(1),
    User(1),
    User(1),
    User(1),
    User(1),
    User(1),
    User(1),
    User(1)
)
@Composable
fun UserList(){
    // Column(modifier = Modifier.verticalScroll(rememberScrollState())) {

    /*for(i in 1..10)
        Greeting(name = "Sidra")

        //   }
        */

    LazyColumn{
        items(userList){ user->
            Greeting(name = "Sidra")


        }
    }
}

fun generateToast() {
    d("<><>","Item clicked")
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    JetpackComposeTutorialTheme {
        UserList()
    }
}