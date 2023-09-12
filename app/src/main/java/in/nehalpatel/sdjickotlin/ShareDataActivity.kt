package `in`.nehalpatel.sdjickotlin

import android.content.ContentValues
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import android.net.Uri
import android.os.Bundle
import android.os.Environment
import android.os.Environment.getExternalStorageDirectory
import android.provider.MediaStore
import android.util.Log
import android.view.View
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.graphics.drawable.toBitmap
import java.io.ByteArrayOutputStream
import java.io.File
import java.io.File.separator
import java.io.FileOutputStream


class ShareDataActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_share_data)
    }

    fun handleShareAppButton(view: View) {
        val shareIntent = Intent(Intent.ACTION_SEND)
        shareIntent.type = "text/plain"
        shareIntent.putExtra(Intent.EXTRA_SUBJECT, "Share Your Application")
        val app_url = "https://play.google.com/store/apps/details?id=" + packageName
        shareIntent.putExtra(Intent.EXTRA_TEXT, app_url)
        startActivity(Intent.createChooser(shareIntent, "Share via"))
    }

    fun handleShareImageButton(view: View) {
        // Get the image view that we want to share
        val iv = findViewById<ImageView>(R.id.ivNidhiDesai)

        // Get the bitmap from the image view
        val bitmap = iv.drawable.toBitmap()

        // Create a content URI for the image
        val uri = Uri.parse(MediaStore.Images.Media.insertImage(
            contentResolver,
            bitmap,
            "Nidhi Desai",
            null
        ))

//        val uri = contentResolver.insert(
//            MediaStore.Images.Media.EXTERNAL_CONTENT_URI,
//            ContentValues().apply {
//                put(MediaStore.Images.Media.DISPLAY_NAME, "Nidhi Desai")
//                put(MediaStore.Images.Media.MIME_TYPE, "image/jpeg")
//                put(MediaStore.Images.Media.RELATIVE_PATH, "Pictures/")
//            }
//        )

        // Create an intent to share the image
        val shareIntent = Intent(Intent.ACTION_SEND)
        shareIntent.type = "image/*"
        shareIntent.putExtra(Intent.EXTRA_STREAM, uri)

        // Start the share activity
        startActivity(shareIntent)
    }
}