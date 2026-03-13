package controller;

import java.util.List;

import dao.AtorDAO;
import model.Ator;

public class AtorController {
    
    private AtorDAO atorDao = new AtorDAO();

    public void inserirAtor (Ator ator){
        atorDao.inserir(ator);
    }

    public List<Ator> pesquisarTodos (){
        return atorDao.lista();
    }

    public List<Ator> pesquisarUmAtor (String nome){
        return atorDao.apenasUmAtor(nome);
    }

    public void apagar (long id){
        atorDao.remover(id);
    }

    public void atualizar (Ator ator){
        atorDao.atualizar(ator);
    }

}
