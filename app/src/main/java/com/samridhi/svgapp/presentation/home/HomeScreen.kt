package com.samridhi.svgapp.presentation.home

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.samridhi.svgapp.R
import com.samridhi.svgapp.alias.AppString
import com.samridhi.svgapp.navigation.HomeScreenActions

@Composable
fun HomeScreen(
    onActions: (HomeScreenActions) -> Unit
){
    HomeScreenContent(
        openGenerateDogsScreen = {
          onActions(HomeScreenActions.OpenGenerateScreen)
        },
        openRecentlyGeneratedScreen = {
             onActions(HomeScreenActions.OpenRecentlyGeneratedScreen)
        }
    )
}

@Composable
fun HomeScreenContent(
    modifier: Modifier = Modifier,
    openGenerateDogsScreen: () -> Unit,
    openRecentlyGeneratedScreen: () -> Unit
){
Column(
    modifier = modifier.fillMaxSize(),
    horizontalAlignment = Alignment.CenterHorizontally,
    verticalArrangement = Arrangement.Center
    ) {
    Text(
        modifier = Modifier,
        text = stringResource(AppString.random_dog_generator)
    )
    Spacer(modifier = Modifier.size(40.dp))
    Button(modifier = Modifier,
        border = BorderStroke(2.dp, Color.Black),
        onClick = {
            openGenerateDogsScreen()
        }
    ) {
        Text(
            text = stringResource(AppString.generate_dogs)
        )
    }

    Button(
        modifier = Modifier.padding(top = 18.dp),
        border = BorderStroke(2.dp, Color.Black),
        onClick = {
            openRecentlyGeneratedScreen()
        }
    ) {
        Text(
            text = stringResource(AppString.my_recently_generated_dogs)
        )
    }
}
}
@Preview(showBackground = true)
@Composable
fun HomeScreenPreview(){
    HomeScreenContent(
        openGenerateDogsScreen = {},
        openRecentlyGeneratedScreen = {}
    )

}