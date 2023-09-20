package com.example.nxtpeassignment.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImage
import com.example.nxtpeassignment.models.PageItem
import com.example.nxtpeassignment.ui.theme.LightOrange
import com.example.nxtpeassignment.ui.theme.Orange
import com.example.nxtpeassignment.viewmodels.DefaultViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import com.example.nxtpeassignment.ui.components.FSPCard
import com.example.nxtpetask.ui.screen.component.popUp
import com.example.nxtpetask.ui.screen.component.savedCard


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CheckoutScreen() {
    val dataViewModel : DefaultViewModel = hiltViewModel()
    val data: State<List<PageItem>> = dataViewModel.pageData.collectAsState()
    val actualData = data.value
    val isLoading = dataViewModel.isLoading.collectAsState().value
    var fsp by remember {
        mutableStateOf(-1)
    }
    if (isLoading) {
        Text(text = "Loading...")
        return
    }
    var savedPaymentoptions by remember {
        mutableStateOf(0)
    }


    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        Surface(shadowElevation = 6.dp, modifier = Modifier.padding(bottom = 16.dp)) {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        text = "Mandate Details",
                        fontSize = 16.sp,
                        color = Color.Black,
                        fontWeight = FontWeight.SemiBold
                    )
                },
                navigationIcon = {
                    Icon(
                        imageVector = Icons.Filled.KeyboardArrowLeft,
                        tint = Orange,
                        contentDescription = "Back Button",
                        modifier = Modifier
                            .padding(10.dp)
                            .size(40.dp)
                    )
                }, colors = TopAppBarDefaults.centerAlignedTopAppBarColors(Color.White)
            )
        }
        Card( 
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp, 10.dp, 16.dp, 16.dp),
            colors = CardDefaults.cardColors(Color.White),
            elevation = CardDefaults.elevatedCardElevation(5.dp)
        ){
            Column(
                modifier = Modifier.fillMaxWidth()
            ) {
                Row (
                    Modifier
                        .fillMaxWidth()
                        .padding(end = 16.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ){
                        val details1 = actualData[0].mandate_details
                        Text(
                            buildAnnotatedString {
                                append("${details1.details[0].key} - ")
                                withStyle(
                                    SpanStyle(
                                        fontWeight = FontWeight.Bold
                                    )
                                ) {
                                    append("${details1.details[0].value}")
                                }
                            },
                            modifier = Modifier.padding(10.dp,16.dp,0.dp,10.dp),
                            fontSize = 13.sp
                        )
                       val details2 = actualData[0].mandate_details
                       Text(
                           buildAnnotatedString {
                               append("${details2.details[2].key} - ")
                               withStyle(
                                   SpanStyle(
                                       fontWeight = FontWeight.Bold
                                   )
                               ) {
                                   append("${details2.details[2].value}")
                               }
                           },
                           modifier = Modifier.padding(10.dp,16.dp,0.dp,10.dp),
                           fontSize = 11.sp
                       )
                }
                Spacer(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp)
                        .height((0.5).dp)
                        .background(Color.LightGray)
                )
                val details = actualData[0].mandate_details
                Text(
                    buildAnnotatedString {
                        append("${details.details[1].key} - ")
                        withStyle(
                            SpanStyle(
                                fontWeight = FontWeight.Bold
                            )
                        ) {
                            append("${details.details[1].value}")
                        }
                    },
                    modifier = Modifier.padding(10.dp,10.dp,0.dp,10.dp),
                    fontSize = 13.sp
                )
                Spacer(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp)
                        .height((0.5).dp)
                        .background(Color.LightGray)
                )
                Row (
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp)
                        .background(LightOrange, RoundedCornerShape(9.dp))
                        .padding(8.dp)
                ) {
                    Icon(
                        imageVector = Icons.Outlined.Info,
                        contentDescription = null,
                        tint = Orange,
                        modifier = Modifier
                            .padding(end = 4.dp, top = 3.dp)
                            .size(18.dp)
                    )
                    val details = actualData[0].mandate_details
                    Text(
                        buildAnnotatedString {
                            append("${details.message}\nThe Limit is upto ")
                            withStyle(
                                SpanStyle(
                                    fontWeight = FontWeight.Bold,
                                    color = Color.Black
                                )
                            ) {
                                append("${details.details[2].value}")
                            }
                        },
                        color = Color.DarkGray,
                        fontSize = 11.sp,
                    )
                }
            }

        }
        val paymentOptions = actualData[1]
        var img by remember {
            mutableStateOf("")
        }
        var sheetState = rememberModalBottomSheetState()
        var isSheetOpen by rememberSaveable {
            mutableStateOf(false)
        }
        var enabled by remember{
            mutableStateOf( true)
        }
        var numfsp by remember {
            mutableStateOf(0)
        }
        Text(
            paymentOptions.title,
            fontSize = 14.sp,
            color = Color.Black,
            fontWeight = FontWeight.SemiBold,
            modifier = Modifier.padding(start = 20.dp, top = 10.dp)
        )
        LazyVerticalGrid(
            columns = GridCells.Fixed(3),
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp, top = 14.dp)
                .align(Alignment.CenterHorizontally),
        ) {
            items(paymentOptions.paymentoptions.size) {
                FSPCard(
                    imageUrl = paymentOptions.paymentoptions[it].icon,
                    selected = fsp == it,
                    onSelect = {
                        img = paymentOptions.paymentoptions[it].icon
                        fsp = it
                        isSheetOpen=true
                        enabled=true
                    }
                )
            }

        }
        if(numfsp>0) {
            val savedOptions = actualData[2]
            Text(
                text = "Pay Using",
                fontSize = 14.sp,
                color = Color.Black,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier.padding(start = 20.dp, top = 10.dp, bottom = 10.dp)
            )
            LazyColumn(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
            ) {
                items(savedOptions.customer_linked_account.options.size-1) {
                    savedCard(
                        text = savedOptions.customer_linked_account.options[it].text,
                        iconUrl = savedOptions.customer_linked_account.options[it].icon
                    ) {
                        dataViewModel.showLoadingDialog = true
                    }
                }
            }
            if (dataViewModel.showLoadingDialog)
                popUp(
                    text="Please approve the request sent to your mobile phone",
                    seconds = dataViewModel.timer.value
                ) {
                    dataViewModel.countDownTimer.start()
                }
            else if (dataViewModel.showConfirmationDialog)
                popUp(
                    text="Your Transaction is successful. Redirecting to merchant site"
                )

        }
        if(isSheetOpen){
            ModalBottomSheet(
                sheetState=sheetState,
                onDismissRequest = {
                    isSheetOpen=false
                }) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color.White)
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(10.dp) ,
                        horizontalArrangement = Arrangement.SpaceBetween,
                        ) {
                        AsyncImage(
                            model = img,
                            contentDescription ="FSPLogo"

                        )
                            Icon(
                                imageVector = Icons.Filled.KeyboardArrowUp,
                                tint = Color.Black,
                                contentDescription = "Up Button",
                                modifier = Modifier
                                    .padding(10.dp)
                                    .size(20.dp)
                            )
                    }
                    var phoneNumber by remember {
                        mutableStateOf("")
                    }
                    var otp by remember{
                        mutableStateOf("")
                    }
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(10.dp) ,
                    ) {
                        TextField(
                            value =phoneNumber,
                            onValueChange = {
                                if(it.length<=10)
                                    phoneNumber = it
                            },
                            label = { Text("Enter phone number") },
                            singleLine = true,
                            keyboardOptions = KeyboardOptions(
                                keyboardType = KeyboardType.Phone,
                                imeAction = ImeAction.Done,
                            ),
                            modifier = Modifier.padding(10.dp)

                        )
                        TextField(
                            value =otp,
                            onValueChange = {
                                if(it.length<=6)
                                    otp = it
                            },
                            label = { Text("OTP") },
                            singleLine = true,
                            keyboardOptions = KeyboardOptions(
                                keyboardType = KeyboardType.Phone,
                                imeAction = ImeAction.Done
                            ),
                            modifier = Modifier.padding(10.dp)


                        )
                        }

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(10.dp),
                        horizontalArrangement = Arrangement.End,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            buildAnnotatedString {
                                append("OTP not recieved?")
                                withStyle(
                                    SpanStyle(
                                        fontWeight = FontWeight.Bold,
                                        color = Color.Blue
                                    )
                                ) {
                                    append("Send again.")
                                }
                            },
                            color = Color.Black,
                            fontSize = 10.sp,
                        )
                        Button(
                            onClick = {
                                enabled=false
                                otp="123456"
                                numfsp+=1
                             },
                            enabled=enabled,
                            shape= RoundedCornerShape(10.dp),
                            modifier = Modifier
                                .padding(16.dp),
                            colors = ButtonDefaults.buttonColors(
                                containerColor = Orange
                            )
                        )
                        {
                            Text(text = "Send OTP",
                                color = Color.White
                            )
                        }
                    }
            }
        }
        }



        

    }


}