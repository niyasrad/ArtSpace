package com.example.artspace

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.artspace.ui.theme.ArtSpaceTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArtSpaceTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    ArtWork()
                }
            }
        }
    }
}

@Composable
fun ArtWork() {
    var cyberval by remember {
        mutableStateOf(1)
    }
    var cyber = R.drawable.cyber1
    var artworkTitle = stringResource(R.string.cyber1a)
    var artistName = stringResource(id = R.string.cyber1at)
    when(cyberval){
        8 -> {
            cyber = R.drawable.cyber8
            artworkTitle = stringResource(R.string.cyber8a)
            artistName = stringResource(R.string.cyber8at)
        }
        2 -> {
            cyber = R.drawable.cyber2
            artworkTitle = stringResource(R.string.cyber2a)
            artistName = stringResource(R.string.cyber2at)
        }
        3 -> {
            cyber = R.drawable.cyber3
            artworkTitle = stringResource(R.string.cyber3a)
            artistName = stringResource(R.string.cyber3at)
        }
        4 -> {
            cyber = R.drawable.cyber4
            artworkTitle = stringResource(R.string.cyber4a)
            artistName = stringResource(R.string.cyber4at)
        }
        5 -> {
            cyber = R.drawable.cyber5
            artworkTitle = stringResource(R.string.cyber5a)
            artistName = stringResource(R.string.cyber5at)
        }
        6 -> {
            cyber = R.drawable.cyber6
            artworkTitle = stringResource(R.string.cyber6a)
            artistName = stringResource(R.string.cyber6at)
        }
        7 -> {
            cyber = R.drawable.cyber7
            artworkTitle = stringResource(R.string.cyber7a)
            artistName = stringResource(R.string.cyber7at)
        }
        else -> {
            cyber = R.drawable.cyber1
            artworkTitle = stringResource(R.string.cyber1a)
            artistName = stringResource(R.string.cyber1at)
        }
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Image(
            painter = painterResource(id = cyber),
            contentDescription = "none",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.CenterHorizontally)
                .padding(top = 50.dp, start = 50.dp, end = 50.dp, bottom = 30.dp)
                .weight(3f)
                .border(width = 5.dp, color = Color.LightGray)
                .shadow(
                    elevation = 20.dp,
                )
        )
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 10.dp)
                .weight(0.8f)
        ) {
            Text(
                text = artworkTitle,
                modifier = Modifier
                    .fillMaxWidth(),
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Bold,
                fontSize = 40.sp
            )
            Text(
                text = artistName,
                modifier = Modifier
                    .padding(top = 10.dp)
                    .fillMaxWidth(),
                textAlign = TextAlign.Center,
                fontSize = 20.sp
            )
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 20.dp)
                .weight(0.5f),
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            Button(
                onClick = {
                     if(cyberval > 1){
                          cyberval--
                     }
                     else cyberval = 8
                } ,
                modifier = Modifier
                    .weight(1f)
                    .padding(start = 30.dp, end = 10.dp),
            ) {

                Text(text = "Previous")
            }
            Button(
                onClick = {
                    if(cyberval < 8){
                        cyberval++
                    }
                    else cyberval = 1
                } ,
                modifier = Modifier
                    .weight(1f)
                    .padding(start = 10.dp, end = 30.dp),
            )  {
                Text(text = "Next")
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ArtSpaceTheme {
        ArtWork()
    }
}