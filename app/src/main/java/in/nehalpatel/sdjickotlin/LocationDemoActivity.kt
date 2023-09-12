package `in`.nehalpatel.sdjickotlin

import android.Manifest
import android.content.pm.PackageManager
import android.location.Location
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices

class LocationDemoActivity : AppCompatActivity() {

    private val LOCATION_PERMISSION_REQUEST_CODE = 1
    private lateinit var fusedLocationClient: FusedLocationProviderClient

    private lateinit var userLatitude : TextView
    private lateinit var userLongitude : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_location_demo)

        userLatitude = findViewById(R.id.userLatitude)
        userLongitude = findViewById(R.id.userLongitude)

        fusedLocationClient = LocationServices.getFusedLocationProviderClient(this)
    }

    fun handleGetLocation(view: View) {
        // Check for location permissions
        if (checkLocationPermission()) {
            // Permissions are granted, so you can request the user's location
            getLastLocation()
        } else {
            // Request location permissions
            ActivityCompat.requestPermissions(
                this,
                arrayOf(Manifest.permission.ACCESS_FINE_LOCATION),
                LOCATION_PERMISSION_REQUEST_CODE
            )
        }
    }

    private fun checkLocationPermission(): Boolean {
        val permission = Manifest.permission.ACCESS_FINE_LOCATION
        val granted = PackageManager.PERMISSION_GRANTED
        return ContextCompat.checkSelfPermission(this, permission) == granted
    }

    private fun getLastLocation() {
        if (checkLocationPermission()) {
            fusedLocationClient.lastLocation
                .addOnSuccessListener { location: Location? ->
                    // Handle the location here, 'location' contains the user's last known location
                    if (location != null) {
                        val latitude = location.latitude
                        val longitude = location.longitude
                        // Display or use the latitude and longitude, e.g., in a TextView

                        this.userLatitude.text = "Latitude: " + latitude.toString()
                        this.userLongitude.text = "Longitude:" + longitude.toString()
                    }
                }
                .addOnFailureListener { e ->
                    // Handle any errors that may occur while getting the location
                    // e.g., if the user's location settings are turned off
                    Toast.makeText(this, "Error: " + e.message, Toast.LENGTH_LONG).show()
                }
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == LOCATION_PERMISSION_REQUEST_CODE) {
            if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                // Permission granted, you can request the user's location
                getLastLocation()
            } else {
                // Permission denied, handle accordingly
                Toast.makeText(this, "Permission denied", Toast.LENGTH_LONG).show()
            }
        }
    }
}