package Interfaces;

import Entidades.Aluno;
import Entidades.Turma;

public interface ServicoDeMatricula {
    void matricularAluno(Aluno aluno, Turma turma);
}
