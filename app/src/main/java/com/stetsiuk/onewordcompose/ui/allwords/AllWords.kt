package com.stetsiuk.onewordcompose.ui.allwords

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.stetsiuk.onewordcompose.ui.Screen
import com.stetsiuk.onewordcompose.ui.addword.states.AddNewWordUiState

@Composable
fun AllWords(
    navController: NavController,
    modifier: Modifier = Modifier,
    allWordViewModel: AllWordViewModel = hiltViewModel(),
) {
    val wordsLiveData = allWordViewModel.getAllWords().observeAsState()
    val words = wordsLiveData.value

    LazyColumn(
        modifier = modifier.padding(4.dp)
    ) {
        if (words != null) {
            itemsIndexed(words) { index, word ->
                val color = if (word.word.length == AddNewWordUiState.EmptyText.value) {
                    AddNewWordUiState.EmptyText.backgroundColor
                } else if (word.word.length < AddNewWordUiState.MiddleText.value) {
                    AddNewWordUiState.MiddleText.backgroundColor
                } else if (word.word.length < AddNewWordUiState.LongText.value) {
                    AddNewWordUiState.LongText.backgroundColor
                } else {
                    AddNewWordUiState.MaxText.backgroundColor
                }
                Text(
                    modifier = Modifier
                        .padding(4.dp)
                        .fillMaxSize()
                        .background(
                            color = color,
                            shape = RoundedCornerShape(8.dp)
                        )
                        .padding(10.dp),
                    text = "${index + 1}. ${word.word}",
                    style = TextStyle(
                        color = Color.DarkGray,
                        fontFamily = FontFamily.SansSerif
                    ),
                    fontSize = 26.sp,
                )
            }
        }
    }

    Row(
        modifier = Modifier
            .fillMaxSize()
            .padding(10.dp),
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.Bottom
    ) {
        Button(onClick = {
            navController.navigate(Screen.AddWordScreen.route)
        }) {
            Text(text = "Add new")
        }
        Button(onClick = {
            allWordViewModel.deleteAllWords()
        }) {
            Text(text = "Delete all")
        }
    }
}