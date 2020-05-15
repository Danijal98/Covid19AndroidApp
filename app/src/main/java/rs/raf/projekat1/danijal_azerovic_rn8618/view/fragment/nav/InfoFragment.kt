package rs.raf.projekat1.danijal_azerovic_rn8618.view.fragment.nav

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import kotlinx.android.synthetic.main.fragment_info.*
import rs.raf.projekat1.danijal_azerovic_rn8618.R
import rs.raf.projekat1.danijal_azerovic_rn8618.view.viewmodel.MainViewModel

class InfoFragment : Fragment(R.layout.fragment_info){

    private val sharedViewModel : MainViewModel by activityViewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initObservers()
    }

    private fun initObservers(){
        sharedViewModel.getCekaonica().observe(viewLifecycleOwner, androidx.lifecycle.Observer {
            infoBrojCekaonica.text = it.size.toString()
        })

        sharedViewModel.getHospitalizovani().observe(viewLifecycleOwner, androidx.lifecycle.Observer {
            infoBrojHosp.text = it.size.toString()
        })

        sharedViewModel.getOtpusteni().observe(viewLifecycleOwner, androidx.lifecycle.Observer {
            infoBrojOtp.text = it.size.toString()
        })
    }

}