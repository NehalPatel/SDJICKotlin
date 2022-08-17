package `in`.nehalpatel.sdjickotlin

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity


class DBDemoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dbdemo)

        val db = DatabaseHelper(this)

        // Inserting Contacts

        // Inserting Contacts
        Log.i("DB Demo: ", "Inserting ..")
        db.addContact(Contact("Ravi", "9100000000"))
        db.addContact(Contact("Srinivas", "9199999999"))
        db.addContact(Contact("Tommy", "9522222222"))
        db.addContact(Contact("Karthik", "9533333333"))

        // Reading all contacts

        // Reading all contacts
        Log.i("DB Demo: ", "Reading all contacts..")
        val contacts: List<Contact>? = db.getAllContacts()

        if (contacts != null) {
            for (cn in contacts) {
                val log = "Id: " + cn.getID() + " ,Name: " + cn.getName() + " ,Phone: " +
                        cn.getPhoneNumber()
                // Writing Contacts to log
                Log.i("DB Demo: ", log)
            }
        }
    }
}