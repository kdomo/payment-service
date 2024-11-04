package com.github.kdomo.paymentservice.payment.application.port.`in`

class CheckoutCommand(
    val cartId: Long,
    val buyerId: Long,
    val productIds: List<Long>,
    val idempotencyKey: String
)
