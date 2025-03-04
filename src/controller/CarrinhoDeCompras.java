package controller;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Model.Ebook;
import Model.Livro;
import Model.LivroFisico;

import java.util.Locale;

public class CarrinhoDeCompras {
    
    Scanner sc;
    List<Livro> livrosNoCarinho = new ArrayList<>();

    public CarrinhoDeCompras() {
        sc = new Scanner(System.in);
        sc.useLocale(Locale.US);
        livrosNoCarinho = new ArrayList<>();
    }

    public void exibirMenu() {
        while (true) {
            limparConsole();
            System.out.println("""
                --- MENU DO CARRINHO ---
                1. Exibir Carrinho
                2. Exibir Preço Total da Compra
                3. Finalizar Compra
                4. Retornar à Loja
                """);
            System.out.print("Escolha: ");
            int opcao = sc.nextInt();
            sc.nextLine();
            switch (opcao) {
              
                case 1:
                    ExibirCarinho();
                    break;
                case 2:
                    calcularTotal();
                    break;
                case 3:
                    finalizarCompra();
                    break;
                case 4:
                    return; // Retorna para o menu da loja
                default:
                    System.out.println("Opção inválida!");
            }
            System.out.println("\nPressione Enter para continuar...");
            sc.nextLine();
        }
    }

    public void AdicionarLivro(Livro livro) {
        livrosNoCarinho.add(livro);
        System.out.println(livro.getTitulo() + " foi adicionado ao carrinho.");
    }
  
    public void calcularTotal() {
        if (livrosNoCarinho.isEmpty()) {
            System.out.println("Seu carrinho está vazio. Não há nada para comprar.");
            return;
        }

        System.out.println("--- Resumo da Compra ---");
        double totalComFrete = 0;
        double totalSemFrete = 0;
        double totalFrete = 0;

        for(Livro l:livrosNoCarinho) {
            if(l instanceof LivroFisico) {
                totalFrete += ((LivroFisico) l).getFrete();
                totalComFrete += l.calcularPrecoTotal();
            } if (l instanceof Ebook) {
                totalSemFrete += l.getPreco();
            }
        }

        System.out.println("Valor Original: " +totalSemFrete);
        System.out.println("Valor do frete: "+ totalFrete);
        System.out.println("Valor da Comprar com frete: " +totalComFrete); 
    }

    public void DeletarLivro() {
        Livro livroParaRemover = null;

        System.out.println("Digite o codigo ISBN do livro: ");
        String codigo = sc.nextLine();

        for(Livro l : livrosNoCarinho) {
            if (codigo.equals(l.getIsbn())) {
                livroParaRemover = l;
                break;
            }
        }

        if (livroParaRemover != null) {
            livrosNoCarinho.remove(livroParaRemover);
            System.out.println("Livro removido com sucesso!");
        } else {
            System.out.println("Livro com ISBN " + codigo + " não encontrado.");
        }
    }

    public void ExibirCarinho() {
        if(livrosNoCarinho.isEmpty()) {
            System.out.println("Não há livros NoCarinho resgistrados");
        } else {
            for(Livro l : livrosNoCarinho) {
                System.out.println(l);
            }
        }
    }
   
    public void finalizarCompra(){
        if (livrosNoCarinho.isEmpty()) {
            System.out.println("Seu carrinho está vazio. Não há nada para comprar.");
            return;
        }

         

        System.out.println("Deseja finalizar a compra (S | N): ");
        String resposta = sc.nextLine().trim().toUpperCase();

        if (resposta.equals("S")) {
            System.out.println("Compra finalizada com sucesso. Obrigado!");
            livrosNoCarinho.clear();
        } else {
            System.out.println("Compra cancelada.");
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

