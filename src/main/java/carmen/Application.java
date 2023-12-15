package carmen;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Application {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("be-s3-p");

    public static void main(String[] args) {

    }
}
