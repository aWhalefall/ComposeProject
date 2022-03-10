package com.kuaidao.composeproject.really

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kuaidao.composeproject.R
import com.kuaidao.composeproject.widget.TopLayout

/**
 * @author kuaidao@reworldgame.com
 * @date 2022/3/9 15:33
 * 关于
 */
class AboutUsActivityDemo : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            companyIcon()
        }
    }

}

@Preview
@Composable
fun ComposablePreview() {
    TopLayout()
}


@Composable
fun companyIcon() {
    Box(modifier = Modifier.fillMaxHeight().fillMaxWidth()){

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(all = 8.dp)) {
            Modifier.fillMaxHeight().fillMaxHeight()
            Image(
                painter = painterResource(id = R.mipmap.profile_picture),
                contentDescription = null, modifier = Modifier
                    .size(40.dp)
                    .clip(
                        CircleShape
                    )
                    .border(1.5.dp, MaterialTheme.colors.secondary, CircleShape)
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(text = "版本1.2.3")
        }

        Text(
            text = "121212",
            fontSize = 15.sp,
            color = Color.Black,
             modifier = Modifier.align(Alignment.BottomCenter))
    }

}
