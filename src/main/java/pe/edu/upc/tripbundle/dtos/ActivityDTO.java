package pe.edu.upc.tripbundle.dtos;

import jakarta.persistence.Column;

public class ActivityDTO {

    private int idActivity;

    private double costActivity;

    private String nameActivity;

    private String descriptionActivity;

    public int getIdActivity() {
        return idActivity;
    }

    public void setIdActivity(int idActivity) {
        this.idActivity = idActivity;
    }

    public double getCostActivity() {
        return costActivity;
    }

    public void setCostActivity(double costActivity) {
        this.costActivity = costActivity;
    }

    public String getNameActivity() {
        return nameActivity;
    }

    public void setNameActivity(String nameActivity) {
        this.nameActivity = nameActivity;
    }

    public String getDescriptionActivity() {
        return descriptionActivity;
    }

    public void setDescriptionActivity(String descriptionActivity) {
        this.descriptionActivity = descriptionActivity;
    }
}
