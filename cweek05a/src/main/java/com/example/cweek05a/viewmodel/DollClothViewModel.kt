package com.example.cweek05a.viewmodel

import androidx.lifecycle.ViewModel
import com.example.cweek05a.model.DollClothData
import com.example.cweek05a.model.DollClothListFactory

class DollClothViewModel : ViewModel() {
    private val _clothList = DollClothListFactory.create()
    val clothList: MutableList<DollClothData>
        get() = _clothList
}