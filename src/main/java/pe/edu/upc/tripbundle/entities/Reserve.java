package pe.edu.upc.tripbundle.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "Reserve")
public class Reserve {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private int idReserve;

    @Column(name = "descriptionReserve",nullable = false,length = 70)
    private String descriptionReserve;

    @ManyToOne
    @JoinColumn(name = "idActivity")
    private Activity activity;

    @ManyToOne
    @JoinColumn(name = "idCity")
    private City city;

    @Column(name = "dateReserve",nullable = false)
    private LocalDate dateReserve;

    @Column(name = "hourReserve",nullable = false)
    private LocalTime hourReserve;

    public Reserve() {
    }

    public Activity getActivity() {
        return activity;
    }

    public void setActivity(Activity activity) {
        this.activity = activity;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public LocalTime getHourReserve() {
        return hourReserve;
    }

    public void setHourReserve(LocalTime hourReserve) {
        this.hourReserve = hourReserve;
    }

    public Reserve(int idReserve, String descriptionReserve, Activity activity, City city, LocalDate dateReserve, LocalTime hourReserve) {
        this.idReserve = idReserve;
        this.descriptionReserve = descriptionReserve;
        this.activity = activity;
        this.city = city;
        this.dateReserve = dateReserve;
        this.hourReserve = hourReserve;
    }

    public int getIdReserve() {
        return idReserve;
    }

    public void setIdReserve(int idReserve) {
        this.idReserve = idReserve;
    }

    public String getDescriptionReserve() {
        return descriptionReserve;
    }

    public void setDescriptionReserve(String descriptionReserve) {
        this.descriptionReserve = descriptionReserve;
    }

    public LocalDate getDateReserve() {
        return dateReserve;
    }

    public void setDateReserve(LocalDate dateReserve) {
        this.dateReserve = dateReserve;
    }
}
