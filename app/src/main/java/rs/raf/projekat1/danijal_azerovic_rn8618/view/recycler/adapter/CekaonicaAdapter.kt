package rs.raf.projekat1.danijal_azerovic_rn8618.view.recycler.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import rs.raf.projekat1.danijal_azerovic_rn8618.R
import rs.raf.projekat1.danijal_azerovic_rn8618.model.Pacijent
import rs.raf.projekat1.danijal_azerovic_rn8618.view.recycler.diff.PacijentDiffItemCallback
import rs.raf.projekat1.danijal_azerovic_rn8618.view.recycler.viewholder.CekaonicaViewHolder

class CekaonicaAdapter (
    pacijentDiffItemCallback: PacijentDiffItemCallback,
    private val onZdravPacijentClicked: (Pacijent) -> Unit,
    private val onHospPacijentClicked: (Pacijent) -> Unit) : ListAdapter<Pacijent,CekaonicaViewHolder>(pacijentDiffItemCallback){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CekaonicaViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val containerView = layoutInflater.inflate(R.layout.list_item_cekaonica, parent, false)
        return CekaonicaViewHolder(containerView,
            {
                val pacijent = getItem(it)
                onZdravPacijentClicked(pacijent)
            },
            {
                val pacijent = getItem(it)
                onHospPacijentClicked(pacijent)
            })
    }

    override fun onBindViewHolder(holder: CekaonicaViewHolder, position: Int) {
        val pacijent = getItem(position)
        holder.bind(pacijent)
    }

}