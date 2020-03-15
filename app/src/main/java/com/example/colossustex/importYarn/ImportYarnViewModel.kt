package com.example.colossustex.importYarn

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ImportYarnViewModel : ViewModel() {

    private var _cotton = MutableLiveData<Boolean>()
    val cotton: LiveData<Boolean>?
        get() = _cotton

    private var _synthetic = MutableLiveData<Boolean>()
    val synthetic: LiveData<Boolean>?
        get() = _synthetic

    private var _viscose = MutableLiveData<Boolean>()
    val viscose: LiveData<Boolean>?
        get() = _viscose

    private var _fancy = MutableLiveData<Boolean>()
    val fancy: LiveData<Boolean>?
        get() = _fancy

    private var _texturized = MutableLiveData<Boolean>()
    val texturized: LiveData<Boolean>?
        get() = _texturized

    init {
        _cotton.value = false
        _synthetic.value = false
        _viscose.value = false
        _fancy.value = false
        _texturized.value = false
    }

    fun toCotton() {
        _cotton.value = true
    }

    fun toSynthetic() {
        _synthetic.value = true
    }

    fun toFancy() {
        _fancy.value = true
    }

    fun toTexturized() {
        _texturized.value = true
    }

    fun toViscose() {
        _viscose.value = true
    }


    fun doneNavigation() {
        _cotton.value = false
        _synthetic.value = false
        _fancy.value = false
        _texturized.value = false
        _viscose.value = false
    }

}
