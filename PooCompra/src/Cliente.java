public class Cliente {
    private int numero;
    private String nome;
    private char sexo;

    //Construtores
    public Cliente(){
        this.numero = -1;
        this.nome = "";
        this.sexo = 'u'; //u = undefined
    }

    //Metodos especiais
    public double getDescontoAdicional(){
        if(this.sexo == 'F') return 0.05;
        else return 0;
    }


    //Getters and Setters
    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }
}
