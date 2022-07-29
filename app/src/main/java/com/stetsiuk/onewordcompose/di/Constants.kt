package com.stetsiuk.onewordcompose.di

import kotlinx.coroutines.Dispatchers

object Constants {
    const val WORD_DATABASE_NAME = "Word database"
    const val WORD_DATABASE_VERSION = 2
    val DISPATCHERS_MAIN = Dispatchers.Main
    val DISPATCHERS_IO = Dispatchers.IO
}