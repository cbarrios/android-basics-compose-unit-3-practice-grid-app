package com.lalosapps.gridapp.ui.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.lalosapps.gridapp.R
import com.lalosapps.gridapp.data.DataSource
import com.lalosapps.gridapp.model.Topic
import com.lalosapps.gridapp.ui.theme.GridAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApp()
        }
    }
}

@Composable
fun MyApp() {
    GridAppTheme {
        // A surface container using the 'background' color from the theme
        Surface(
            modifier = Modifier
                .fillMaxSize()
                .padding(4.dp),
            color = MaterialTheme.colors.background
        ) {
            LazyColumn {
                items(DataSource.topics) {
                    TopicItem(topic = it)
                }
            }
        }
    }
}

@Composable
fun TopicItem(topic: Topic, modifier: Modifier = Modifier) {
    Card(modifier = modifier.padding(4.dp), elevation = 4.dp) {
        Row {
            Image(
                painter = painterResource(id = topic.imageResource),
                contentDescription = stringResource(id = topic.nameResource),
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .width(68.dp)
                    .height(68.dp)

            )
            Column(
                modifier = Modifier.padding(horizontal = 16.dp)
            ) {
                Text(
                    text = stringResource(id = topic.nameResource),
                    style = MaterialTheme.typography.body2,
                    modifier = Modifier.padding(top = 16.dp),
                )
                Spacer(modifier = Modifier.height(8.dp))
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.ic_grain),
                        contentDescription = null,
                        contentScale = ContentScale.Crop,
                        colorFilter = ColorFilter.tint(color = MaterialTheme.colors.onBackground),
                        modifier = Modifier
                            .width(12.dp)
                            .aspectRatio(1f)
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                        text = topic.totalCourses.toString(),
                        style = MaterialTheme.typography.caption,
                    )
                }
            }
        }
    }

}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    TopicItem(topic = DataSource.topics[1])
}