package com.example.myandroidapp

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    
    private var counter = 0
    
    private val _counterText = MutableLiveData<String>()
    val counterText: LiveData<String> = _counterText
    
    private val _welcomeMessage = MutableLiveData<String>()
    val welcomeMessage: LiveData<String> = _welcomeMessage
    
    init {
        updateCounterText()
        _welcomeMessage.value = "欢迎使用我的Android应用！"
    }
    
    fun onButtonClicked() {
        counter++
        updateCounterText()
    }
    
    fun resetCounter() {
        counter = 0
        updateCounterText()
    }
    
    private fun updateCounterText() {
        _counterText.value = "点击次数: $counter"
    }
}