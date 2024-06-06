package com.example.digitalartspace

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.digitalartspace.ui.theme.DigitalArtspaceTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DigitalArtspaceTheme {
                Surface {
                    val paintings = DataSource().loadPainting()
                    DigitalArtSpace(paintings)
                }
            }
        }
    }
}



@Composable
fun DigitalArtSpace(paintings: List<Painting>, modifier: Modifier = Modifier){
    var imageSource by remember { mutableIntStateOf(1) }
    Column (modifier = Modifier.fillMaxWidth()){
        Box(modifier = modifier.fillMaxWidth()
            .padding(top = 30.dp, start = 10.dp, end = 10.dp)
            .border(1.5.dp, Color.DarkGray, RoundedCornerShape(20.dp))
            .shadow(elevation = 5.dp, shape = RoundedCornerShape((20.dp)))
            ) {
            Image(
                painter = painterResource(paintings[imageSource].imageResourceid),
                contentDescription = stringResource(paintings[imageSource].title),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(500.dp)
                    .clip(RoundedCornerShape(20.dp)),
                contentScale = ContentScale.Crop
            )
        }
        Spacer(modifier.height(30.dp))
        AuthorInfo(artPiece = stringResource(paintings[imageSource].title),
            author = stringResource(paintings[imageSource].description),
            year = stringResource(paintings[imageSource].year))
        Spacer(modifier.height(30.dp))
        Row(modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center){
            Button(onClick = { imageSource = (imageSource-1)%paintings.size
                if(imageSource < 0){
                    imageSource = paintings.size-1
                }

            }){ Text(
                text = stringResource(R.string.back_btn),
                fontSize = 24.sp)}
            Spacer(modifier = modifier.padding(16.dp))
            Button(onClick = { imageSource = (imageSource+1)%paintings.size }) {
                Text(
                    text = stringResource(R.string.next_btn),
                    fontSize = 24.sp)}
            }
    }
}



@Composable
fun AuthorInfo(artPiece: String, author: String, year: String, modifier: Modifier=Modifier){
    val tempString = "$author ($year)"
    Box(modifier = Modifier,
        contentAlignment = Alignment.Center){
        Column(modifier = modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally){
            Text(text = artPiece,
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold)
            Text(text = tempString,
                fontSize = 24.sp,
                fontWeight = FontWeight.SemiBold)
        }
    }
}


@Preview(showBackground = true)
@Composable
fun Preview() {
    DigitalArtspaceTheme {
        AuthorInfo("Test", "Test", "5555")
    }
}