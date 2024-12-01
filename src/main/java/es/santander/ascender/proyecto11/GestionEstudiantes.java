package es.santander.ascender.proyecto11;

import java.util.HashMap;

import java.util.Map;
import java.util.Set;

public class GestionEstudiantes implements IGestionEstudiantes{

    private Map<String, Integer> estudiantes = new HashMap<>();

   
    public Map<String, Integer> obtenerEstudiantesYCalificaciones() {
        
        return new HashMap<>(estudiantes);  
    }
   
    public boolean agregarEstudiante(String nombre, int calificacion) {
        if (nombre == null|| nombre.isEmpty()|| estudiantes.containsKey(nombre))  {
            return false;  
        }
        estudiantes.put(nombre, calificacion);
        return true;
    }
   

    public Integer obtenerCalificacion(String nombre) {
        return estudiantes.get(nombre);  
    }

   
    

  
    public boolean existeEstudiante(String nombre) {
        return estudiantes.containsKey(nombre);  
    }


    public boolean eliminarEstudiante(String nombre) {
        if (estudiantes.containsKey(nombre)) {
            estudiantes.remove(nombre);
            return true;
        }
        return false; 
    }

   
    public void agregarEstudiantes(Set<String> nuevosEstudiantes, Map<String, Integer> nuevasCalificaciones) {
        for (String estudiante : nuevosEstudiantes) {
            Integer calificacion = nuevasCalificaciones.get(estudiante);
            if (calificacion != null) {
                agregarEstudiante(estudiante, calificacion);  
            }
        }
    }
   

    
    
}
