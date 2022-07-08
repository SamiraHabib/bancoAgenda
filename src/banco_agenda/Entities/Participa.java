package banco_agenda.Entities;

import java.sql.Date;
import java.sql.Time;

public class Participa {
    private Time horarioChegada;
    private int idPesFK;
    private Date dataAtivFK;
    private String horaAtivFk;

    public Participa(){
        
    }

    public Participa(Time horarioChegada, int idPesFK){
        this.horarioChegada = horarioChegada;
        this.idPesFK = idPesFK;
    }

    public Participa(Time horarioChegada, int idPesFK, Date dataAtivFK, String horaAtivFk) {
        this.horarioChegada = horarioChegada;
        this.idPesFK = idPesFK;
        this.dataAtivFK = dataAtivFK;
        this.horaAtivFk = horaAtivFk;
    }

    public Time getHorarioChegada() {
        return horarioChegada;
    }

    public void setHorarioChegada(Time horarioChegada) {
        this.horarioChegada = horarioChegada;
    }

    public int getIdPesFK() {
        return idPesFK;
    }

    public void setIdPesFK(int idPesFK) {
        this.idPesFK = idPesFK;
    }

    public Date getDataAtivFK() {
        return dataAtivFK;
    }

    public void setDataAtivFK(Date dataAtivFK) {
        this.dataAtivFK = dataAtivFK;
    }

    public String getHoraAtivFk() {
        return horaAtivFk;
    }

    public void setHoraAtivFk(String horaAtivFk) {
        this.horaAtivFk = horaAtivFk;
    }
}
