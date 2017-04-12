package com.demo

class Person {
    String name

    static constraints = {
        name matches: /[A-Z].*/
    }
}