package rs.raf.projekat1.danijal_azerovic_rn8618.view.fragment.tab

import android.os.Bundle
import android.view.View
import androidx.core.widget.doAfterTextChanged
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_cekaonica.*
import rs.raf.projekat1.danijal_azerovic_rn8618.R
import rs.raf.projekat1.danijal_azerovic_rn8618.view.recycler.adapter.CekaonicaAdapter
import rs.raf.projekat1.danijal_azerovic_rn8618.view.recycler.diff.PacijentDiffItemCallback
import rs.raf.projekat1.danijal_azerovic_rn8618.view.viewmodel.MainViewModel

class CekaonicaFragment : Fragment(R.layout.fragment_cekaonica){

    private val sharedViewModel : MainViewModel by activityViewModels()
    private lateinit var cekaonicaAdapter: CekaonicaAdapter

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
        initRecycler()
    }

    private fun initListeners(){
        ceokaonicaSearchText.doAfterTextChanged {
            sharedViewModel.filterCekaonica(it.toString())
        }
    }

    private fun initRecycler(){
        cekaonicaRecyclerList.layoutManager = LinearLayoutManager(activity)
        cekaonicaAdapter = CekaonicaAdapter(PacijentDiffItemCallback(),
            {
                sharedViewModel.zdravPacijent(it)
            },
            {
                sharedViewModel.hospitalizacija(it)
            })
        cekaonicaRecyclerList.adapter = cekaonicaAdapter
    }

    private fun initObservers(){
        sharedViewModel.getCekaonica().observe(viewLifecycleOwner, Observer {
            cekaonicaAdapter.submitList(it)
        })
    }

}