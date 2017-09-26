public class Produto {
    private int numero;
    private double preco;

    //Construtores
    public Produto(){
        this.numero = -1;
        this.preco = 0;
    }

    public Produto(int numero, double preco) {
        this.numero = numero;
        this.preco = preco;
    }

    //Metodos especiais
    public double getDesconto(){
        if(this.preco > 100) return 0.15;
        else return 0.05;
    }

    //Getters and Setters
    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }
}
