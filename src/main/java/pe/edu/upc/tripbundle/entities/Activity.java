package pe.edu.upc.tripbundle.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "Activity")
public class Activity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private int idActivity;

    @Column(name = "nameActivity",nullable = false,length = 70)
    private String nameActivity;

    @Column(name = "descriptionActivity",nullable = false,length = 70)
    private String descriptionActivity;

    @Column(name="costActivity",nullable=false)
    private double costActivity;

    public Activity() {
    }

    public Activity(int idActivity, String nameActivity, String descriptionActivity,double costActivity) {
        this.idActivity = idActivity;
        this.nameActivity = nameActivity;
        this.descriptionActivity = descriptionActivity;
        this.costActivity=costActivity;

    }

    public int getIdActivity() {
        return idActivity;
    }

    public void setIdActivity(int idActivity) {
        this.idActivity = idActivity;
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

    public int getCostActivity() {
        return idActivity;
    }

    public void setCostActivity(double costActivity) {
        this.costActivity = Activity.this.costActivity;
    }
}
