package rs.raf.projekat1.danijal_azerovic_rn8618.view.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import rs.raf.projekat1.danijal_azerovic_rn8618.R
import rs.raf.projekat1.danijal_azerovic_rn8618.view.viewpager.PagerAdapterNav

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
    }

    private fun init(){
        initViewPager()
        initNavigation()
    }

    private fun initViewPager(){
        viewPagerNav.adapter = PagerAdapterNav(supportFragmentManager)
    }

    private fun initNavigation(){
        bottomNavigation.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.navigation_info ->{
                    viewPagerNav.setCurrentItem(PagerAdapterNav.FRAGMENT_1,false)
                }
                R.id.navigation_add ->{
                    viewPagerNav.setCurrentItem(PagerAdapterNav.FRAGMENT_2,false)
                }
                R.id.navigation_list ->{
                    viewPagerNav.setCurrentItem(PagerAdapterNav.FRAGMENT_3,false)
                }
                R.id.navigation_profile ->{
                    viewPagerNav.setCurrentItem(PagerAdapterNav.FRAGMENT_4,false)
                }
            }
            true
        }
    }

}
