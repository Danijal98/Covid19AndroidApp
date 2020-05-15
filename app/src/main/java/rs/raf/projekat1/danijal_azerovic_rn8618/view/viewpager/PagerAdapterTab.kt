package rs.raf.projekat1.danijal_azerovic_rn8618.view.viewpager

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import rs.raf.projekat1.danijal_azerovic_rn8618.view.fragment.tab.CekaonicaFragment
import rs.raf.projekat1.danijal_azerovic_rn8618.view.fragment.tab.HospitalizovaniFragment
import rs.raf.projekat1.danijal_azerovic_rn8618.view.fragment.tab.OtpusteniFragment

class PagerAdapterTab(fragmentManager: FragmentManager) : FragmentPagerAdapter(fragmentManager, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT){

    companion object {
        const val FRAGMENT_1 = 0
        const val FRAGMENT_2 = 1
        const val FRAGMENT_3 = 2
    }

    private val ITEM_COUNT = 3

    override fun getItem(position: Int): Fragment {
        return when(position){
            FRAGMENT_1 -> CekaonicaFragment()
            FRAGMENT_2 -> HospitalizovaniFragment()
            else -> OtpusteniFragment()
        }
    }

    override fun getCount(): Int {
        return ITEM_COUNT
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return when(position){
            FRAGMENT_1 -> "Cekaonica"
            FRAGMENT_2 -> "Hospitalizovani"
            else -> "Otpusteni"
        }
    }


}