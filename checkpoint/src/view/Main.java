package view;

import java.util.Scanner;

import container.Conteiner;
import controller.TipoPilhaConteiner;

public class Main {
	static Scanner teclado = new Scanner(System.in);

	public static void main(String[] args) {

		int opcao;
		String id;
		int contMove = 0;

		TipoPilhaConteiner tipoconteiner = new TipoPilhaConteiner();

		do {
			System.out.println(gerarMenu());
			opcao = teclado.nextInt();
			if (opcao < 0 || opcao > 6) {
				System.out.println("-------> Op��o Inv�lida!! <-------");
			} else {
				switch (opcao) {
				case 0:
					System.exit(0);
					break;
				case 1:
					System.out.println("Informe c�digo de identifica��o do conteiner: ");
					id = teclado.next();
					contMove = 1;
					Conteiner conteiner = new Conteiner(id, contMove);
					tipoconteiner.push(conteiner);
					break;
				case 2:
					System.out.println("Retirar o cont�iner da pilha, digite identifica��o: ");
					id = teclado.next();
					tipoconteiner.retiraContainer(id);

					break;
				case 3:
					tipoconteiner.contMove();
					break;
				case 4:
					tipoconteiner.show();
					break;
				case 5:
					tipoconteiner.planilha();
					break;
				}
			}

			System.out.println();
		} while (opcao != 6 && opcao <= 6);

	}

	public static String gerarMenu() {
		String aux = "Escolha uma opera��o\n";
		aux += "0 - Encerrar programa\n";
		aux += "1 - Insere conteiner no p�tio\n";
		aux += "2 - Retira conteiner do p�tio\n";
		aux += "3 - C�lculo do custo da movimenta��o dos conteiners\n";
		aux += "4 - Apresenta os conteiners em cada pilha do p�tio\n";
		aux += "5 - Apresenta planilhas de conteineres de cada pilha do p�tio";
		return aux;
	}

}
