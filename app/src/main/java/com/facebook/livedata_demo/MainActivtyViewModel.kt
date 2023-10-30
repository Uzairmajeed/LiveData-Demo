package com.facebook.livedata_demo

import android.os.CountDownTimer
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainActivtyViewModel:ViewModel() {
    private lateinit var timer: CountDownTimer

    val finsihed=MutableLiveData<Boolean>()
    private val _seconds=MutableLiveData<Int>()

    fun seconds():LiveData<Int>{
        return _seconds
    }

    fun startTimer(){
        timer=object :CountDownTimer(10000,1000){
            override fun onFinish() {
           finsihed.value=true
            }


            override fun onTick(p0: Long) {
                val timeLeft = p0/1000
                _seconds.value = timeLeft.toInt()
            }

        }.start()
    }
    fun  stoptimer(){
        timer.cancel()
    }
}