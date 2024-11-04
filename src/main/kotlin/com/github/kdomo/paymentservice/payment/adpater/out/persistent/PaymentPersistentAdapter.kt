package com.github.kdomo.paymentservice.payment.adpater.out.persistent

import com.github.kdomo.paymentservice.common.PersistentAdapter
import com.github.kdomo.paymentservice.payment.adpater.out.persistent.repository.PaymentRepository
import com.github.kdomo.paymentservice.payment.application.port.out.SavePaymentPort
import com.github.kdomo.paymentservice.payment.domain.PaymentEvent
import reactor.core.publisher.Mono

@PersistentAdapter
class PaymentPersistentAdapter(
    private val paymentRepository: PaymentRepository
): SavePaymentPort {
    override fun save(paymentEvent: PaymentEvent): Mono<Void> {
        return paymentRepository.save(paymentEvent)
    }
}