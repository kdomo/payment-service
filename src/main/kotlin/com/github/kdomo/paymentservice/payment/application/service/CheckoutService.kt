package com.github.kdomo.paymentservice.payment.application.service

import com.github.kdomo.paymentservice.common.UseCase
import com.github.kdomo.paymentservice.payment.application.port.`in`.CheckoutCommand
import com.github.kdomo.paymentservice.payment.application.port.`in`.CheckoutUseCase
import com.github.kdomo.paymentservice.payment.application.port.out.LoadProductPort
import com.github.kdomo.paymentservice.payment.application.port.out.SavePaymentPort
import com.github.kdomo.paymentservice.payment.domain.*
import reactor.core.publisher.Mono

@UseCase
class CheckoutService(
    private val loadProductPort: LoadProductPort,
    private val savePaymentPort: SavePaymentPort
): CheckoutUseCase {
    override fun checkout(command: CheckoutCommand): Mono<CheckoutResult> {
        return loadProductPort.getProducts(command.cartId, command.productIds)
            .collectList()
            .map { createPaymentEvent(command, it) }
            .flatMap { savePaymentPort.save(it).thenReturn(it) }
            .map { CheckoutResult(amount = it.totalAmount(), orderId = it.orderId, orderName = it.orderName) }
    }

    private fun createPaymentEvent(command: CheckoutCommand, products: List<Product>): PaymentEvent {
        return PaymentEvent(
            buyerId = command.buyerId,
            orderName =  products.joinToString { it.name },
            orderId = command.idempotencyKey,
            paymentOrders = products.map {
                PaymentOrder(
                    sellerId = it.sellerId,
                    orderId = command.idempotencyKey,
                    productId = it.id,
                    amount = it.amount,
                    paymentStatus = PaymentStatus.NOT_STARTED
                )
            }
        )
    }
}