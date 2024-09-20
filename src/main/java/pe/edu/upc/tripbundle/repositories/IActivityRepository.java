package pe.edu.upc.tripbundle.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pe.edu.upc.tripbundle.entities.Activity;

import java.util.List;

@Repository
public interface IActivityRepository extends JpaRepository<Activity,Integer> {

    @Query(value = " select rs.description_reserve, count(*)\n" +
            " from reserve rs\n" +
            " inner join activity ac ON rs.id_activity = ac.id_activity\n" +
            " GROUP BY rs.description_reserve",nativeQuery = true)
    public List<String[]> cantidadactividades();
}
