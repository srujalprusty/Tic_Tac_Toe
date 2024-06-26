package com.srujal.tictactoe

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.scaleIn
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.font.FontWeight.Companion.Bold
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.srujal.tictactoe.ui.theme.Blue
import com.srujal.tictactoe.ui.theme.GreyBackGround


@Composable
fun GameScreen(
    viewModel: GameViewModel
){
   val state = viewModel.state
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(GreyBackGround)
            .padding(horizontal = 30.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement  = Arrangement.SpaceEvenly


    ) {
       Row(
           modifier = Modifier.fillMaxWidth(),
           horizontalArrangement = Arrangement.SpaceBetween,
           verticalAlignment = Alignment.CenterVertically
       ){
           Text(text = "Player A- ${state.playerCircleCount}" , fontSize = 18.sp,color = Color.Cyan, fontWeight = Bold)
           Text(text = "Draw- ${state.drawCount}" , fontSize = 18.sp,color = Color.Cyan, fontWeight = Bold)
           Text(text = "Player B- ${state.playerCrossCount}" , fontSize = 18.sp,color = Color.Cyan, fontWeight = Bold)
       }
        Text(text = "Tic Tak Toe",
            fontSize = 40.sp,
            fontWeight = FontWeight.Bold,
            fontFamily = FontFamily.Serif,
            color = Blue
        )

        Box(modifier = Modifier
            .fillMaxWidth()
            .aspectRatio(1f)
            .shadow(
                elevation = 10.dp,
                shape = RoundedCornerShape(30.dp)
            )
            .clip(RoundedCornerShape(20.dp))
            .background(GreyBackGround),
            contentAlignment = Alignment.Center
        ){
              BoardBase()
             LazyVerticalGrid(
                 modifier = Modifier
                     .fillMaxWidth(0.9f)
                     .aspectRatio(1f),
                 columns = GridCells.Fixed(3),
             ) {
                viewModel.boardItem.forEach {(cellNo , boardCellValue) ->
                    item{
                        Column(
                            modifier = Modifier
                                .fillMaxSize()
                                .aspectRatio(1f)
                                .clickable(
                                    //Use for remove clickable affect
                                    interactionSource = MutableInteractionSource(),
                                    indication = null
                                ) {
                                    viewModel.onAction(UserAction.BoardTapped(cellNo))
                                },
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center
                        ) {
                            AnimatedVisibility(visible = viewModel.boardItem[cellNo] != BoardCellValue.NONE,
                                enter = scaleIn(tween(1000))
                            ) {
                                if(boardCellValue == BoardCellValue.CIRCLE){
                                    Circle()
                                }else if(boardCellValue == BoardCellValue.CROSS){
                                    Cross()

                                }
                            }
                                                       }
                        }
                    }
             }
            Column (
                modifier = Modifier.fillMaxWidth().aspectRatio(1f),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                AnimatedVisibility(
                    visible = state.hasWon,
                    enter = fadeIn(tween(1000))
                ) {
                    DrawVictoryLine(state = state)
                }
            }

        }

        Row (
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ){
             Text(text = state.hintText
                  , fontSize = 24.sp,
                   fontWeight= Bold, color = Color.Cyan,
                  fontStyle = FontStyle.Italic
             )
            Button(
                onClick = {
                          viewModel.onAction(
                              UserAction.PlayAgain
                          )
                },
                shape = RoundedCornerShape(5.dp),
                elevation = ButtonDefaults.elevatedButtonElevation(5.dp),
                colors = ButtonDefaults.buttonColors(
                  containerColor = Blue
                ),
            ) {
                Text(text = "Play Again", fontSize = 16.sp)
            }

        }
    }
}


@Composable
fun DrawVictoryLine(
    state: GameState
){
    when(state.victoryType){
        VictoryType.HORIZONTAL1 -> WinHorizontalLine1()
        VictoryType.HORIZONTAL2 -> WinHorizontalLine2()
        VictoryType.HORIZONTAL3 -> WinHorizontalLine3()
        VictoryType.VERTICAL1 -> WinVerticalLine1()
        VictoryType.VERTICAL2 -> WinVerticalLine2()
        VictoryType.VERTICAL3 -> WinVerticalLine3()
        VictoryType.DIAGONAL1 -> WinDiagonalLine1()
        VictoryType.DIAGONAL2 -> WinDiagonalLine2()
        VictoryType.NONE -> {}
    }
}

@Preview
@Composable
fun GameScreenPreview(){
    GameScreen(
        viewModel = GameViewModel()
    )
}

