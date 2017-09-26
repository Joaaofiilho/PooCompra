public class Compra {
    private int numeroProduto;
    private Produto produtos[];
    private Cliente clientes[];
    private int numeroCliente;
    private int quantidadeProdutos;
    private double valorTotal;

    //Construtor
    public Compra(Cliente clientes[], Produto produtos[]){
        this.numeroProduto = 0;
        this.numeroCliente = 0;
        this.quantidadeProdutos = 0;
        this.clientes = clientes;
        this.produtos = produtos;
        this.valorTotal = 0;
    }

    public Compra(int numeroProduto, int numeroCliente, int quantidadeProdutos) {
        this.numeroProduto = numeroProduto;
        this.numeroCliente = numeroCliente;
        this.quantidadeProdutos = quantidadeProdutos;
        this.valorTotal = calcularValorTotal();
    }

    //Metodos especiais
    private double calcularValorTotal() {
        //TODO calcular precoFinal
        return this.quantidadeProdutos * (buscarProduto(this.numeroProduto).getPreco() -
                (buscarProduto(this.numeroProduto).getPreco() * buscarProduto(this.numeroProduto).getDesconto()) -
                (buscarProduto(this.numeroProduto).getPreco() * buscarCliente(this.numeroCliente).getDescontoAdicional()));
    }

    public Produto buscarProduto(int numeroProduto){
        for (int i = 0; i < produtos.length; i++) {
            if(produtos[i].getNumero() == numeroProduto) return produtos[i];
        }
        return null;
    }

    public Cliente buscarCliente(int numeroCliente){
        for (int i = 0; i < clientes.length; i++) {
            if(clientes[i].getNumero() == numeroCliente) return clientes[i];
        }
        return null;
    }

    //Getters and Setters
    public int getNumeroProduto() {
        return numeroProduto;
    }

    public void setNumeroProduto(int numeroProduto) {
        this.numeroProduto = numeroProduto;
    }

    public int getNumeroCliente() {
        return numeroCliente;
    }

    public void setNumeroCliente(int numeroCliente) {
        this.numeroCliente = numeroCliente;
    }

    public int getQuantidadeProdutos() {
        return quantidadeProdutos;
    }

    public void setQuantidadeProdutos(int quantidadeProdutos) {
        this.quantidadeProdutos = quantidadeProdutos;
        this.valorTotal = calcularValorTotal();
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }
}
