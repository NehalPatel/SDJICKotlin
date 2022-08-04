package `in`.nehalpatel.sdjickotlin

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import java.net.URI

class ImplicitIntentDemoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_implicit_intent_demo)
    }

    fun handleOpenGoogle(view: View) {
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com"))
        startActivity(intent)
    }
    fun handleCallMe(view: View) {
        val intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:9558815342"))
        startActivity(intent)
    }
}