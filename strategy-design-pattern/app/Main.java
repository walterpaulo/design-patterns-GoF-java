package app;

import java.math.BigDecimal;
import java.util.InputMismatchException;
import java.util.Scanner;

import strategy.context.PaymentContext;
import strategy.pay.ByCashPaymentStrategy;
import strategy.pay.CreditCardPaymentStrategy;
import strategy.pay.DebitCardPaymentStrategy;

public class Main {
    public static void main(String[] args) {
      PaymentContext ctx = null;
      ctx = new PaymentContext();
      String tipoDePagamento = "";
      Scanner scanner = new Scanner(System.in);
      System.out.println("#".repeat(20)+"[ PAGAMENTO ]"+"#".repeat(20));

      while(true){
        System.out.println("Digite o número: \n( 1 ) - 'Crédito' \n( 2 ) - 'Dédito' \n( 3 ) - 'Dinheiro'");
       
        tipoDePagamento = scanner.next();

        if( "1".equalsIgnoreCase(tipoDePagamento) ) {
          ctx.setPaymentStrategy(new CreditCardPaymentStrategy());
          break;
        } else if( "2".equalsIgnoreCase(tipoDePagamento) ) {
          ctx.setPaymentStrategy(new DebitCardPaymentStrategy());
          break;
        } else if( "3".equalsIgnoreCase(tipoDePagamento) ) {
          ctx.setPaymentStrategy(new ByCashPaymentStrategy());
          break;
        }
      }

      try {
        System.out.println("Digite o valor: " + tipoDePagamento);
        BigDecimal amount = scanner.nextBigDecimal();
        ctx.pay(amount);
      } catch (InputMismatchException e) {
        System.out.println("O valor digitado inválido.");
        main(args);
      }catch (Exception e){
        System.out.println("O progroma foi encerrado!\nError: "+ e.getMessage());
        System.exit(0);
      }
        
      System.out.println("PaymentContext tem :"+ctx.getPaymentStrategy());
      
      scanner.close();
      }
}
