package controller;

import container.Conteiner;

public class TipoPilhaConteiner {

	public final int N = 5;
	Conteiner pilha1[] = new Conteiner[N];
	Conteiner pilha2[] = new Conteiner[N];
	Conteiner pilhaAux[] = new Conteiner[N];
	int topo1;
	int topo2;

	// inicializa os indices **contadores**
	public void init() {
		topo1 = 0;
		topo2 = 0;
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
			System.out.println("Container Inserido com sucesso na pilha 1");
			topo1++;

		} else if (isFullPilha2() == false && topo1 >= topo2) {
			pilha2[topo2] = valor;
			System.out.println("Container Inserido com sucesso na pilha 2");
			topo2++;

		} else
			System.out.println("Stack Overflow");
	}

	// Apresenta os conteiners em cada pilha do pátio
	public void show() {
		System.out.println("************* Ocupação das pilhas de conteineres ******************");
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
		if (!isEmptyPilha1() && !isEmptyPilha2()) {
			// VERIFICA PILHA 1
			for (int i = topo1 - 1; i >= 0; i--) {
				if (pilha1[i].getId().equals(valor)) {
					contPilha1 += i;
					System.out.println("Pilha 1 -->\t" + pilha1[i].toString() + " na posicao " + contPilha1);
					System.out.println("Tem " + ((topo1 - 1) - contPilha1) + " Conteiner(s) acima dele");
					verifica = true;
					break;
				}
			}
			// VERIFICA PILHA 2
			for (int h = topo2 - 1; h >= 0; h--) {
				if (pilha2[h].getId().equals(valor)) {
					contPilha2 += h;
					System.out.println("Pilha 2 -->\t" + pilha2[h].toString() + " na posicao " + contPilha2);
					System.out.println("Tem " + ((topo2 - 1) - contPilha2) + " Conteiner(s) acima dele");
					verifica = true;
					break;
				}
			}

			if (verifica != true)
				System.out.println("Verifique o ID do Conteiner e tente novamente ");
		} else
			System.out.println("Nenhum Container cadastrado !!");
	}
	
	//Apresenta planilhas de conteiners de cada pilha do pátio
	public void planilha() {
		System.out.println("************* Planilha de conteiners (pilha 1) ******************");
		for (int i = 0; i < topo1; i++) {
			if (pilha1[i] == null) {
			} else
				System.out.println("" + pilha1[i].getId());
		}
		System.out.println("\n");
		System.out.println("************* Planilha de conteiners (pilha 2) ******************");
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

		System.out.println("Contador 1 --> " + contador1 + "\nContador 2 --> " + contador2);

	}

}
