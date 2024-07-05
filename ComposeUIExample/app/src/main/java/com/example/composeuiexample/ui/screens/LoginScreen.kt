package com.example.composeuiexample.ui.screens

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Password
import androidx.compose.material.icons.outlined.Password
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import com.example.composeuiexample.R
import com.example.composeuiexample.ui.navigation.NavigationScreens
import com.example.composeuiexample.ui.theme.NDarkGray
import com.example.composeuiexample.ui.theme.NGray
import com.example.composeuiexample.ui.utils.getGradient


@Composable
fun LoginScreen(navController: NavController){

    val context= LocalContext.current

    Box(modifier = Modifier
        .fillMaxSize()
        .background(Color.Black)
        .padding(top = 16.dp)) {
        Column(modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally) {
            
            Box(modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
            , contentAlignment = Alignment.TopCenter) {
                
                Image(painter = painterResource(id = R.drawable.netflixlogobrand), contentDescription ="",
                    modifier = Modifier.fillMaxWidth())
            }

            Column(modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
                ) {

                var emailValue by remember {
                    mutableStateOf("")
                }

                var passwordValue by remember {
                    mutableStateOf("")
                }

                TextField(value =emailValue , onValueChange ={
                    emailValue=it
                },

                    label = {
                        Text(text = "E-Posta",
                            color = Color.White,
                            fontSize = 12.sp)
                    },
                    colors = OutlinedTextFieldDefaults.colors(
                        unfocusedContainerColor = NGray,
                        focusedContainerColor = NGray,
                        cursorColor = Color.White,
                        focusedTextColor = Color.White,
                        unfocusedTextColor = Color.White,
                        disabledContainerColor = NGray,

                        ),
                    modifier = Modifier.fillMaxWidth(),
                    placeholder = {
                        Text(text = "E-Posta")
                    }
                )

                Spacer(modifier = Modifier.height(50.dp))

                var shortPasswordState by remember {
                    mutableStateOf(false)
                }
                var passwordState by remember {
                    mutableStateOf(true)
                }
                
                var passwordVisible by remember{
                    mutableStateOf(false)
                }

                TextField(value =passwordValue , onValueChange ={
                    passwordValue=it
                    if (passwordValue.length<8){
                        shortPasswordState=true
                    }else shortPasswordState=false

                },

                    label = {
                        Text(text = "Parola",
                            color = Color.White,
                            fontSize = 12.sp)
                    },
                    colors = OutlinedTextFieldDefaults.colors(
                        unfocusedContainerColor = NGray,
                        focusedContainerColor = NGray,
                        cursorColor = Color.White,
                        focusedTextColor = Color.White,
                        unfocusedTextColor = Color.White,
                        disabledContainerColor = NGray,

                        ),
                    modifier = Modifier.fillMaxWidth(),
                    placeholder = {
                        Text(text = "Parola Giriniz")
                    },
                    supportingText = {
                        Column {
                            if (shortPasswordState){
                                Text(text = "Parolanız en az 8 karakter olmalı!"
                                    , color = Color.Red)
                            }
                            if (!passwordState){
                                Text(text = "Lütfen parolanızı giriniz!",
                                    color = Color.Red)
                            }
                        }

                    },
                    trailingIcon = {
                                   IconButton(onClick = {
                                       passwordVisible=!passwordVisible
                                   }) {
                                       Icon(imageVector = Icons.Outlined.Password, contentDescription = "")
                                   }
                                   
                    }
                    ,
                    visualTransformation = if(passwordVisible) VisualTransformation.None else PasswordVisualTransformation()
                )

                Spacer(modifier = Modifier.height(16.dp))

                Button(onClick = {
                    if (passwordValue.isEmpty() || emailValue.isEmpty()){
                        passwordState=false
                        Toast.makeText(context,"Lütfen giriş bilgilerinizi kontrol ediniz",Toast.LENGTH_LONG).show()
                    }else{
                        passwordState=true
                        //password girilmişse appscreene gidecek ve login screen backstackten kalkacak
                        navController.navigate(NavigationScreens.AppScreenRoute.route){
                            popUpTo(navController.graph.findStartDestination().id){
                                inclusive=true
                            }
                        }
                    }


                },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.Red,
                        contentColor = Color.Black
                    )) {

                        Text(text = "Giriş Yap",
                            fontSize = 15.sp)
                }
                
                TextButton(onClick = {
                    Toast.makeText(context,"Parola olustu",Toast.LENGTH_LONG).show()
                }) {
                    Text(text = "Parolanı Mı Unuttun?", color = NGray)
                }

                Spacer(modifier = Modifier
                    .height(16.dp))

                Spacer(modifier = Modifier
                    .height(1.dp)
                    .background(NGray)
                    .fillMaxWidth())

                Row(modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically) {

                    Text(text = "Hesabınız yok mu?", color = NGray)
                    TextButton(onClick = { }) {
                        Text(text = "Kayıt Ol", color = Color.Red)
                    }
                }

            }






        }
    }
}