package com.srujal.tictactoe

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.srujal.tictactoe.ui.theme.Aqua
import com.srujal.tictactoe.ui.theme.Greenish


@Composable
fun BoardBase(){
    Canvas(modifier = Modifier
        .size(300.dp)
        .padding(16.dp)
    ) {

        //Use for to draw layout line of the board of the tik tok toe game
          drawLine(
              color = Color.Black,
              strokeWidth = 5f,
              cap = StrokeCap.Round,
              start = Offset(x = size.width * 1/3 , y = 0f),
              end = Offset(size.width*1/3, size.height)
          )
        drawLine(
              color = Color.Black,
              strokeWidth = 5f,
              cap = StrokeCap.Round,
              start = Offset(x = size.width * 2/3 , y = 0f),
              end = Offset(size.width * 2/3, size.height)
          )
        drawLine(
              color = Color.Black,
              strokeWidth = 5f,
              cap = StrokeCap.Round,
              start = Offset(x = 0f , y = size.height * 1/3),
              end = Offset(size.width, size.height * 1/3)
          )
        drawLine(
              color = Color.Black,
              strokeWidth = 5f,
              cap = StrokeCap.Round,
              start = Offset(x = 0f , y = size.height * 2/3),
              end = Offset( size.width , size.height*2/3)
          )
    }
}


@Composable
fun Cross(){
    Canvas(modifier = Modifier
        .size(60.dp)
        .padding(5.dp)
    ) {

        drawLine(
            color = Greenish,
            strokeWidth = 20f,
            cap = StrokeCap.Round,
            start = Offset(x = 0f , y = 0f),
            end = Offset(size.width, size.height)
        )
        drawLine(
            color = Greenish,
            strokeWidth = 20f,
            cap = StrokeCap.Round,
            start = Offset(x = 0f , y = size.height),
            end = Offset(size.width, 0f)
        )
    }
}

@Composable
fun Circle(){
    Canvas(modifier = Modifier
        .size(60.dp)
        .padding(5.dp)
    ) {
        drawCircle(
            color = Aqua,
            style = Stroke(width = 20f),
            radius = size.width/2
        )
    }
}


@Composable
fun  WinHorizontalLine1(){

    Canvas(modifier = Modifier.size(300.dp)) {
           drawLine(
               color = Color.Red,
               strokeWidth = 10f,
               cap = StrokeCap.Round,
               start = Offset(x = 0f , y = size.height*1/6),
               end = Offset(size.width, size.height *1/6)
           )
    }
}
@Composable
fun  WinHorizontalLine2(){

    Canvas(modifier = Modifier.size(300.dp)) {
           drawLine(
               color = Color.Red,
               strokeWidth = 10f,
               cap = StrokeCap.Round,
               start = Offset(x = 0f , y = size.height*3/6),
               end = Offset(size.width, size.height *3/6)
           )
    }
}
@Composable
fun  WinHorizontalLine3(){

    Canvas(modifier = Modifier.size(300.dp)) {
           drawLine(
               color = Color.Red,
               strokeWidth = 10f,
               cap = StrokeCap.Round,
               start = Offset(x = 0f , y = size.height*5/6),
               end = Offset(size.width, size.height *5/6)
           )
    }
}

@Composable
fun WinVerticalLine1(){
    Canvas(modifier = Modifier.size(300.dp)) {
        drawLine(
            color = Color.Red,
            strokeWidth = 10f,
            cap = StrokeCap.Round,
           start = Offset(x = size.width*1/6 , y = 0f),
            end = Offset(size.width*1/6, size.height)
        )
    }
}
@Composable
fun WinVerticalLine2(){
    Canvas(modifier = Modifier.size(300.dp)) {
        drawLine(
            color = Color.Red,
            strokeWidth = 10f,
            cap = StrokeCap.Round,
           start = Offset(x = size.width*3/6 , y = 0f),
            end = Offset(size.width*3/6, size.height)
        )
    }
}
@Composable
fun WinVerticalLine3(){
    Canvas(modifier = Modifier.size(300.dp)) {
        drawLine(
            color = Color.Red,
            strokeWidth = 10f,
            cap = StrokeCap.Round,
           start = Offset(x = size.width*5/6 , y = 0f),
            end = Offset(size.width*5/6, size.height)
        )
    }
}

@Composable
fun WinDiagonalLine1(){
    Canvas(modifier = Modifier.size(300.dp)) {
        drawLine(
            color = Color.Red,
            strokeWidth = 10f,
            cap = StrokeCap.Round,
           start = Offset(x = 0f , y = size.height),
            end = Offset(size.width, 0f)
        )
    }
}

@Composable
fun WinDiagonalLine2(){
    Canvas(modifier = Modifier.size(300.dp)) {
        drawLine(
            color = Color.Red,
            strokeWidth = 10f,
            cap = StrokeCap.Round,
           start = Offset(x = 0f , y = 0f),
            end = Offset(size.width, size.height)
        )
    }
}




@Preview
@Composable
fun BoardPreview(){

//       WinHorizontalLine1()
//       WinHorizontalLine2()
//       WinHorizontalLine3()
//        WinVerticalLine1()
//        WinVerticalLine2()
//       WinVerticalLine3()
       WinDiagonalLine1()
       WinDiagonalLine2()

}