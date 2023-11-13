package com.kyawzinlinn.carouselslider

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.kyawzinlinn.carouselslider.ui.theme.CarouselSliderTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CarouselSliderTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background
                ) {
                    val images = listOf(
                        R.drawable.img,
                        R.drawable.img_1,
                        R.drawable.img_2,
                        R.drawable.img_3,
                        R.drawable.img_4,
                    )
                    Column {
                        Spacer(Modifier.height(32.dp))
                        CarouselSlider(itemCount = images.size,
                            itemCardShape = RoundedCornerShape(10.dp),
                            dotShape = CircleShape,
                            dotColor = MaterialTheme.colorScheme.primary,
                            dotSize = 10.dp,
                            pageSpacing = 16.dp,
                            duration = 3000L,
                            modifier = Modifier.height(200.dp),
                            onItemClick = { index ->
                                // handle item click here
                            }) { index ->
                            Image(
                                painter = painterResource(images.get(index)),
                                contentDescription = null,
                                modifier = Modifier
                                    .height(200.dp)
                                    .fillMaxWidth(),
                                contentScale = ContentScale.Crop
                            )
                        }
                    }
                }
            }
        }
    }
}