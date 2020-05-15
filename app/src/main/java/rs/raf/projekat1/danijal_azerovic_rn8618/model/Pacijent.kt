package rs.raf.projekat1.danijal_azerovic_rn8618.model

import java.util.*

data class Pacijent(val id: Int, var ime: String, var prezime:String, var simptopmi:String, val datumPrijema: Date, val pic: String){

    var trenutnoStanje: String? = null
    var datumHospitalizacije: Date? = null
    var datumOtpusta: Date? = null

}