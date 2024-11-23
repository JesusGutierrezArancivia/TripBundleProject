package pe.edu.upc.tripbundle.serviceinterfaces;

import pe.edu.upc.tripbundle.entities.Fauna;

import java.util.List;

public interface IFaunaService {

    public List<Fauna> list();
    public Fauna insert(Fauna fauna);
    public void delete(int idFauna);
    public Fauna listId(int idFauna);
    public void update(Fauna fauna);
    public Fauna updateImage(int idFauna, byte[] image);
}
