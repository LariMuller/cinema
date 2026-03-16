package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Ator;
import model.Filme;

public class AtorDAO implements IAtorDAO {

    EntityManagerFactory mf = Persistence.createEntityManagerFactory("HibJPA");

    public Ator pesquisar(String ator) {
        return null;
    }

    public void inserir(Ator ator) {
        EntityManager em = mf.createEntityManager();
        em.getTransaction().begin();
        em.persist(ator);
        em.getTransaction().commit();
        em.close();
    }

    public void remover(long id) {
        EntityManager em = mf.createEntityManager();
        em.getTransaction().begin();
        Ator ator = em.find(Ator.class, id);
        if (ator != null) {
            em.remove(ator);
        }
        em.getTransaction().commit();
        em.close();
    }

    public List<Ator> lista() {
        EntityManager em = mf.createEntityManager();
        List<Ator> atores = em.createQuery("select a from Ator a", Ator.class).getResultList();
        em.close();
        return atores;
    }

    public void atualizar(Ator ator) {
        EntityManager em = mf.createEntityManager();
        em.getTransaction().begin();
        em.merge(ator);
        em.getTransaction().commit();
        em.close();
    }

    public List<Ator> apenasUmAtor(String nome) {
        EntityManager em = mf.createEntityManager();
        List<Ator> atores = em.createQuery("SELECT a FROM Ator a WHERE a.nome like :nome", Ator.class)
                .setParameter("nome", "%" + nome + "%")
                .getResultList();
        em.close();
        return atores;
    }

    public void conectarFilme(Ator ator, long idF) {
        EntityManager em = mf.createEntityManager();
        Filme filme = em.find(Filme.class, idF);

        if (filme != null) {
            em.getTransaction().begin();
            ator.setFilme(filme);
            em.merge(ator);
            em.getTransaction().commit();
        } else {
            System.out.println("Filme não encontrado.");
        }
        em.close();
    }
}
