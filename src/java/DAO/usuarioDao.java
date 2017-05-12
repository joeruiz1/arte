package DAO;

import Modelo.Artista;
import Modelo.Usuario;
import Modelo.obra_Arte;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.net.URISyntaxException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class usuarioDao {
    /**
     * Funcion que permite obtener una lista de los departamentos existentes en
     * la base de datos
     *
     * @return List<Departamento> Retorna la lista de Departamentos existentes
     * en la base de datos
     */
    public List<Usuario> findAll() {
        List<Usuario> usuario = null;
        String query = "SELECT * FROM usuario";
        Connection connection = null;
        try {
            connection = conexion.getConnection();
        } catch (URISyntaxException ex) {
            Logger.getLogger(usuarioDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(query);
            String user = null;
            String nombre = null;

            while (rs.next()) {
                if (usuario == null) {
                    usuario = new ArrayList<Usuario>();
                }

                Usuario registro = new Usuario();
                user = rs.getString("user");
                registro.setUser(user);

                nombre = rs.getString("nombre");
                registro.setName(nombre);

                usuario.add(registro);
            }
            st.close();

        } catch (SQLException e) {
            System.out.println("Problemas al obtener la lista de usuarios");
            e.printStackTrace();
        }

        return usuario;
    }

    /**
     * Funcion que permite realizar la insercion de un nuevo registro en la
     * tabla Departamento
     *
     * @param Departamento recibe un objeto de tipo Departamento
     * @return boolean retorna true si la operacion de insercion es exitosa.
     */
    public boolean insert(Usuario t) {
        boolean result = false;
        Connection connection = null;
        try {
            connection = conexion.getConnection();
        } catch (URISyntaxException ex) {
            Logger.getLogger(usuarioDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        String query = " insert into usuario (user,nombre)" + " values (?,?)";
        PreparedStatement preparedStmt = null;
        try {
            preparedStmt = connection.prepareStatement(query);
            preparedStmt.setString(1, t.getUser());
            preparedStmt.setString(2, t.getName());
            result = preparedStmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * Funcion que permite realizar la actualizacion de un nuevo registro en la
     * tabla Usuario
     *
     * @param Departamento recibe un objeto de tipo Departamento
     * @return boolean retorna true si la operacion de actualizacion es exitosa.
     */
    public boolean update(Usuario t) {
        boolean result = false;
        Connection connection = null;
        try {
            connection = conexion.getConnection();
        } catch (URISyntaxException ex) {
            Logger.getLogger(usuarioDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        String query = "update usuario set user = ? where=nombre ?";
        PreparedStatement preparedStmt = null;
        try {
            preparedStmt = connection.prepareStatement(query);
            preparedStmt.setString(1, t.getUser());
            preparedStmt.setString(2, t.getName());
            if (preparedStmt.executeUpdate() > 0) {
                result = true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }

    /**
     * Funcion que permite realizar la eliminario de registro en la tabla
     * Departamento
     *
     * @param Departamento recibe un objeto de tipo Departamento
     * @return boolean retorna true si la operacion de borrado es exitosa.
     */
    public boolean delete(Usuario t) {
        boolean result = false;
        Connection connection = null;
        try {
            connection = conexion.getConnection();
        } catch (URISyntaxException ex) {
            Logger.getLogger(usuarioDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        String query = "delete from usuario where user = ?";
        PreparedStatement preparedStmt = null;
        try {
            preparedStmt = connection.prepareStatement(query);
            preparedStmt.setString(1, t.getUser());
            result = preparedStmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }

    public List<obra_Arte> recursos() {
        List<obra_Arte> proyectos = null;

        String query = "select nom_proy,Count(id_rec) as total from Proyecto left join Recurso using (id_proyecto) group by nom_proy;";
        Connection connection = null;
        obra_Arte d = null;
        try {
            connection = conexion.getConnection();
        } catch (URISyntaxException ex) {
            Logger.getLogger(usuarioDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(query);

            double valor = 0;
            String nombre_pro = null;
            d = new obra_Arte();
            while (rs.next()) {
                if (proyectos == null) {
                    proyectos = new ArrayList<obra_Arte>();
                }

                nombre_pro = rs.getString("nombre");
                d.setNombre(nombre_pro);

                valor = rs.getDouble("total");
                d.setValor(valor);

                proyectos.add(d);
            }
            st.close();

        } catch (SQLException e) {
            System.out.println("Problemas al obtener la lista de proyectos");
            e.printStackTrace();
        }
        return proyectos;
    }

}

