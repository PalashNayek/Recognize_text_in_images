package com.palash.recognizetextinimages

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.google.firebase.ml.vision.text.FirebaseVisionText
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private val textRecognitionHelper = TextRecognitionHelper()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val bitmap = BitmapFactory.decodeResource(resources, R.drawable.pan_card)
        recognizeText(bitmap)
    }

    private fun recognizeText(bitmap: Bitmap) {
        textRecognitionHelper.recognizeText(bitmap)
            .addOnSuccessListener { firebaseVisionText ->
                // Task completed successfully
                processTextRecognitionResult(firebaseVisionText)
            }
            .addOnFailureListener { e ->
                // Task failed with an exception
                Log.e("MyRes", "Text recognition failed", e)
            }
    }

    private fun processTextRecognitionResult(firebaseVisionText: FirebaseVisionText) {
        for (block in firebaseVisionText.textBlocks) {
            val blockText = block.text
            Log.d("MyTxt", "Text: $blockText")
            // Process individual blocks of text as needed
        }
    }
}