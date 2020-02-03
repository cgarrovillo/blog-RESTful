package ca.rest;

/**
 * ******************************************** **
 * Main - main.Main
 *
 * @author Christian Garrovillo
 * Information and Communications Technologies
 * Software Development
 * * ********************************************* **
 */
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@ComponentScan({"ca.rest.dao", "ca.rest.domain"})
@SpringBootApplication
public class Main{

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }
}
