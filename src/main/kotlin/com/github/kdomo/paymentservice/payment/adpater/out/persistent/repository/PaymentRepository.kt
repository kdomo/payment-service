package com.github.kdomo.paymentservice.payment.adpater.out.persistent.repository

import com.github.kdomo.paymentservice.payment.domain.PaymentEvent
import reactor.core.publisher.Mono

interface PaymentRepository {
    fun save(paymentEvent: PaymentEvent): Mono<Void>
}