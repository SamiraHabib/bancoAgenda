package banco_agenda.Entities;

import java.sql.Date;

public class Pessoa {
    private int idPes;
    private String nomePes;
    private Date DataNascPes;
    private String cidadePes;
    private String ruaPes;
    private int numeroPes;

    public Pessoa(){

    }

    public Pessoa(String nomePes, Date dataNascPes, String cidadePes, String ruaPes, int numeroPes) {
        this.nomePes = nomePes;
        DataNascPes = dataNascPes;
        this.cidadePes = cidadePes;
        this.ruaPes = ruaPes;
        this.numeroPes = numeroPes;
    } 

    public Pessoa(int idPes, String nomePes, Date dataNascPes, String cidadePes, String ruaPes, int numeroPes) {
        this.idPes = idPes;
        this.nomePes = nomePes;
        DataNascPes = dataNascPes;
        this.cidadePes = cidadePes;
        this.ruaPes = ruaPes;
        this.numeroPes = numeroPes;
    } 
    
    public int getIdPes() {
        return idPes;
    }
    public void setIdPes(int idPes) {
        this.idPes = idPes;
    }
    public String getNomePes() {
        return nomePes;
    }  
    public void setNomePes(String nomePes) {
        this.nomePes = nomePes;
    }
    public Date getDataNascPes() {
        return DataNascPes;
    }
    public void setDataNascPes(Date DataNascPes) {
        this.DataNascPes = DataNascPes;
    }
    public String getCidadePes() {
        return cidadePes;
    }
    public void setCidadePes(String cidadePes) {
        this.cidadePes = cidadePes;
    }
    public String getRuaPes() {
        return ruaPes;
    }
    public void setRuaPes(String ruaPes) {
        this.ruaPes = ruaPes;
    }
    public int getNumeroPes() {
        return numeroPes;
    }
    public void setNumeroPes(int numeroPes) {
        this.numeroPes = numeroPes;
    }
}

