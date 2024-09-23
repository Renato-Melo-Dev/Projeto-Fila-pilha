import Entidades.Aluno;
import Entidades.Escola;
import Entidades.Professor;
import Entidades.Turma;
import Repositorios.AlunoRepositorio;
import Repositorios.EscolaRepositorio;
import Repositorios.ProfessorRepositorio;
import Repositorios.TurmaRepositorio;
import java.util.Scanner;

/**
 * Classe principal do sistema escolar.
 */
public class Main {
    public static void main(String[] args) {
        // Instanciando repositórios para gerenciar alunos, professores, turmas e escolas
        AlunoRepositorio alunoRepo = new AlunoRepositorio();
        ProfessorRepositorio professorRepo = new ProfessorRepositorio();
        TurmaRepositorio turmaRepo = new TurmaRepositorio();
        EscolaRepositorio escolaRepo = new EscolaRepositorio();

        // Criando alunos e adicionando ao repositório
        Aluno aluno1 = new Aluno("Joao", 20, "joao123", "senha123");
        Aluno aluno2 = new Aluno("Maria", 19, "maria123", "senha123");
        alunoRepo.adicionarAluno(aluno1);
        alunoRepo.adicionarAluno(aluno2);

        // Criando professor e adicionando ao repositório
        Professor professor = new Professor("Renato", 28, "renato", "ehoq", "Matematica");
        professorRepo.adicionarProfessor(professor);

        // Criando turma e adicionando alunos
        Turma turma = new Turma("Turma A");
        turma.adicionarAluno(aluno1);
        turma.adicionarAluno(aluno2);
        turmaRepo.adicionarTurma(turma);

        // Criando escola e matriculando alunos
        Escola escola = new Escola("Escola Tupiniquin");
        escolaRepo.adicionarEscola(escola);
        escola.matricularAluno(aluno1, turma);
        escola.matricularAluno(aluno2, turma);

        try (Scanner scanner = new Scanner(System.in)) {
            OUTER:
            while (true) {
                System.out.println("Escolha uma opção:");
                System.out.println("1. Login");
                System.out.println("2. Registrar-se");
                System.out.println("3. Sair");
                int opcao = scanner.nextInt();
                scanner.nextLine();

                switch (opcao) {
                    case 1 -> {
                        // Processo de login
                        while (true) {
                            System.out.println("Digite o seu nome de usuário:");
                            String username = scanner.nextLine();
                            System.out.println("Digite a sua senha:");
                            String password = scanner.nextLine();

                            Aluno alunoLogado = null;
                            // Verifica se o aluno existe e se a senha está correta
                            for (Aluno aluno : turma.getAlunos()) {
                                if (aluno.getUsername().equals(username) && aluno.checkPassword(password)) {
                                    alunoLogado = aluno;
                                    break;
                                }
                            }

                            // Verifica se o professor existe e se a senha está correta
                            if (alunoLogado != null) {
                                alunoLogado(alunoLogado, scanner);
                                break;
                            } else if (professor.getUsername().equals(username) && professor.checkPassword(password)) {
                                professorLogado(professor, scanner, aluno1, aluno2);
                                break;
                            } else {
                                System.out.println("Nome de usuário ou senha inválidos.");
                                break;
                            }
                        }
                    }
                    case 2 -> {
                        // Processo de registro de aluno
                        System.out.println("Digite o seu nome:");
                        String nome = scanner.nextLine();
                        System.out.println("Digite a sua idade:");
                        int idade = scanner.nextInt();
                        scanner.nextLine();
                        System.out.println("Digite o seu nome de usuário:");
                        String username = scanner.nextLine();
                        System.out.println("Digite a sua senha:");
                        String password = scanner.nextLine();
                        Aluno novoAluno = new Aluno(nome, idade, username, password);
                        turma.adicionarAluno(novoAluno);
                        System.out.println("Aluno registrado com sucesso!");
                    }
                    case 3 -> {
                        System.out.println("Saindo...");
                        break OUTER;
                    }
                    default -> System.out.println("Opção inválida.");
                }
            }
        }
    }

