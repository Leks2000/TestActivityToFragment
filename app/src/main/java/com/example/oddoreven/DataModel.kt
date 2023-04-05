package com.example.oddoreven

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

open class DataModel: ViewModel() {
        val  messageForOneFragment: MutableLiveData<String> by lazy {
            MutableLiveData<String>()
        }
        val  messageForTwoFragment: MutableLiveData<String> by lazy {
            MutableLiveData<String>()
        }
         val  messageForActivityOneFragment: MutableLiveData<String> by lazy {
            MutableLiveData<String>()
         }
        val  messageForActivityTwoFragment: MutableLiveData<String> by lazy {
            MutableLiveData<String>()
        }
        val  messageForFragmentFrom2: MutableLiveData<String> by lazy {
             MutableLiveData<String>()
         }
        val  messageForTwoFragmentFrom1: MutableLiveData<String> by lazy {
             MutableLiveData<String>()
        }
}
