package objetos;

import java.math.BigDecimal;

public class Produtos {
    int id_produto;
    String nome_produto;
    BigDecimal preco_produto;
    int quantidade_estoque;

    public Produtos(){};

    public Produtos(int id_produto, String nome_produto, BigDecimal preco_produto, int quantidade_estoque) {
        this.id_produto = id_produto;
        this.nome_produto = nome_produto;
        this.preco_produto = preco_produto;
        this.quantidade_estoque = quantidade_estoque;
    }

    public int getId_produto() {
        return id_produto;
    }

    public void setId_produto(int id_produto) {
        this.id_produto = id_produto;
    }

    public String getNome_produto() {
        return nome_produto;
    }

    public void setNome_produto(String nome_produto) {
        this.nome_produto = nome_produto;
    }

    public BigDecimal getPreco_produto() {
        return preco_produto;
    }

    public void setPreco_produto(BigDecimal preco_produto) {
        this.preco_produto = preco_produto;
    }

    public int getQuantidade_estoque() {
        return quantidade_estoque;
    }

    public void setQuantidade_estoque(int quantidade_estoque) {
        this.quantidade_estoque = quantidade_estoque;
    }
}
