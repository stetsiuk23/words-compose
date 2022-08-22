package com.stetsiuk.onewordcompose.ui.addword

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController

@Composable
fun AddNewWord(
    navController: NavController,
    modifier: Modifier = Modifier,
    addWordViewModel: AddNewWordViewModel = hiltViewModel(),
) {
    val textFieldData = rememberSaveable() {
        mutableStateOf("")
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(
                color = addWordViewModel.uiState.observeAsState().value!!.backgroundColor
            ),
        verticalArrangement = Arrangement.SpaceAround,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        OutlinedTextField(
            value = textFieldData.value,
            onValueChange = {
                textFieldData.value = it
                addWordViewModel.textChanged(it)
            }, label = {
                Text(text = "Word")
            }
        )
        Button(onClick = {
            addWordViewModel.addNewWord(textFieldData.value)
            navController.popBackStack()
        }) {
            Text(text = "Add")
        }
    }
}
