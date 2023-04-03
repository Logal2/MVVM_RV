package com.example.homewordroman.State

sealed class State {

    class NoData() : State()

    class Success<T>(val data: T) : State()

    class Error<T>(val message: String, data: T) : State()

}