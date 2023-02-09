package id.ryan.fragmentlifecycle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import id.ryan.fragmentlifecycle.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewPagerAdapter: ViewPagerAdapter
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewPagerAdapter = ViewPagerAdapter(supportFragmentManager, lifecycle)

        with(binding) {
            viewPager.adapter =viewPagerAdapter

            TabLayoutMediator(tabLayout,viewPager) {tab, posisiton ->
                when(posisiton) {
                    0-> tab.text = "Chats"
                    1-> tab.text = "Status"
            }
            } .attach()
        }
    }
}