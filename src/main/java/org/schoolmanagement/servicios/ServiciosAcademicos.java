package org.schoolmanagement.servicios;

import org.schoolmanagement.exception.EstudianteNoInscritoEnCursoException;
import org.schoolmanagement.exception.EstudianteYaInscritoException;
import org.schoolmanagement.models.Curso;
import org.schoolmanagement.models.Estudiante;

import java.util.List;

public interface ServiciosAcademicos {
    void matricularEstudiante(Estudiante estudiante);
    void agregarCurso(Curso curso);
    void inscribirEstudianteCurso(Estudiante estudiante, int idCurso) throws EstudianteYaInscritoException;
    void desinscribirEstudianteCurso(int idEstudiante, int idCurso) throws EstudianteNoInscritoEnCursoException;
}
