package Repositorios;

import Entidades.Escola;
import java.util.ArrayList;
import java.util.List;

public class EscolaRepositorio {
    private List<Escola> escolas;

    public EscolaRepositorio() {
        this.escolas = new ArrayList<>();
    }

    public void adicionarEscola(Escola escola) {
        escolas.add(escola);
    }

    public List<Escola> getEscolas() {
        return escolas;
    }

    public void setEscolas(List<Escola> escolas) {
        this.escolas = escolas;
    }

}
