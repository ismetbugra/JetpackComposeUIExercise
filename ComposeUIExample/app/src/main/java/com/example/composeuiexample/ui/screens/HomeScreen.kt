package com.example.composeuiexample.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.composeuiexample.R
import com.example.composeuiexample.ui.data.Movie
import com.example.composeuiexample.ui.theme.NGray

var movieList = listOf(
    Movie(
        movie_name = "Joker",
        movie_genre = "Thriller/Crime",
        movie_point = "8.4",
        movie_details = "Arthur Fleck, a party clown and a failed stand-up comedian, leads an impoverished life with his ailing mother. " +
                "However, when society shuns him and brands him as a freak, he decides to embrace the life of crime and chaos in Gotham City.",
        movie_image = R.drawable.joker
    ),
    Movie(
        movie_name = "Money Heist",
        movie_genre = "Action/Crime/Drama",
        movie_point = "8.2",
        movie_details = "An unusual group of robbers attempt to carry out the most perfect robbery in Spanish history - stealing 2.4 billion euros from the Royal Mint of Spain.",
        movie_image =  R.drawable.lacasadepapel
    ),
    Movie(
        movie_name = "Batman",
        movie_genre = "Action/Crime/Drama",
        movie_point = "7.8",
        movie_details = "When a sadistic serial killer begins murdering key political figures in Gotham, " +
                "The Batman is forced to investigate the city's hidden corruption and question his family's involvement.",
        movie_image =  R.drawable.batman
    ),
    Movie(
        movie_name = "The Godfather",
        movie_genre = "Crime/Drama",
        movie_point = "9.2",
        movie_details = "Don Vito Corleone, head of a mafia family, decides to hand over his empire to his youngest son, Michael." +
                " However, his decision unintentionally puts the lives of his loved ones in grave danger.",
        movie_image =  R.drawable.godfather
    )



)


@Composable
fun HomeScreen(navController: NavController,innerPaddingValues: PaddingValues){

    Box(modifier = Modifier
        .fillMaxSize()
        .padding(innerPaddingValues)) {

        Column(modifier = Modifier.fillMaxSize()) {

            Box(modifier =Modifier.fillMaxWidth() ){

                NetflixOriginalSection(navController = navController)



            }
        }
    }
}


@Composable
fun NetflixOriginalSection(navController: NavController){
    Column(modifier = Modifier.fillMaxSize()) {
        Text(text = "Netflix Originals", color = NGray
            , fontSize = 20.sp)

        MovieList(navController = navController)


    }


}


@Composable
fun MovieList(navController: NavController){

    LazyRow {
        items(movieList){

            MovieRow(it,navController)
        }
    }


}


@Composable
fun MovieRow(movie: Movie,navController: NavController){
    Card(colors = CardDefaults.cardColors(
        containerColor = Color.Black,
    ),
        shape = RoundedCornerShape(15.dp),
        modifier = Modifier.padding(horizontal = 10.dp)) {
        Column(modifier = Modifier
            .wrapContentSize()
            , verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally) {
            Image(painter = painterResource(id = movie.movie_image), contentDescription = "",
                modifier = Modifier.size(200.dp,200.dp), contentScale = ContentScale.FillBounds)
            Text(text = movie.movie_name, fontSize = 15.sp, modifier = Modifier.padding(10.dp))
        }
    }



}