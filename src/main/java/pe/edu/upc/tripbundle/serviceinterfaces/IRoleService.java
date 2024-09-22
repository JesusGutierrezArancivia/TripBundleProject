package pe.edu.upc.tripbundle.serviceinterfaces;

import pe.edu.upc.tripbundle.entities.Role;

import java.util.List;

public interface IRoleService {

    public List<Role> list();

    public void insert(Role rol);

    public void update(Role rol);

    public void delete(Long id);

    public Role listarId(Long idRol);
}
