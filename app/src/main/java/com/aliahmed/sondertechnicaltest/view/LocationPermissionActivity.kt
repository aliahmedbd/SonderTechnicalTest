package com.aliahmed.sondertechnicaltest.view

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.provider.Settings
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.aliahmed.sondertechnicaltest.databinding.ActivityMapPermissionBinding

class LocationPermissionActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMapPermissionBinding
    private val REQUEST_FINE_LOCATION = 1002

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMapPermissionBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
       clickListener()
    }

    private fun clickListener() {
       binding.btnAllowAccess.setOnClickListener { requestPermission() }
        binding.txtNotNow.setOnClickListener {
            finish()
            moveTaskToBack(true)
        }
    }

    private fun requestPermission() {
        if (ContextCompat.checkSelfPermission(
                this,
                Manifest.permission.ACCESS_FINE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            if (ActivityCompat.shouldShowRequestPermissionRationale(
                    this@LocationPermissionActivity,
                    Manifest.permission.ACCESS_FINE_LOCATION
                )
            ) {
                ActivityCompat.requestPermissions(
                    this@LocationPermissionActivity,
                    arrayOf(Manifest.permission.ACCESS_FINE_LOCATION),
                    REQUEST_FINE_LOCATION
                )
            } else {
                ActivityCompat.requestPermissions(
                    this@LocationPermissionActivity,
                    arrayOf(Manifest.permission.ACCESS_FINE_LOCATION),
                    REQUEST_FINE_LOCATION
                )
            }
        } else {
            checkRedirectPage()
            // Toast.makeText(getApplicationContext(), "Permission granted", Toast.LENGTH_SHORT).show();
        }
    }

    /*
     The shouldShowRequestPermissionRationale() function returns true if the app has requested this permission
     previously and the user denied the request.If the user turned down the permission request in the past and chose
     the Don't ask again option, this method returns false.
      */
    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<String?>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == REQUEST_FINE_LOCATION) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                checkRedirectPage()
                //  Toast.makeText(getApplicationContext(), "Permission granted", Toast.LENGTH_SHORT).show();
            } else {
                if (!ActivityCompat.shouldShowRequestPermissionRationale(
                        this@LocationPermissionActivity,
                        Manifest.permission.ACCESS_FINE_LOCATION
                    )
                ) {
                    val alert = AlertDialog.Builder(this)
                        .setMessage("You have permanently disabled the permission ")
                        .setPositiveButton(
                            "Go to Settings -> Permission -> Location -> Click Allow option, after that re-open the application."
                        ) { _, _ -> openSettings() }.setNegativeButton("Don't Go", null)
                        .setCancelable(false).create()
                    alert.setTitle("Give permission manually")
                    alert.show()
                } else {
                    Toast.makeText(
                        applicationContext,
                        "Permission has been denied the 1st time",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }
    }

    private fun openSettings() {
        val intent = Intent()
        val uri = Uri.fromParts("package", this.packageName, null)
        intent.setAction(Settings.ACTION_APPLICATION_DETAILS_SETTINGS).data = uri
        startActivity(intent)
    }

    private fun checkRedirectPage() {
        /* Create an Intent that will start the Menu-Activity. */
        val mainIntent = Intent(this@LocationPermissionActivity, MainActivity::class.java)
        this@LocationPermissionActivity.startActivity(mainIntent)
        finish()

    }
}