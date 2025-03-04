package Model;
public class Ebook extends Livro {

    private double tamanhoEmMb;

    public Ebook(String titulo, String autor, String genero, String isbn, double preco, double tamanhoEmMb) {
        super(titulo, autor, genero, isbn, preco);
        this.tamanhoEmMb = tamanhoEmMb;
    }

    public double getTamanhoEmMb() {
        return tamanhoEmMb;
    }

    public void setTamanhoEmMb(double tamanhoEmMb) {
        this.tamanhoEmMb = tamanhoEmMb;
    }

    @Override
    public double calcularPrecoTotal() {
        return this.getPreco();
    }

    @Override
    public String toString() {
        return super.toString() + " (Ebook - " + tamanhoEmMb + "MB)";
    }

}
