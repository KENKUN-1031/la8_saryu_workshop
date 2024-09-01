package app.yoshida.saryu.countup

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import app.yoshida.saryu.countup.databinding.ActivityTitleBinding
import org.json.JSONObject

class TitleActivity : AppCompatActivity() {
    private lateinit var binding: ActivityTitleBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTitleBinding.inflate(layoutInflater).apply { setContentView(this.root) }

        val countIntent: Intent = Intent(this, MainActivity::class.java)

        binding.moveButton.setOnClickListener {
            startActivity(countIntent)
        }

    }
}