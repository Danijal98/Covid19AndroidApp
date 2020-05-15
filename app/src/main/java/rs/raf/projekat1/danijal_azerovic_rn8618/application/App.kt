package rs.raf.projekat1.danijal_azerovic_rn8618.application

import android.app.Application
import timber.log.Timber

class App : Application(){

    override fun onCreate() {
        super.onCreate()

        Timber.plant(Timber.DebugTree())
    }

}