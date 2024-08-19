
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Biblioteca {

    public static void main(String[] args) {

        Autor autor1 = new Autor(1, "Eusebio Pereira da Silva", LocalDate.of(1800, 1, 1));
        Autor autor2 = new Autor(2, "Dona Cegonha do Cerrado", LocalDate.of(1900, 12, 31));
        Autor autor3 = new Autor(3, "Ze do Pe de Feijão Mágico", LocalDate.of(1850, 6, 15));
        Autor autor4 = new Autor(4, "Fantasma do Suburbio Leste", LocalDate.of(2001, 4, 22));
        Autor autor5 = new Autor(5, "Mestre dos Mares Secos", LocalDate.of(1955, 8, 18));

        List<Autor> autores = new ArrayList<>();
        autores.add(autor1);
        autores.add(autor2);
        autores.add(autor3);
        autores.add(autor4);
        autores.add(autor5);

        Livro livro1 = new Livro(1, "A Morte do Eterno Imortal", autor1.getNome(), true,
                LocalDateTime.of(2024, 8, 15, 10, 0), LocalDateTime.of(2024, 8, 15, 12, 0));
        Livro livro2 = new Livro(2, "O Manual do Desmanualizado", autor2.getNome(), true,
                LocalDateTime.of(2023, 11, 11, 9, 30), LocalDateTime.of(2024, 1, 1, 15, 0));
        Livro livro3 = new Livro(3, "Histórias do Buraco Infinito", autor3.getNome(), true,
                LocalDateTime.of(2022, 6, 1, 14, 45), LocalDateTime.of(2023, 3, 22, 17, 20));
        Livro livro4 = new Livro(4, "A Lâmpada que Apagou o Sol", autor4.getNome(), true,
                LocalDateTime.of(2020, 12, 25, 8, 0), LocalDateTime.of(2021, 5, 5, 10, 30));
        Livro livro5 = new Livro(5, "O Oceano na Gota Dagua", autor5.getNome(), true,
                LocalDateTime.of(2019, 3, 30, 18, 20), LocalDateTime.of(2019, 8, 1, 12, 10));

        List<Livro> livros = new ArrayList<>();
        livros.add(livro1);
        livros.add(livro2);
        livros.add(livro3);
        livros.add(livro4);
        livros.add(livro5);

        List<Livro> emprestimo = new ArrayList<>();
        List<String> livrosEmprestados = new ArrayList<>();

        for (Livro livro : livros) {
            if (livro.isDisponivel() == true) {
                emprestimo.add(livro);
            } 
        }
        for (Livro livro : livros) {
            if (livro.isDisponivel() == false) {
                emprestimo.remove(livro);
            } 
        }

        Scanner sc = new Scanner(System.in);

        boolean continuar = true;
        String nome = "";
        System.out.println("Digite o seu nome de usuário para inicializar o programa:");
        nome = sc.next().toLowerCase();

        while (continuar && nome != null) {
            System.out.println(
                    "Digite o número desejado \n 1 - Exibir os livros disponiveis \n 2 - Obter um livro emprestado \n 3 - Adicionar um novo livro à biblioteca");

            int menuIndice = sc.nextInt();
            sc.nextLine();

            switch (menuIndice) {
                case 1:
                    System.out.println("Esses são todos os livros disponiveis: ");
                    System.out.println(livros);
                    break;

                case 2:
                    System.out.println("Esses são todos os livros disponiveis: ");
                    System.out.println(emprestimo);
                    System.out.println("Digite o número identificador do livro que deseja pegar emprestado: ");
                    int idLivro = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Confirme seu nome para obter um empréstimo: ");
                    String validaNome = sc.next().toLowerCase();
                    sc.nextLine();
                    if (validaNome == null ? nome != null : !validaNome.equals(nome)) {
                        System.out.println("Usuário não reconhecido, tente novamente. ");
                        break;
                    }

                        for (Livro livro : livros) {
                            if (idLivro == livro.getId()) {
                                livro.setDisponivel(false);
                                livrosEmprestados.add(livro.getTitulo());
                                emprestimo.remove(livro);
                                System.out.println("Emprestimo realizado com sucesso!");
                                System.out.println(livrosEmprestados);
                            }
                        }
                        break;
                    
                    case 3:
                    System.out.println("Digite o título do livro: ");
                    String tituloDoLivro = sc.nextLine();

                    System.out.println("Digite o autor do livro: ");
                    String autorDoLivro = sc.nextLine();

                    Livro lv = new Livro((livros.size() + 1), tituloDoLivro, autorDoLivro, true, LocalDateTime.now(), LocalDateTime.now());
                    livros.add(lv);
                    System.out.println("Livro adicionado com sucesso.");
                    System.out.println(livros);
                    break;

                default:
                    System.out.println("Número inválido! Tente novamente!");
                    break;
            }
            int isContinuar;
                    System.out.println("Deseja continuar? 1 para sim e 2 para encerrar o programa");
                    isContinuar = sc.nextInt();
                    if (isContinuar != 1) {
                        continuar = false;
                        System.out.println("Programa encerrado!");
                    }
            }
            sc.close();
        }
    }
