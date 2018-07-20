
package manutencao;

public class Cliente {
    private int codigo;
    private String nome;
    private String email;

    public Cliente() {
    }

    public Cliente(int codigo, String nome , String email) {
        this.codigo = codigo;
        this.nome = nome;
        this.email = email;
    }

    @Override
    public String toString() {
        return nome;
    }

    
    
    
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
}
