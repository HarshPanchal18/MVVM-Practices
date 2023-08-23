package com.example.movie_mvvm.common.base

interface Mapper<F,T> { // From, To
    fun fromMap(from: F): T
}
