package dao;

import model.Ator;

import java.util.List;

public interface IAtorDAO {
    public Ator pesquisar(String ator) ;
	public void inserir(Ator ator) ;
	public void remover (long id) ;
	public List<Ator> lista(); 
	public void atualizar(Ator ator);
	public List<Ator> apenasUmAtor (String titulo);
	public void conectarFilme(Ator ator, long idF);
}
