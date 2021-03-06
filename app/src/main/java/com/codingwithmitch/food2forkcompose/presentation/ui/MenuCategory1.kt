package com.codingwithmitch.food2forkcompose.presentation.ui
import  com.codingwithmitch.food2forkcompose.presentation.ui.MenuCategory1.*


enum class MenuCategory1(val value: String){
    ERROR("error"),
    CHICKEN("Chicken"),

}

fun getAllMenus1(): List<MenuCategory1>{
    return listOf(
        ERROR, CHICKEN
    )
}



fun getMenuCategory1(value: String): MenuCategory1? {
    val map = values().associateBy(MenuCategory1::value)

    return map[value]
}

