package Services;

import Entidades.Aluno;
import Entidades.Disciplina;
import Entidades.Turma;

public class Servicos {

    public interface ServicoDeNotas {
        void adicionarNota(Aluno aluno, String materia, int nota, int faltas);
        void adicionarNota(Aluno aluno, String materia, int nota);
        void adicionarNota(Aluno aluno, Disciplina disciplina);
        void adicionarNota(Aluno aluno, String materia);
    }
    
    public interface ServicoDeFaltas {
        void adicionarFalta(Aluno aluno, String materia, int faltas);
    }
    
    public interface ServicoDeMatricula {
        void matricularAluno(Aluno aluno, Turma turma);
    }
    
    public interface ServicoDeConsulta {
        void verNotas();
        void verFaltas();
    }
    
    public interface ServicoDeAutenticacao {
        boolean checkPassword(String password);
    }
    
}
