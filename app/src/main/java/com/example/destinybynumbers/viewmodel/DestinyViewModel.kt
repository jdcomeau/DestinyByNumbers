package com.example.destinybynumbers.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.destinybynumbers.model.DestinyRepository
import com.example.destinybynumbers.model.InquiryResults
import com.example.destinybynumbers.model.PythagoreanTable

class DestinyViewModel: ViewModel() {

    var pythagoreanResultLiveData = MutableLiveData<List<PythagoreanTable>>()

    var destinyRepository: DestinyRepository = DestinyRepository()

    fun insertIntoInquiryResults(dataSet: InquiryResults) {
        destinyRepository.insertIntoInquiryResults(dataSet)
    }

    fun queryPythagoreanTable() {
        destinyRepository.getPythagoreanValue(pythagoreanResultLiveData)
    }

}