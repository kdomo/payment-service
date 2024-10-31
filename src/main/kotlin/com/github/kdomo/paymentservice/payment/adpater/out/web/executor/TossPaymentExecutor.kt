package com.github.kdomo.paymentservice.payment.adpater.out.web.executor

import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.client.WebClient
import reactor.core.publisher.Mono

@Component
class TossPaymentExecutor(
    private val tossPaymentWebClient: WebClient,
    private val uri: String = "/v1/payment/confirm"
) {

    fun execute(paynemtKey: String, orderId: String, amount: String): Mono<String> {
        return tossPaymentWebClient.post()
            .uri(uri)
            .bodyValue("""
                {
                    "paymentKey": "${paynemtKey}",
                    "orderId": "${orderId}",
                    "amount": "${amount}"
                }
            """.trimIndent())
            .retrieve()
            .bodyToMono(String::class.java)
    }

}