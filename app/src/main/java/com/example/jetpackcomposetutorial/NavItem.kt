package com.example.jetpackcomposetutorial


import com.example.jetpackcomposetutorial.ui.NAV_FAV
import com.example.jetpackcomposetutorial.ui.NAV_FEED
import com.example.jetpackcomposetutorial.ui.NAV_HOME
import com.example.jetpackcomposetutorial.ui.NAV_PROFILE


sealed class NavItem (
     val title: Int,
     val icon: Int,
    val navRoute: String
) {
    object Home : NavItem(R.string.home, R.drawable.ic_home, NAV_HOME)
    object Fav : NavItem(R.string.fav, R.drawable.ic_fav, NAV_FAV)
    object Feed : NavItem(R.string.feed, R.drawable.ic_feed, NAV_FEED)
    object Profile : NavItem(R.string.feed, R.drawable.ic_profile, NAV_PROFILE)
}