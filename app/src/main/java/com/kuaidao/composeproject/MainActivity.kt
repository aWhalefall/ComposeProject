package com.kuaidao.composeproject

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kuaidao.composeproject.ui.theme.ComposeProjectTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            // Greeting(name = "nihao")
            //MessageCard(message = Message("kuaidao", "is my first project"))
//            ComposeProjectTheme {
//                MessageCard(message = Message("kuaidao", "is my first project"))
//            }
            ComposeProjectTheme {
                Conversation(SampleData.conversationSample)
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

//@Preview
//@Composable
//fun DefaultPreview() {
//        Greeting("world")
//}


//lession 2
data class Message(val author: String, val body: String)

//@Composable
//fun MessageCard(message: Message) {
//// Add padding around our message
//    Row(modifier = Modifier.padding(all = 8.dp)) {
//        Image(painter = painterResource(id = R.mipmap.profile_picture),
//            contentDescription = "Contact profile picture",modifier = Modifier
//                .size(40.dp)
//                .clip(
//                    CircleShape
//                ))
//        Spacer(modifier = Modifier.width(8.dp))
//        Column {
//            Text(text = message.author)
//            // Add a vertical space between the author and message texts
//            Spacer(modifier = Modifier.height(4.dp))
//            Text(text = message.body)
//        }
//
//    }
//
//}


//@Composable
//fun preMessageCard() {
//    ComposeProjectTheme {
//        MessageCard(message = Message("kuaidao", "is my first project"))
//    }
//}


//lession 3

@Composable
fun MessageCard(message: Message) {
// Add padding around our message
    Row(modifier = Modifier.padding(all = 8.dp)) {
        Image(
            painter = painterResource(id = R.mipmap.profile_picture),
            contentDescription = null, modifier = Modifier
                .size(40.dp)
                .clip(
                    CircleShape
                )
                .border(1.5.dp, MaterialTheme.colors.secondary, CircleShape)
        )
        Spacer(modifier = Modifier.width(8.dp))

        var isExpanded by remember{ mutableStateOf(false)}

        val surfaceColor: Color by animateColorAsState(
            if(isExpanded) MaterialTheme.colors.primary else MaterialTheme.colors.surface
        )

        Column(modifier = Modifier.clickable { isExpanded=!isExpanded }) {
            Text(
                text = message.author,
                color = MaterialTheme.colors.secondaryVariant,
                style = MaterialTheme.typography.subtitle2
            )
            // Add a vertical space between the author and message texts
            Spacer(modifier = Modifier.height(4.dp))

            Surface(shape = MaterialTheme.shapes.medium, elevation = 1.dp,
            color = surfaceColor,
            modifier =  Modifier.animateContentSize().padding(1.dp)) {
                Text(
                    text = message.body,
                    modifier = Modifier.padding(all = 4.dp),
                    maxLines=if (isExpanded)Int.MAX_VALUE else 1,
                    style = MaterialTheme.typography.body2
                )
            }
        }

    }

}
//预览深色和浅色主题
//@Preview(name = "Light Mode")
//@Preview(
//    name = "Dark Mode",
//    uiMode = Configuration.UI_MODE_NIGHT_YES,
//    showBackground = true
//)
//@Composable
//fun preMessageCard() {
//    ComposeProjectTheme {
//        MessageCard(message = Message("kuaidao", "is my first project"))
//    }
//}
//列表和动画
@Composable
fun Conversation(messages: List<Message>){
    LazyColumn{
        items(messages){
            message->
            MessageCard(message)
        }
    }
}

@Preview
@Composable
fun PreviewConversation() {
    ComposeProjectTheme {
        Conversation(SampleData.conversationSample)
    }
}

