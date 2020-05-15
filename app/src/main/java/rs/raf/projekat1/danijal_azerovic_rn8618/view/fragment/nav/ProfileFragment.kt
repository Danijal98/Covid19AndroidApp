package rs.raf.projekat1.danijal_azerovic_rn8618.view.fragment.nav

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import androidx.core.content.edit
import androidx.fragment.app.Fragment
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_profile.*
import rs.raf.projekat1.danijal_azerovic_rn8618.R
import rs.raf.projekat1.danijal_azerovic_rn8618.view.activity.LoginActivity
import rs.raf.projekat1.danijal_azerovic_rn8618.view.viewmodel.MainViewModel.Companion.pictureUrl


class ProfileFragment : Fragment(R.layout.fragment_profile){

    private lateinit var sharedPreferences:SharedPreferences

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        sharedPreferences = this.requireActivity().getSharedPreferences(this.requireActivity().packageName,Context.MODE_PRIVATE)
        init()
    }

    private fun init(){
        Picasso
            .get()
            .load(pictureUrl)
            .placeholder(R.drawable.ic_launcher_foreground)
            .into(profileImg)
        updateData()
        initListeners()
    }

    private fun updateData(){
        profileName.text = sharedPreferences.getString("ime","Greska u ucitavanju podataka...")
        profileSurname.text = sharedPreferences.getString("prezime","Greska u ucitavanju podataka...")
        profileHospital.text = sharedPreferences.getString("bolnica","Greska u ucitavanju podataka...")
    }

    private fun initListeners(){
        profileOdjavaBtn.setOnClickListener {
            sharedPreferences.edit().clear().commit()
            val intent = Intent(this.requireContext(), LoginActivity::class.java)
            startActivity(intent)
            this.requireActivity().finish()
        }

        prifileIzmeniBtn.setOnClickListener {
            updateView(true)
        }

        profileSacuvajBtn.setOnClickListener {
            //CHANGE DATA
            sharedPreferences.edit {
                /*
                Mogu se menjati pojedinacne stavke, ako se klikne sacuvaj sa
                svim praznim parametrima nece se nista promeniti
                 */
                if (profileEditName.text.isNotBlank()) putString("ime",profileEditName.text.toString())
                if (profileEditSurname.text.isNotBlank()) putString("prezime",profileEditSurname.text.toString())
                if (profileEditHospital.text.isNotBlank()) putString("bolnica",profileEditHospital.text.toString())
                commit()
            }
            updateData()
            clearInput()
            updateView()
        }

        profileOdustaniBtn.setOnClickListener {
            clearInput()
            updateView()
        }

    }

    private fun clearInput(){
        profileEditName.text.clear()
        profileEditSurname.text.clear()
        profileEditHospital.text.clear()
    }

    private fun updateView(edit: Boolean = false){
        if(edit){
            //HIDE
            bottomButtonsLayout.visibility = View.GONE
            profileName.visibility = View.GONE
            profileSurname.visibility = View.GONE
            profileHospital.visibility = View.GONE

            //SHOW
            bottomButtonsLayout2.visibility = View.VISIBLE
            profileEditName.visibility = View.VISIBLE
            profileEditSurname.visibility = View.VISIBLE
            profileEditHospital.visibility = View.VISIBLE
        }else{
            //HIDE
            bottomButtonsLayout2.visibility = View.GONE
            profileEditName.visibility = View.GONE
            profileEditSurname.visibility = View.GONE
            profileEditHospital.visibility = View.GONE

            //SHOW
            bottomButtonsLayout.visibility = View.VISIBLE
            profileName.visibility = View.VISIBLE
            profileSurname.visibility = View.VISIBLE
            profileHospital.visibility = View.VISIBLE
        }
    }


}