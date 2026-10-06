package dao;

import modelo.persona;
import java.util.List;

public interface personaDao {

    List<persona> listarPersonas();

    persona buscarPorId(int id);
}