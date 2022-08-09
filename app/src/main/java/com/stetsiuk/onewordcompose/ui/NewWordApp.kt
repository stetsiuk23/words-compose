package com.stetsiuk.onewordcompose.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.stetsiuk.onewordcompose.ui.addword.AddNewWord
import com.stetsiuk.onewordcompose.ui.allwords.AllWords

@Composable
fun NewWordApp(
    wordsViewModel: WordsViewModel = hiltViewModel(),
    modifier: Modifier = Modifier
        .padding(30.dp)
) {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = Screen.WordsScreen.route,
    ) {
        composable(route = Screen.WordsScreen.route) {
            AllWords(
                navController = navController,
                modifier = Modifier.fillMaxSize().padding(30.dp)
            )
        }
        composable(route = Screen.AddWordScreen.route) {
            AddNewWord(
                navController = navController,
                modifier = Modifier.fillMaxSize().padding(30.dp)
            )
        }
    }

    /*if (wordsViewModel.filteredData == "") wordsViewModel.setCurrentScreen(WordsViewModel.ALL_WORDS_SCREEN)
    val currentScreen = wordsViewModel.filteredData
    if (currentScreen == WordsViewModel.ALL_WORDS_SCREEN) {
        AllWords(
            modifier = modifier,
            move = {
                wordsViewModel.setCurrentScreen(WordsViewModel.ADD_NEW_WORD_SCREEN)
            }
        )
    } else {
        AddNewWord(
            modifier = modifier,
            moveBack = {
                wordsViewModel.setCurrentScreen(WordsViewModel.ALL_WORDS_SCREEN)
            }
        )
    }*/
}