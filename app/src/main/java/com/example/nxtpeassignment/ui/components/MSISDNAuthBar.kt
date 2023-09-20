package com.example.nxtpeassignment.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.SheetState
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.nxtpeassignment.ui.theme.LightOrange

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun authBar(url:String){

    var sheetState = rememberModalBottomSheetState()


    ModalBottomSheet(
        sheetState=sheetState,
        onDismissRequest = {

    }) {
        Column(
            modifier = Modifier.fillMaxWidth()
        ) {
            Row (
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp)

            ){
                AsyncImage(
                    model =url ,
                    contentDescription ="FSPLogo"

                )

            }
        }
    }

}
