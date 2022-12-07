package com.cursoandroid.ph.enterprise

class Enterprise {

    class Employee(
        val name: String,
        val lastName: String,
        var position: String,
        var salary: Double
    ) {
        override fun toString(): String {
            return """
                $name $lastName
                Cargo: $position
                Salário: $salary
            """.trimIndent()
        }
    }

    class Enterprises(
        val name: String,
        val cnpj: String,
        val segment: String,
        private val listEmployee: MutableList<Employee> = mutableListOf()
    ) {
        fun insertEmployee(employee: Employee) {
            // Add employee in the list of employee
            listEmployee.add(employee)
        }

        fun viewEmployee(): List<Employee> {
            return listEmployee.toList()
        }

        fun removeEmployee(name: String, lastName: String) {
            val findEmployee: Employee? = findEmployee(name, lastName)
            val removeMessage = if (listEmployee.remove(findEmployee)) "Removido com sucesso."
            else "Funcionário não encontrado!"
            println(removeMessage)
        }

        fun modifyEmployee(
            newPosition: String,
            newSalary: Double,
            name: String,
            lastName: String
        ) {
            val findEmployee: Employee? = findEmployee(name, lastName)
            findEmployee?.apply {
                this.position = newPosition
                this.salary = newSalary
            }
        }

        private fun findEmployee(name: String, lastName: String): Employee? =
            listEmployee.find { it.name == name && it.lastName == lastName }

    }
}

fun main () {
    val santander = Enterprise.Enterprises("Santander", "00.000.000/0001-00", "Financeiro")
    val employee = Enterprise.Employee("Paulo", "Souza", "Gerente", 5500.00)
    santander.insertEmployee(employee)
    println(santander.viewEmployee())
}