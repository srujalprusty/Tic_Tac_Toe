package com.srujal.tictactoe

sealed class UserAction{

    object  PlayAgain:UserAction()
    data class BoardTapped(val cellNo : Int):UserAction()


}