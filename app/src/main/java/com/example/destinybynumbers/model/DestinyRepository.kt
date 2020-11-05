package com.example.destinybynumbers.model

import androidx.lifecycle.MutableLiveData

class DestinyRepository(private val destinyDao: DestinyDao = DestinyDB.createInstance().getDao()) {

    fun insertIntoInquiryResults(data: InquiryResults) {
        destinyDao.addNewEntry(data)
    }



    fun getPythagoreanValue(liveData: MutableLiveData<List<PythagoreanTable>>) {
        liveData.postValue( destinyDao.getPythagoreanNumber() )
    }

}