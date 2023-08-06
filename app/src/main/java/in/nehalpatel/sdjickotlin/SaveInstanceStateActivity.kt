package `in`.nehalpatel.sdjickotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView

class SaveInstanceStateActivity : AppCompatActivity() {
    private var tvCounter:TextView? = null
    private var counter:Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_save_instance_state)

        tvCounter = findViewById<TextView>(R.id.tvCounter)
    }

    fun decreseCounter(view: View) {
        counter--
        tvCounter?.text = counter.toString()
    }
    fun increaseCounter(view: View) {
        counter++
        tvCounter?.text = counter.toString()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt("counter", counter)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        counter = savedInstanceState.getInt("counter")
        tvCounter?.text = counter.toString()
    }

    fun onClickSaveInstance(view: View) {}
}