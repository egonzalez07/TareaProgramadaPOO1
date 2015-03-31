/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.ParserConfigurationException;
import org.jespxml.JespXML;
import org.jespxml.excepciones.AtributoNotFoundException;
import org.jespxml.excepciones.TagHijoNotFoundException;
import org.jespxml.modelo.Tag;
import org.xml.sax.SAXException;
import java.io.FileNotFoundException;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import org.jespxml.modelo.Atributo;

/**
 *
 * @author alralaos
 */
public class XML {
    public XML(java.io.File archivoXML){        
    }
    XML() {}
    public void leerXML() throws TagHijoNotFoundException, AtributoNotFoundException{
        try {
            //Cargo el archivo
            JespXML archivo = new JespXML("info.xml");
            //leo el archivo y me retorna el tag raiz, que en este caso
            // es biblioteca
            Tag empresa = archivo.leerXML();
            //Obtengo los tags que necesito, por el nombre
            Tag nombre = empresa.getTagHijoByName("nombre");
            Tag cedula = empresa.getTagHijoByName("cedula");
            Tag consecutivo = empresa.getTagHijoByName("consecutivo");
            //puedo obtener los valores de los atributos de un tag especÃ­fico
            String paginas = empresa.getValorDeAtributo("paginas");
            //imprimo la informaciÃ³n requerida
            System.out.println("Nombre: "+nombre);
            System.out.println("cedula: "+cedula.getContenido());
            System.out.println("consecutivo: "+consecutivo.getContenido());
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(XML.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SAXException ex) {
            Logger.getLogger(XML.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(XML.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void escribirXML(String pNombre, String pCedula, String pConsecutivo){
        try {
            //creo el objeto JespXML con el archivo que quiero crear
            JespXML archivo = new JespXML("info.xml");
            //declaro el Tag raiz, que en esta caso se llama raiz
            Tag raiz = new Tag("raiz");
            //le agrego un atributo a ese Tag (clientes="3")
            raiz.addAtributo(new Atributo("empresa", "1"));
            //creo el Tag cliente, que va a tener un nombre y un apellido
            Tag empresa = new Tag("empresa");
            Tag nombre, cedula, consecutivo;
            //construyo los Tags nombre y apellido y le agrego contenido
            nombre = new Tag("nombre");
            cedula = new Tag("cedula");
            consecutivo = new Tag("consecutivo");
            nombre.addContenido(pNombre);
            cedula.addContenido(pCedula);
            consecutivo.addContenido(pConsecutivo);
            //agrego el Tag nombre y apellido al Tag cliente
            empresa.addTagHijo(nombre);
            empresa.addTagHijo(cedula);
            empresa.addTagHijo(consecutivo);
            //finalmente agrego al Tag raiz, el tag cliente
            raiz.addTagHijo(empresa);
            //y escribo el archivo XML
            archivo.escribirXML(raiz);
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(XML.class.getName()).log(Level.SEVERE, null, ex);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(XML.class.getName()).log(Level.SEVERE, null, ex);
        } catch (TransformerException ex) {
            Logger.getLogger(XML.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}