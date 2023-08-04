package `in`.nehalpatel.sdjickotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class SecondActivity : AppCompatActivity() {

    private var TAG = "TYBCA"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        Log.d(TAG, "onCreate Activity Called : SecondActivity")
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart Activity Called : SecondActivity")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume Activity Called : SecondActivity")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPause Activity Called : SecondActivity")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "onStop Activity Called : SecondActivity")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(TAG, "onRestart Activity Called : SecondActivity")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy Activity Called : SecondActivity")
    }
}