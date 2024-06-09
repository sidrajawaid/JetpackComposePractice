package com.example.jetpackcomposetutorial

import android.os.Bundle
import android.util.Log.d
import android.view.View
import android.widget.ImageView
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
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
import androidx.compose.ui.viewinterop.AndroidView
import androidx.fragment.app.FragmentManager
import androidx.navigation.NavHostController
import com.example.jetpackcomposetutorial.ui.theme.JetpackComposeTutorialTheme


class MainActivity : ComponentActivity() {
    private lateinit var ref: FragmentManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        setContent {
            JetpackComposeTutorialTheme {
                NavHost()
            }


        }
    }
}

@Composable
fun Greeting( navCont: NavHostController,name: String, modifier: Modifier = Modifier) {

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
                        .clickable { changeFragment(navCont) }

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

fun changeFragment(navCont: NavHostController) {
navCont.navigate("composeFragment")

}

data class User(val id: Int)

@Composable
fun incrementList(navCont: NavHostController) {

    val user = User(1)

    val users = remember { mutableStateListOf(user) }

    Box(modifier = Modifier.fillMaxHeight()) {
        showList(userList = users,navCont)
        Button(modifier = Modifier.align(Alignment.BottomStart), onClick = {
            users.add(User(1))
        }) {

            Text(text = "Add row")
        }

        Button(modifier = Modifier.align(Alignment.BottomEnd)
            , onClick = {
                users.removeLast()
            }) {

            Text(text = "delete row")
        }


    }

}


@Composable
fun showList(userList: List<User>, navCont: NavHostController) {

    LazyColumn {
        items(userList) { user ->
            Greeting(navCont,name = "Sidra")


        }
    }
}

fun generateToast() {
    d("<><>", "Item clicked")
}




@Composable
fun ComposeWithXML(){
AndroidView(factory = {View.inflate(it,R.layout.child_layout,null) },
    modifier =Modifier.fillMaxSize() ,
    update = {it.findViewById<ImageView>(R.id.man_on_swing).setOnClickListener { generateToast() }} )
}

@Composable
fun showFullComposeView(){
    JetpackComposeTutorialTheme {

Column (modifier = Modifier.fillMaxSize()) {
    Image(
        painter = painterResource(id = R.drawable.ic_launcher_background),
        contentDescription = "",
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
    )
    Text(text = "This is compose view")
}


}
}