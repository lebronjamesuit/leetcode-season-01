package random.revise.challenge;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class PetDAO {

    public static void main(String[] args) {
        LogManager logManager = LogManager.getLogManager();
        Logger logger = logManager.getLogger("");
        logger.setLevel(Level.OFF);

        Properties prop = new Properties();
        prop.setProperty("hibernate.connection.url", "jdbc:h2:mem:db1");
        prop.setProperty("dialect", "org.hibernate.dialect.H2Dialect");
        prop.setProperty("hibernate.hbm2ddl.auto", "create");

        SessionFactory sessionFactory = new Configuration().addProperties(prop)
                .addAnnotatedClass(Pet.class).buildSessionFactory();

        Session session = sessionFactory.openSession();
        session.beginTransaction();

        Pet dog = new Pet(0, "Lady", "Dog");
        Pet cat = new Pet(1, "Max", "Cat");
        Pet camel = new Pet(2, null, "Camel");

        session.save(dog);
        session.save(cat);
        session.save(camel);
        session.flush();

        PetDAO petDao = new PetDAO();
        List<Pet> pets = petDao.findNamedPetsBySpecies(session, "Cat");
        for (Pet p : pets) {
            System.out.println(p.id);
            System.out.println(p.name);
            System.out.println(p.species);
        }
    }

    public List<Pet> findNamedPetsBySpecies(Session session, String species) {
        StringBuilder builder = new StringBuilder();
        builder.append(" select * from Pet P where P.species = :param1");
        String hql = builder.toString();
        List<Pet> pets = session.createQuery(hql, Pet.class).setParameter("param1", species).stream().toList();
        return pets.stream().filter(pet -> pet.name != null).collect(Collectors.toList());
    }

    @Entity(name = "Pet")
    @Table
    public static class Pet {
        @Id
        public Integer id;
        @Column
        public String name;
        @Column
        public String species;

        public Pet() {
        }

        public Pet(Integer id, String name, String species) {
            this.id = id;
            this.name = name;
            this.species = species;
        }
    }
}