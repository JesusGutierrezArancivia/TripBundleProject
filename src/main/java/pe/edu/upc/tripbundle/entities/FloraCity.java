package pe.edu.upc.tripbundle.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "FloraCity")
public class FloraCity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int idFloraCity;

    @ManyToOne
    @JoinColumn(name = "idFlora")
    private Flora flora;

    @ManyToOne
    @JoinColumn(name = "idCity")
    private City city;

    public FloraCity() {
    }

    public FloraCity(int idFloraCity, Flora flora, City city) {
        this.idFloraCity = idFloraCity;
        this.flora = flora;
        this.city=city;
    }

    public int getIdFloraCity() {
        return idFloraCity;
    }

    public void setIdFloraCity(int idFloraCity) {
        this.idFloraCity = idFloraCity;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public Flora getFlora() {
        return flora;
    }

    public void setFlora(Flora flora) {
        this.flora = flora;
    }
}
