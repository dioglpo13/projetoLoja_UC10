
package manutencao;

import java.sql.ResultSet;
import java.util.List;
import java.util.ArrayList;
import javax.swing.JOptionPane;


public class ClienteDAO {
    
    public static boolean inserir(Cliente cliente){
       /* String sql = "INSERT INTO clientes "
            + " ( nome ) VALUES "
            + " ( '" + cliente.getNome() + "' );";*/
       
        String sql = "INSERT INTO clientes "
            + " ( nome, email ) "
            + " VALUES ( "
            + " '" + cliente.getNome()              + "' , "
            + " '" + cliente.getEmail()          + "'  "
                
            + " );";
        return conexao.executar(sql);
    }
    
      
    public static boolean editar(Cliente cliente){
        String sql = "UPDATE clientes SET "
            + " nome =  '" + cliente.getNome() + "' , "
            + " email =  '" + cliente.getEmail() + "' "
            + " WHERE codigo = " + cliente.getCodigo();
        return conexao.executar(sql);
    }
    
    public static boolean excluir(Cliente categoria){
        String sql = "DELETE FROM clientes "
            + " WHERE codigo = " + categoria.getCodigo();
        return conexao.executar(sql);
    }
    
    public static List<Cliente> getCategoria(){
        List<Cliente> lista = new ArrayList<>();
        String sql = "SELECT * FROM clientes ORDER BY nome";
        ResultSet rs = conexao.consultar( sql );
        
        if( rs != null ){
            try{
                while ( rs.next() ) {  
                    Cliente cid = new Cliente();
                    cid.setCodigo( rs.getInt(1) );
                    cid.setNome( rs.getString(2) );
                    cid.setEmail( rs.getString(3) );
                    lista.add(cid);
                } 
            }catch(Exception e){
                JOptionPane.showMessageDialog(null, e.toString());
            }
        }
        
        return lista;
    }
    
    
}

