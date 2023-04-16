package com.example.bottomsheetjetpackcomposeapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.Green
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bottomsheetjetpackcomposeapp.ui.theme.BottomsheetJetpackcomposeAppTheme
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterialApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BottomsheetJetpackcomposeAppTheme {

                val sheetState = rememberBottomSheetState(initialValue =BottomSheetValue.Collapsed ,
                    // if you create an animation
//                animationSpec = spring(
//                    dampingRatio = Spring.DampingRatioHighBouncy
//                )
                )
                val scaffoldState = rememberBottomSheetScaffoldState(
                    bottomSheetState = sheetState
                )

                val scope = rememberCoroutineScope()
                BottomSheetScaffold(
                    scaffoldState = scaffoldState,
                    sheetContent ={

                    Box(modifier = Modifier
                        .fillMaxWidth()
                        .height(300.dp),
                    contentAlignment = Alignment.Center) {

                        Text(text = "Bottom sheet", fontSize = 60.sp)

                    }


                } ,
                sheetBackgroundColor = Green,
                sheetPeekHeight = 0.dp) {


                        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {

                            Button(onClick = {
                                scope.launch {

                                    if (sheetState.isCollapsed) {

                                        sheetState.expand()


                                    } else {
                                        sheetState.collapse()
                                    }


                                }



                            }) {

                                Text( text = "Bottom sheet fraction ${sheetState.progress.fraction}")



                            }



                        }

                }

            }
        }
    }
}

