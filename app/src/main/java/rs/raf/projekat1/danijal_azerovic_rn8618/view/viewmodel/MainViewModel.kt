package rs.raf.projekat1.danijal_azerovic_rn8618.view.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import rs.raf.projekat1.danijal_azerovic_rn8618.model.Pacijent
import java.util.*

class MainViewModel : ViewModel(){

    companion object{
        var id = 0
        val pictureUrl: String = "https://www.jumpstarttech.com/files/2018/08/Network-Profile.png"
    }

    //Cekaonice
    private val listaCekaonica : MutableLiveData<List<Pacijent>> = MutableLiveData()
    private val cekList : MutableList<Pacijent> = mutableListOf()

    //Hospitalizovani
    private val listaHospitalizovani : MutableLiveData<List<Pacijent>> = MutableLiveData()
    private val hospList : MutableList<Pacijent> = mutableListOf()

    //Otpusteni
    private val listaOtpusteni : MutableLiveData<List<Pacijent>> = MutableLiveData()
    private val otpList : MutableList<Pacijent> = mutableListOf()

    init {
        for (i in 0..5){
            val pacijent = Pacijent(
                id,
                "Ime$id",
                "Prezime$id",
                "Kasalj",
                Date(),
                pictureUrl
            )
            id++
            cekList.add(pacijent)
        }
        val listToSubmit = mutableListOf<Pacijent>()
        listToSubmit.addAll(cekList)
        listaCekaonica.value = listToSubmit
    }


    fun getCekaonica() : LiveData<List<Pacijent>>{
        return listaCekaonica
    }

    fun getHospitalizovani() : LiveData<List<Pacijent>>{
        return listaHospitalizovani
    }

    fun getOtpusteni() : LiveData<List<Pacijent>>{
        return listaOtpusteni
    }

    fun filterCekaonica(filter: String){
        val filteredList = cekList.filter {
            it.ime.toLowerCase().startsWith(filter.toLowerCase()) ||
                    it.prezime.toLowerCase().startsWith(filter.toLowerCase())
        }
        listaCekaonica.value = filteredList
    }

    fun filterHospitalizovani(filter: String){
        val filteredList = hospList.filter {
            it.ime.toLowerCase().startsWith(filter.toLowerCase()) ||
                    it.prezime.toLowerCase().startsWith(filter.toLowerCase())
        }
        listaHospitalizovani.value = filteredList
    }

    fun filterOtpusteni(filter: String){
        val filteredList = otpList.filter {
            it.ime.toLowerCase().startsWith(filter.toLowerCase()) ||
                    it.prezime.toLowerCase().startsWith(filter.toLowerCase())
        }
        listaOtpusteni.value = filteredList
    }

    fun addPacijent(ime: String, prezime: String, simptopmi: String){
        val date = Date()
        val pacijent = Pacijent(id++,ime,prezime,simptopmi,date, pictureUrl)
        cekList.add(pacijent)
        val listToSubmit = mutableListOf<Pacijent>()
        listToSubmit.addAll(cekList)
        listaCekaonica.value = listToSubmit
    }

    fun zdravPacijent(pacijent: Pacijent){
        cekList.remove(pacijent)
        val listToSubmit = mutableListOf<Pacijent>()
        listToSubmit.addAll(cekList)
        listaCekaonica.value = listToSubmit
    }

    fun hospitalizacija(pacijent: Pacijent){
        //Brisanje iz cekaonice
        cekList.remove(pacijent)
        val listToSubmit = mutableListOf<Pacijent>()
        listToSubmit.addAll(cekList)
        listaCekaonica.value = listToSubmit

        //Dodavanje u hosp
        pacijent.datumHospitalizacije = Date()
        hospList.add(pacijent)
        val listToSubmit2 = mutableListOf<Pacijent>()
        listToSubmit2.addAll(hospList)
        listaHospitalizovani.value = listToSubmit2
    }

    fun otpust(pacijent: Pacijent){
        //Birsanje iz hosp
        hospList.remove(pacijent)
        val listToSubmit = mutableListOf<Pacijent>()
        listToSubmit.addAll(hospList)
        listaHospitalizovani.value = listToSubmit

        //Dodavanje u otp
        pacijent.datumOtpusta = Date()
        otpList.add(pacijent)
        val listToSubmit2 = mutableListOf<Pacijent>()
        listToSubmit2.addAll(otpList)
        listaOtpusteni.value = listToSubmit2
    }

    fun izmeniPacijent(id: Int, ime: String, prezime: String, stanjePrijem: String, stanjeSada: String){

        hospList.forEach {
            if (it.id == id){
                if (ime.isNotBlank()) it.ime = ime
                if (prezime.isNotBlank()) it.prezime = prezime
                if (stanjePrijem.isNotBlank()) it.simptopmi = stanjePrijem
                if (stanjeSada.isNotBlank()) it.trenutnoStanje = stanjeSada
                return@forEach
            }
        }

        val listToSubmit = mutableListOf<Pacijent>()
        listToSubmit.addAll(hospList)
        listaHospitalizovani.value = listToSubmit
    }


}