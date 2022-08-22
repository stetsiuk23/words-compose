package com.stetsiuk.onewordcompose.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.stetsiuk.onewordcompose.ui.addword.AddNewWord
import com.stetsiuk.onewordcompose.ui.allwords.AllWords

@Composable
fun NewWordApp() {
    val navController = rememberNavController()
    val modifier = Modifier
        .fillMaxSize()
        .background(color = Color.DarkGray)
    NavHost(
        navController = navController,
        startDestination = Screen.WordsScreen.route,
    ) {
        composable(route = Screen.WordsScreen.route) {
            AllWords(
                navController = navController,
                modifier = modifier
            )
        }
        composable(route = Screen.AddWordScreen.route) {
            AddNewWord(
                navController = navController,
                modifier = modifier
            )
        }
    }
}