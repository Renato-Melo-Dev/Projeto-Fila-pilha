package Interfaces;

import Entidades.Aluno;
import Entidades.Disciplina;

public interface ServicoDeNotas {
    void adicionarNota(Aluno aluno, String materia, int nota, int faltas);
    void adicionarNota(Aluno aluno, String materia, int nota);
    void adicionarNota(Aluno aluno, Disciplina disciplina);
    void adicionarNota(Aluno aluno, String materia);
}
