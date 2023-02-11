package strategy.context;

import java.math.BigDecimal;

import strategy.strategy.IPaymentStrategy;


public class PaymentContext {
    private IPaymentStrategy paymentStrategy;

    public IPaymentStrategy getPaymentStrategy() {
        return paymentStrategy;
    }

    public void setPaymentStrategy(IPaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public void pay(BigDecimal amount) {
        paymentStrategy.pay(amount);
    }

}