package Entidades;

import Interfaces.ServicoDeAutenticacao;
import Interfaces.ServicoDeConsulta;
import java.util.ArrayList;
import java.util.List;

public class Aluno extends Usuario implements ServicoDeConsulta, ServicoDeAutenticacao {
    List<Disciplina> disciplinas;

    public Aluno(String nome, int idade, String username, String password) {
        super(nome, idade, username, password);
        this.disciplinas = new ArrayList<>();
    }

    public Aluno(String nome, int idade) {
        super(nome, idade, "", "");
    }

    public Aluno(String nome, int idade, String username) {
        super(nome, idade, username, "");
    }

    public Aluno(String nome, int idade, String username, String password, List<Disciplina> disciplinas) {
        super(nome, idade, username, password);
        this.disciplinas = disciplinas;
    }

    public List<Disciplina> getDisciplinas() {
        return disciplinas;
    }

    public void setDisciplinas(List<Disciplina> disciplinas) {
        this.disciplinas = disciplinas;
    }

    @Override
    public void verNotas() {
        for (Disciplina disciplina : this.disciplinas) {
            System.out.println("Matéria: " + disciplina.getNome() + ", Nota: " + disciplina.getNota());
        }
    }

    @Override
    public void verFaltas() {
        for (Disciplina disciplina : this.disciplinas) {
            System.out.println("Matéria: " + disciplina.getNome() + ", Faltas: " + disciplina.getFaltas());
        }
    }

    @Override
    public boolean checkPassword(String password) {
        return this.getPassword().equals(password);
    }
}
