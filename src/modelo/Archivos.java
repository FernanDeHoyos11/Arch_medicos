package modelo;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import static java.lang.Integer.parseInt;
import static java.lang.Integer.parseInt;
import static java.lang.System.getProperty;
import static java.lang.System.out;
import java.util.ArrayList;
import java.util.Date;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.showMessageDialog;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author USER
 */
public class Archivos {
    private String path;
    private File archi;
    String barra = File.separator;
    
    public Archivos(){
        path =  System.getProperty("user.dir") + barra + "medicos.txt" + barra;
    }
    
        public void agregar(Medicos nuevo) throws IOException {
        archi = new File(path);
        BufferedWriter escritura;
        if (archi.exists()){
            escritura = new BufferedWriter(new FileWriter(archi, true));
        }
            
        else {
            escritura = new BufferedWriter(new FileWriter(archi));
        }
        
        escritura.write(nuevo.toString());
        escritura.newLine();
        escritura.close();
        showMessageDialog(null, "Agregado.");
    }
        
    public ArrayList<Medicos> get() throws IOException {
        
        String lineaCompleta = "";
        Object array[];
        ArrayList<Medicos> datos = new ArrayList<>();
        archi = new File(path);
        BufferedReader data;
        
        if (archi.exists()) {
            data = new BufferedReader(new FileReader(archi));
            while ((lineaCompleta = data.readLine()) != null) {
                Medicos art = new Medicos();
                array = lineaCompleta.split(";");
                /*
                art.id((String) array[0]);
                art.setNombre((SimpleStringProperty) array[1]);
                art.setTelefono((SimpleIntegerProperty) array[2]);
                art.setEdad((SimpleIntegerProperty)array[3]);
                art.setEspecialisacion((SimpleStringProperty)array[4]);
                
                datos.add(art);
*/
            }
            out.println(datos.size());
            data.close();
            return datos;
        }
        else{
            showMessageDialog(null, "Archivo no encontrado o creado.");
            return null;
        }
    }
}
