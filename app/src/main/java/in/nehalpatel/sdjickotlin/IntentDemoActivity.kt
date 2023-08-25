package `in`.nehalpatel.sdjickotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText

class IntentDemoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intent_demo)
    }

    fun handleOnClickEvent(view: View) {

        val username = findViewById<EditText>(R.id.editTextName)
        val email = findViewById<EditText>(R.id.editTextEmail)
        Log.d("SDJIC", username.text.toString())
        Log.i("SDJIC", email.text.toString())

        val intent = Intent(this, IntentDemoResultActivity::class.java)
        intent.putExtra("username", username.text.toString())
        intent.putExtra("email", email.text.toString())

        startActivity(intent)
    }
}