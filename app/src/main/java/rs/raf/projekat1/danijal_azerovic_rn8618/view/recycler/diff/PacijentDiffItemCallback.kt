package rs.raf.projekat1.danijal_azerovic_rn8618.view.recycler.diff

import androidx.recyclerview.widget.DiffUtil
import rs.raf.projekat1.danijal_azerovic_rn8618.model.Pacijent

class PacijentDiffItemCallback : DiffUtil.ItemCallback<Pacijent>(){

    override fun areItemsTheSame(oldItem: Pacijent, newItem: Pacijent): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Pacijent, newItem: Pacijent): Boolean {
        return oldItem.ime == newItem.ime &&
                oldItem.prezime == newItem.prezime &&
                oldItem.pic == newItem.pic
    }

}