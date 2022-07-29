package com.stetsiuk.onewordcompose.ui.allwords

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.ExperimentalUnitApi
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel

@OptIn(ExperimentalUnitApi::class)
@Composable
fun AllWords(
    modifier: Modifier = Modifier,
    allWordViewModel: AllWordViewModel = viewModel(),
    move: () -> Unit
) {
    val wordsLiveData = allWordViewModel.getAllWords().observeAsState()
    val words = wordsLiveData.value

    LazyColumn(
        modifier = modifier
    ) {
        if (words != null) {

            items(words) { word ->
                Text(
                    text = word.word,
                    fontSize = TextUnit(30f, TextUnitType.Sp)
                )
            }
        }
    }

    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.Bottom
    ) {
        Button(onClick = {
            move()
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