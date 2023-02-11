package strategy.pay;

import java.math.BigDecimal;

import strategy.strategy.IPaymentStrategy;


public class ByCashPaymentStrategy implements IPaymentStrategy{

    @Override
    public void pay(BigDecimal amount) {
        System.out.println("-".repeat(20)+"[ RESUMO ]"+"-".repeat(20)+
        "\n\nValor R$ " +amount+ "\nPagamento: Cash\n\n"+"-".repeat(50));        
    }
    
}
