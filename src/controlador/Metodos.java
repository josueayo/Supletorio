/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.Persona;

/**
 *
 * @author Casa
 */
public class Metodos {
    Vector vPrincipal = new Vector();
    
    public void guardar(Persona unaPersona) {
        vPrincipal.addElement(unaPersona);
    }
    
    //Guardar en un txt
    public void guardarArchivo(Persona persona) {
        try {
            FileWriter fw = new FileWriter("Personas.txt",true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);
            pw.print(persona.getCodigo());
            pw.print("|"+persona.getNombre());
            pw.print("|"+persona.getApellido());
            pw.print("|"+persona.getDireccion());
            pw.print("|"+persona.getTelefono());
            pw.print("|"+persona.getEdad());
            pw.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    //Mostrar los datos
    
    public DefaultTableModel listaPersonas(){
        Vector cabeceras = new Vector();
        cabeceras.addElement("Codigo");
        cabeceras.addElement("Nombre");
        cabeceras.addElement("Apellido");
        cabeceras.addElement("Direccion");
        cabeceras.addElement("Telefono");
        
        
        DefaultTableModel mdlTabla = new DefaultTableModel(cabeceras,0);
        
        try {
            FileReader fr = new FileReader("Personas.txt");
            BufferedReader br = new BufferedReader(fr);
            String d;
            while((d= br.readLine()) !=null){
                StringTokenizer dato = new StringTokenizer(d,"|");
                Vector x = new Vector();
                while(dato.hasMoreTokens()){
                    x.addElement(dato.nextToken());
                }
                mdlTabla.addRow(x);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return mdlTabla;
        
    }
    
    
    
}
