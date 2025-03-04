package Model;
public class LivroFisico extends Livro {

    private double peso;
    private double frete;

    public LivroFisico(String titulo, String autor, String genero, String isbn, double preco, double peso, double frete) {
        super(titulo, autor, genero, isbn, preco);
        this.peso = peso;
        this.frete = frete;
    }

    public LivroFisico() {
        super();
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getFrete() {
        return frete;
    }

    public void setFrete(double frete) {
        this.frete = frete;
    }

    @Override
    public double calcularPrecoTotal() {
        return this.getPreco() + this.frete;
    }

    @Override
    public String toString() {

        return super.toString() + " (Fisico - peso: " + peso + " - FRETE  " + frete+")";
    }

    

    

   

}
