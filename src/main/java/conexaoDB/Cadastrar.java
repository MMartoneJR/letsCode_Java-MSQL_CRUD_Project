package conexaoDB;

import objetos.Produtos;

import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class Cadastrar {

    ConexaoDB conn = new ConexaoDB();
    Produtos produtos = new Produtos();


    public void cadastroProduto(String nome, BigDecimal preco, int quantidade){
        try {
            PreparedStatement cadastrar = conn.getConexaoDB().prepareStatement(
                    "INSERT INTO produtos (nome_produto, preco, quantidade_estoque) VALUES (?,?,?);"
            );
            cadastrar.setString(1, nome);
            cadastrar.setBigDecimal(2, preco);
            cadastrar.setInt(3, quantidade);
            cadastrar.executeUpdate();

            System.out.println("Produto cadastrado com sucesso!\n");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void cadastroVendedor(String nome, String email){
        try {
            PreparedStatement cadastrar = conn.getConexaoDB().prepareStatement(
                    "INSERT INTO vendedor (nome_vendedor, email_vendedor) VALUES (?,?);"
            );
            cadastrar.setString(1, nome);
            cadastrar.setString(2, email);
            cadastrar.executeUpdate();
            System.out.println("Vendedor cadastrado com sucesso!\n");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
