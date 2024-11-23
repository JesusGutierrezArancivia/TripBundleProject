package pe.edu.upc.tripbundle.serviceinterfaces;

import pe.edu.upc.tripbundle.entities.City;

import java.util.List;

public interface ICityService {
    public List <City> list();
    public void insert(City city);
    public void update(City city);
    public void delete(int idCity);
    public City listId(int idCity);
    public List<String[]> cantidadFloraPorCiudad();
    public List<String[]> cantidadFaunaPorCiudad();

}
