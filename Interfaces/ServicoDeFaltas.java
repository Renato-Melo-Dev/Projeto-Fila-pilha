package Interfaces;

import Entidades.Aluno;

public interface ServicoDeFaltas {
    void adicionarFalta(Aluno aluno, String materia, int faltas);
}
