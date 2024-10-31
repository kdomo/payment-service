package com.github.kdomo.paymentservice.payment.adpater.`in`.web.reuqest

data class TossPaymentConfirmRequest(
    val paymentKey: String,
    val orderId: String,
    val amount: Long
)
