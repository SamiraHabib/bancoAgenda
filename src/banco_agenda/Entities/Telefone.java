package banco_agenda.Entities;

public class Telefone {
    private int idTel;
    private String numeroTel;
    private String tipoTel;
    private int idPesFK;

    public Telefone(){
        
    }

    public Telefone(String numeroTel, String tipoTel, int idPesFK) {
        this.numeroTel = numeroTel;
        this.tipoTel = tipoTel;
        this.idPesFK = idPesFK;
    }

    public Telefone(int idTel, String numeroTel, String tipoTel, int idPesFK) {
        this.idTel = idTel;
        this.numeroTel = numeroTel;
        this.tipoTel = tipoTel;
        this.idPesFK = idPesFK;
    }
    
    public int getIdPesFK() {
        return idPesFK;
    }
    public void setIdPesFK(int idPesFK) {
        this.idPesFK = idPesFK;
    }
    public int getIdTel() {
        return idTel;
    }
    public void setIdTel(int idTel) {
        this.idTel = idTel;
    }
    public String getNumeroTel() {
        return numeroTel;
    }
    public void setNumeroTel(String numeroTel) {
        this.numeroTel = numeroTel;
    }
    public String getTipoTel() {
        return tipoTel;
    }
    public void setTipoTel(String tipoTel) {
        this.tipoTel = tipoTel;
    }
}
