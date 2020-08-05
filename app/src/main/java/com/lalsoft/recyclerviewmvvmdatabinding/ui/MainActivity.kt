package com.lalsoft.recyclerviewmvvmdatabinding.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.lalsoft.recyclerviewmvvmdatabinding.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction().replace(R.id.fragment_container,
                    RecyclerFragment()).commit()
        }
    }
}