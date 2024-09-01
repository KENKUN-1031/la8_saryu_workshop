package app.yoshida.saryu.countup

import android.content.Context
import android.content.SharedPreferences
import android.graphics.Color
import android.media.MediaPlayer
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import app.yoshida.saryu.countup.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var sharedPreferences: SharedPreferences
    private var countNumber: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater).apply { setContentView(this.root) }
//        setContentView(R.layout.activity_title)

        // sharedPreferenceを読み込む
        sharedPreferences = getSharedPreferences("prefs_name", Context.MODE_PRIVATE)
        countNumber = sharedPreferences.getInt("COUNT", 0)

        val oddSound = MediaPlayer.create(this, R.raw.drum_sound)
        binding.countNumber.text = countNumber.toString()

        binding.upButton.setOnClickListener {
            countNumber += 1
            binding.countNumber.text = countNumber.toString()
            when {
                countNumber % 2 == 0 -> {
                    binding.countNumber.setTextColor(Color.BLUE)
                }
                countNumber % 2 == 1 -> {
                    binding.countNumber.setTextColor(Color.RED)
                    oddSound.seekTo(0)
                    oddSound.start()
                }
                else -> {
                    binding.countNumber.setTextColor(Color.BLACK)
                }
            }
        }
    }

    override fun onPause() {
        super.onPause()
        val editor = sharedPreferences.edit()
        editor.putInt("COUNT", countNumber)
        editor.apply()
    }
}
