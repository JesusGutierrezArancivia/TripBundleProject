package pe.edu.upc.tripbundle.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pe.edu.upc.tripbundle.entities.City;

import java.util.List;

@Repository

public interface ICityRepository extends JpaRepository <City,Integer> {
    @Query(value ="Select c.name_city, count(*) " +
            " from city c inner join flora_city fc on c.id_city=fc.id_city inner join flora f on fc.id_flora=f.id_flora" +
            " group by c.name_city"  ,nativeQuery = true)
    public List<String[]> cantidadFloraPorCiudad();

    @Query(value ="Select c.name_city, count(*) " +
            " from city c inner join fauna_city fc on c.id_city=fc.id_city inner join fauna f on fc.id_fauna=f.id_fauna" +
            " group by c.name_city"  ,nativeQuery = true)
    public List<String[]> cantidadFaunaPorCiudad();
}
