package com.xeridia.mockexample
class TransactionalEmployeeManager(
    private val transactionManager: TransactionManager,
    private val bankService: BankService
) {
    fun payEmployees() {
        val employees =
            transactionManager.doInTransaction { obj: EmployeeRepository -> obj.findAll() }
        for (employee in employees) {
            bankService.pay(employee!!.id, employee.salary)
            employee.isPaid = true
            transactionManager.doInTransaction { employeeRepository: EmployeeRepository ->
                employeeRepository.save(
                    employee
                )
            }
        }
    }

}