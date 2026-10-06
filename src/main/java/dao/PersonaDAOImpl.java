package dao;

import conexion.ConexionJPA;
import jakarta.persistence.EntityManager;
import modelo.persona;

import java.util.List;

public class PersonaDAOImpl implements personaDao {

    private EntityManager em;

    public PersonaDAOImpl() {
        em = ConexionJPA.crearEntityManager();
    }

    @Override
    public List<persona> listarPersonas() {

        String jpql = "SELECT p FROM persona p";

        return em.createQuery(jpql, persona.class)
                 .getResultList();
    }

    @Override
    public persona buscarPorId(int id) {

        return em.find(persona.class, id);
    }
}