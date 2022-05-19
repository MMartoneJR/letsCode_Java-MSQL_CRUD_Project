package objetos;

import conexaoDB.ConexaoDB;

import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;

public class Vendas {
    int id_venda;
    int id_vendedor;
    LocalDateTime data_venda;
    int vendaID;
    ConexaoDB conn = new ConexaoDB();

    public Vendas (){};

    public Vendas(int id_venda, int id_vendedor, LocalDateTime data_venda) {
        this.id_venda = id_venda;
        this.id_vendedor = id_vendedor;
        this.data_venda = data_venda;
    }

    public int getId_venda() {
        return id_venda;
    }

    public void setId_venda(int id_venda) {
        this.id_venda = id_venda;
    }

    public int getId_vendedor() {
        return id_vendedor;
    }

    public void setId_vendedor(int id_vendedor) {
        this.id_vendedor = id_vendedor;
    }

    public LocalDateTime getData_venda() {
        return data_venda;
    }

    public void setData_venda(LocalDateTime data_venda) {
        this.data_venda = data_venda;
    }

    public void cadastroVenda(int idVendedor){
        int venda_id = 0;
        try {
            PreparedStatement venda = conn.getConexaoDB().prepareStatement(
                    "INSERT INTO vendas (id_vendedor) VALUES (?);",
                    Statement.RETURN_GENERATED_KEYS
            );
            venda.setInt(1, idVendedor);
            venda.executeUpdate();
            ResultSet rs = venda.getGeneratedKeys();
            if(rs.next()){
                venda_id = rs.getInt(1);
            }
            vendaID = venda_id;
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public int vendaID(){
        return vendaID;
    }

    public void produtoVendido(int idVenda, int idProduto, int quantidade){

        BigDecimal precoProduto = null;

        try {
            PreparedStatement getPrecoProduto = conn.getConexaoDB().prepareStatement(
                    "SELECT preco FROM produtos WHERE id_produto = (?);"
            );
            getPrecoProduto.setInt(1, idVenda);
            ResultSet preco = getPrecoProduto.executeQuery();
            while(preco.next()){
                precoProduto = preco.getBigDecimal("preco");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            PreparedStatement venda = conn.getConexaoDB().prepareStatement(
                    "INSERT INTO produtos_vendidos (id_venda, id_produto, quantidade, valor_unitario) VALUES (?, ?, ?, ?);"
            );
            venda.setInt(1, idVenda);
            venda.setInt(2, idProduto);
            venda.setInt(3, quantidade);
            venda.setBigDecimal(4, precoProduto);
            venda.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            PreparedStatement baixaEstoque = conn.getConexaoDB().prepareStatement(
                    "UPDATE produtos SET quantidade_estoque = quantidade_estoque - ? WHERE id_produto = ?;"
            );
            baixaEstoque.setInt(1, quantidade);
            baixaEstoque.setInt(2, idProduto);
            baixaEstoque.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
