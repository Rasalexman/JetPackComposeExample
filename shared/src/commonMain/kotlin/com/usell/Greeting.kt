package com.usell

class Greeting {
    fun greeting(): String {
        return "Hello, ${Platform().platform}!"
    }
}