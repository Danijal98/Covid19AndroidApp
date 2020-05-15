package rs.raf.projekat1.danijal_azerovic_rn8618.view.fragment.nav

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import kotlinx.android.synthetic.main.fragment_add.*
import rs.raf.projekat1.danijal_azerovic_rn8618.R
import rs.raf.projekat1.danijal_azerovic_rn8618.view.viewmodel.MainViewModel

class AddFragment : Fragment(R.layout.fragment_add){

    private val sharedViewModel : MainViewModel by activityViewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initListeners()
    }

    private fun initListeners(){
        addDodajBtn.setOnClickListener {
            if (addIme.text.isBlank() || addPrezime.text.isBlank() || addSimptomi.text.isBlank()){
                Toast.makeText(activity,"Jedno od polja nije popunjeno!", Toast.LENGTH_SHORT).show()
            }else{
                sharedViewModel.addPacijent(
                    addIme.text.toString(),
                    addPrezime.text.toString(),
                    addSimptomi.text.toString())
                clearInput()
                Toast.makeText(activity,"Osoba uspesno uneta u cekaonicu!", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun clearInput(){
        addIme.text.clear()
        addPrezime.text.clear()
        addSimptomi.text.clear()
    }

}