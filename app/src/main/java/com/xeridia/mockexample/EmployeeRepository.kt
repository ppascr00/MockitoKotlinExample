package com.xeridia.mockexample
interface EmployeeRepository {
    fun findAll(): List<Employee?>
    fun save(e: Employee): Employee
}