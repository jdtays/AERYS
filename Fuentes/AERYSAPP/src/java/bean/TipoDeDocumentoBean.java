/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import dao.TipoDeDocumentoDAO;
import domain.TipoDeDocumento;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.Dependent;

/**
 *
 * @author josed
 */
@Named(value = "tipoDeDocumentoBean")
@Dependent
public class TipoDeDocumentoBean {

     private TipoDeDocumento tipoDeDocumento;

    private TipoDeDocumentoDAO tipoDeDocumentoDAO = new TipoDeDocumentoDAO();
    
    public TipoDeDocumentoBean() {
    }
    
     public List<TipoDeDocumento> getTipoDeDocumentos() {
        return tipoDeDocumentoDAO.obtenerTodos();
    }
}
