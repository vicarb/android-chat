package com.local.androidapp.activity

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.local.androidapp.R
import com.local.androidapp.adapters.GridAdapter
import com.local.androidapp.models.GridItem

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)  // make sure this line is before findViewById

        // Initialize UI elements
        val navigateToLoginButton: Button = findViewById(R.id.navigateToLoginButton)
        val gridRecyclerView: RecyclerView = findViewById(R.id.gridRecyclerView)

        // Button click listener for navigating to the Login activity
        navigateToLoginButton.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }

        // Define mock data for the grid items
        val mockGridItems: List<GridItem> = listOf(
            GridItem("Item1", R.drawable.sample_image_1),
            GridItem("Item2", R.drawable.sample_image_2),
            GridItem("Item3", R.drawable.sample_image_3),
            GridItem("Item4", R.drawable.sample_image_4)
            // Add more items as you need
        )

        // Set up the RecyclerView
        gridRecyclerView.layoutManager = GridLayoutManager(this, 2) // 2 columns in the grid
        gridRecyclerView.adapter = GridAdapter(mockGridItems)

    }
}
