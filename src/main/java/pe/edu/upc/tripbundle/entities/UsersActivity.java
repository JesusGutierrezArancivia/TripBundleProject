package pe.edu.upc.tripbundle.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "UsersActivity")
public class UsersActivity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int idUsersActivity;

    @ManyToOne
    @JoinColumn(name = "idActivity")
    private Activity activity;

    @ManyToOne
    @JoinColumn(name = "idUsers")
    private Users users;

    public UsersActivity() {
    }

    public UsersActivity(int idUsersActivity, Activity activity, Users users) {
        this.idUsersActivity = idUsersActivity;
        this.activity = activity;
        this.users=users;
    }

    public int getIdUsersActivity() {
        return idUsersActivity;
    }

    public void setIdUsersActivity(int idUsersActivity) {
        this.idUsersActivity = idUsersActivity;
    }

    public Activity getActivity() {
        return activity;
    }

    public void setActivity(Activity activity) {
        this.activity = activity;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }
}
