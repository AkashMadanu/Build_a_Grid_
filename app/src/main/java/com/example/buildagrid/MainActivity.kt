package com.example.buildagrid

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.layout.*
import androidx.compose.ui.res.*
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.*
import com.example.buildagrid.Datasource.*
import com.example.buildagrid.model.*
import com.example.buildagrid.ui.theme.BuildAGridTheme

class MainActivity : ComponentActivity()
{
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContent {
            BuildAGridTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                        modifier = Modifier.fillMaxSize(),
                        color = MaterialTheme.colorScheme.background
                ) {
                    TopicGrid(modifier = Modifier.padding(8.dp))
                }
            }
        }
    }
}



@Composable
fun TopicGrid(modifier: Modifier){

    LazyVerticalGrid(columns = GridCells.Fixed(2), verticalArrangement = Arrangement.spacedBy(
            dimensionResource(id = R.dimen.padding_small)), horizontalArrangement = Arrangement.spacedBy(
            dimensionResource(id = R.dimen.padding_small))){
        items(DataSource.topics){
            topic-> TopicCard(topic)
        }
    }
}


@Composable
fun TopicCard(topic: Topic)
{
    Card {
        Row(modifier = Modifier) {
            Box {
                
                Image(
                        painter = painterResource(id = topic.Pics),
                        contentDescription = stringResource(id = topic.topicName),
                        modifier = Modifier
                                .size(height = 68.dp, width = (70.dp))
                                .aspectRatio(1f)
//                                .height(68.dp)
//                                .width(68.dp),
                        ,
                        contentScale = ContentScale.Crop
                )
                
            }
            
            Column(modifier = Modifier) {
                
                Text(
                        text = stringResource(id = topic.topicName),
                        style = MaterialTheme.typography.bodyMedium,
                        modifier = Modifier.padding(
                                
                                start = dimensionResource(id = R.dimen.padding_medium),
                                bottom = dimensionResource(id = R.dimen.padding_small),
                                end = dimensionResource(id = R.dimen.padding_medium),
                                top = dimensionResource(id = R.dimen.padding_medium)
                        
                        )
                )
                
                Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.height(17.dp)
                ) {
                    Icon(
                            painter = painterResource(id = R.drawable.ic_grain),
                            contentDescription = null,
                            modifier = Modifier.padding(start = dimensionResource(id = R.dimen.padding_medium))
                    
                    )
                    Text(
                            text = topic.subTopics.toString(),
                            modifier = Modifier.padding(start = dimensionResource(id = R.dimen.padding_small))
                    )
                    
                }
            }
            
        }
    }
}




@Preview
@Composable
fun DefaultPreview()
{
    TopicCard(Topic(R.string.business,321,R.drawable.business))
}