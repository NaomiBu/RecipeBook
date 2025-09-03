package com.example.recipebook

import android.graphics.drawable.Drawable
import android.media.Image
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.foundation.Image
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.platform.LocalContext
import com.example.recipebook.ui.theme.RecipeBookTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            RecipeBookTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Homescreen(
                        modifier = Modifier.padding(innerPadding)
                    )
                    Mexican_Burrito(
                        modifier = Modifier.padding(innerPadding)
                    )


                }
            }
        }
    }
}

@Composable
fun Homescreen ( modifier: Modifier = Modifier) {
    Column () {
        Text(
            text = stringResource(R.string.homepage_title),
            modifier = modifier
        )
        LazyColumn {
            // Add a single item
            item {
                Text(text = stringResource(R.string.recipe_one))
            }
            item {
                Text(text = stringResource(R.string.recipe_two))
            }
            item {
                Text(text = stringResource(R.string.recipe_three))
            }
            item {
                Text(text = stringResource(R.string.recipe_four))
            }
            item {
                Text(text = stringResource(R.string.recipe_five))
            }
        }
    }
}

@Composable
fun Mexican_Burrito (modifier: Modifier = Modifier) {
 Column (){
     val context = LocalContext.current
     val ingredients = context.resources.getStringArray(R.array.burrito_ingredients)
     val steps = context.resources.getStringArray(R.array.burrito_steps)
    Text(
        text =  stringResource(R.string.recipe_one)
    )
     Image(
        painter = painterResource(R.drawable.burrito),
         contentDescription = "Image of burrito"
     )
     Text(
         text = stringResource(R.string.burrito_description)
     )
     LazyColumn {
         // Add a single item
         ingredients.forEach {
             ingredient -> item { Text(text = ingredient)}
         }

     }
     LazyColumn {
         // Add a single item
         steps.forEach {
                 step -> item { Text(text = step)}
         }

     }

 }
}

@Preview(showBackground = true)
@Composable
fun RecipeBookPreview() {
    RecipeBookTheme {
        Homescreen()
    }
}