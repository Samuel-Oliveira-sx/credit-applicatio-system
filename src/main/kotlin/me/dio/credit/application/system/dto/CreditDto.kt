package me.dio.credit.application.system.dto

import jakarta.validation.constraints.Future
import jakarta.validation.constraints.Max
import jakarta.validation.constraints.Min
import jakarta.validation.constraints.NotNull
import me.dio.credit.application.system.entity.Credit
import me.dio.credit.application.system.entity.Customer
import java.math.BigDecimal
import java.time.LocalDate
import java.time.Period

data class CreditDto(
    @field:NotNull(message = "invalid input")
    val creditValue: BigDecimal,

    @field:Future
    val dayFirstOfInstallment: LocalDate,

    @field:Min(1, message = "Number of installments must be at least 1")
    @field:Max(48, message = "Number of installments must be at most 48")
    val numberOfInstallment: Int,

    @field:NotNull(message = "invalid input")
    val customerId: Long
) {
    init {
        require(Period.between(LocalDate.now(), dayFirstOfInstallment).months <= 3) {
            "The first installment date must be at most 3 months after the current date"
        }
    }

    fun toEntity(): Credit = Credit(
        creditValue = this.creditValue,
        dayFirstInstallment = this.dayFirstOfInstallment,
        numberOfInstallments = this.numberOfInstallment,
        customer = Customer(id = this.customerId)
    )
}

