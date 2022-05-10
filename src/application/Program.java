package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Lesson;
import entities.Task;
import entities.Video;

public class Program {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		List<Lesson> list = new ArrayList<>();

		System.out.print("Quantas aulas tem o curso? ");
		int qty = sc.nextInt();
		System.out.println();

		for (int i = 1; i <= qty; i++) {

			System.out.println("Dados da " + i + "a aula:");
			System.out.print("Conteúdo ou tarefa (c/t)? ");
			char op = sc.next().charAt(0);
			sc.nextLine();
			System.out.print("Título: ");
			String title = sc.nextLine();

			if (op == 'c') {

				System.out.print("URL do vídeo: ");
				String url = sc.nextLine();
				System.out.print("Duração em segundos: ");
				int seconds = sc.nextInt();

				list.add(new Video(title, url, seconds));

			} else if (op == 't') {

				System.out.print("Descrição: ");
				String description = sc.nextLine();
				System.out.print("Quantidade de questões: ");
				int questionCount = sc.nextInt();

				list.add(new Task(title, description, questionCount));
			}
			System.out.println();

		}

		int totDuration = 0;
		for (Lesson l : list) {

			totDuration += l.duration();
		}

		System.out.println("DURAÇÃO TOTAL DO CURSO = " + totDuration + " segundos");

		sc.close();

	}

}
