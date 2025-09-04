package com.example.recipebook

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.recipebook.ui.theme.RecipeBookTheme
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            RecipeBookTheme {
                val navController = rememberNavController()

                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    NavHost(
                        navController = navController,
                        startDestination = "home",
                        modifier = Modifier.padding(innerPadding)
                    ) {
                        composable("home") {
                            Homescreen(
                                onNextScreen = { route ->
                                    navController.navigate(route)
                                }
                            )
                        }
                        composable("mexican_burrito") {
                            Mexican_Burrito(
                                onNextScreen = { route ->
                                    navController.navigate(route)
                                }
                            )
                        }
                        composable("chicken_katsu_curry") {
                            Chicken_Katsu_Curry(onNextScreen = { route ->
                                navController.navigate(route)
                            })
                        }
                        composable("waakye") {
                            Waakye(onNextScreen = { route ->
                                navController.navigate(route)
                            })
                        }
                        composable("lasagne") {
                            Lasagne(onNextScreen = { route ->
                                navController.navigate(route)
                            })
                        }
                        composable("lamb_biryani") {
                            Lamb_Biryani(onNextScreen = { route ->
                                navController.navigate(route)
                            })
                        }
                    }
                }
            }
        }
    }
}


@Composable()
fun App() {
    // We won't use this `navController` for now,
    // but it's needed to setup the `NavHost`.
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "home")
     {

        // Here we declare all screens,
        // giving them a "route", which is a unique name
        // for each one.

        composable(route = "home") {
            Homescreen(onNextScreen = {
                navController.navigate("details")
            })
        }

        composable(route = "details") {
            Mexican_Burrito(onNextScreen = {
                navController.navigate("details")
            })
        }

        composable(route = "details") {
            Chicken_Katsu_Curry(onNextScreen = {
                navController.navigate("details")
            })
        }

        composable(route = "details") {
            Waakye(onNextScreen = {
                navController.navigate("details")
            })
        }

        composable(route = "details") {
            Lasagne(onNextScreen = {
                navController.navigate("details")
            })
        }

        composable(route = "details") {
            Lamb_Biryani(onNextScreen = {
                navController.navigate("details")
            })
        }
    }
}

@Composable
fun Homescreen (onNextScreen: (String) -> Unit, modifier: Modifier = Modifier) {
    val context = LocalContext.current
    val recipes = context.resources.getStringArray(R.array.recipes)
    Column ( modifier = Modifier
        .fillMaxSize(),

        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = stringResource(R.string.homepage_title),
            fontSize = 50.sp,
            fontFamily = FontFamily.Cursive,
            modifier = Modifier
                .padding(bottom = 40.dp, top = 30.dp)
        )
        Button( modifier = Modifier
                    .padding(bottom = 18.dp)
                     , colors = ButtonDefaults.buttonColors(
                         containerColor = colorResource(R.color.maximum_green),     // Background
                    contentColor = Color.White),


                        onClick = { onNextScreen("mexican_burrito") }) {
            Text(text = recipes[0])
        }
        Button(modifier = Modifier
                 .padding(bottom = 18.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = colorResource(R.color.maximum_green),     // Background
                         contentColor = Color.White),

            onClick = { onNextScreen("chicken_katsu_curry") }) {
            Text(text = recipes[1])
        }
        Button( modifier = Modifier
                 .padding(bottom = 18.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = colorResource(R.color.maximum_green),     // Background
                            contentColor = Color.White),

            onClick = { onNextScreen("waakye") }) {
            Text(text = recipes[2])
        }
        Button( modifier = Modifier
                .padding(bottom = 18.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = colorResource(R.color.maximum_green),
                            contentColor = Color.White),
                    onClick = { onNextScreen("lasagne") }) {
                         Text(text = recipes[3])
        }
        Button( modifier = Modifier
                .padding(bottom = 18.dp), colors = ButtonDefaults.buttonColors(
                    containerColor = colorResource(R.color.maximum_green),
                        contentColor = Color.White),
                    onClick = { onNextScreen("lamb_biryani") }) {
                        Text(text = recipes[4])
        }
        Image(
            painter = painterResource(R.drawable.collage),
            contentDescription = "Image of Burrito",
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .padding(top=100.dp)
            ,
            contentScale = ContentScale.Crop // scales nicely
        )
    }
}

