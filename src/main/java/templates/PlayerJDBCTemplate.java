package templates;

import java.util.List;
import javax.sql.DataSource;

import dao.PlayerDAO;
import model.Player;
import org.springframework.jdbc.core.JdbcTemplate;
import repository.PlayerRepository;

public class PlayerJDBCTemplate implements PlayerDAO {
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplateObject;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplateObject = new JdbcTemplate(dataSource);
    }
    public void create(String firstname, String lastname) {
        String SQL = "insert into player (firstname, lastname) values (?, ?)";
        jdbcTemplateObject.update( SQL, firstname, lastname);
        System.out.println("First Name = " + firstname + " Lastname = " + lastname);
        return;
    }

    @Override
    public Player getPlayer(String firstname, String lastname) {
        return null;
    }

    @Override
    public List<Player> listStudents() {
        return null;
    }

    public List<Player> listPlayers() {
        return null;
    }

    public Player getPlayer(Integer id) {
        String SQL = "select * from player where id = ?";
        Player student = jdbcTemplateObject.queryForObject(SQL,
                new Object[]{id}, new PlayerRepository());

        return student;
    }
    public List<Player> listPlayer() {
        String SQL = "select * from player";
        List <Player> players = jdbcTemplateObject.query(SQL, new PlayerRepository());
        return players;
    }
    public void delete(Integer id) {
        String SQL = "delete from player where id = ?";
        jdbcTemplateObject.update(SQL, id);
        System.out.println("Deleted Record with ID = " + id );
        return;
    }

    @Override
    public void update(Integer id) {

    }

    public void update(Integer id, String firstname){
        String SQL = "update player set firstname = ? where id = ?";
        jdbcTemplateObject.update(SQL, firstname, id);
        System.out.println("Updated Record with ID = " + id );
        return;
    }
}
