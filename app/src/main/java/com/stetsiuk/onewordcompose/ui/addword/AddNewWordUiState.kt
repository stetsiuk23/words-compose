package com.stetsiuk.onewordcompose.ui.addword

import androidx.compose.ui.graphics.Color

sealed class AddNewWordUiState(
    open val value: Int = 0,
    open val backgroundColor: Color = com.stetsiuk.onewordcompose.ui.theme.EmptyText,
) {
    object EmptyText : AddNewWordUiState(
        value = 0,
        backgroundColor = com.stetsiuk.onewordcompose.ui.theme.EmptyText
    )

    object MiddleText : AddNewWordUiState(
        value = 8,
        backgroundColor = com.stetsiuk.onewordcompose.ui.theme.MiddleText
    )

    object LongText : AddNewWordUiState(
        value = 16,
        backgroundColor = com.stetsiuk.onewordcompose.ui.theme.LongText
    )

    object MaxText : AddNewWordUiState(
        value = 24,
        backgroundColor = com.stetsiuk.onewordcompose.ui.theme.MaxText
    )
}