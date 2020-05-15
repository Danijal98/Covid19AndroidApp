package rs.raf.projekat1.danijal_azerovic_rn8618.view.activity

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.content.edit
import kotlinx.android.synthetic.main.activity_login.*
import rs.raf.projekat1.danijal_azerovic_rn8618.R

class LoginActivity : AppCompatActivity() {

    private val PIN = "1111"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        initListeners()
    }

    private fun initListeners(){
        login_btn.setOnClickListener {
            val access = !(login_ime.text.isBlank() || login_prezime.text.isBlank() || login_ime_bolnice.text.isBlank()
                    || login_pin.text.isBlank())

            if(access){

                if(login_pin.text.length != 4){
                    Toast.makeText(this,"Pin ima manje ili vise od 4 cifre!", Toast.LENGTH_SHORT).show()
                    login_pin.requestFocus()
                    return@setOnClickListener
                }else if(login_pin.text.toString() != PIN){
                    Toast.makeText(this,"Pogresan pin!", Toast.LENGTH_SHORT).show()
                    login_pin.requestFocus()
                    return@setOnClickListener
                }

                val intent = Intent(this, MainActivity::class.java).apply {
                    putExtra("ime",login_ime.text.toString())
                    putExtra("prezime", login_prezime.text.toString())
                    putExtra("bolnica", login_ime_bolnice.text.toString())
                }
                getSharedPreferences(packageName, Context.MODE_PRIVATE).edit {
                    putString("ime",login_ime.text.toString())
                    putString("prezime",login_prezime.text.toString())
                    putString("bolnica",login_ime_bolnice.text.toString())
                }
                startActivity(intent)
                finish()
            }else{
                Toast.makeText(this,"Jedno od polja je prazno!", Toast.LENGTH_SHORT).show()
                login_ime.requestFocus()
            }
        }
    }

}
