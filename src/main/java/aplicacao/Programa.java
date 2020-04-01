package aplicacao;

import dominio.Pessoa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Programa {
    public static void main(String[] args) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("exemplo-jpa");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        Pessoa p = entityManager.find(Pessoa.class,2);

        entityManager.getTransaction().begin();

        entityManager.remove(p);

        entityManager.getTransaction().commit();
        System.out.println("Pronto!");
        entityManager.close();
        entityManagerFactory.close();
    }
}
