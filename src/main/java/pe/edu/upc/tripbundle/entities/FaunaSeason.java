package pe.edu.upc.tripbundle.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "FaunaSeason")
public class FaunaSeason {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int idFaunaSeason;

    @ManyToOne
    @JoinColumn(name = "idFauna")
    private Fauna fauna;

    @ManyToOne
    @JoinColumn(name = "idSeason")
    private Season season;

    public FaunaSeason() {
    }

    public FaunaSeason(int idFaunaSeason, Fauna fauna, Season season) {
        this.idFaunaSeason = idFaunaSeason;
        this.fauna = fauna;
        this.season=season;
    }

    public int getIdFaunaSeason() {
        return idFaunaSeason;
    }

    public void setIdFaunaSeason(int idFaunaSeason) {
        this.idFaunaSeason = idFaunaSeason;
    }

    public Season getSeason() {
        return season;
    }

    public void setSeason(Season season) {
        this.season = season;
    }

    public Fauna getFauna() {
        return fauna;
    }

    public void setFauna(Fauna fauna) {
        this.fauna = fauna;
    }
}
