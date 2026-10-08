package conexion;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.HashMap;
import java.util.Map;

public class ConexionJPA {

    private static EntityManagerFactory emf;

    private ConexionJPA() {
    }

    private static synchronized EntityManagerFactory getEntityManagerFactory() {
        if (emf == null || !emf.isOpen()) {
            emf = crearEntityManagerFactory();
        }
        return emf;
    }

    private static String env(String nombre, String porDefecto) {
        String valor = System.getenv(nombre);
        return (valor == null || valor.isBlank()) ? porDefecto : valor;
    }

    private static EntityManagerFactory crearEntityManagerFactory() {

        String host = env("DB_HOST", "localhost");
        String puerto = env("DB_PORT", "3306");
        String usuario = env("DB_USER", "root");
        String baseDatos = env("DB_NAME", "sistema_personas");
        String password = System.getenv("DB_PASSWORD");
        if (password == null) {
            password = "";
        }

        // SSL solo cuando no es local (Azure MySQL lo exige, XAMPP no lo tiene)
        boolean esLocal = host.equals("localhost") || host.equals("127.0.0.1");
        String ssl = esLocal ? "DISABLED" : "REQUIRED";

        String url = "jdbc:mysql://" + host + ":" + puerto + "/" + baseDatos
                + "?sslMode=" + ssl + "&serverTimezone=UTC";

        Map<String, Object> propiedades = new HashMap<>();
        propiedades.put("jakarta.persistence.jdbc.driver", "com.mysql.cj.jdbc.Driver");
        propiedades.put("jakarta.persistence.jdbc.url", url);
        propiedades.put("jakarta.persistence.jdbc.user", usuario);
        propiedades.put("jakarta.persistence.jdbc.password", password);

        return Persistence.createEntityManagerFactory("PersonaPU", propiedades);
    }

    public static EntityManager crearEntityManager() {
        return getEntityManagerFactory().createEntityManager();
    }
}