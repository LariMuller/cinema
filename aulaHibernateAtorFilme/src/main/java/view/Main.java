package view;

import java.util.List;
import java.util.Scanner;

import controller.AtorController;
import controller.FilmeController;
import model.Ator;
import model.Filme;

public class Main {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		long id;

		AtorController aControl = new AtorController();
		FilmeController fControl = new FilmeController();
		int escolha;

		do {
			System.out.println();
			System.out.println("Menu:");
			System.out.println("1. Inserir Filme");
			System.out.println("2. Pequisar um Filme");
			System.out.println("3. Listar Todos");
			System.out.println("4. Atualizar um Filme");
			System.out.println("5. Apagar um Filme");
			System.out.println("=======================");
			System.out.println("6. Inserir ator");
			System.out.println("7. Pequisar um ator");
			System.out.println("8. Apagar um ator");
			System.out.println("9. Atualizar um ator");
			System.out.println("10. Listar Todos");
			System.out.println("=======================");
			System.out.println("11. Participação ator no Filme");
			System.out.println("12. Sair");

			System.out.print("Escolha uma opção: ");
			escolha = scanner.nextInt();

			switch (escolha) {
				case 1:
					scanner.nextLine();
					Filme f1 = new Filme ();

					System.out.println();
					System.out.println("Inserir Filme.");
					
					System.out.println("Nome: ");
					f1.setTitulo(scanner.nextLine());

					System.out.println("Diretor: ");
					f1.setNomeDiretor(scanner.nextLine());
					
					fControl.inserirFilme(f1);		
					System.out.println();
					System.out.println("Filme Inserido.");
				break;

				case 2:
					scanner.nextLine();
					System.out.println();

					System.out.println("Pesquisar um filme por título: ");
					String nomeFilme = scanner.nextLine();

					List<Filme> filmes = fControl.pesquisarUmFilme(nomeFilme);	
					if (!(filmes.isEmpty())) {
						for (Filme filme : filmes ) {
							System.out.println("ID: " + filme.getId() + " | Título: " + filme.getTitulo() + " | Diretor: " + filme.getNomeDiretor());
						}
					} else { 
						System.out.println(); 
						System.out.println("Filme não encontrado.");
					}
				break;
					
				case 3:
					System.out.println(); 
					System.out.println("Listando Todos os Filmes: ");
					filmes = fControl.pesquisarTodos();	
					if (!(filmes.isEmpty())) {
						for (Filme filme : filmes ) {
							System.out.println("ID: " + filme.getId() + " | Título: " + filme.getTitulo() + " | Diretor: " + filme.getNomeDiretor());
						}
					}
					else {
						System.out.println(); 
						System.out.println("Não encontrou o Filme");
					}
				break;
					
				case 4:
					scanner.nextLine();
					System.out.println();

					System.out.println("Escolha um filme para atualizar: ");
					id = scanner.nextLong();
					scanner.nextLine();

					Filme f4 = new Filme ( );
					f4.setId(id);
					
					System.out.println("Título: ");
					f4.setTitulo(scanner.nextLine());
					
					System.out.println("Diretor: ");
					f4.setNomeDiretor(scanner.nextLine());

					fControl.atualizar(f4);
					System.out.println(); 
					System.out.println("Filme Atualizado.");
				break;

				case 5:
					System.out.println();
					System.out.println("Escolha um filme para apagar ");

					id = scanner.nextLong();
					fControl.apagar(id);

					System.out.println(); 
					System.out.println("Filme Apagado.");
				break;	

				case 6:
					scanner.nextLine();
					Ator a6 = new Ator();

					System.out.println();
					System.out.println("Inserir ator.");
					
					System.out.println("Nome: ");
					a6.setNome(scanner.nextLine());

					System.out.println("País: ");
					a6.setPais(scanner.nextLine());
					
					aControl.inserirAtor(a6);		
					System.out.println();
					System.out.println("Ator Inserido.");
				break;

				case 7:
					scanner.nextLine();
					System.out.println();

					System.out.println("Pesquisar um ator por nome: ");
					String nomeAtor = scanner.nextLine();

					List<Ator> atores = aControl.pesquisarUmAtor(nomeAtor);	
					if (!(atores.isEmpty())) {
						for (Ator ator : atores ) { //Como mostra a conexão de ator com filme caso tenha depois
							System.out.println("ID: " + ator.getId() + " | Nome: " + ator.getNome() + " | País: " + ator.getPais());
						}
					} else { 
						System.out.println(); 
						System.out.println("Ator não encontrado.");
					}
				break;

				case 8:
					System.out.println();
					System.out.println("Escolha um ator para apagar: ");

					id = scanner.nextLong();
					aControl.apagar(id);

					System.out.println(); 
					System.out.println("Ator Apagado.");
				break;

				case 9:
					scanner.nextLine();
					System.out.println(); 

					System.out.println("Escolha um ator para atualizar: ");
					id = scanner.nextLong();
					scanner.nextLine();
					
					Ator a9 = new Ator ( );
					a9.setId(id);
					
					System.out.println("Nome: ");
					a9.setNome(scanner.nextLine());
					
					System.out.println("País: ");
					a9.setPais(scanner.nextLine());

					aControl.atualizar(a9);
					System.out.println(); 
					System.out.println("Ator Atualizado.");
				break;

				case 10:
					System.out.println(); 
					System.out.println("Listando Todos os atores: ");
					atores = aControl.pesquisarTodos();	
					if (!(atores.isEmpty())) {
						for (Ator ator : atores ) {
							System.out.println("ID: " + ator.getId() + " | Nome: " + ator.getNome() + " | País: " + ator.getPais());
						}
					}
					else {
						System.out.println(); 
						System.out.println("Não encontrou o Filme");
					}
				break;

				case 11:
					System.out.println("");
					System.out.println("XXXX");
				break;

				case 12:
					System.out.println("");
					System.out.println("Saindo do menu.");
				break;

				default:
					System.out.println("");
					System.out.println("Opção inválida. Tente novamente.");
				break;
			}
		} while (escolha != 12);
		scanner.close();
	}
}


