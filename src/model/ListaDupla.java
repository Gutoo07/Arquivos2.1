package model;

import java.lang.Exception;
import model.NoListaDupla;

public class ListaDupla<T> {
	private NoListaDupla<T> inicio = null;
	private NoListaDupla<T> fim = null;
	
	//append
	//get
	//index
	//insert
	//last
	//prepend
	//remove
	//total
	
	public void append (T elemento) {
		NoListaDupla<T> novo = new NoListaDupla<>(elemento);
		if (this.fim == null) {
			this.fim = novo;
			this.inicio = novo;
			return;
		} 
		this.last().setProximo(novo);
		novo.setAnterior(this.last());
		this.fim = novo;
	}
	public NoListaDupla<T> last() throws IllegalArgumentException {
		if (this.inicio == null) {
			throw new IllegalArgumentException("Lista vazia.");
		}
		NoListaDupla<T> buffer = this.inicio;
		while ( buffer.getProximo() != null ) {
			buffer = buffer.getProximo();
		}
		return buffer;		
	}
	public NoListaDupla<T> get(int index) throws IllegalArgumentException {
		int i = 0;
		if (this.inicio == null) {
			throw new IllegalArgumentException("Lista vazia.");
		}
		NoListaDupla<T> buffer = this.inicio;
		while (i < index) {
			i++;
			buffer = buffer.getProximo();
		}
		if (buffer == null) {
			throw new IllegalArgumentException("Indice informado nao existe.");
		}
		return buffer;
	}
	public int index(T valor) throws IllegalArgumentException {
		if (this.inicio == null) {
			throw new IllegalArgumentException("Lista vazia.");
		}
		NoListaDupla<T> buffer = this.inicio;
		int index = 0;
		while (buffer.getProximo() != null) {
			if (buffer.getValor() == valor) {
				return index;
			} else {
				buffer = buffer.getProximo();
				index++;
			}
		}
		throw new IllegalArgumentException("Item nao encontrado na lista.");
	}
	public void insert(T valor, int index) {
		NoListaDupla<T> novo = new NoListaDupla<>(valor);

		if ( index == 0 ) {
			this.prepend(valor);
		} else {
			NoListaDupla<T> buffer_proximo = get(index);
			NoListaDupla<T> buffer_anterior = get(--index);
			buffer_anterior.setProximo(novo);
			buffer_proximo.setAnterior(novo);
			novo.setProximo(buffer_proximo);
			novo.setAnterior(buffer_anterior); 
		}		
	}
	public void prepend (T valor) {
		NoListaDupla<T> novo = new NoListaDupla<>(valor);
		if (this.inicio == null) {
			this.inicio = novo;
			this.fim = novo;
		} else {
			NoListaDupla<T> buffer_inicio = this.inicio;
			this.inicio = novo;
			novo.setProximo(buffer_inicio);
			buffer_inicio.setAnterior(novo);
		}
	}
	public void remove (int index) throws IllegalArgumentException {
		if ( get(index) == null ) {
			throw new IllegalArgumentException("Indice inexistente.");
		}
		if (index == 0) {
			this.inicio = this.inicio.getProximo();
			this.inicio.setAnterior(null);
		} else {
			NoListaDupla<T> remover = get(index);
			NoListaDupla<T> anterior = remover.getAnterior();
			NoListaDupla<T> proximo = remover.getProximo();
			anterior.setProximo(proximo);
			proximo.setAnterior(anterior);
			remover.setAnterior(null);
			remover.setProximo(null);
			remover.setValor(null);
		}
	}
	public int total() {
		if (this.inicio == null) {
			return 0;
		}
		NoListaDupla<T> buffer = this.inicio;
		int total = 1;
		
		while ( buffer.getProximo() != null ) {
			total++;
			buffer = buffer.getProximo();
		}
		return total;
	}
	@Override
	public String toString() {
		if (this.inicio == null) {
			return "[]";
		}
		StringBuilder builder = new StringBuilder("[");
		NoListaDupla<T> buffer = this.inicio;
		builder.append( buffer.getValor() );
		while ( buffer.getProximo() != null ) {
			builder.append("\n");
			buffer = buffer.getProximo();
			builder.append(buffer.getValor());
		}
		builder.append("]");
		return builder.toString();
	}
}