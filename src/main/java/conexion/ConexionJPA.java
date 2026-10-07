package conexion;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.HashMap;
import java.util.Map;

public class ConexionJPA {

    private static final EntityManagerFactory emf = crearEntityManagerFactory();

    private static EntityManagerFactory crearEntityManagerFactory() {

        Map<String, Object> propiedades = new HashMap<>();

        String host = System.getenv("DB_HOST");
        String puerto = System.getenv("DB_PORT");
        String usuario = System.getenv("DB_USER");
        String password = System.getenv("DB_PASSWORD");
        String baseDatos = System.getenv("DB_NAME");

        // Si no existen variables de entorno,
        // usamos la configuración local de XAMPP.
        if (host == null || host.isBlank()) {
            host = "localhost";
        }

        if (puerto == null || puerto.isBlank()) {
            puerto = "3306";
        }

        if (usuario == null || usuario.isBlank()) {
            usuario = "root";
        }

        if (password == null) {
            password = "";
        }

        if (baseDatos == null || baseDatos.isBlank()) {
            baseDatos = "sistema_personas";
        }

        String url = "jdbc:mysql://" + host + ":" + puerto + "/" + baseDatos;

        propiedades.put(
                "jakarta.persistence.jdbc.driver",
                "com.mysql.cj.jdbc.Driver"
        );

        propiedades.put(
                "jakarta.persistence.jdbc.url",
                url
        );

        propiedades.put(
                "jakarta.persistence.jdbc.user",
                usuario
        );

        propiedades.put(
                "jakarta.persistence.jdbc.password",
                password
        );

        propiedades.put(
                "hibernate.dialect",
                "org.hibernate.dialect.MySQLDialect"
        );

        return Persistence.createEntityManagerFactory(
                "PersonaPU",
                propiedades
        );
    }

    public static EntityManager crearEntityManager() {
        return emf.createEntityManager();
    }
}