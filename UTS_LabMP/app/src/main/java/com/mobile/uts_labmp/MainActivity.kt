package com.mobile.uts_labmp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomnavigation.BottomNavigationView


class MainActivity : AppCompatActivity() {
    private lateinit var rvCategory: RecyclerView
    private val list = ArrayList<Category>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottom_navigation_view)
        bottomNavigationView.setOnNavigationItemReselectedListener { item ->
            when (item.itemId) {
                R.id.navigation_home -> {
                    // Handle Home item click
                    true
                }
                R.id.navigation_meal -> {
                    // Handle Meal Plans item click
                    true
                }
                R.id.navigation_exercise -> {
                    // Handle Exercise item click
                    true
                }
                R.id.navigation_profile -> {
                    // Handle Profile item click
                    true
                }
                else -> false
            }
        }

        rvCategory = findViewById(R.id.rv_category)
        rvCategory.setHasFixedSize(true)

        list.addAll(getListCategory())
        showRecyclerList()
    }

    private fun getListCategory(): ArrayList<Category> {
        val dataName = resources.getStringArray(R.array.data_name)
        val dataImage = resources.obtainTypedArray(R.array.data_img)
        val listCategory = ArrayList<Category>()
        for (i in dataName.indices) {
            val category = Category(dataImage.getResourceId(i, -1), dataName[i])
            listCategory.add(category)
        }

        return listCategory
    }

    private fun showRecyclerList() {
        rvCategory.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        val listCategoryAdapter = ListCategoryAdapter(list)
        rvCategory.adapter = listCategoryAdapter
    }
}