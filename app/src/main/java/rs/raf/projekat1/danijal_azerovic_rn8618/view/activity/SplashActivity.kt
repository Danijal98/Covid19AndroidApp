package rs.raf.projekat1.danijal_azerovic_rn8618.view.activity

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val sharedPreferences = getSharedPreferences(packageName, Context.MODE_PRIVATE)
        val username = sharedPreferences.getString("ime","")
        val intent = if(username=="") Intent(this,
            LoginActivity::class.java)
                     else Intent(this,
            MainActivity::class.java)
        startActivity(intent)
        finish()
    }
}
