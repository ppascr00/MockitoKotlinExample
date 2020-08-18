package com.xeridia.mockexample

class Employee(var id: String, var salary: Double) {
    var isPaid = false

    override fun toString(): String {
        return "Employee [id=$id, salary=$salary]"
    }

}