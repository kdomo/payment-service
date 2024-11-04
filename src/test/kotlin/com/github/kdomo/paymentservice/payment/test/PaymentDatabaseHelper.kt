package com.github.kdomo.paymentservice.payment.test

import com.github.kdomo.paymentservice.payment.domain.PaymentEvent
import reactor.core.publisher.Mono

interface PaymentDatabaseHelper {
    fun getPayments(orderId: String): PaymentEvent?
    fun clean(): Mono<Void>
}