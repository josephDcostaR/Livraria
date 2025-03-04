package controller;

import java.util.Scanner;

import Model.Ebook;
import Model.Livro;
import Model.LivroFisico;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class LojaLivros {

    private Scanner sc;
    private List<Livro> catalogo;
    private CarrinhoDeCompras carrinho;

    public LojaLivros() {
        sc = new Scanner(System.in);
        sc.useLocale(Locale.US);
        catalogo = new ArrayList<>();
        carrinho = new CarrinhoDeCompras();
        catalogo.add( new LivroFisico("Clean Code", "Robert C. Martin", "Tech", "9780132350884", 120.0, 0.5, 15.0));
        catalogo.add(new LivroFisico("O Programador Pragmático", "Andrew Hunt", "Tech", "9780201616224", 150.0, 0.6, 18.0));
        catalogo.add(new Ebook("Java Efetivo", "Joshua Bloch", "Tech", "9780134685991", 90.0, 25));
        catalogo.add(new Ebook("Código Limpo para Java", "Robert C. Martin", "Tech", "9780135175781", 80.0, 20));
    }

    public void iniciar() {
        while (true) {
            limparConsole();
            exibirMenuLoja();
            int opcao = sc.nextInt();
            sc.nextLine();
            switch (opcao) {
                case 1:
                    listarCatalogo();
                    break;
                case 2:
                    pesquisarLivroCatalogo();
                    break;
                case 3:
                    FiltarPreco();
                    break;
                case 4:
                    adicionarLivroAoCarrinho();
                    break;
                case 5:
                    carrinho.DeletarLivro();
                    break;
                case 6:
                    CadastrarLivro();
                    break;
                case 7:
                    carrinho.exibirMenu();// Exibe o menu do carrinho
                    break;
                case 8:
                    System.out.println("Saindo da loja...");
                    return;
                default:
                    System.out.println("Opção inválida!");
            }
            System.out.println("\nPressione Enter para continuar...");
            sc.nextLine();
        }
    }

    private void exibirMenuLoja() {
        System.out.println("""
            --- MENU DA LOJA ---
            1. Listar Catálogo de Livros
            2. Pesquisar Livro no Catálogo
            3. Filtrar Preços
            4. Adicionar Livro ao Carrinho
            5. Deletar Livro do carinho
            6. Cadastrar Novo Livro
            7. Ir para o Carrinho
            8. Sair
            """);
        System.out.print("Escolha: ");
    }

    private void listarCatalogo() {
        System.out.println("--- Catálogo de Livros ---");
        if (catalogo.isEmpty()) {
            System.out.println("nunhum livro disponível");  
        } else {
            for(Livro livro : catalogo) {
                System.out.println(livro);
            }
        }
    }

    private void pesquisarLivroCatalogo() {
        System.out.println("""
                Pesquisar por:
                1. Titulo
                2. Autor
                3. Genero
                """);

        System.out.println("Escolha uma opção: ");
        int opcao = sc.nextInt();
        sc.nextLine(); // Limpa o buffer

        System.out.println("Digitr o termo de pesquisa: ");
        String termo = sc.nextLine().trim().toLowerCase();

        List<Livro> resultados = new ArrayList<>();

        for(Livro l : catalogo) {
            if (opcao == 1 && l.getTitulo().toLowerCase().contains(termo)||
                opcao == 2 && l.getAutor().toLowerCase().contains(termo) ||
                opcao == 3 && l.getGenero().toLowerCase().contains(termo)) {
                resultados.add(l);
            }
        }

        if (resultados.isEmpty()) {
            System.out.println("Nenhum livro encontrado.");
        }else {
            for(Livro livro : resultados) {
                System.out.println(livro);
            }
        }
    }

    public void FiltarPreco() {
        System.out.println("Digite o preço mínimo: ");
        double precoMin = sc.nextDouble();

        System.out.println("Digite o preco máximo: ");
        double precoMax = sc.nextDouble();

        sc.nextLine();

        List<Livro> livrosFiltrados = new ArrayList<>();

        for(Livro l : catalogo) {
            if (l.getPreco() >= precoMin && l.getPreco() <= precoMax) {
                livrosFiltrados.add(l);
            }
        }

        if (livrosFiltrados.isEmpty()) {
            System.out.println("Nenhum livro encontrado nesse intervalo de preço.");
        }else {
            System.out.println("livrosNoCarinhoencontrados: ");
            for(Livro livro : livrosFiltrados) {
                System.out.println(livro);
            }
        }
    }

    private void adicionarLivroAoCarrinho() {
        System.out.println("Digite o ISBN do livro a ser adicionado ao carrinho: ");
        String isbn =sc.nextLine();
        Livro livroSelecionado = null;
        for (Livro livro : catalogo) {
            if (livro.getIsbn().equals(isbn)) {
                livroSelecionado = livro;
                break;
            }
        }

        if (livroSelecionado != null) {
            carrinho.AdicionarLivro(livroSelecionado);
        } else {
            System.out.println("Livro com ISBN " + isbn + " não encontrado no catálogo.");
        }
    }

    
     
    public void CadastrarLivro() {
        if (!catalogo.isEmpty()) {
            System.out.println("Já temos alguns livrosNoCarinhono carrinho.");
        }

        System.out.println("O livro comparado é: [0 - Fisico | 1 - Digital]");
        int opcao = sc.nextInt();
        sc.nextLine();

        System.out.println("Digite o titulo do Livro: ");
        String titulo = sc.nextLine();
        System.out.println("Digite o autor do Livro: ");
        String autor = sc.nextLine();
        System.out.println("Digite o genero do Livro: ");
        String genero = sc.nextLine();
        System.out.println("Digite o codigo ISBN do Livro: ");
        String isbn = sc.nextLine();
        System.out.println("Digite o preco do Livro: ");
        double preco = sc.nextDouble();
        sc.nextLine();

        if (opcao == 0) {
            System.out.println("Digite o peso do livro: ");
            double peso = sc.nextDouble();
            sc.nextLine();

            System.out.println("Digite o frete do livro: ");
            double frete = sc.nextDouble();

            catalogo.add(new LivroFisico(titulo, autor, genero, isbn, preco, peso, frete));

            System.out.println("Tarefa adicionada com sucesso!"); 
        } else if (opcao == 1) {
            System.out.println("Digite o tamanho do livro em MB: ");
            double tamanhoEmMb = sc.nextDouble();
            sc.nextLine();

            catalogo.add(new Ebook(titulo, autor, genero, isbn, preco, tamanhoEmMb));

            System.out.println("Tarefa adicionada com sucesso!");
        }
    }

    private void limparConsole() {
        try{
            String os = System.getProperty("os.name").toLowerCase();
            if (os.contains("win")) {
                
                new ProcessBuilder("cmd","/c","cls").inheritIO().start().waitFor();
            }else {
                System.out.println("\\u001b[H\\u001b[2J");
                System.out.flush();
            }

        } catch (Exception e) {
            System.out.println("Erro ao limpar o console!");
        }
    }

}
