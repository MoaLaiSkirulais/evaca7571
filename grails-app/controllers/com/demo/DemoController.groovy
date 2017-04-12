package com.demo

class DemoController {

    def addItems(MyCommandObject co) {
        if(co.hasErrors()) {
            render 'something went wrong'
        } else {
            render 'items have been added'
        }
    }
}

class MyCommandObject {
    Integer numberOfItems

    static constraints = {
        numberOfItems range: 1..10
    }
}