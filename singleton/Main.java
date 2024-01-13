package singleton;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		try (Scanner teclado = new Scanner(System.in)) {
			try {
				System.out.println("=========[ Programa ]===========");
				while (true) {
					System.out.println("Menu\n1) Verificar Versão DB\n 0) Sair\n");
					System.out.print("Escolhe uma opção:");
					int valor = teclado.nextInt();
					switch (valor) {
					case 1:
						UtilDao dao = new UtilDao();
						String versao = dao.verificarVersaoBanco();
						System.out.println("Banco: " + versao);
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
