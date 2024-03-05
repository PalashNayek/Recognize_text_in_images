package com.palash.recognizetextinimages

import android.graphics.Bitmap
import com.google.android.gms.tasks.Task
import com.google.firebase.ml.vision.FirebaseVision
import com.google.firebase.ml.vision.common.FirebaseVisionImage
import com.google.firebase.ml.vision.text.FirebaseVisionText
import com.google.firebase.ml.vision.text.FirebaseVisionTextRecognizer

class TextRecognitionHelper {

    fun recognizeText(bitmap: Bitmap): Task<FirebaseVisionText> {
        val image = FirebaseVisionImage.fromBitmap(bitmap)
        val recognizer = FirebaseVision.getInstance().onDeviceTextRecognizer
        return recognizer.processImage(image)
    }
}