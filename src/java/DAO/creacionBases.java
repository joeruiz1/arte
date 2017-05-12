
import DAO.conexion;
import DAO.usuarioDao;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Labing
 */
public class creacionBases {

    /**
     *
     * @author Fabian Giraldo
     */
    public static void run() {
        String sql = "create table usuario"
                + "user varchar(20)not null "
                + "nombre varchar (15)not null ,primary key(nombre)";
        Connection connection = null;
        try {
            connection = conexion.getConnection();
            Statement stmt = connection.createStatement();
            stmt.executeUpdate(sql);

        } catch (URISyntaxException ex) {
            Logger.getLogger(usuarioDao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(creacionBases.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
