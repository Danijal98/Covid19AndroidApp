package rs.raf.projekat1.danijal_azerovic_rn8618.view.recycler.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import rs.raf.projekat1.danijal_azerovic_rn8618.R
import rs.raf.projekat1.danijal_azerovic_rn8618.model.Pacijent
import rs.raf.projekat1.danijal_azerovic_rn8618.view.recycler.diff.PacijentDiffItemCallback
import rs.raf.projekat1.danijal_azerovic_rn8618.view.recycler.viewholder.HospViewHolder

class HospAdapter (
    pacijentDiffItemCallback: PacijentDiffItemCallback,
    private val onOtpustClicked: (Pacijent) -> Unit,
    private val onKartonClicked: (Pacijent) -> Unit) : ListAdapter<Pacijent, HospViewHolder>(pacijentDiffItemCallback){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HospViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val containerView = layoutInflater.inflate(R.layout.list_item_hosp, parent, false)
        return HospViewHolder(containerView,{
            val pacijent = getItem(it)
            onOtpustClicked(pacijent)
        },
        {
            val pacijent = getItem(it)
            onKartonClicked(pacijent)
        })
    }

    override fun onBindViewHolder(holder: HospViewHolder, position: Int) {
        val pacijent = getItem(position)
        holder.bind(pacijent)
    }


}