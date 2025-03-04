package Model;
public abstract class Livro {

    private String titulo;
    private String autor;
    private String genero;
    private String isbn;
    private double preco;

    public Livro(String titulo, String autor, String genero, String isbn, double preco) {
        this.titulo = titulo;
        this.autor = autor;
        this.genero = genero;
        this.isbn = isbn;
        this.preco = preco;
    }

    public Livro(){}

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public abstract double calcularPrecoTotal();

    @Override
    public String toString() {
        return  titulo + " - " + autor + " - " + genero + " - " + isbn + " - R$ " + preco;
    }

    

    

    

}
