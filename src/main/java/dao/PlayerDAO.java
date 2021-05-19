package dao;

import model.Player;

import javax.sql.DataSource;
import java.util.List;

public interface PlayerDAO {

    public void setDataSource(DataSource ds);

    public void create(String firstname, String lastname);

    public Player getStudent(String firstname, String lastname);

    public List<Player> listStudents();

    public void delete(Integer id);

    public void update(Integer id);
}
