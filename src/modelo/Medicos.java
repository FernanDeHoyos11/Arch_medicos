package modelo;


import java.util.Date;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author USER
 */
public class Medicos {
    public SimpleStringProperty id = new SimpleStringProperty();
    public SimpleStringProperty nombre = new SimpleStringProperty();
    public SimpleIntegerProperty telefono = new SimpleIntegerProperty();
    public SimpleIntegerProperty edad = new SimpleIntegerProperty();
    public SimpleStringProperty especialisacion = new SimpleStringProperty();
    

    public String getId() {
        return id.get();
    }

    public String getNombre() {
        return nombre.get();
    }

    public Integer getTelefono() {
        return telefono.get();
    }

    public Integer getEdad() {
        return edad.get();
    }

    public String getEspecialisacion() {
        return especialisacion.get();
    }

     
     
}
