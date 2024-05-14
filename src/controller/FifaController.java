package controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import model.ListaDupla;
import model.NoListaDupla;
import model.Pilha;
import model.NoPilha;

public class FifaController implements IFifaController {

	@Override
	public Pilha<String> empilhaBrasileiros(String caminho, String nome) throws IOException {
		File arq = new File(caminho, nome);
		Pilha pilha = new Pilha();
		
		if (arq.exists() && arq.isFile()) {
			FileInputStream fluxo = new FileInputStream(arq);
			InputStreamReader leitor = new InputStreamReader(fluxo);
			BufferedReader buffer = new BufferedReader(leitor);
			String linha = buffer.readLine();
			linha = buffer.readLine();
			while (linha != null) {
				if (linha.contains("Brazil")) {
					pilha.push(linha);
				}
				linha = buffer.readLine();
			}
		}
		return pilha;		
	}

	@Override
	public void desmpilhaBonsBrasileiros(Pilha<String> pilha) throws IOException {
		
		NoPilha<String> linha = pilha.pop();
		String print[] = linha.getValor().split(",");
		if (Integer.parseInt(print[7]) > 80) {
			System.out.println(print[2] + "\t" + print[7]);
		}
		
		while (linha.getAnterior() != null) {
			linha = pilha.pop();
			print = linha.getValor().split(",");
			if (Integer.parseInt(print[7]) > 80) {
				System.out.println(print[2] + "\t" + print[7]);
			}
		}
	}
	@Override
	public ListaDupla<String> listaRevelacoes(String caminho, String nome) throws IOException {
		ListaDupla lista = new ListaDupla();
		File arq = new File(caminho, nome);
		
		if (arq.exists() && arq.isFile()) {
			FileInputStream fluxo = new FileInputStream(arq);
			InputStreamReader leitor = new InputStreamReader(fluxo);
			BufferedReader buffer = new BufferedReader(leitor);
			String linha = buffer.readLine();
			linha = buffer.readLine();
			while (linha != null) {
				String dados[] = linha.split(",");
				if (Integer.parseInt(dados[3]) <= 20) {
					lista.append(linha);
				}
				linha = buffer.readLine();
			}
		}		
		return lista;
	}
	@Override
	public void buscaListaBonsJovens(ListaDupla<String> lista) throws IOException {
		NoListaDupla<String> buffer = lista.get(0);
		String print[] = buffer.getValor().split(",");
		if (Integer.parseInt(print[7]) > 80) {
			System.out.println(print[2] + "\t" + print[3] + " anos: " + print[7]);
		}
		while (buffer.getProximo() != null) {
			buffer = buffer.getProximo();
			print = buffer.getValor().split(",");
			if (Integer.parseInt(print[7]) > 80) {
				System.out.println(print[2] + "\t" + print[3] + " anos: " + print[7]);
			}
		}
	}
}