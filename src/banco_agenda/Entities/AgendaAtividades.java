package banco_agenda.Entities;

import java.sql.Date;

public class AgendaAtividades {
    private Date dataAtiv;
    private String horaAtiv;
    private String descricaoAtiv;
    private String duracaoAtiv;
    private String localAtiv;

    public AgendaAtividades(){
        
    }

    public AgendaAtividades(Date dataAtiv, String horaAtiv, String descricaoAtiv, String duracaoAtiv, String localAtiv) {
        this.dataAtiv = dataAtiv;
        this.horaAtiv = horaAtiv;
        this.descricaoAtiv = descricaoAtiv;
        this.duracaoAtiv = duracaoAtiv;
        this.localAtiv = localAtiv;
    }
    
    public Date getDataAtiv() {
        return dataAtiv;
    }
    public void setDataAtiv(Date dataAtiv) {
        this.dataAtiv = dataAtiv;
    }
    public String getHoraAtiv() {
        return horaAtiv;
    }
    public void setHoraAtiv(String horaAtiv) {
        this.horaAtiv = horaAtiv;
    }
    public String getDescricaoAtiv() {
        return descricaoAtiv;
    }
    public void setDescricaoAtiv(String descricaoAtiv) {
        this.descricaoAtiv = descricaoAtiv;
    }
    public String getDuracaoAtiv() {
        return duracaoAtiv;
    }
    public void setDuracaoAtiv(String duracaoAtiv) {
        this.duracaoAtiv = duracaoAtiv;
    }
    public String getLocalAtiv() {
        return localAtiv;
    }
    public void setLocalAtiv(String localAtiv) {
        this.localAtiv = localAtiv;
    }
}
