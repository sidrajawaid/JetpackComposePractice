package com.example.jetpackcomposetutorial

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController


@Composable
fun Home(navController: NavHostController? = null) {
    Column(
        Modifier
            .fillMaxSize()
            .padding(top = 24.dp, bottom = 12.dp, start = 12.dp, end = 12.dp)
    ) {
        TextField(
            value = "",
            onValueChange = {

            },
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight(),
            shape = RoundedCornerShape(5.dp),
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Search,
                    ""
                )
            }
        )
        Text(text = "My Tasks")

        LazyColumn {
            var i = 0
            items((0..4).toList()) {
                TaskCard("Item ${++i}", navController)
            }
        }
    }
}

@Composable
fun TaskCard(task: String, navController: NavHostController? = null) {
    Card(
        elevation = CardDefaults.cardElevation(4.dp),
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(top = 8.dp)
            .clickable {
                navController?.navigate("task?item=$task")
            }
    ) {
        Row(
            modifier = Modifier.padding(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_todo),
                contentDescription = "",
                modifier = Modifier
                    .padding(end = 32.dp)
                    .size(32.dp)
            )
            Text(text = task,
                fontSize = 24.sp,
                modifier = Modifier.padding(top = 8.dp, bottom = 8.dp).wrapContentSize())
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomePreview() {
    Home()
}