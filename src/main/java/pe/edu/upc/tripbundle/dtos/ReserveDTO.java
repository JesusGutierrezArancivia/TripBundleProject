package pe.edu.upc.tripbundle.dtos;

import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import pe.edu.upc.tripbundle.entities.Activity;
import pe.edu.upc.tripbundle.entities.City;

import java.time.LocalDate;
import java.time.LocalTime;

public class ReserveDTO {

    private int idReserve;
    private String descriptionReserve;
    private Activity activity;
    private City city;
    private LocalDate dateReserve;
    private LocalTime hourReserve;

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

    public LocalDate getDateReserve() {
        return dateReserve;
    }

    public void setDateReserve(LocalDate dateReserve) {
        this.dateReserve = dateReserve;
    }

    public LocalTime getHourReserve() {
        return hourReserve;
    }

    public void setHourReserve(LocalTime hourReserve) {
        this.hourReserve = hourReserve;
    }
}
