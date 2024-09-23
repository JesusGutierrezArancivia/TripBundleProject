package pe.edu.upc.tripbundle.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pe.edu.upc.tripbundle.entities.Season;

import java.util.List;

@Repository
public interface ISeasonRepository extends JpaRepository<Season,Integer> {
    @Query(value ="Select s.name_season, count(*) " +
            " from season s inner join flora_season fs on s.id_season=fs.id_season inner join flora f on fs.id_flora=f.id_flora" +
            " group by s.name_season"  ,nativeQuery = true)
    public List<String[]> cantidadFloraPorEstacion();

    @Query(value ="Select s.name_season, count(*) " +
            " from season s inner join fauna_season fs on s.id_season=fs.id_season inner join fauna f on fs.id_fauna=f.id_fauna" +
            " group by s.name_season"  ,nativeQuery = true)
    public List<String[]> cantidadFaunaPorEstacion();
}
