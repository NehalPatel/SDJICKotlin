package `in`.nehalpatel.sdjickotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View

class LifeCycleDemoActivity : AppCompatActivity() {

    private var TAG = "TYBCA"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_life_cycle_demo)

        Log.d(TAG, "onCreate Activity Called : LifeCycleDemoActivity")
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart Activity Called : LifeCycleDemoActivity")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume Activity Called : LifeCycleDemoActivity")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPause Activity Called : LifeCycleDemoActivity")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "onStop Activity Called : LifeCycleDemoActivity")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(TAG, "onRestart Activity Called : LifeCycleDemoActivity")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy Activity Called : LifeCycleDemoActivity")
    }

    fun openSecondActivity(view: View) {
        val intent = Intent(this, SecondActivity::class.java)
        startActivity(intent)
    }
}