    /**
     * Método para gerenciar a sessão de um aluno logado.
     * 
     * @param aluno   O aluno logado.
     * @param scanner O objeto Scanner para entrada de dados.
     */
    public static void alunoLogado(Aluno aluno, Scanner scanner) {
        System.out.println("Bem-vindo, " + aluno.getNome() + "!");
        OUTER:
        while (true) {
            System.out.println("Escolha uma opção:");
            System.out.println("1. Ver notas");
            System.out.println("2. Ver faltas");
            System.out.println("3. Sair");
            int opcao = scanner.nextInt();
            scanner.nextLine();
            switch (opcao) {
                case 1 -> aluno.verNotas();
                case 2 -> aluno.verFaltas();
                case 3 -> {
                    break OUTER;
                }
                default -> System.out.println("Opção inválida.");
            }
        }
    }

    /**
     * Método para gerenciar a sessão de um professor logado.
     * 
     * @param professor O professor logado.
     * @param scanner   O objeto Scanner para entrada de dados.
     * @param aluno1    O primeiro aluno para gerenciar.
     * @param aluno2    O segundo aluno para gerenciar.
     */
    public static void professorLogado(Professor professor, Scanner scanner, Aluno aluno1, Aluno aluno2) {
        System.out.println("Bem-vindo, " + professor.getNome() + "!");
        OUTER:
        while (true) {
            System.out.println("Escolha uma opção:");
            System.out.println("1. Adicionar notas");
            System.out.println("2. Alterar notas");
            System.out.println("3. Adicionar faltas");
            System.out.println("4. Alterar faltas");
            System.out.println("5. Sair");
            int opcao = scanner.nextInt();
            scanner.nextLine();
            switch (opcao) {
                case 1 -> {
                    // Adicionando notas
                    System.out.println("Digite o nome do aluno:");
                    String nomeAluno = scanner.nextLine();
                    System.out.println("Digite a matéria:");
                    String materia = scanner.nextLine();
                    System.out.println("Digite a nota:");
                    int nota = scanner.nextInt();
                    System.out.println("Digite as faltas:");
                    int faltas = scanner.nextInt();
                    scanner.nextLine();
                    if (nomeAluno.equals(aluno1.getNome())) {
                        professor.adicionarNota(aluno1, materia, nota, faltas);
                    } else if (nomeAluno.equals(aluno2.getNome())) {
                        professor.adicionarNota(aluno2, materia, nota, faltas);
                    } else {
                        System.out.println("Aluno não encontrado.");
                    }
                }
                case 2 -> {
                    // Alterando notas
                    System.out.println("Digite o nome do aluno:");
                    String nomeAluno = scanner.nextLine();
                    System.out.println("Digite a nota:");
                    int nota = scanner.nextInt();
                    scanner.nextLine();
                    if (nomeAluno.equals(aluno1.getNome())) {
                        professor.alterarNota(aluno1, nota);
                    } else if (nomeAluno.equals(aluno2.getNome())) {
                        professor.alterarNota(aluno2, nota);
                    } else {
                        System.out.println("Aluno não encontrado.");
                    }
                }
                case 3 -> {
                    // Adicionando faltas
                    System.out.println("Digite o nome do aluno:");
                    String nomeAluno = scanner.nextLine();
                    System.out.println("Digite a matéria:");
                    String materia = scanner.nextLine();
                    System.out.println("Digite as faltas:");
                    int faltas = scanner.nextInt();
                    scanner.nextLine();
                    if (nomeAluno.equals(aluno1.getNome())) {
                        professor.adicionarFalta(aluno1, materia, faltas);
                    } else if (nomeAluno.equals(aluno2.getNome())) {
                        professor.adicionarFalta(aluno2, materia, faltas);
                    } else {
                        System.out.println("Aluno não encontrado.");
                    }
                }
                case 4 -> {
                    // Alterando faltas
                    System.out.println("Digite o nome do aluno:");
                    String nomeAluno = scanner.nextLine();
                    System.out.println("Digite as faltas:");
                    int faltas = scanner.nextInt();
                    scanner.nextLine();
                    if (nomeAluno.equals(aluno1.getNome())) {
                        professor.alterarFalta(aluno1, faltas);
                    } else if (nomeAluno.equals(aluno2.getNome())) {
                        professor.alterarFalta(aluno2, faltas);
                    } else {
                        System.out.println("Aluno não encontrado.");
                    }
                }
                case 5 -> {
                    break OUTER;
                }
                default -> System.out.println("Opção inválida.");
            }
        }
    }
}
