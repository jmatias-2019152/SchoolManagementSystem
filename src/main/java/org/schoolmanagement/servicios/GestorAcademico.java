package org.schoolmanagement.servicios;
import org.schoolmanagement.models.Estudiante;
import org.schoolmanagement.models.Curso;
import java.util.ArrayList;
import java.util.HashMap;
import org.schoolmanagement.exception.EstudianteNoInscritoEnCursoException;
import org.schoolmanagement.exception.EstudianteYaInscritoException;

public class GestorAcademico implements ServiciosAcademicos {
    private ArrayList<Estudiante> estudiantes;
    private ArrayList<Curso> cursos;
    private HashMap<Integer, ArrayList<Estudiante>> inscripciones;

    public GestorAcademico() {
        estudiantes = new ArrayList<>();
        cursos = new ArrayList<>();
        inscripciones = new HashMap<>();
    }

    @Override
    public void matricularEstudiante(Estudiante estudiante) {
        if (!estudiantes.contains(estudiante)) {
            estudiantes.add(estudiante);
        }
    }

    @Override
    public void agregarCurso(Curso curso) {
        if (!cursos.contains(curso)) {
            cursos.add(curso);
        }
    }

    @Override
    public void inscribirEstudianteCurso(Estudiante estudiante, int idCurso) throws EstudianteYaInscritoException {
        if (inscripciones.containsKey(idCurso) && inscripciones.get(idCurso).contains(estudiante)) {
            throw new EstudianteYaInscritoException("El estudiante ya está inscrito en este curso.");
        }
        inscripciones.putIfAbsent(idCurso, new ArrayList<>());
        inscripciones.get(idCurso).add(estudiante);
    }

    @Override
    public void desinscribirEstudianteCurso(int idEstudiante, int idCurso) throws EstudianteNoInscritoEnCursoException {
        ArrayList<Estudiante> inscritos = inscripciones.get(idCurso);
        if (inscritos == null || !inscritos.removeIf(e -> e.getId() == idEstudiante)) {
            throw new EstudianteNoInscritoEnCursoException("El estudiante no está inscrito en este curso.");
        }
    }
}
