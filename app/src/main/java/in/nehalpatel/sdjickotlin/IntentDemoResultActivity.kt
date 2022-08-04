package `in`.nehalpatel.sdjickotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView

class IntentDemoResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intent_demo_result)

        val userName = findViewById<TextView>(R.id.txtUserNameResult)
        userName.text = intent.getStringExtra("username")

        val userEmail = findViewById<TextView>(R.id.txtEmailTitleResult)
        userEmail.text = intent.getStringExtra("email")

    }

    fun handleOnClickEvent(view: View) {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }
}