package pe.edu.upc.tripbundle.serviceimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.tripbundle.entities.Fauna;
import pe.edu.upc.tripbundle.repositories.IFaunaRepository;
import pe.edu.upc.tripbundle.serviceinterfaces.IFaunaService;

import java.util.List;
@Service
public class FaunaServiceImplement implements IFaunaService {
    @Autowired
    private IFaunaRepository fR;

    @Override
    public List<Fauna> list() {
        return fR.findAll();
    }

    @Override
    public Fauna insert(Fauna fauna) {
        return fR.save(fauna);
    }

    @Override
    public void delete(int idFauna) {
        fR.deleteById(idFauna);
    }

    @Override
    public Fauna listId(int idFauna) {
        return fR.findById(idFauna).orElse(new Fauna());
    }

    @Override
    public void update(Fauna fauna) {
        fR.save(fauna);
    }

    @Override
    public Fauna updateImage(int idFauna, byte[] image) {
        Fauna fauna = listId(idFauna);
        fauna.setImageFauna(image);
        return fR.save(fauna);
    }
}
