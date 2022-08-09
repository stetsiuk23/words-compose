package com.stetsiuk.onewordcompose.ui

sealed class Screen(
    val route: String
) {
    object WordsScreen : Screen("words_screen")
    object AddWordScreen : Screen("add_word_screen")

    fun withArgs(vararg args: String): String {
        return buildString {
            append(route)
            args.forEach { arg ->
                append("/$arg")
            }
        }
    }
}