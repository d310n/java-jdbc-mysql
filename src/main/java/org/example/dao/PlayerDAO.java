package org.example.dao;

import org.example.model.Player;

import javax.sql.DataSource;
import java.util.List;

public interface PlayerDAO {

    public void setDataSource(DataSource ds);

    public void create(String firstname, String lastname);

    public Player getPlayer(String firstname, String lastname);

    public List<Player> listPlayers();

    public void delete(Integer id);
    public void update(Integer id, String firstname);
}
