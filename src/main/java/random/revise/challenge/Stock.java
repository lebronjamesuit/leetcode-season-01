package random.revise.challenge;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;


@Entity
public class Stock {

    @Id
    @GeneratedValue
    private Integer id;

    @Column(name = "company_name")
    private String companyName;

    @Column(nullable = false)
    private Integer price;

    public int getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public static void main(String[] args) {
        LogManager logManager = LogManager.getLogManager();
        Logger logger = logManager.getLogger("");
        logger.setLevel(Level.OFF);

        Properties prop = new Properties();

        prop.setProperty("hibernate.connection.url", "jdbc:h2:mem:db1");
        prop.setProperty("dialect", "org.hibernate.dialect.H2Dialect");
        prop.setProperty("hibernate.hbm2ddl.auto", "create");

        SessionFactory sessionFactory = new Configuration().addProperties(prop)
                .addAnnotatedClass(Stock.class).buildSessionFactory();

        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Stock stock = new Stock();
        stock.setCompanyName("Big company");
        stock.setPrice(1000);

        session.save(stock);
        session.flush();
        Query<Stock> query = session.createQuery("FROM Stock", Stock.class);
        List<Stock> stocks = query.list();
        for(Stock st : stocks) {
            System.out.println(st.getId());
            System.out.println(st.getCompanyName());
            System.out.println(st.getPrice());
        }
    }
}