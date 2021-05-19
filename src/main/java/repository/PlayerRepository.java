package repository;

import model.Player;

import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PlayerRepository implements RowMapper<Player> {

    public Player mapRow(ResultSet rs, int rowNum) throws SQLException {
        Player player = new Player();
        player.setId(rs.getInt("id"));
        player.setFirstname(rs.getString("firstname"));
        player.setLastname(rs.getString("lastname"));

        return player;
    }

}