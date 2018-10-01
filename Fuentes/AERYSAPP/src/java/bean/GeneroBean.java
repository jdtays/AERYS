/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import dao.GeneroDAO;
import dao.TipoDeDocumentoDAO;
import domain.Genero;
import domain.TipoDeDocumento;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.Dependent;

/**
 *
 * @author josed
 */
@Named(value = "generoBean")
@Dependent
public class GeneroBean {

    private Genero genero;

    private GeneroDAO generoDAO = new GeneroDAO();

    public GeneroBean() {
    }

    public List<Genero> getGeneros() {
        return generoDAO.obtenerTodos();
    }
}