@Composable
fun Mexican_Burrito (onNextScreen: (String) -> Unit, modifier: Modifier = Modifier) {
    val context = LocalContext.current
    val recipes = context.resources.getStringArray(R.array.recipes)
    val ingredients = context.resources.getStringArray(R.array.burrito_ingredients)
    val steps = context.resources.getStringArray(R.array.burrito_steps)
    val scrollState = rememberScrollState()

    Column (modifier = Modifier
        .fillMaxSize()
        .verticalScroll(scrollState),
        horizontalAlignment = Alignment.CenterHorizontally
        ) {

     Row (modifier = Modifier
     )
        {Text(
            text = stringResource(R.string.homepage_title),
                fontSize = 30.sp,
                    fontFamily = FontFamily.Cursive,
         modifier = Modifier
             .padding(bottom = 40.dp, top = 20.dp, end = 50.dp)
     )
         Button( modifier = Modifier
             .padding(10.dp),
                colors = ButtonDefaults.buttonColors(
                containerColor = colorResource(R.color.maximum_green),     // Background
                contentColor = Color.White),
                 onClick = { onNextScreen("home") }) {
            Icon( modifier = Modifier
                .size(18.dp),
                painter =  painterResource(R.drawable.home),
                contentDescription = "Home",

             )

         }}


     Column (modifier = Modifier
         .fillMaxWidth(),
          horizontalAlignment = Alignment.CenterHorizontally)
     {
         Text(
             text =  recipes[0],
             modifier = Modifier
                 .padding(bottom = 18.dp),
             fontWeight = FontWeight.Bold,
             fontSize = 20.sp

         )
         Image(
             painter = painterResource(R.drawable.burrito),
             contentDescription = "Image of Burrito",
             modifier = Modifier
                .align(Alignment.CenterHorizontally)
                 .size(350.dp),
                contentScale = ContentScale.Crop

         )
         Text(
                 text = stringResource(R.string.burrito_description),
         modifier = Modifier
             .fillMaxWidth()
             .padding(top = 18.dp, bottom = 18.dp, start = 20.dp, end = 20.dp),
             textAlign = TextAlign.Left
         )
         Text(
             modifier = Modifier
                 .fillMaxWidth()
                 .padding(top = 18.dp, bottom = 2.dp, start = 20.dp, end = 20.dp),
             text = stringResource(R.string.ingredients)
         )
         Column (modifier = Modifier
             .fillMaxWidth()
             .padding(top = 5.dp, bottom = 10.dp, start = 20.dp, end = 20.dp),
         ) {
             // Add a single item
             ingredients.forEach {
                     ingredient ->  Text(text = "• $ingredient")
             }

         }
         Text(
             modifier = Modifier
                 .fillMaxWidth()
                 .padding(top = 18.dp, bottom = 2.dp, start = 20.dp, end = 20.dp),
             text = stringResource(R.string.steps)
         )
         Column (modifier = Modifier
             .fillMaxWidth()
             .padding(top = 5.dp, bottom = 10.dp, start = 20.dp, end = 20.dp),
         ){
             // Add a single item
             steps.forEach {
                     step -> Text(text = "• $step")
             }

         }

     }


 }
}

@Composable
fun Chicken_Katsu_Curry (onNextScreen: (String) -> Unit, modifier: Modifier = Modifier) {
    val context = LocalContext.current
    val recipes = context.resources.getStringArray(R.array.recipes)
    val ingredients = context.resources.getStringArray(R.array.chicken_katsu_curry_ingredients)
    val steps = context.resources.getStringArray(R.array.chicken_katsu_curry_steps)
    val scrollState = rememberScrollState()

    Column (modifier = Modifier
        .fillMaxSize()
        .verticalScroll(scrollState),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Row (modifier = Modifier
        )
        {Text(
            text = stringResource(R.string.homepage_title),
            fontSize = 30.sp,
            fontFamily = FontFamily.Cursive,
            modifier = Modifier
                .padding(bottom = 40.dp, top = 20.dp, end = 50.dp)
        )
            Button( modifier = Modifier
                .padding(10.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = colorResource(R.color.maximum_green),     // Background
                    contentColor = Color.White),
                onClick = { onNextScreen("home") }) {
                Icon( modifier = Modifier
                    .size(18.dp),
                    painter =  painterResource(R.drawable.home),
                    contentDescription = "Home",

                    )

            }}


        Column (modifier = Modifier
            .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally)
        {
            Text(
                text =  recipes[1],
                modifier = Modifier
                    .padding(bottom = 18.dp),
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp

            )
            Image(
                painter = painterResource(R.drawable.chicken_katsu),
                contentDescription = "Image of Chicken Katsu Curry",
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .size(350.dp),
                    contentScale = ContentScale.Crop

            )
            Text(
                text = stringResource(R.string.chicken_katsu_curry_description),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 18.dp, bottom = 18.dp, start = 20.dp, end = 20.dp),
                textAlign = TextAlign.Left
            )
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 18.dp, bottom = 2.dp, start = 20.dp, end = 20.dp),
                text = stringResource(R.string.ingredients)
            )
            Column (modifier = Modifier
                .fillMaxWidth()
                .padding(top = 5.dp, bottom = 10.dp, start = 20.dp, end = 20.dp),
            ) {
                // Add a single item
                ingredients.forEach {
                        ingredient ->  Text(text = "• $ingredient")
                }

            }
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 18.dp, bottom = 2.dp, start = 20.dp, end = 20.dp),
                text = stringResource(R.string.steps)
            )
            Column (modifier = Modifier
                .fillMaxWidth()
                .padding(top = 5.dp, bottom = 10.dp, start = 20.dp, end = 20.dp),
            ){
                // Add a single item
                steps.forEach {
                        step -> Text(text = "• $step")
                }

            }

        }


    }
}


