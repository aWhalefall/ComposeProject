package com.kuaidao.composeproject.widget

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kuaidao.composeproject.R
import com.kuaidao.composeproject.really.companyIcon

/**
 * @author kuaidao@reworldgame.com
 * @date 2022/3/10 16:32
 * 通用topBar
 */
@Composable
fun TopLayout() {
    Scaffold(topBar = {
        TopAppBar(
            title = {
                Text(
                    text = "我就是标题",
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Center
                )
            },
            navigationIcon = {
                IconButton(onClick = {}) {
                    Icon(
                        painter = painterResource(R.mipmap.ic_bar_back),
                        contentDescription ="",
                    )
                }
            },
            actions = {
                IconButton(
                    onClick = { /* TODO: Open search */ }
                ) {
                    Icon(
                        imageVector = Icons.Filled.Search,
                        contentDescription = null
                    )
                }
            },
            backgroundColor = MaterialTheme.colors.surface,
            elevation = 0.dp
        )
    }) {
        companyIcon()
    }
}