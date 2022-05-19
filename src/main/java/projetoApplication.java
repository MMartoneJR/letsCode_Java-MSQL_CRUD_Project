import conexaoDB.Cadastrar;
import conexaoDB.Consultar;
import objetos.Produtos;
import objetos.Vendas;
import objetos.Vendedor;

import java.math.BigDecimal;
import java.util.Scanner;

public class projetoApplication {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Consultar consultar = new Consultar();
        Cadastrar cadastrar = new Cadastrar();

        Produtos produtos = new Produtos();
        Vendedor vendedor = new Vendedor();
        Vendas vendas = new Vendas();

        int opc = 0;

        do{
            System.out.println("Selecione uma das opções abaixo:");
            System.out.println("1 - Realizar venda");
            System.out.println("2 - Consultar produtos disponíveis");
            System.out.println("3 - Consultar vendas realizadas");
            System.out.println("4 - Cadastro de novo produto");
            System.out.println("5 - Cadastro de novo vendedor");
            System.out.println("0 - Sair");
            System.out.print("\nEscolha: ");

            opc = sc.nextInt();
            System.out.println();

            switch (opc){
                case 1:
                    System.out.print("ID do vendedor: ");
                    int idVendedor = sc.nextInt();
                    vendas.setId_vendedor(idVendedor);
                    vendas.cadastroVenda(vendas.getId_vendedor());
                    vendas.setId_venda(vendas.vendaID());

                    System.out.print("ID do produto: ");
                    int idProduto = sc.nextInt();
                    produtos.setId_produto(idProduto);
                    System.out.print("Quantidade: ");
                    int quantidade = sc.nextInt();
                    produtos.setQuantidade_estoque(quantidade);

                    vendas.produtoVendido(vendas.getId_venda(),produtos.getId_produto(), produtos.getQuantidade_estoque());

                    break;
                case 2:
                    consultar.consultarProdutos();
                    break;
                case 3:
                    consultar.consultarVendas();
                    break;
                case 4:
                    System.out.print("Digite o nome do produto: ");
                    String nomeNovoProduto = sc.next();
                    produtos.setNome_produto(nomeNovoProduto);

                    System.out.print("Digite o valor do produto: ");
                    BigDecimal precoNovoProduto = sc.nextBigDecimal();
                    produtos.setPreco_produto(precoNovoProduto);

                    System.out.print("Digite a quantidade do produto: ");
                    int quantidadeNovoProduto = sc.nextInt();
                    produtos.setQuantidade_estoque(quantidadeNovoProduto);

                    cadastrar.cadastroProduto(produtos.getNome_produto(), produtos.getPreco_produto(), produtos.getQuantidade_estoque());

                    break;
                case 5:
                    System.out.print("Nome: ");
                    String nomeNovoVendedor = sc.next();
                    vendedor.setNome_vendedor(nomeNovoVendedor);

                    System.out.print("E-mail: ");
                    String emailNovoVendedor = sc.next();
                    vendedor.setEmail(emailNovoVendedor);

                    cadastrar.cadastroVendedor(vendedor.getNome_vendedor(), vendedor.getEmail());
                    break;
            }
        }while (opc != 0);
    }
}
