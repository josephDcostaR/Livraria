import controller.LojaLivros;

public class App {
    public static void main(String[] args) throws Exception {

        LojaLivros loja = new LojaLivros();

        // Livro livroFisico1 = new LivroFisico("Clean Code", "Robert C. Martin", "Tech", "9780132350884", 120.0, 0.5, 15.0);
        // Livro livroFisico2 = new LivroFisico("O Programador Pragmático", "Andrew Hunt", "Tech", "9780201616224", 150.0, 0.6, 18.0);
        // Livro livroEbook1 = new Ebook("Java Efetivo", "Joshua Bloch", "Tech", "9780134685991", 90.0, 25);
        // Livro livroEbook2 = new Ebook("Código Limpo para Java", "Robert C. Martin", "Tech", "9780135175781", 80.0, 20);
        // carinho.getLivrosNoCarinho().add(livroFisico1);
        // carinho.getLivrosNoCarinho().add(livroFisico2);
        // carinho.getLivrosNoCarinho().add(livroEbook1);
        // carinho.getLivrosNoCarinho().add(livroEbook2);
        // //Metodo 1
        // for (Livro l : carinho.livros) {
        //     System.out.println("Titulo: "+l.getTitulo());
        //     System.out.println("Autor: "+l.getAutor());
        //     System.out.println("ISBN: "+l.getIsbn());
        //     System.out.println("Preco: "+l.getPreco());
        //     // Forma de printar os dados dos filhos de Livro pelo instanceof e if/else
        //     if (l instanceof LivroFisico) {
        //         System.out.println("Peso: "+((LivroFisico)l).getPeso());
        //         System.out.println("Frete: "+((LivroFisico)l).getPeso());
        //     } else if (l instanceof Ebook) {
        //         System.out.println("Tamanho em MB: "+((Ebook)l).getTamanhoEmMb());    
        //     }
        // }

        loja.iniciar();
    }
}
