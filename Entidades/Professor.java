package Entidades;

import Interfaces.ServicoDeFaltas;
import Interfaces.ServicoDeNotas;
import java.util.ArrayList;
import java.util.List;

public class Professor extends Usuario implements ServicoDeNotas, ServicoDeFaltas {
    private String disciplina;
    private List<Aluno> alunos;

    public Professor(String nome, int idade, String username, String password, String disciplina) {
        super(nome, idade, username, password);
        this.disciplina = disciplina;
        this.alunos = new ArrayList<>();
    }

    public Professor(String nome, int idade, String disciplina) {
        super(nome, idade, "", "");
        this.disciplina = disciplina;
        this.alunos = new ArrayList<>();
    }

    public Professor(String nome, int idade) {
        super(nome, idade, "", "");
        this.disciplina = "";
        this.alunos = new ArrayList<>();
    }

    public String getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(String disciplina) {
        this.disciplina = disciplina;
    }

    public List<Aluno> getAlunos() {
        return alunos;
    }

    public void setAlunos(List<Aluno> alunos) {
        this.alunos = alunos;
    }

    public void alterarNota(Aluno aluno, int nota) {
        for (Disciplina d : aluno.getDisciplinas()) {
            if (d.getNome().equals(this.disciplina)) {
                d.setNota(nota);
            }
        }
    }

    public void alterarFalta(Aluno aluno, int falta) {
        for (Disciplina d : aluno.getDisciplinas()) {
            if (d.getNome().equals(this.disciplina)) {
                d.setFaltas(falta);
            }
        }
    }

    @Override
    public void adicionarNota(Aluno aluno, String materia, int nota, int faltas) {
        aluno.getDisciplinas().add(new Disciplina(materia, nota, faltas));
    }

    @Override
    public void adicionarNota(Aluno aluno, String materia, int nota) {
        aluno.getDisciplinas().add(new Disciplina(materia, nota, 0));
    }

    @Override
    public void adicionarNota(Aluno aluno, Disciplina disciplina) {
        aluno.getDisciplinas().add(disciplina);
    }

    @Override
    public void adicionarNota(Aluno aluno, String materia) {
        aluno.getDisciplinas().add(new Disciplina(materia, 0, 0));
    }

    @Override
    public void adicionarFalta(Aluno aluno, String materia, int faltas) {
        for (Disciplina d : aluno.getDisciplinas()) {
            if (d.getNome().equals(materia)) {
                d.setFaltas(faltas);
            }

        }
    }
}
