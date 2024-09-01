package app.yoshida.saryu.countup

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager2.adapter.FragmentStateAdapter
import app.yoshida.saryu.countup.databinding.ActivityTutorialBinding

class TutorialActivity : AppCompatActivity() {
    private lateinit var binding: ActivityTutorialBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTutorialBinding.inflate(layoutInflater).apply { setContentView(this.root) }

        val pagerAdapter = PagerAdapter(this)
        binding.viewPager.adapter = pagerAdapter
    }

    private inner class PagerAdapter(fa: FragmentActivity) : FragmentStateAdapter(fa) {
        override fun getItemCount(): Int = 3

        override fun createFragment(position: Int): Fragment =
            when(position) {
                0 -> {
                    FragmentOne()
                }
                1 -> {
                    FragmentTwo()
                }
                2 -> {
                    FragmentThree()
                }
                else -> {
                    FragmentOne()
                }
            }
    }

}