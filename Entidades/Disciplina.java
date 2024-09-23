package Entidades;

public class Disciplina {
    private String nome;
    private int nota;
    private int faltas;

    public Disciplina(String nome, int nota, int faltas) {
        this.nome = nome;
        this.nota = nota;
        this.faltas = faltas;
    }

    public Disciplina(String nome, int nota) {
        this.nome = nome;
        this.nota = nota;
        this.faltas = 0;
    }

    public Disciplina(String nome) {
        this.nome = nome;
        this.nota = 0;
        this.faltas = 0;
    }

    public Disciplina() {
    }

    public String getNome() {
        return nome;
    }

    public int getFaltas() {
        return faltas;
    }

    public void setFaltas(int faltas) {
        this.faltas = faltas;
    }

    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }
}
