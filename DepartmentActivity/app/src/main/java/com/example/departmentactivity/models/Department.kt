package com.example.departmentactivity.models

data class Department(

    var title: String,

    var price: String,

    var image: String,

    var time: String


) {

    override fun toString(): String {
        return "Department(title='$title',price='$price',image='$image',time='$time')"
    }


}
