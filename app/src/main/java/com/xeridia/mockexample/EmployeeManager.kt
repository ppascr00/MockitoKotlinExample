package com.xeridia.mockexample

class EmployeeManager{

    private lateinit var employeeRepository: EmployeeRepository
    private lateinit var bankService: BankService

    constructor(employeeRepository: EmployeeRepository, bankService: BankService){
        this.employeeRepository = employeeRepository
        this.bankService = bankService
    }

    fun payEmployees(): Int {
        val employees = employeeRepository.findAll()
        var payments = 0
        for (employee in employees) {
            try {
                if (employee != null) {
                    bankService.pay(employee.id, employee.salary)
                }
                if (employee != null) {
                    employee.isPaid = true
                }
                payments++
            } catch (e: RuntimeException) {
                if (employee != null) {
                    employee.isPaid = false
                }
            }
        }
        return payments
    }

}