package com.example.usernavigationexercise

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.example.usernavigationexercise.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayout


class MainActivity : AppCompatActivity() {
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val toolbar: Toolbar = binding.toolbar
        setSupportActionBar(toolbar)

        // Create an instance of the tab layout from the view.
        val tabLayout = binding.tabLayout as TabLayout
        // Set the text for each tab.
        tabLayout.addTab(tabLayout.newTab().setText("Top Stories"))
        tabLayout.addTab(tabLayout.newTab().setText("Tech News"))
        tabLayout.addTab(tabLayout.newTab().setText("Cooking"))

        // Set the tabs to fill the entire layout.
        tabLayout.tabGravity = TabLayout.GRAVITY_FILL

        // Use PagerAdapter to manage page views in fragments.
        // Using PagerAdapter to manage page views in fragments.
        // Each page is represented by its own fragment.
        // This is another example of the adapter pattern.
        val viewPager = binding.pager
        val adapter = PagerAdapter(
            supportFragmentManager, tabLayout.tabCount
        )
        viewPager.adapter = adapter

        // Setting a listener for clicks.
        viewPager.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(tabLayout))
        tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                tab?.let {
                    viewPager.currentItem = it.position
                }
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
                // Thực hiện các hành động khi tab không được chọn
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {
                // Thực hiện các hành động khi tab được chọn lại
            }
        })

    }
}



