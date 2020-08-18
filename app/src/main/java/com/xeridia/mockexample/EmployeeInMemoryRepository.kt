package com.xeridia.mockexample

/**
 * An example of test double that is a "fake"
 *
 * @author Lorenzo Bettini
 */
class EmployeeInMemoryRepository(private val employees: MutableList<Employee>) :
    EmployeeRepository {
    override fun findAll(): List<Employee> {
        return employees
    }

    override fun save(employee: Employee): Employee {
        val listIterator =
            employees.listIterator()
        while (listIterator.hasNext()) {
            if (listIterator.next().id == employee.id) {
                listIterator.set(employee)
                return employee
            }
        }
        employees.add(employee)
        return employee
    }

}