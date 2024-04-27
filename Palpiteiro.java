package firstProject;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;
import java.util.Scanner;

public class PalpiteiroLoterias {

	public static void main(String[] args) throws IOException {
		Scanner entrada = new Scanner(System.in);
		Random gerador = new Random();
		FileWriter arq = new FileWriter("C:/Users/treinamentosti01/Desktop/palpiteiro.txt");
		PrintWriter gravatxt = new PrintWriter(arq);

		System.out.println("Escolha o jogo para gerar o palpite:");
		System.out.println("Digite 1 para MEGA-SENA");
		System.out.println("Digite 2 para LOTOFACIL");
		System.out.println("Digite 3 para QUINA");

		int escolha = entrada.nextInt();
		Object palpite = null;

		switch (escolha) {
		case 1:
			int palpite1[] = new int[6];
			System.out.println("Você escolheu MEGA-SENA");
			gravatxt.println("Aqui está o seu palpite para MEGA-SENA: ");
			for (int cont = 0; cont < 6; cont++) {
				int num;
				do {
					num = gerador.nextInt(60) + 1;
				} while (contains(palpite1, cont, num));
				palpite1[cont] = num;
				gravatxt.print(" " + palpite1[cont]);
			}
			break;
		case 2:
			int palpite2[] = new int[20];
			System.out.println("Você escolheu LOTOFACIL");
			gravatxt.println("Aqui está o seu palpite para LOTOFACIL: ");
			for (int cont = 0; cont < 15; cont++) {
				int num;
				do {
					num = gerador.nextInt(25) + 1;
				} while (contains(palpite2, cont, num));
				palpite2[cont] = num;
				gravatxt.print(" " + palpite2[cont]);
			}
			break;
		case 3:
			int palpite3[] = new int[5];
			System.out.println("Você escolheu QUINA");
			gravatxt.println("Aqui está o seu palpite para QUINA: ");
			for (int cont = 0; cont < 5; cont++) {
				int num;
				do {
					num = gerador.nextInt(80) + 1;
				} while (contains(palpite3, cont, num));
				palpite3[cont] = num;
				gravatxt.print(" " + palpite3[cont]);
			}
			break;

		default:
			System.out.println("Escolha inválida");
		}

		arq.close();
		System.out.println("Arquivo gerado com sucesso!");
	}

	private static boolean contains(int[] array, int length, int num) {
		for (int i = 0; i < length; i++) {
			if (array[i] == num) {
				return true;
			}
		}
		return false;
	}
}
