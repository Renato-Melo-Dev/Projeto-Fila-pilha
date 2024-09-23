package Repositorios;

import Entidades.Professor;
import java.util.ArrayList;
import java.util.List;

public class ProfessorRepositorio {
    private List<Professor> professores;

    public ProfessorRepositorio() {
        this.professores = new ArrayList<>();
    }

    public void adicionarProfessor(Professor professor) {
        professores.add(professor);
    }

    public List<Professor> getProfessores() {
        return professores;
    }

    public void setProfessores(List<Professor> professores) {
        this.professores = professores;
    }

    
}
