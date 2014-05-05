package com.luis.model;
// Generated 25-abr-2014 21:04:13 by Hibernate Tools 3.6.0


import java.util.HashSet;
import java.util.Set;

/**
 * Puesto generated by hbm2java
 */
public class Puesto  implements java.io.Serializable {


     private Integer idPuesto;
     private String nombre;
     private Set empleados = new HashSet(0);

    public Puesto() {
    }

	
    public Puesto(String nombre) {
        this.nombre = nombre;
    }
    public Puesto(String nombre, Set empleados) {
       this.nombre = nombre;
       this.empleados = empleados;
    }
   
    public Integer getIdPuesto() {
        return this.idPuesto;
    }
    
    public void setIdPuesto(Integer idPuesto) {
        this.idPuesto = idPuesto;
    }
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public Set getEmpleados() {
        return this.empleados;
    }
    
    public void setEmpleados(Set empleados) {
        this.empleados = empleados;
    }




}


