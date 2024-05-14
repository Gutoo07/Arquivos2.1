package view;
import java.io.IOException;

import controller.FifaController;
import model.ListaDupla;
import model.Pilha;

public class Principal {
	public static void main(String args[]) {
		FifaController m = new FifaController();
		String caminho = "C:\\TEMP";
		String nome = "data.csv";
		try {
			Pilha pilha = m.empilhaBrasileiros(caminho, nome);
			m.desmpilhaBonsBrasileiros(pilha);
			ListaDupla lista = m.listaRevelacoes(caminho, nome);
			m.buscaListaBonsJovens(lista);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
