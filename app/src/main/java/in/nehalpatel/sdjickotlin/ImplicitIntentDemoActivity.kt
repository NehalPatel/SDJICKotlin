package `in`.nehalpatel.sdjickotlin

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

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
        val intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:+919558815342"))
        startActivity(intent)
    }

    fun handleSendEmail(view: View) {

        val to = findViewById<EditText>(R.id.etEmailAddress)
        val subject = findViewById<EditText>(R.id.etEmailSubject)
        val body = findViewById<EditText>(R.id.etEmailBody)

        val intent = Intent(Intent.ACTION_VIEW)
        val data = Uri.parse("mailto:?subject=" + subject.text.toString() + "&body=" + body.text.toString() + "&to=" + to.text.toString())
        intent.data = data
        startActivity(intent)
    }
}