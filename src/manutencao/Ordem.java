
package manutencao;


public class Ordem {
   
    private int codigo;
    private String servico, endereco;
    private Cliente cliente;
    
    public Ordem(){
        
    }
    
    public Ordem(String servico){
        this.servico = servico;
    }
     
    public Ordem(String servico, String endereco, Cliente cliente) {
        this.servico = servico;
        this.endereco = endereco;
       
        this.cliente = cliente;
    }

    
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

   
    public String getServico() {
        return servico;
    }

    public void setServico(String servico) {
        this.servico = servico;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
   
    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

   
    
}




