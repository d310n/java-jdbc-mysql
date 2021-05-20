package org.example;

import java.util.List;

import org.example.model.Player;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.example.templates.PlayerJDBCTemplate;

public class PlayerMain {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");

        PlayerJDBCTemplate playerJDBCTemplate = (PlayerJDBCTemplate)context.getBean("playerJDBCTemplate");

        System.out.println("------Records Creation--------" );
        playerJDBCTemplate.create("Luka", "Doncic");
        playerJDBCTemplate.create("Kristaps", "Porzingis");
        playerJDBCTemplate.create("Tim", "Hardaway");

        System.out.println("------Listing Multiple Records--------" );
        List<Player> players = playerJDBCTemplate.listPlayers();

        for (Player record : players) {
            System.out.print("ID : " + record.getId() );
            System.out.print(", Firstname : " + record.getFirstname() );
            System.out.println(", Lastname : " + record.getLastname());
        }

        System.out.println("----Updating Record with ID = 2 -----" );
        playerJDBCTemplate.update(3, "Chicago");

        System.out.println("----Listing Record with ID = 2 -----" );
        Player player = playerJDBCTemplate.getPlayer(2);
        System.out.print("ID : " + player.getId() );
        System.out.print(", Firstname : " + player.getFirstname() );
        System.out.println(", Lastname : " + player.getLastname());
    }
}