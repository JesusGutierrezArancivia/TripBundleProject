package pe.edu.upc.tripbundle.repositories;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.upc.tripbundle.entities.Users;

import java.util.List;

@Repository
public interface IUsersRepository extends JpaRepository<Users, Long> {
    public Users findByUsername(String username);
    public Users findOneByUsername(String username);

    @Query("select count(u.username) from Users u where u.username =:username")
    public int buscarUsername(@Param("username") String username);

    @Transactional
    @Modifying
    @Query(value = "insert into roles (rol, user_id) VALUES (:rol, :user_id)", nativeQuery = true)
    public void insertarRoles(@Param("rol") String rol, @Param("user_id") int userId);

    @Query(value ="Select u.name_users, count(*) " +
            " from users u inner join users_activity ua on u.id_users=ua.id_users inner join activity a on ua.id_activity=a.id_activity" +
            " group by u.name_users"  ,nativeQuery = true)
    public List<String[]> cantidadActividadesPorUsuario();

}
