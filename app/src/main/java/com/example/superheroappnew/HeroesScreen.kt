package com.example.superheroappnew

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import com.example.superheroappnew.R
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.superheroappnew.model.Hero
import com.example.superheroappnew.model.HeroesRepository
import com.example.superheroappnew.ui.theme.SuperHeroAppNewTheme

@Composable
fun HeroCard(
    hero: Hero
) {
    Card(
        modifier = Modifier
            .clip(RoundedCornerShape(16.dp))
            .background(MaterialTheme.colors.onSurface),
        elevation = 2.dp,
    ) {
        Row(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
                .height(72.dp)
        ) {
            Column(modifier = Modifier
                .weight(1f)) {
                Text(
                    text = stringResource(id = hero.nameRes),
                    style = MaterialTheme.typography.h3
                )
                Text(
                    text = stringResource(id = hero.descriptionRes),
                    style = MaterialTheme.typography.body1
                )
            }

            Spacer(modifier = Modifier
                .width(16.dp))

            Image(
                painter = painterResource(id = hero.imageRes),
                contentDescription = stringResource(id = hero.descriptionRes),
                modifier = Modifier
                    .clip(RoundedCornerShape(8.dp))
                    .size(72.dp)
            )
        }
    }
}

@Composable
fun HeroListing(hero: List<Hero>, modifier: Modifier = Modifier) {
    LazyColumn(
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
    ) {

        items(hero) {
                heroes ->
            HeroCard(
                hero = heroes
            )
        }
    }
}

@Preview("Dark Theme", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Preview("light mode")
@Composable
fun HeroPreview() {
    val hero = Hero(
        R.string.hero1,
        R.string.description1,
        R.drawable.android_superhero1
    )
    SuperHeroAppNewTheme {
        HeroCard(hero = hero)
    }
}

@Preview
@Composable
fun HeroListingPreview(){
    SuperHeroAppNewTheme(darkTheme = false) {

        Surface(
            color = MaterialTheme.colors.background
        ) {
            HeroListing(hero = HeroesRepository.heroes)
        }
    }
}