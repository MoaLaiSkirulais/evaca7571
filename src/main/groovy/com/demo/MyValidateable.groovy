package com.demo

class MyValidateable implements grails.validation.Validateable {
    String name
    Integer age

    static constraints = {
        name matches: /[A-Z].*/
        age range: 1..99
    }
}