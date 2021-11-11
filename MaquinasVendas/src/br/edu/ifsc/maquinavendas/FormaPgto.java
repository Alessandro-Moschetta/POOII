package br.edu.ifsc.maquinavendas;

import conexao.DBController;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FormaPgto {
    
    private Integer id;
    private String descr;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescr() {
        return descr;
    }

    public void setDescr(String descr) {
        this.descr = descr;
    }
    
    public void adicionar() throws Exception {
        DBController db = new DBController();
        Map<String,String> dados = new HashMap<>();
        
        dados.put("descr", descr);
        
        db.conectar();
        db.insert("FormaPgto", dados);
        db.desconectar();
    }
    
    public void atualizar() throws Exception {
        DBController db = new DBController();
        Map<String,String> dados = new HashMap<>();
        Map<String,String> where = new HashMap<>();
        
        dados.put("descr", descr);
        where.put("id", String.valueOf(id));
        
        db.conectar();
        db.update("FormaPgto", dados, where);
        db.desconectar();
    }
    
    public static List<FormaPgto> buscaFormasPgto() throws Exception {
        DBController db = new DBController();
        ResultSet rset;
        List<FormaPgto> formas = new ArrayList<>();
        
        
        db.conectar();
        rset = db.executeQuery("SELECT * FROM FormaPgto");
            
        try {
            while (rset.next()) {
                FormaPgto f = new FormaPgto();
                f.id = rset.getInt("id");
                f.descr = rset.getString("descr");

                formas.add(f);
            }
        } catch (SQLException ex) {
            throw new Exception("Erro ao percorrer resultados!");
        }
            
        db.desconectar();
                
        return formas;
    }
}