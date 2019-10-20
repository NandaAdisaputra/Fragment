package nandaadi.saputra.fragment.activity

import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import nandaadi.saputra.fragment.R
import org.jetbrains.anko.startActivity

class SplashScreenActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)
       //TODO Buat handler splashscreennya
        Handler().postDelayed({
            finish()
            //anko
            startActivity<MainActivity>()
        }, 5000)

    }
}
