package com.codingwithmitch.food2forkcompose.presentation.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.codingwithmitch.food2forkcompose.presentation.ui.MenuCategory1

@ExperimentalComposeUiApi
@Composable
fun AppBar(
    menuCategories: List<MenuCategory1>,
    selectedCategory: MenuCategory1?,
    onSelectedCategoryChanged: (String) -> Unit,
    onToggleTheme: () -> Unit,
) {

    Surface(
        modifier = Modifier
            .fillMaxWidth(),
        color = MaterialTheme.colors.secondary,
        elevation = 8.dp,
    ) {
        Column {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
            ) {

                ConstraintLayout(
                    modifier = Modifier.align(Alignment.CenterVertically)
                ) {
                    val (menu) = createRefs()
                    IconButton(
                        modifier = Modifier
                            .constrainAs(menu) {
                                end.linkTo(parent.end)
                                linkTo(top = parent.top, bottom = parent.bottom)
                            },
                        onClick = onToggleTheme,
                    ) {
                        Icon(Icons.Filled.MoreVert, contentDescription = "Toggle Dark/Light Theme")
                    }
                }
            }// end row
            val scrollState = rememberLazyListState()
            LazyRow(
                modifier = Modifier
                    .padding(start = 8.dp, bottom = 8.dp),
                state = scrollState,
            ) {
                items(menuCategories) {
                    MenuCategorieChip1(
                        category = it.value,
                        isSelected = selectedCategory == it,
                       onSelectedCategoryChanged = {
                         onSelectedCategoryChanged(it)
                        },


                    )
                }
            }

        }
    }
}