package rs.raf.projekat1.danijal_azerovic_rn8618.view.recycler.viewholder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.list_item_hosp.*
import rs.raf.projekat1.danijal_azerovic_rn8618.R
import rs.raf.projekat1.danijal_azerovic_rn8618.model.Pacijent

class HospViewHolder (
    override val containerView: View,
    onOtpustClicked: (Int) -> Unit,
    onKartonClicked: (Int) -> Unit) : RecyclerView.ViewHolder(containerView), LayoutContainer{

    init {
        hospItemOtpustBtn.setOnClickListener {
            onOtpustClicked(adapterPosition)
        }
        hospItemKartonBtn.setOnClickListener {
            onKartonClicked(adapterPosition)
        }
    }

    fun bind(pacijent: Pacijent){
        Picasso
            .get()
            .load(pacijent.pic)
            .placeholder(R.mipmap.ic_launcher_round)
            .into(hospItemImg)
        hospItemName.text = pacijent.ime
        hospItemLastName.text = pacijent.prezime
    }

}