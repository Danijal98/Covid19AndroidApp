package rs.raf.projekat1.danijal_azerovic_rn8618.view.activity

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_karton.*
import kotlinx.android.synthetic.main.fragment_profile.*
import rs.raf.projekat1.danijal_azerovic_rn8618.R
import timber.log.Timber

class KartonActivity : AppCompatActivity(R.layout.activity_karton) {

    private lateinit var pacijentID: Integer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        init()
    }

    private fun init(){
        initView()
        initListeners()
    }

    private fun initView(){
        intent.let {
            kartonIme.setText(it.getStringExtra("ime"))
            kartonPrezime.setText(it.getStringExtra("prezime"))
            kartonStanjePrijem.setText(it.getStringExtra("stanjePrijem"))
            kartonStanjeSada.setText(it.getStringExtra("stanjeSada"))
            kartonDatumPrijema.text = it.getStringExtra("datum")
            pacijentID = Integer(it.getIntExtra("id",-1))
        }
    }

    private fun initListeners(){
        kartonOdustaniBtn.setOnClickListener {
            finish()
        }
        kartonIzmeniBtn.setOnClickListener {
            val returnIntent = Intent()
            returnIntent.putExtra("id", pacijentID)
            returnIntent.putExtra("ime", kartonIme.text.toString())
            returnIntent.putExtra("prezime", kartonPrezime.text.toString())
            returnIntent.putExtra("stanjePrijem", kartonStanjePrijem.text.toString())
            returnIntent.putExtra("stanjeSada", kartonStanjeSada.text.toString())
            setResult(Activity.RESULT_OK, returnIntent)
            finish()
        }
    }

}
