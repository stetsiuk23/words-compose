package com.stetsiuk.onewordcompose.ui.addword

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController

@Composable
fun AddNewWord(
    navController: NavController,
    modifier: Modifier = Modifier,
    addWordViewModel: AddNewWordViewModel = hiltViewModel(),
    //moveBack: () -> Unit
) {
    val textFieldData = rememberSaveable() {
        mutableStateOf("")
    }
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.SpaceAround,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        OutlinedTextField(
            value = textFieldData.value,
            onValueChange = {
                textFieldData.value = it
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