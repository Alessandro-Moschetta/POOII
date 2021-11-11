package br.edu.ifsc.maquinavendas;

import conexao.DBController;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

public class Produto {
    
    private Integer id;
    private String descr;
    private Double preco;
    private String imagem;
    
    public Produto() {
    }

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

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }
    
    public void adicionar() throws Exception {
        DBController db = new DBController();
        Map<String,String> dados = new HashMap<>();
        
        dados.put("descr", descr);
        dados.put("preco", String.valueOf(preco));
        dados.put("imagem", imagem);
        
        db.conectar();
        db.insert("Produto", dados);
        db.desconectar();
    }
    
    public void atualizar() throws Exception {
        DBController db = new DBController();
        Map<String,String> dados = new HashMap<>();
        Map<String,String> where = new HashMap<>();
        
        dados.put("descr", descr);
        dados.put("preco", String.valueOf(preco));
        dados.put("imagem", imagem);
        where.put("id", String.valueOf(id));
        
        db.conectar();
        db.update("Produto", dados, where);
        db.desconectar();
    }
    
    public static List<Produto> buscaProdutos() throws Exception {
        DBController db = new DBController();
        ResultSet rset;
        List<Produto> prods = new ArrayList<>();
                
        db.conectar();
        rset = db.executeQuery("SELECT * FROM Produto");
            
        try {
            while (rset.next()) {
                Produto p = new Produto();
                p.id = rset.getInt("id");
                p.descr = rset.getString("descr");
                p.preco = rset.getDouble("preco");
                p.imagem = rset.getString("imagem");
                
                prods.add(p);
            }
        } catch (SQLException ex) {
            throw new Exception("Erro ao percorrer resultados!");
        }
            
        db.desconectar();
                
        return prods;
    }    
}