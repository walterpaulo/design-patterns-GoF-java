package templatemethod;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		try (Scanner teclado = new Scanner(System.in)) {
			try {
				System.out.println("=========[ Programa ]===========");
				while (true) {
					System.out.println("Menu\n1) Valor do Dolar Hoje\n0) Sair\n");
					System.out.print("Escolhe uma opção:");
					int valor = teclado.nextInt();
					switch (valor) {
					case 1:
						System.out.println("Menu-Moedas\n1) BRL \n2) EUR\n0) Sair\n");
						System.out.print("Escolhe uma opção:");
						valor = teclado.nextInt();
						double exchangeRate = 0;
						switch (valor) {
						case 1:
							exchangeRate = OpenDolarSevice.getExchangeRate("BRL");
				            System.out.println("1 USD para BRL : " + exchangeRate);
				            break;
						case 2:
							exchangeRate = OpenDolarSevice.getExchangeRate("EUR");
				            System.out.println("1 USD para EUR : " + exchangeRate);
				            break;
						case 0:
							exchangeRate = OpenDolarSevice.getExchangeRate("EUR");
				            System.out.println("1 USD para EUR : " + exchangeRate);
				            break;
						default:
							System.out.println("Opção Inválida!");
							break;
						}
						break;
					case 0:
						System.out.println("Programa Encerrado!!");
						System.exit(0);
						break;

					default:
						System.out.println("Opção Inválida!");
						break;
					}

				}

			} catch (Exception e) {
				System.out.println("Erro na Conexão: " + e.getMessage());
			}
		}
	}

}
