package pe.edu.upc.tripbundle.serviceinterfaces;


import pe.edu.upc.tripbundle.entities.Flora;

import java.util.List;

public interface IFloraService {
    public List<Flora> list();
    public void insert(Flora flora);
    public void delete(int idFlora);
    public Flora listId(int idFlora);
    public void update(Flora flora);
}
