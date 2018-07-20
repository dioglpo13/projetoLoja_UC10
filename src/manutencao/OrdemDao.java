package manutencao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;


public class OrdemDao {
    
    public static boolean inserir(Ordem ordem){
        String sql = "INSERT INTO ordens "
            + " ( servico, endereco , codCliente) "
            + " VALUES ( "
            + " '" + ordem.getServico()            + "' , "
            + " '" + ordem.getEndereco()           + "' , "
            + "  " + ordem.getCliente().getCodigo()+ "    "
            + " );";
        return conexao.executar(sql);
    }
    
    
    public static boolean editar(Ordem ordem){
        String sql = "UPDATE clientes SET "
            + " nome =     '"    + ordem.getServico()              + "' , "
            + " endereco = '"    + ordem.getEndereco()             + "' , "
            + " codCliente = "   + ordem.getCliente().getCodigo()  + "   "
            + " WHERE codigo = " + ordem.getCodigo();
        return conexao.executar(sql);
    }
    
    public static boolean excluir(Ordem ordem){
        String sql = "DELETE FROM ordens "
        + " WHERE codigo = " + ordem.getCodigo();
        return conexao.executar(sql);
    }
    
    public static List<Ordem> getClientes(){
        List<Ordem> lista = new ArrayList<>();
        String sql = "SELECT c.codigo, c.nome, c.endereco,"
            + " d.codigo, d.nome  "
            + " FROM ordens c  "
            + " INNER JOIN clientes d ON c.codCliente = d.codigo "
            + " WHERE c.tipo = '' "
            + " ORDER BY c.nome";
        ResultSet rs = conexao.consultar( sql );
        if( rs != null ){
            try{
                while ( rs.next() ) {  
                    Ordem ord = new Ordem();
                    ord.setCodigo( rs.getInt(1) );
                    ord.setServico( rs.getString(2));
                    ord.setEndereco(rs.getString(3));
                    
                    Cliente cli = new Cliente();
                    cli.setCodigo( rs.getInt(4) );
                    cli.setNome( rs.getString(5) );
                    cli.setEmail( rs.getString(6) );
                    
                    lista.add(ord);
                } 
            }catch(Exception e){
                JOptionPane.showMessageDialog(null, e.toString());
            }
        }
        return lista;
    }
    
    
}
