package me.dio.credit.application.system.dto

import me.dio.credit.application.system.entity.Customer
import org.aspectj.apache.bcel.classfile.Code
import java.math.BigDecimal

data class CustomerUpdateDto(

    val firstName: String,
    val lastName: String,
    val income: BigDecimal,
    val zipCode: String,
    val street: String

) {
    fun toEntity(customer: Customer): Customer{
        customer.firstName = firstName
        customer.lastName = lastName
        customer.income = income
        customer.adress.zipCode = zipCode
        customer.adress.street = street
        return customer

    }

}
