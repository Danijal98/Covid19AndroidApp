package rs.raf.projekat1.danijal_azerovic_rn8618.view.recycler.viewholder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.list_item_otpusteni.*
import rs.raf.projekat1.danijal_azerovic_rn8618.R
import rs.raf.projekat1.danijal_azerovic_rn8618.model.Pacijent
import java.text.SimpleDateFormat

class OtpusteniViewHolder (override val containerView: View) : RecyclerView.ViewHolder(containerView), LayoutContainer{

    fun bind(pacijent: Pacijent){
        Picasso
            .get()
            .load(pacijent.pic)
            .placeholder(R.mipmap.ic_launcher_round)
            .into(otpItemImg)
        otpItemName.text = pacijent.ime
        otpItemLastName.text = pacijent.prezime
        val datePattern = "dd.MM.yyyy"
        val dateFormat = SimpleDateFormat(datePattern)
        otpItemDatum.text = "Otpusten: " + dateFormat.format(pacijent.datumOtpusta)
    }

}