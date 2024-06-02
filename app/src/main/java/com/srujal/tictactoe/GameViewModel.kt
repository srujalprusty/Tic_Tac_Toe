package com.srujal.tictactoe

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class GameViewModel: ViewModel(){

    var state by mutableStateOf(GameState())

    val boardItem:MutableMap<Int,BoardCellValue> = mutableMapOf(
        1 to BoardCellValue.NONE,
        2 to BoardCellValue.NONE,
        3 to BoardCellValue.NONE,
        4 to BoardCellValue.NONE,
        5 to BoardCellValue.NONE,
        6 to BoardCellValue.NONE,
        7 to BoardCellValue.NONE,
        8 to BoardCellValue.NONE,
        9 to BoardCellValue.NONE,

    )

    fun onAction(action: UserAction){

        when(action){
            is UserAction.BoardTapped->{
                addValueToBoard(action.cellNo)
            }
            UserAction.PlayAgain ->{
               gameReset()

            }
        }
    }

    private fun gameReset() {
        boardItem.forEach{(i,_)->
            boardItem[i] = BoardCellValue.NONE
        }
        state = state.copy(
            hintText = "Player A Turn",
            currentTurn = BoardCellValue.CIRCLE,
            victoryType = VictoryType.NONE,
            hasWon = false
        )
    }

    private fun addValueToBoard(cellNo: Int) {
             if(boardItem[cellNo] != BoardCellValue.NONE){
                 return
             }
        if(state.currentTurn == BoardCellValue.CIRCLE){
            boardItem[cellNo] = BoardCellValue.CIRCLE
            if(checkForVictory(BoardCellValue.CIRCLE)){
                state = state.copy(
                    hintText = "Player A Won",
                    playerCircleCount = state.playerCircleCount + 1,
                    currentTurn = BoardCellValue.NONE,
                    hasWon = true
                )
            } else if(hasBoardFull()){
                state = state.copy(
                    hintText = "Game Draw",
                    drawCount = state.drawCount + 1
                )
                }else{
                    state = state.copy(
                        hintText = "Player B Turn",
                        currentTurn = BoardCellValue.CROSS
                    )
                }
        }else if(state.currentTurn == BoardCellValue.CROSS){
            boardItem[cellNo] = BoardCellValue.CROSS
            if(checkForVictory(BoardCellValue.CROSS)){
                state = state.copy(
                    hintText = "Player B Won",
                    playerCrossCount = state.playerCrossCount + 1,
                    currentTurn = BoardCellValue.NONE,
                    hasWon = true
                )
            } else if(hasBoardFull()){
                state = state.copy(
                    hintText = "Game Draw",
                    drawCount = state.drawCount + 1
                )
            }else{
                state = state.copy(
                    hintText = "Player A Turn",
                    currentTurn = BoardCellValue.CIRCLE
                )
            }
        }
    }

    private fun checkForVictory(circle: BoardCellValue): Boolean {
        when {
            boardItem[1] == boardItem[2] && boardItem[2] == boardItem[3] && boardItem[1] == circle -> {
                state = state.copy(victoryType = VictoryType.HORIZONTAL1)
                return true
            }
            boardItem[4] == boardItem[5] && boardItem[5] == boardItem[6] && boardItem[4] == circle -> {
                state = state.copy(victoryType = VictoryType.HORIZONTAL2)
                return true
            }
            boardItem[7] == boardItem[8] && boardItem[8] == boardItem[9] && boardItem[7] == circle -> {
                state = state.copy(victoryType = VictoryType.HORIZONTAL3)
                return true
            }
            boardItem[1] == boardItem[4] && boardItem[4] == boardItem[7] && boardItem[1] == circle -> {
                state = state.copy(victoryType = VictoryType.VERTICAL1)
                return true
            }
            boardItem[2] == boardItem[5] && boardItem[5] == boardItem[8] && boardItem[2] == circle -> {
                state = state.copy(victoryType = VictoryType.VERTICAL2)
                return true
            }
            boardItem[3] == boardItem[6] && boardItem[6] == boardItem[9] && boardItem[3] == circle -> {
                state = state.copy(victoryType = VictoryType.VERTICAL3)
                return true
            }
            boardItem[1] == boardItem[5] && boardItem[5] == boardItem[9] && boardItem[1] == circle -> {
                state = state.copy(victoryType = VictoryType.DIAGONAL2)
                return true
            }
            boardItem[3] == boardItem[5] && boardItem[5] == boardItem[7] && boardItem[3] == circle -> {
                state = state.copy(victoryType = VictoryType.DIAGONAL1)
                return true
            }
            else ->return false

        }
    }




    private fun hasBoardFull(): Boolean {
        if (boardItem.containsValue(BoardCellValue.NONE)) return false
        return true
    }
}