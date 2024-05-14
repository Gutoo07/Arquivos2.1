package controller;

import model.Pilha;
import model.ListaDupla;

import java.io.IOException;

public interface IFifaController {
	public Pilha<String> empilhaBrasileiros(String caminho, String nome) throws IOException;
	public void desmpilhaBonsBrasileiros(Pilha<String> pilha) throws IOException;
	public ListaDupla<String> listaRevelacoes(String caminho, String nome) throws IOException;
	public void buscaListaBonsJovens(ListaDupla<String> lista) throws IOException;
}
