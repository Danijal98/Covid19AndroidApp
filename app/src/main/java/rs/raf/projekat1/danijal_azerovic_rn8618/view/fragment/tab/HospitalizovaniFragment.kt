package rs.raf.projekat1.danijal_azerovic_rn8618.view.fragment.tab

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.core.widget.doAfterTextChanged
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_hospitalizovani.*
import rs.raf.projekat1.danijal_azerovic_rn8618.R
import rs.raf.projekat1.danijal_azerovic_rn8618.view.activity.KartonActivity
import rs.raf.projekat1.danijal_azerovic_rn8618.view.recycler.adapter.HospAdapter
import rs.raf.projekat1.danijal_azerovic_rn8618.view.recycler.diff.PacijentDiffItemCallback
import rs.raf.projekat1.danijal_azerovic_rn8618.view.viewmodel.MainViewModel
import java.text.SimpleDateFormat

class HospitalizovaniFragment : Fragment(R.layout.fragment_hospitalizovani){

    companion object{
        const val MESSAGE_REQUEST_CODE = 1
    }

    private val sharedViewModel : MainViewModel by activityViewModels()
    private lateinit var hospAdapter: HospAdapter

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
        hospSearchText.doAfterTextChanged {
            sharedViewModel.filterHospitalizovani(it.toString())
        }
    }

    private fun initRecycler(){
        hospRecyclerList.layoutManager = LinearLayoutManager(activity)
        hospAdapter = HospAdapter(PacijentDiffItemCallback(), {
            sharedViewModel.otpust(it)
        },
        {
            val intent = Intent(activity, KartonActivity::class.java)
            val datePattern = "dd.MM.yyyy"
            val dateFormat = SimpleDateFormat(datePattern)
            val datum = dateFormat.format(it.datumPrijema)
            intent.putExtra("ime",it.ime)
            intent.putExtra("prezime", it.prezime)
            intent.putExtra("stanjePrijem", it.simptopmi)
            intent.putExtra("stanjeSada", it.trenutnoStanje)
            intent.putExtra("datum",datum)
            intent.putExtra("id",it.id)
            startActivityForResult(intent, MESSAGE_REQUEST_CODE)
        })
        hospRecyclerList.adapter = hospAdapter
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(resultCode != Activity.RESULT_OK){
            return
        }

        if(requestCode == MESSAGE_REQUEST_CODE){
            data?.let {
                val id = it.getIntExtra("id",-1)
                val ime = it.getStringExtra("ime")
                val prezime = it.getStringExtra("prezime")
                val stanjePrijem = it.getStringExtra("stanjePrijem")
                val stanjeSada = it.getStringExtra("stanjeSada")

                sharedViewModel.izmeniPacijent(id,ime,prezime,stanjePrijem,stanjeSada)
                hospAdapter.notifyDataSetChanged()
            }
        }
    }

    private fun initObservers(){
        sharedViewModel.getHospitalizovani().observe(viewLifecycleOwner, Observer {
            hospAdapter.submitList(it)
        })
    }

}