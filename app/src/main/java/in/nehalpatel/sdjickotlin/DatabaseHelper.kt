package `in`.nehalpatel.sdjickotlin

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper


class DatabaseHelper : SQLiteOpenHelper  {

    private val TABLE_CONTACTS:String?
    private val KEY_ID:String?
    private val KEY_NAME:String?
    private val KEY_PH_NO:String?

    init {
        TABLE_CONTACTS = "contacts"
        KEY_ID = "id"
        KEY_NAME = "name"
        KEY_PH_NO = "phone_number"
    }

    constructor(context: Context?) : super(context, "contactsManager", null, 1)


    override fun onCreate(p0: SQLiteDatabase?) {
        val CREATE_CONTACTS_TABLE = ("CREATE TABLE " + TABLE_CONTACTS + "("
                + KEY_ID + " INTEGER PRIMARY KEY," + KEY_NAME + " TEXT,"
                + KEY_PH_NO + " TEXT" + ")")
        if (p0 != null) {
            p0.execSQL(CREATE_CONTACTS_TABLE)
        }
    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
        if (p0 != null) {
            // Drop older table if existed
            p0.execSQL("DROP TABLE IF EXISTS " + TABLE_CONTACTS)

            // Create tables again
            onCreate(p0);
        }
    }

    fun addContact(contact: Contact) {
        val db = this.writableDatabase
        val values = ContentValues()
        values.put(KEY_NAME, contact.getName()) // Contact Name
        values.put(KEY_PH_NO, contact.getPhoneNumber()) // Contact Phone

        // Inserting Row
        db.insert(TABLE_CONTACTS, null, values)
        //2nd argument is String containing nullColumnHack
        db.close() // Closing database connection
    }

    // code to get the single contact  
    fun getContact(id: Int): Contact? {
        val db = this.readableDatabase
        val cursor: Cursor? = db.query(
            TABLE_CONTACTS, arrayOf(
                KEY_ID,
                KEY_NAME, KEY_PH_NO
            ), "$KEY_ID=?", arrayOf(id.toString()), null, null, null, null
        )
        if (cursor != null) cursor.moveToFirst()
        // return contact  
        if (cursor != null) {
            return Contact(
                cursor.getString(0).toInt(),
                cursor.getString(1), cursor.getString(2)
            )
        }
        
        return null
    }

    // code to get all contacts in a list view
    fun getAllContacts(): List<Contact>? {
        val contactList: MutableList<Contact> = ArrayList()
        // Select All Query
        val selectQuery = "SELECT  * FROM $TABLE_CONTACTS"
        val db = this.writableDatabase
        val cursor = db.rawQuery(selectQuery, null)

        // looping through all rows and adding to list
        if (cursor != null && cursor.moveToFirst()) {
            do {

                val contact = Contact()

                contact.setID(cursor.getString(0).toInt())
                contact.setName(cursor.getString(1))
                contact.setPhoneNumber(cursor.getString(2))
                // Adding contact to list
                contactList.add(contact)
            } while (cursor.moveToNext())
        }

        // return contact list
        return contactList
    }

    // code to update the single contact
    fun updateContact(contact: Contact): Int {
        val db = this.writableDatabase
        val values = ContentValues()
        values.put(KEY_NAME, contact.getName())
        values.put(KEY_PH_NO, contact.getPhoneNumber())

        // updating row
        return db.update(TABLE_CONTACTS, values, "$KEY_ID = ?", arrayOf(contact.getID().toString()))
    }

    // Deleting single contact
    fun deleteContact(contact: Contact) {
        val db = this.writableDatabase
        db.delete(TABLE_CONTACTS, "$KEY_ID = ?", arrayOf(contact.getID().toString()))
        db.close()
    }

    // Getting contacts Count
    fun getContactsCount(): Int {
        val countQuery = "SELECT  * FROM $TABLE_CONTACTS"
        val db = this.readableDatabase
        val cursor = db.rawQuery(countQuery, null)
        cursor.close()

        // return count
        return cursor.count
    }
}