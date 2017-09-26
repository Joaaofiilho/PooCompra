import java.util.Scanner;

public class Aplicacao {
    public static void main(String[] args) {
        Produto produto[] = new Produto[3];
        Cliente cliente[] = new Cliente[3];

        //Instanciando
        for (int i = 0; i < produto.length; i++) {
            produto[i] = new Produto();
        }
        for (int i = 0; i < cliente.length; i++) {
            cliente[i] = new Cliente();
        }


        Scanner scan = new Scanner(System.in);

        System.out.println("#Cadastro de produtos#");
        for (int i = 0; i < produto.length; i++) {
            Produto p = new Produto();
            int numeroProduto = -1;
            double precoProduto = 0;
            System.out.printf("->Produto %d\n", i + 1);

            do {
                System.out.print("Numero do produto: ");
                numeroProduto = scan.nextInt();

                if(hasNumeroProduto(produto, numeroProduto))
                    System.out.println("Já existe um produto com este número!");

            }while(hasNumeroProduto(produto, numeroProduto));
            p.setNumero(numeroProduto);

            do{
                System.out.print("Preço do produto: ");
                precoProduto = scan.nextDouble();

                if(precoProduto < 20 || precoProduto > 360)
                    System.out.println("Preço inválido (R$20 - R$360)");

            }while(precoProduto < 20 || precoProduto > 360);
            p.setPreco(precoProduto);

            produto[i] = p;
        }

        System.out.println("#Cadastro de clientes#");
        for (int i = 0; i < cliente.length; i++) {
            Cliente c = new Cliente();
            int numeroCliente = -1;
            char sexoCliente = 'u';

            System.out.printf("->Cliente %d\n",i + 1);

            do {
                System.out.print("Numero do cliente: ");
                numeroCliente = scan.nextInt();

                if(hasNumeroCliente(cliente, numeroCliente))
                    System.out.println("Já existe um cliente com este número!");
            }while(hasNumeroCliente(cliente, numeroCliente));
            c.setNumero(numeroCliente);

            System.out.print("Nome do cliente: ");
            c.setNome(scan.nextLine());
            c.setNome(scan.nextLine()); //Debugger do Scanner

            do {
                System.out.print("Sexo do cliente: ");
                sexoCliente = scan.nextLine().toUpperCase().charAt(0);

                if(sexoCliente != 'F' && sexoCliente != 'M')
                    System.out.println("Sexo inválido! (M ou F)");

            }while (sexoCliente != 'F' && sexoCliente != 'M') ;
            c.setSexo(sexoCliente);

            cliente[i] = c;
        }


        Compra compra = new Compra(cliente, produto);
        System.out.println("#Compra#");
        int numeroCliente = -1, numeroProduto = -1;

        do {
            System.out.print("Digite o número do cliente: ");
            numeroCliente = scan.nextInt();

            if(!hasNumeroCliente(cliente, numeroCliente))
                System.out.println("Não existe um cliente com esse número!");
        }while(!hasNumeroCliente(cliente, numeroCliente));
        compra.setNumeroCliente(numeroCliente);

        do {
            System.out.print("Digite o número do produto: ");
            numeroProduto = scan.nextInt();

            if(!hasNumeroProduto(produto, numeroProduto))
                System.out.println("Não existe um produto com esse número!");
        }while(!hasNumeroProduto(produto, numeroProduto));
        compra.setNumeroProduto(numeroProduto);

        System.out.print("Digite a quantidade de produtos: ");
        compra.setQuantidadeProdutos(scan.nextInt());

        System.out.println();

        System.out.println("#Dados da compra#");
        System.out.printf("Nome do cliente: %s\n", compra.buscarCliente(compra.getNumeroCliente()).getNome());
        System.out.printf("Preço do produto: %.2f\n", compra.buscarProduto(compra.getNumeroProduto()).getPreco());
        System.out.printf("Quantidade de desconto: %.2f%%\n", ((compra.buscarCliente(compra.getNumeroCliente()).getDescontoAdicional()
        + compra.buscarProduto(compra.getNumeroProduto()).getDesconto()) * 100));
        System.out.printf("O valor total da compra eh: R$%.2f", compra.getValorTotal());
    }

    private static boolean hasNumeroProduto(Produto produtos[], int numeroProduto){
        for (int i = 0; i < produtos.length; i++) {
            if(produtos[i].getNumero() == numeroProduto) return true;
        }
        return false;
    }

    private static boolean hasNumeroCliente(Cliente clientes[], int numeroCliente) {
        for (int i = 0; i < clientes.length; i++) {
            if (clientes[i].getNumero() == numeroCliente) return true;
        }
        return false;
    }
}
