package rs.raf.projekat1.danijal_azerovic_rn8618.view.fragment.tab

import android.os.Bundle
import android.view.View
import androidx.core.widget.doAfterTextChanged
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import kotlinx.android.synthetic.main.fragment_otpusteni.*
import rs.raf.projekat1.danijal_azerovic_rn8618.R
import rs.raf.projekat1.danijal_azerovic_rn8618.view.recycler.adapter.OtpusteniAdapter
import rs.raf.projekat1.danijal_azerovic_rn8618.view.recycler.diff.PacijentDiffItemCallback
import rs.raf.projekat1.danijal_azerovic_rn8618.view.viewmodel.MainViewModel

class OtpusteniFragment : Fragment(R.layout.fragment_otpusteni){

    private val sharedViewModel : MainViewModel by activityViewModels()
    private lateinit var otpusteniAdapter: OtpusteniAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun init(){
        initUi()
        initObservers()
    }

    private fun initUi(){
        initListeners()
        initRecyclers()
    }

    private fun initListeners(){
        otpSearchText.doAfterTextChanged {
            sharedViewModel.filterOtpusteni(it.toString())
        }
    }

    private fun initRecyclers(){
        otpRecyclerList.layoutManager = GridLayoutManager(activity,2)
        otpusteniAdapter = OtpusteniAdapter(PacijentDiffItemCallback())
        otpRecyclerList.adapter = otpusteniAdapter
    }

    private fun initObservers(){
        sharedViewModel.getOtpusteni().observe(viewLifecycleOwner, Observer {
            otpusteniAdapter.submitList(it)
        })
    }



}