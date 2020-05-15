package rs.raf.projekat1.danijal_azerovic_rn8618.view.viewpager

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import rs.raf.projekat1.danijal_azerovic_rn8618.view.fragment.nav.AddFragment
import rs.raf.projekat1.danijal_azerovic_rn8618.view.fragment.nav.InfoFragment
import rs.raf.projekat1.danijal_azerovic_rn8618.view.fragment.nav.ListFragment
import rs.raf.projekat1.danijal_azerovic_rn8618.view.fragment.nav.ProfileFragment

class PagerAdapterNav(fragmentManager: FragmentManager) : FragmentPagerAdapter(fragmentManager, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT){

    companion object {
        const val FRAGMENT_1 = 0
        const val FRAGMENT_2 = 1
        const val FRAGMENT_3 = 2
        const val FRAGMENT_4 = 3
    }

    private val ITEM_COUNT = 4

    override fun getItem(position: Int): Fragment {
        return when(position){
            FRAGMENT_1 -> InfoFragment()
            FRAGMENT_2 -> AddFragment()
            FRAGMENT_3 -> ListFragment()
            else -> ProfileFragment()
        }
    }

    override fun getCount(): Int {
        return ITEM_COUNT
    }



}