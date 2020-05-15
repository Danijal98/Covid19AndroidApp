package rs.raf.projekat1.danijal_azerovic_rn8618.view.recycler.viewholder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.list_item_cekaonica.*
import rs.raf.projekat1.danijal_azerovic_rn8618.R
import rs.raf.projekat1.danijal_azerovic_rn8618.model.Pacijent

class CekaonicaViewHolder (
    override val containerView: View,
    onZdravClicked: (Int) -> Unit,
    onHospClicked: (Int) -> Unit) : RecyclerView.ViewHolder(containerView), LayoutContainer{

    init {
        cekaonicaItemZdravBtn.setOnClickListener {
            onZdravClicked(adapterPosition)
        }
        cekaonicaItemHospBtn.setOnClickListener {
            onHospClicked(adapterPosition)
        }
    }

    fun bind(pacijent: Pacijent){
        Picasso
            .get()
            .load(pacijent.pic)
            .placeholder(R.mipmap.ic_launcher_round)
            .into(cekaonicaItemImg)
        cekaonicaItemName.text = pacijent.ime
        cekaonicaItemLastName.text = pacijent.prezime
        cekaonicaItemDescription.text = pacijent.simptopmi

    }

}