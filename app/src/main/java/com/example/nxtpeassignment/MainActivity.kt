package com.example.nxtpeassignment

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.nxtpeassignment.screens.CheckoutScreen
import com.example.nxtpeassignment.ui.theme.NxtpeassignmentTheme
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : ComponentActivity() {
//    @Inject
//    lateinit var nxtPeAPI:NxtPeAPI
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        lifecycleScope.launch {
//            try {
//                val data = nxtPeAPI.getPageData()
//                Log.d("pageData", data.page_title)
//                Log.d("pageData", data.page_items[1].title)
//            } catch (e: Exception) {
//                Log.e("APIRequest", "Error: ${e.message}")
//            }
//        }
        setContent {
            NxtpeassignmentTheme {
                Surface (
                    modifier= Modifier.fillMaxSize(),
                    color = Color.White
                ){
                    App()
                }

            }
        }
    }
}

@Composable
fun App(){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination ="Checkout") {
        composable(route="Checkout"){
            checkoutScreen()
        }
    }

}

@Composable
fun checkoutScreen() {
    CheckoutScreen()
}