@Composable
fun Waakye (onNextScreen: (String) -> Unit, modifier: Modifier = Modifier) {
        val context = LocalContext.current
        val recipes = context.resources.getStringArray(R.array.recipes)
        val ingredients = context.resources.getStringArray(R.array.waakye_ingredients)
        val steps = context.resources.getStringArray(R.array.waakye_steps)
        val scrollState = rememberScrollState()

        Column (modifier = Modifier
            .fillMaxSize()
            .verticalScroll(scrollState),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Row (modifier = Modifier
            )
            {Text(
                text = stringResource(R.string.homepage_title),
                fontSize = 30.sp,
                fontFamily = FontFamily.Cursive,
                modifier = Modifier
                    .padding(bottom = 40.dp, top = 20.dp, end = 50.dp)
            )
                Button( modifier = Modifier
                    .padding(10.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = colorResource(R.color.maximum_green),     // Background
                        contentColor = Color.White),
                    onClick = { onNextScreen("home") }) {
                    Icon( modifier = Modifier
                        .size(18.dp),
                        painter =  painterResource(R.drawable.home),
                        contentDescription = "Home",

                        )

                }}


            Column (modifier = Modifier
                .fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally)
            {
                Text(
                    text =  recipes[2],
                    modifier = Modifier
                        .padding(bottom = 18.dp),
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp

                )
                Image(
                    painter = painterResource(R.drawable.waakye),
                    contentDescription = "Image of Waakye",
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                        .size(350.dp),
                        contentScale = ContentScale.Crop

                )
                Text(
                    text = stringResource(R.string.waakye_description),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 18.dp, bottom = 18.dp, start = 20.dp, end = 20.dp),
                    textAlign = TextAlign.Left
                )
                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 18.dp, bottom = 2.dp, start = 20.dp, end = 20.dp),
                    text = stringResource(R.string.ingredients)
                )
                Column (modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 5.dp, bottom = 10.dp, start = 20.dp, end = 20.dp),
                ) {
                    // Add a single item
                    ingredients.forEach {
                            ingredient ->  Text(text = "• $ingredient")
                    }

                }
                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 18.dp, bottom = 2.dp, start = 20.dp, end = 20.dp),
                    text = stringResource(R.string.steps)
                )
                Column (modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 5.dp, bottom = 10.dp, start = 20.dp, end = 20.dp),
                ){
                    // Add a single item
                    steps.forEach {
                            step -> Text(text = "• $step")
                    }

                }

            }


        }
    }

@Composable
fun Lasagne (onNextScreen: (String) -> Unit, modifier: Modifier = Modifier) {
        val context = LocalContext.current
        val recipes = context.resources.getStringArray(R.array.recipes)
        val ingredients = context.resources.getStringArray(R.array.lasagne_ingredients)
        val steps = context.resources.getStringArray(R.array.lasagne_steps)
        val scrollState = rememberScrollState()

        Column (modifier = Modifier
            .fillMaxSize()
            .verticalScroll(scrollState),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Row (modifier = Modifier
            )
            {Text(
                text = stringResource(R.string.homepage_title),
                fontSize = 30.sp,
                fontFamily = FontFamily.Cursive,
                modifier = Modifier
                    .padding(bottom = 40.dp, top = 20.dp, end = 50.dp)
            )
                Button( modifier = Modifier
                    .padding(10.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = colorResource(R.color.maximum_green),     // Background
                        contentColor = Color.White),
                    onClick = { onNextScreen("home") }) {
                    Icon( modifier = Modifier
                        .size(18.dp),
                        painter =  painterResource(R.drawable.home),
                        contentDescription = "Home",

                        )

                }}


            Column (modifier = Modifier
                .fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally)
            {
                Text(
                    text =  recipes[3],
                    modifier = Modifier
                        .padding(bottom = 18.dp),
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp

                )
                Image(
                    painter = painterResource(R.drawable.lasagne),
                    contentDescription = "Image of Lasagne",
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                        .size(350.dp),
                        contentScale = ContentScale.Crop

                )
                Text(
                    text = stringResource(R.string.lasagne_description),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 18.dp, bottom = 18.dp, start = 20.dp, end = 20.dp),
                    textAlign = TextAlign.Left
                )
                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 18.dp, bottom = 2.dp, start = 20.dp, end = 20.dp),
                    text = stringResource(R.string.ingredients)
                )
                Column (modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 5.dp, bottom = 10.dp, start = 20.dp, end = 20.dp),
                ) {
                    // Add a single item
                    ingredients.forEach {
                            ingredient ->  Text(text = "• $ingredient")
                    }

                }
                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 18.dp, bottom = 2.dp, start = 20.dp, end = 20.dp),
                    text = stringResource(R.string.steps)
                )
                Column (modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 5.dp, bottom = 10.dp, start = 20.dp, end = 20.dp),
                ){
                    // Add a single item
                    steps.forEach {
                            step -> Text(text = "• $step")
                    }

                }

            }


        }
    }

