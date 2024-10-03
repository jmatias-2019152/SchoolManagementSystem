package org.schoolmanagement;

import org.schoolmanagement.servicios.GestorAcademico;
import org.schoolmanagement.models.Estudiante;
import org.schoolmanagement.models.Curso;
import org.schoolmanagement.exception.EstudianteYaInscritoException;

public class Main {
    public static void main(String[] args) {
        GestorAcademico gestor = new GestorAcademico();

        // Crear estudiantes
        Estudiante est1 = new Estudiante(1, "Juan", "Pérez", "2000-01-01", "matriculado");
        Estudiante est2 = new Estudiante(2, "Ana", "Gómez", "2001-02-02", "matriculado");

        // Crear cursos
        Curso curso1 = new Curso(1, "Matemáticas", "Curso de matemáticas avanzadas", 3, "v1.0");
        Curso curso2 = new Curso(2, "Historia", "Curso de historia universal", 3, "v1.0");

        // Matricular estudiantes
        gestor.matricularEstudiante(est1);
        gestor.matricularEstudiante(est2);

        // Agregar cursos
        gestor.agregarCurso(curso1);
        gestor.agregarCurso(curso2);

        try {
            // Inscribir estudiantes a cursos
            gestor.inscribirEstudianteCurso(est1, 1);
            gestor.inscribirEstudianteCurso(est2, 1);
            gestor.inscribirEstudianteCurso(est1, 2);

            // Desinscribir estudiante de un curso
            gestor.desinscribirEstudianteCurso(1, 1);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println("Sistema de gestión escolar ejecutado con éxito.");
    }
}

