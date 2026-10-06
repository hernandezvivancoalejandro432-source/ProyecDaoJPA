
package controlador;

import dao.PersonaDAOImpl;
import dao.personaDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import modelo.persona;

import java.io.IOException;
import java.util.List;

@WebServlet("/personas")
public class PersonaServlet extends HttpServlet {

    private personaDao personaDAO;

    @Override
    public void init() {
        personaDAO = new PersonaDAOImpl();
    }

    @Override
    protected void doGet(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        List<persona> personas = personaDAO.listarPersonas();

        request.setAttribute("personas", personas);

        request.getRequestDispatcher("personas.jsp")
               .forward(request, response);
    }
}