@Composable
fun Lamb_Biryani (onNextScreen: (String) -> Unit, modifier: Modifier = Modifier) {
        val context = LocalContext.current
        val recipes = context.resources.getStringArray(R.array.recipes)
        val ingredients = context.resources.getStringArray(R.array.lamb_biryani_ingredients)
        val steps = context.resources.getStringArray(R.array.lamb_biryani_steps)
        val scrollState = rememberScrollState()

        Column (modifier = Modifier
            .fillMaxSize()
            .verticalScroll(scrollState),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Row (modifier = Modifier
            )
            {Text(
                text = stringResource(R.string.homepage_title),
                fontSize = 30.sp,
                fontFamily = FontFamily.Cursive,
                modifier = Modifier
                    .padding(bottom = 40.dp, top = 20.dp, end = 50.dp)
            )
                Button( modifier = Modifier
                    .padding(10.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = colorResource(R.color.maximum_green),     // Background
                        contentColor = Color.White),
                    onClick = { onNextScreen("home") }) {
                    Icon( modifier = Modifier
                        .size(18.dp),
                        painter =  painterResource(R.drawable.home),
                        contentDescription = "Home",

                        )

                }}


            Column (modifier = Modifier
                .fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally)
            {
                Text(
                    text =  recipes[4],
                    modifier = Modifier
                        .padding(bottom = 18.dp),
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp

                )
                Image(
                    painter = painterResource(R.drawable.lamb_biryani),
                    contentDescription = "Image of Lamb Biryani",
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                        .size(350.dp),
                        contentScale = ContentScale.Crop

                )
                Text(
                    text = stringResource(R.string.lamb_biryani_description),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 18.dp, bottom = 18.dp, start = 20.dp, end = 20.dp),
                    textAlign = TextAlign.Left
                )
                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 18.dp, bottom = 2.dp, start = 20.dp, end = 20.dp),
                    text = stringResource(R.string.ingredients)
                )
                Column (modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 5.dp, bottom = 10.dp, start = 20.dp, end = 20.dp),
                ) {
                    // Add a single item
                    ingredients.forEach {
                            ingredient ->  Text(text = "• $ingredient")
                    }

                }
                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 18.dp, bottom = 2.dp, start = 20.dp, end = 20.dp),
                    text = stringResource(R.string.steps)
                )
                Column (modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 5.dp, bottom = 10.dp, start = 20.dp, end = 20.dp),
                ){
                    // Add a single item
                    steps.forEach {
                            step -> Text(text = "• $step")
                    }

                }

            }


        }
    }


@Preview(showBackground = true)
@Composable
fun RecipeBookPreview() {
    RecipeBookTheme {
        Homescreen(
            onNextScreen = {}
        )
    }
}

@Preview(showBackground = true)
@Composable
fun MexicanBurritoPreview() {
    RecipeBookTheme {
        Mexican_Burrito(
            onNextScreen = {}
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ChickenKatsuCurryPreview() {
    RecipeBookTheme {
        Chicken_Katsu_Curry(
            onNextScreen = {}
        )
    }
}

@Preview(showBackground = true)
@Composable
fun WaakyePreview() {
    RecipeBookTheme {
        Waakye(
            onNextScreen = {}
        )
    }
}

@Preview(showBackground = true)
@Composable
fun LasagnePreview() {
    RecipeBookTheme {
        Lasagne(
            onNextScreen = {}
        )
    }
}

@Preview(showBackground = true)
@Composable
fun LambBiryaniPreview() {
    RecipeBookTheme {
        Lamb_Biryani(
            onNextScreen = {}
        )
    }
}