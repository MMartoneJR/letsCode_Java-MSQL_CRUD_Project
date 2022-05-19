package objetos;

public class Vendedor {
    int id_vendedor;
    String nome_vendedor;
    String email;

    public Vendedor(){};

    public Vendedor(int id_vendedor, String nome_vendedor, String email) {
        this.id_vendedor = id_vendedor;
        this.nome_vendedor = nome_vendedor;
        this.email = email;
    }

    public int getId_vendedor() {
        return id_vendedor;
    }

    public void setId_vendedor(int id_vendedor) {
        this.id_vendedor = id_vendedor;
    }

    public String getNome_vendedor() {
        return nome_vendedor;
    }

    public void setNome_vendedor(String nome_vendedor) {
        this.nome_vendedor = nome_vendedor;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
