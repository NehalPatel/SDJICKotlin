package `in`.nehalpatel.sdjickotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.Window

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        getSupportActionBar()?.hide()
    }

    fun OnLifeCycleDemo(view: View) {
        val intent = Intent(this, LifeCycleDemoActivity::class.java)
        startActivity(intent)
    }

    fun handleOnClickEvent(view: View) {
        val intent = Intent(this, IntentDemoActivity::class.java)
        startActivity(intent)
    }

    fun handleOnClickImplicitIntent(view: View) {
        val intent = Intent(this, ImplicitIntentDemoActivity::class.java)
        startActivity(intent)
    }

    fun handleOnClickShareData(view: View) {
        val intent = Intent(this, ShareDataActivity::class.java)
        startActivity(intent)
    }

    fun handleOnClickOpenGallery(view: View) {
        val intent = Intent(this, GalleryImagesActivity::class.java)
        startActivity(intent)
    }

    fun OnClickDBDemo(view: View) {
        val intent = Intent(this, DBDemoActivity::class.java)
        startActivity(intent)
    }

    fun OnClickSaveState(view: View) {
        val intent = Intent(this, SaveInstanceStateActivity::class.java)
        startActivity(intent)
    }

    fun OnClickStudentRegistration(view: View) {
        val intent = Intent(this, StudentsActivity::class.java)
        startActivity(intent)
    }

    fun OnClickLocationDemo(view: View) {
        val intent = Intent(this, LocationDemoActivity::class.java)
        startActivity(intent)
    }
}