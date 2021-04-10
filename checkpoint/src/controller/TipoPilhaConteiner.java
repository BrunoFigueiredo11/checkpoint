package controller;

import container.Conteiner;

public class TipoPilhaConteiner {

	public final int N = 5;
	Conteiner pilha1[] = new Conteiner[N];
	Conteiner pilha2[] = new Conteiner[N];
	Conteiner pilhaAux[] = new Conteiner[N];
	int contMoveRetirados = 0;
	int topo1;
	int topo2;
	int topoAux;

	// inicializa os indices **contadores**
	public void init() {
		topo1 = 0;
		topo2 = 0;
		topoAux = 0;
	}

	// verifica se a pilha 1 esta vazia
	public boolean isEmptyPilha1() {
		if (topo1 == 0)
			return true;
		else
			return false;
	}

	// verifica se a pilha 2 esta vazia
	public boolean isEmptyPilha2() {
		if (topo2 == 0)
			return true;
		else
			return false;
	}

	// verifica se a pilha 1 esta cheia
	public boolean isFullPilha1() {
		if (topo1 == N)
			return true;
		else
			return false;
	}

	// verifica se a pilha 2 esta cheia
	public boolean isFullPilha2() {
		if (topo2 == N)
			return true;
		else
			return false;
	}

	// insere o container na pilha de menor ocupação
	public void push(Conteiner valor) {
		if (isFullPilha1() == false && topo1 <= topo2) {
			pilha1[topo1] = valor;
			System.out.println("Contêiner Inserido com sucesso na pilha 1");
			topo1++;

		} else if (isFullPilha2() == false && topo1 >= topo2) {
			pilha2[topo2] = valor;
			System.out.println("Contêiner Inserido com sucesso na pilha 2");
			topo2++;

		} else
			System.out.println("Pilha 1 e 2 no Limite Máximo");
	}

	// Apresenta os conteiners em cada pilha do pátio
	public void show() {
		System.out.println("************* Ocupação das pilhas de contêiners ******************");
		System.out.println("\tPILHA 1");
		System.out.println("topo-> " + topo1 + "]: ");
		for (int i = topo1 - 1; i >= 0; i--) {
			if (pilha1[i] == null) {
			} else
				System.out.println("       " + i + "]: " + pilha1[i]);
		}
		System.out.println("");
		System.out.println("\tPILHA 2");
		System.out.println("topo-> " + topo2 + "]: ");
		for (int i = topo2 - 1; i >= 0; i--) {
			if (pilha2[i] == null) {
			} else
				System.out.println("       " + i + "]: " + pilha2[i]);
		}

	}

	// Retira conteiner do pátio
	public void retiraContainer(String valor) {
		int contPilha1 = 0;
		int contPilha2 = 0;
		boolean verifica = false;
		if (!isEmptyPilha1() || !isEmptyPilha2()) {
			// VERIFICA PILHA 1
			for (int i = topo1 - 1; i >= 0; i--) {
				if (pilha1[i].getId().equals(valor)) {
					contPilha1 += i;
					for (int j = topo1 - 1; j >= contPilha1; j--) {
						if (j >= contPilha1) {
							System.out.println("Movimentado o contêiner " + pilha1[j].getId() + " .");
							int contMove = pilha1[j].getContMove();
							contMove += 1;
							pilha1[j].setContMove(contMove);
							if (j == contPilha1) {
								System.out
										.println("Conteiner " + pilha1[j].getId() + " saindo para seu destino final.");
								contMoveRetirados += pilha1[j].getContMove();
								realoca(1, contPilha1);
							}
						}
					}
					verifica = true;
					break;
				}

			}
			// VERIFICA PILHA 2
			for (int h = topo2 - 1; h >= 0; h--) {
				if (pilha2[h].getId().equals(valor)) {
					contPilha2 += h;

					for (int j = topo2 - 1; j >= contPilha2; j--) {
						if (j >= contPilha2) {
							System.out.println("Movimentado o contêiner " + pilha2[j].getId() + " .");
							int contMove = pilha2[j].getContMove();
							contMove += 1;
							pilha2[j].setContMove(contMove);
							if (j == contPilha2) {
								System.out
										.println("Conteiner " + pilha2[j].getId() + " saindo para seu destino final.");
								contMoveRetirados += pilha2[j].getContMove();
								realoca(2, contPilha2);
							}
						}
					}

					verifica = true;
					break;
				}

			}

			if (verifica != true)
				System.out.println("Verifique o ID do Conteiner e tente novamente ");
		} else
			System.out.println("Nenhum Container cadastrado !!");
	}

	// Apresenta planilhas de conteiners de cada pilha do pátio
	public void planilha() {
		System.out.println("************* Planilha de contêiners (pilha 1) ******************");
		for (int i = 0; i < topo1; i++) {
			if (pilha1[i] == null) {
			} else
				System.out.println("" + pilha1[i].getId());
		}
		System.out.println("\n");
		System.out.println("************* Planilha de contêiners (pilha 2) ******************");
		for (int i = 0; i < topo2; i++) {
			if (pilha2[i] == null) {
			} else
				System.out.println("" + pilha2[i].getId());
		}

	}

	// Cálculo das movimentações dos conteiners
	public void contMove() {
		int contador1 = 0;
		int contador2 = 0;
		for (int i = 0; i < topo1; i++) {
			if (pilha1[i] == null) {
			} else
				contador1 += pilha1[i].getContMove();
		}
		for (int i = 0; i < topo2; i++) {
			if (pilha2[i] == null) {
			} else
				contador2 += pilha2[i].getContMove();
		}

		System.out.println("Número de movimentações: " + (contador1 + contador2+contMoveRetirados));

	}

	public void realoca(int pilha, int indice) {
		if (pilha == 1) {
			int cont = (topo1 - 1);
			int qtdConteiner = cont - indice;
			// move o conteiner para a pilha auxiliar
			for (int i = 0; i < qtdConteiner; i++) {
				pilhaAux[i] = pilha1[cont];
				topoAux++;
				cont--;
			}
			// retorna os conteiner para a pilha 1
			for (int i = topoAux - 1; i >= 0; i--) {
				pilha1[indice] = pilhaAux[i];
				int contMove = pilha1[indice].getContMove();
				contMove += 1;
				pilha1[indice].setContMove(contMove);
				indice++;
			}
			topoAux = 0;
			topo1--;
		} else {
			int cont = (topo2 - 1);
			int qtdConteiner = cont - indice;
			for (int i = 0; i < qtdConteiner; i++) {
				pilhaAux[i] = pilha2[cont];
				topoAux++;
				cont--;
			}
			for (int i = topoAux - 1; i >= 0; i--) {
				pilha2[indice] = pilhaAux[i];
				int contMove = pilha2[indice].getContMove();
				contMove += 1;
				pilha2[indice].setContMove(contMove);
				indice++;
			}
			topoAux = 0;
			topo2--;

		}
	}
}
