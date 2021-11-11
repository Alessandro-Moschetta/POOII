package conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Map;

public class DBController {
    
    private final String DB_NAME = "MaquinaVendas";
    private final String DB_USER = "root";
    private final String DB_PASSWORD = "";
    
    private Connection db = null;
    private boolean conectado = false;
    
    public DBController() {}
    
    public Connection getConexao() {
        return db;
    }
    
    public void conectar() throws Exception {
        String url = "jdbc:mysql://localhost/";
        
        url += DB_NAME + "?";
        url += "user=" + DB_USER + "&";
        url += "password=" + DB_PASSWORD;
        
        System.out.println("Conectando ao banco de dados...");
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");        
            db = DriverManager.getConnection(url);
        } catch(ClassNotFoundException e) {
            throw new Exception("Erro ao carregar driver de conexão!");
        } catch (SQLException ex) {
            throw new Exception("URL de conexão inválida! " + ex.getMessage());
        }        

        conectado = true;
    }
    
    public void desconectar() throws Exception {
        try {
            db.close();
        } catch (SQLException e) {
            throw new Exception("Erro ao encerrar conexão com o banco!");
        }
        conectado = false;
    }
    
    public ResultSet executeQuery(String query) throws Exception {
        Statement stmt;
        
        if (!conectado) {
            throw new Exception("Banco de dados desconectado!");
        }
        
        try {
            stmt = db.createStatement();
            ResultSet rset = stmt.executeQuery(query);
            return rset;
        } catch (SQLException ex) {
            throw new Exception("Erro ao executar Consulta!");
        }
    }
    
    public void insert(String tabela, Map<String,String> valores) 
            throws Exception {
        String ins = "INSERT INTO " + tabela + " ";
        String keys = "";
        String values = "";
        
        if (!conectado) {
            throw new Exception("Banco de dados desconectado!");
        }
        
        for (Map.Entry<String,String> e : valores.entrySet()) {
            keys += e.getKey() + ",";
            values += "'" + e.getValue() + "',";
        }
        
        ins += "(" + keys.substring(0, keys.length() - 1) + ") VALUES (";
        ins += values.substring(0, values.length() - 1) + ")";
        
        Statement stmt;
        
        System.out.println("INS: " + ins);
        
        try {
            stmt = db.createStatement();
            stmt.executeUpdate(ins);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            throw new Exception("Erro ao executar Insert!");
        }
    }
    
    public void update(String tabela, Map<String,String> valores, 
                       Map<String,String> where) throws Exception {
        String upd = "UPDATE " + tabela + " SET ";
        String val = "";
        String whe = "";
        
        if (!conectado) {
            throw new Exception("Banco de dados desconectado!");
        }        
        for (Map.Entry<String,String> e : valores.entrySet()) {
            val += e.getKey() + " = ";
            val += "'" + e.getValue() + "',";
        }
        
        upd += val.substring(0, val.length() - 1);
        
        for (Map.Entry<String,String> e: where.entrySet()) {
            whe += e.getKey() + " = ";
            whe += "'" + e.getValue() + "' AND ";
        }
        
        upd += " WHERE " + whe.substring(0, whe.length() - 4);
        
        Statement stmt;        
        System.out.println("UPD: " + upd);
        
        try {
            System.out.println("upd: " + upd);
            stmt = db.createStatement();
            stmt.executeUpdate(upd);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            throw new Exception("Erro ao executar Update!");
        }
    }
    
    public void delete(String tabela, Map<String,String> where) 
            throws Exception {
        String del = "DELETE FROM " + tabela + " WHERE ";
        String whe = "";
        
        if (!conectado) {
            throw new Exception("Banco de dados desconectado!");
        }
        
        for (Map.Entry<String,String> e: where.entrySet()) {
            whe += e.getKey() + " = ";
            whe += "'" + e.getValue() + "' AND ";
        }
        
        del += whe.substring(0, whe.length() - 4);
        
        Statement stmt;
        
        try {
            stmt = db.createStatement();
            stmt.executeUpdate(del);
        } catch (SQLException e) {
            throw new Exception("Erro ao executar Delete!");
        }
    }
}