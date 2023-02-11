package strategy.strategy;

import java.math.BigDecimal;

public interface IPaymentStrategy {
    public void pay(BigDecimal amount);
    
}
