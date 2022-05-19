package conexaoDB;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Consultar {

    ConexaoDB conn = new ConexaoDB();

    public void consultarProdutos(){
        try {
            PreparedStatement consultar = conn.getConexaoDB().prepareStatement("SELECT * FROM produtos");
            ResultSet consulta = consultar.executeQuery();

            while(consulta.next()){
                System.out.printf(
                        "ID: %d | Nome: %s | Preço = %.0f | Em estoque = %d\n",
                        consulta.getInt("id_produto"),
                        consulta.getString("nome_produto"),
                        consulta.getBigDecimal("preco"),
                        consulta.getInt("quantidade_estoque")
                        );
            }
            System.out.println();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void consultarVendas(){
        try {
            PreparedStatement consultar = conn.getConexaoDB().prepareStatement(
                    "select vendas.id_venda, vendas.data_venda, vendedor.nome_vendedor, " +
                            "produtos.nome_produto, produtos_vendidos.quantidade, " +
                            "SUM(produtos.preco * produtos_vendidos.quantidade) " +
                            "from vendas " +
                            "inner join vendedor " +
                            "on vendas.id_vendedor = vendedor.id_vendedor " +
                            "inner join produtos_vendidos " +
                            "on vendas.id_venda = produtos_vendidos.id_venda " +
                            "inner join produtos " +
                            "on produtos_vendidos.id_produto = produtos.id_produto " +
                            "group by vendas.id_venda " +
                            "order by vendas.id_venda"
            );
            ResultSet consulta = consultar.executeQuery();

            while(consulta.next()){
                System.out.printf(
                        "ID venda: %d | Data da venda: %s | Vendedor: %s | Produto: %s |Quantidade: %d | total da venda: R$ %.2f \n",
                        consulta.getInt("vendas.id_venda"),
                        consulta.getString("vendas.data_venda"),
                        consulta.getString("vendedor.nome_vendedor"),
                        consulta.getString("produtos.nome_produto"),
                        consulta.getInt("produtos_vendidos.quantidade"),
                        consulta.getFloat("SUM(produtos.preco * produtos_vendidos.quantidade)")
                );
            }
            System.out.println();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
