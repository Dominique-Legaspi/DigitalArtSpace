package com.example.digitalartspace
import com.example.digitalartspace.R
import com.example.digitalartspace.DataSource

class DataSource {
    fun loadPainting(): List<Painting> {
        return listOf<Painting>(
            Painting(R.string.image0, R.string.image0author, R.string.year, R.drawable.image0),
            Painting(R.string.image1, R.string.image1author, R.string.year, R.drawable.image1),
            Painting(R.string.image2, R.string.image2author, R.string.year, R.drawable.image2),
            Painting(R.string.image3, R.string.image3author, R.string.year, R.drawable.image3),
            Painting(R.string.image4, R.string.image4author, R.string.year, R.drawable.image4),
            Painting(R.string.image5, R.string.image5author, R.string.year, R.drawable.image5),
            Painting(R.string.image6, R.string.image6author, R.string.year, R.drawable.image6),
            Painting(R.string.image7, R.string.image7author, R.string.year, R.drawable.image7),
            Painting(R.string.image8, R.string.image8author, R.string.year, R.drawable.image8),
        )
    }
}