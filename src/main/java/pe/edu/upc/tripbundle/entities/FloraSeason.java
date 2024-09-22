package pe.edu.upc.tripbundle.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "FloraSeason")
public class FloraSeason {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int idFloraSeason;

    @ManyToOne
    @JoinColumn(name = "idFlora")
    private Flora flora;

    @ManyToOne
    @JoinColumn(name = "idSeason")
    private Season season;

    public FloraSeason() {
    }

    public FloraSeason(int idFloraSeason, Flora flora, Season season) {
        this.idFloraSeason = idFloraSeason;
        this.flora = flora;
        this.season=season;
    }

    public int getIdFloraSeason() {
        return idFloraSeason;
    }

    public void setIdFloraSeason(int idFloraSeason) {
        this.idFloraSeason = idFloraSeason;
    }

    public Season getSeason() {
        return season;
    }

    public void setSeason(Season season) {
        this.season = season;
    }

    public Flora getFlora() {
        return flora;
    }

    public void setFlora(Flora flora) {
        this.flora = flora;
    }
}
