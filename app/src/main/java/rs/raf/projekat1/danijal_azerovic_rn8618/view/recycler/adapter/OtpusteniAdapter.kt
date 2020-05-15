package rs.raf.projekat1.danijal_azerovic_rn8618.view.recycler.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import rs.raf.projekat1.danijal_azerovic_rn8618.R
import rs.raf.projekat1.danijal_azerovic_rn8618.model.Pacijent
import rs.raf.projekat1.danijal_azerovic_rn8618.view.recycler.diff.PacijentDiffItemCallback
import rs.raf.projekat1.danijal_azerovic_rn8618.view.recycler.viewholder.OtpusteniViewHolder

class OtpusteniAdapter (pacijentDiffItemCallback: PacijentDiffItemCallback) : ListAdapter<Pacijent, OtpusteniViewHolder>(pacijentDiffItemCallback){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OtpusteniViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val containerView = layoutInflater.inflate(R.layout.list_item_otpusteni, parent, false)
        return  OtpusteniViewHolder(containerView)
    }

    override fun onBindViewHolder(holder: OtpusteniViewHolder, position: Int) {
        val pacijent = getItem(position)
        holder.bind(pacijent)
    }

}