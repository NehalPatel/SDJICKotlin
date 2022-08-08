package `in`.nehalpatel.sdjickotlin

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
        //val file: Uri = Uri.parse("android.resource://in.nehalpatel.sdjickotlin/" + R.drawable.nidhidesai)

        var iv:ImageView = findViewById(R.id.ivNidhiDesai)
        val bitmap = iv.drawable.toBitmap();


//        val bytes = ByteArrayOutputStream()
//        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, bytes)

        val path = MediaStore.Images.Media.insertImage(contentResolver, bitmap, "Nidhi Desai", null)

        Log.d("devashya", path.toString())

        val uri = Uri.parse(path)

        val shareIntent = Intent(Intent.ACTION_SEND)
        shareIntent.type = "image/*"
        shareIntent.putExtra(Intent.EXTRA_STREAM, uri)
        startActivity(shareIntent)
    }
}