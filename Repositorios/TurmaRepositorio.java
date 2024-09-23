package Repositorios;

import Entidades.Turma;
import java.util.ArrayList;
import java.util.List;

public class TurmaRepositorio {
    private List<Turma> turmas;

    public TurmaRepositorio() {
        this.turmas = new ArrayList<>();
    }

    public void adicionarTurma(Turma turma) {
        turmas.add(turma);
    }

    public List<Turma> getTurmas() {
        return turmas;
    }

    public void setTurmas(List<Turma> turmas) {
        this.turmas = turmas;
    }
}
