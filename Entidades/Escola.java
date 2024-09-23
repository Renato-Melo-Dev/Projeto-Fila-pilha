package Entidades;

import Interfaces.ServicoDeMatricula;
import java.util.ArrayList;
import java.util.List;

public class Escola implements ServicoDeMatricula {
    private String nome;
    private List<Turma> turmas;

    public Escola(String nome) {
        this.nome = nome;
        this.turmas = new ArrayList<>();
    }

    @Override
    public void matricularAluno(Aluno aluno, Turma turma) {
        turma.adicionarAluno(aluno);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Turma> getTurmas() {
        return turmas;
    }

    public void setTurmas(List<Turma> turmas) {
        this.turmas = turmas;
    }
}
