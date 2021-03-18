package com.a.randomsquare.viewmodel

import androidx.lifecycle.ViewModel
import com.a.randomsquare.ColorsGenerator
import javax.inject.Inject

class MainViewModel @Inject constructor(private var generator: ColorsGenerator): ViewModel() {
}