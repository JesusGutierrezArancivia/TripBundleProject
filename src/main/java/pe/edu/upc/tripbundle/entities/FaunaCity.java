package pe.edu.upc.tripbundle.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "FaunaCity")
public class FaunaCity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int idFaunaCity;

    @ManyToOne
    @JoinColumn(name = "idFauna")
    private Fauna fauna;

    @ManyToOne
    @JoinColumn(name = "idCity")
    private City city;

    public FaunaCity() {
    }

    public FaunaCity(int idFaunaCity, Fauna fauna, City city) {
        this.idFaunaCity = idFaunaCity;
        this.fauna = fauna;
        this.city=city;
    }

    public int getIdFaunaCity() {
        return idFaunaCity;
    }

    public void setIdFaunaCity(int idFaunaCity) {
        this.idFaunaCity = idFaunaCity;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public Fauna getFauna() {
        return fauna;
    }

    public void setFauna(Fauna fauna) {
        this.fauna = fauna;
    }
}
