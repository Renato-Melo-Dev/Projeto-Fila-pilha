package Repositorios;

import Entidades.Aluno;
import java.util.Stack;

//Utilizando a estrutura de pilha para gerenciar alunos
 
public class AlunoRepositorio {
    private Stack<Aluno> alunos;

    
    public AlunoRepositorio() {
        alunos = new Stack<>();
    }

    
    public void adicionarAluno(Aluno aluno) {
        alunos.push(aluno);
    }

    
    public Aluno removerAluno() {
        return alunos.isEmpty() ? null : alunos.pop();
    }

   
    public Aluno verAlunoTopo() {
        return alunos.isEmpty() ? null : alunos.peek();
    }

   
    public boolean isEmpty() {
        return alunos.isEmpty();
    }
       
    public int tamanho() {
        return alunos.size();
    }

    public Stack<Aluno> getAlunos() {
        return alunos;
    }

    public void setAlunos(Stack<Aluno> alunos) {
        this.alunos = alunos;
    }
}
