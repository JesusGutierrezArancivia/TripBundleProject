package pe.edu.upc.tripbundle.dtos;

public class QuantityFloraBySeasonDTO {

    public String nameSeason;
    public int quantityFlora;

    public String getNameSeason() {
        return nameSeason;
    }

    public void setNameSeason(String nameSeason) {
        this.nameSeason = nameSeason;
    }

    public int getQuantityFlora() {
        return quantityFlora;
    }

    public void setQuantityFlora(int quantityFlora) {
        this.quantityFlora = quantityFlora;
    }
}
