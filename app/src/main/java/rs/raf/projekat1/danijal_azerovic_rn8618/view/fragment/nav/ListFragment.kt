package rs.raf.projekat1.danijal_azerovic_rn8618.view.fragment.nav

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_list.*
import rs.raf.projekat1.danijal_azerovic_rn8618.R
import rs.raf.projekat1.danijal_azerovic_rn8618.view.viewpager.PagerAdapterTab

class ListFragment : Fragment(R.layout.fragment_list){

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun init(){
        initTabs()
    }

    private fun initTabs(){
        viewPagerTab.adapter = PagerAdapterTab(childFragmentManager)
        tabLayout.setupWithViewPager(viewPagerTab)
    }

}