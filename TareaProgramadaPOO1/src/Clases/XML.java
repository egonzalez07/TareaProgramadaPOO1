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
    public String leerNombre(){
        String pNombre="";
        try {
            JespXML archivo = new JespXML("info.xml");
            Tag raiz = archivo.leerXML();
            Tag nombre = raiz.getTagHijoByName("empresa").getTagHijoByName("nombre");
            pNombre=nombre.getContenido();
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(XML.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SAXException ex) {
            Logger.getLogger(XML.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(XML.class.getName()).log(Level.SEVERE, null, ex);
        } catch (TagHijoNotFoundException ex) {
            Logger.getLogger(XML.class.getName()).log(Level.SEVERE, null, ex);
        }
        return pNombre;
    }
    public String leerCedula(){
        String pCedula="";
        try {
            JespXML archivo = new JespXML("info.xml");
            Tag raiz = archivo.leerXML();
            Tag cedula = raiz.getTagHijoByName("empresa").getTagHijoByName("cedula");
            pCedula= cedula.getContenido();
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(XML.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SAXException ex) {
            Logger.getLogger(XML.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(XML.class.getName()).log(Level.SEVERE, null, ex);
        } catch (TagHijoNotFoundException ex) {
            Logger.getLogger(XML.class.getName()).log(Level.SEVERE, null, ex);
        }
        return pCedula;
    }
    public String leerConsecutivo(){
        String pConsecutivo="";
        try {
            JespXML archivo = new JespXML("info.xml");
            Tag raiz = archivo.leerXML();
            Tag consecutivo=raiz.getTagHijoByName("empresa").getTagHijoByName("consecutivo");
            pConsecutivo = consecutivo.getContenido();
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(XML.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SAXException ex) {
            Logger.getLogger(XML.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(XML.class.getName()).log(Level.SEVERE, null, ex);
        } catch (TagHijoNotFoundException ex) {
            Logger.getLogger(XML.class.getName()).log(Level.SEVERE, null, ex);
        }
        return pConsecutivo;
    }
    public String leerTelefono(){
        String pTelefono="";
        try {
            JespXML archivo = new JespXML("info.xml");
            Tag raiz = archivo.leerXML();
            Tag telefono = raiz.getTagHijoByName("empresa").getTagHijoByName("telefono");
            pTelefono=telefono.getContenido();
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(XML.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SAXException ex) {
            Logger.getLogger(XML.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(XML.class.getName()).log(Level.SEVERE, null, ex);
        } catch (TagHijoNotFoundException ex) {
            Logger.getLogger(XML.class.getName()).log(Level.SEVERE, null, ex);
        }
        return pTelefono;
    }
    public String leerTarifa(){
        String pTarifa="";
        try {
            JespXML archivo = new JespXML("info.xml");
            Tag raiz = archivo.leerXML();
            Tag tarifa = raiz.getTagHijoByName("empresa").getTagHijoByName("tarifa");
            pTarifa=tarifa.getContenido();
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(XML.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SAXException ex) {
            Logger.getLogger(XML.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(XML.class.getName()).log(Level.SEVERE, null, ex);
        } catch (TagHijoNotFoundException ex) {
            Logger.getLogger(XML.class.getName()).log(Level.SEVERE, null, ex);
        }
        return pTarifa;
    }
    public String leerContraseña(){
        String pContraseña="";
        try {
            JespXML archivo = new JespXML("info.xml");
            Tag raiz = archivo.leerXML();
            Tag contraseña = raiz.getTagHijoByName("empresa").getTagHijoByName("contraseña");
            pContraseña=contraseña.getContenido();
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(XML.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SAXException ex) {
            Logger.getLogger(XML.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(XML.class.getName()).log(Level.SEVERE, null, ex);
        } catch (TagHijoNotFoundException ex) {
            Logger.getLogger(XML.class.getName()).log(Level.SEVERE, null, ex);
        }
        return pContraseña;
    }
    public String leerHorario(){
        String pHorario="";
        try {
            JespXML archivo = new JespXML("info.xml");
            Tag raiz = archivo.leerXML();
            Tag horario = raiz.getTagHijoByName("empresa").getTagHijoByName("horario");
            pHorario=horario.getContenido();
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(XML.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SAXException ex) {
            Logger.getLogger(XML.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(XML.class.getName()).log(Level.SEVERE, null, ex);
        } catch (TagHijoNotFoundException ex) {
            Logger.getLogger(XML.class.getName()).log(Level.SEVERE, null, ex);
        }
        return pHorario;
    }
    public Tag raizEmpresa = new Tag("info");
    public void escribirEmpresa(String pNombre, String pCedula, String pConsecutivo, String pTelefono, String pTarifa, String pContraseña, String pHorario){
        try {
            //creo el objeto JespXML con el archivo que quiero crear
            JespXML archivo = new JespXML("info.xml");
            //creo el Tag empresa, que va a tener un nombre una cedula y un consecutivo
            Tag empresa = new Tag("empresa");
            Tag nombre, cedula, consecutivo, telefono, tarifa, contraseña,horario;
            //construyo los Tags nombre y apellido y le agrego contenido
            nombre = new Tag("nombre");
            cedula = new Tag("cedula");
            consecutivo = new Tag("consecutivo");
            telefono= new Tag("telefono");
            tarifa= new Tag("tarifa");
            contraseña= new Tag("contraseña");
            horario= new Tag("horario");
            nombre.addContenido(pNombre);
            cedula.addContenido(pCedula);
            consecutivo.addContenido(pConsecutivo);
            telefono.addContenido(pTelefono);
            tarifa.addContenido(pTarifa);
            contraseña.addContenido(pContraseña);
            horario.addContenido(pHorario);
            empresa.addTagHijo(nombre);
            empresa.addTagHijo(cedula);
            empresa.addTagHijo(consecutivo);
            empresa.addTagHijo(telefono);
            empresa.addTagHijo(tarifa);
            empresa.addTagHijo(contraseña);
            empresa.addTagHijo(horario);
            raizEmpresa.addTagHijo(empresa);
            archivo.escribirXML(raizEmpresa);
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(XML.class.getName()).log(Level.SEVERE, null, ex);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(XML.class.getName()).log(Level.SEVERE, null, ex);
        } catch (TransformerException ex) {
            Logger.getLogger(XML.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}