package com.example.destinybynumbers

import android.app.Application
import android.content.Context


class DestinyApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        destinyApplication = applicationContext
        //init libraries(Timber<logs>, Analytics, DI)
    }

    companion object{
        var destinyApplication: Context? = null
    }
}