
package prueba;
import dao.personaDao; 
import dao.PersonaDAOImpl; 
import modelo.persona; 
import java.util.List;

public class personaDAOTest {
    public static void main(String[] args) {
        personaDao dao = new PersonaDAOImpl();
        List<persona> personas = dao.listarPersonas();
        System.out.println("===== LISTA DE PERSONAS ====="); 
        for (persona persona : personas) { 
            System.out.println(persona); 
        }
    }
}