package model;
import model.NoPilha;
import java.lang.Exception;

public class Pilha<T> {
	private NoPilha<T> ultimo = null;
	
	//push : adiciona novo elemento no topo
	//pop : remove elemento do topo
	
	public void push(T valor) {
		NoPilha<T> novo = new NoPilha<>(valor);
		if (this.ultimo == null) {
			this.ultimo = novo;
		} else {
			//novo.setAnterior(this.ultimo);
			//this.ultimo = novo;
			NoPilha<T> anterior = this.ultimo;
			novo.setAnterior(anterior);
			this.ultimo = novo;
		}
	}
	public NoPilha<T> pop() throws IllegalArgumentException {
		if (this.ultimo == null) {
			throw new IllegalArgumentException("Lista vazia.");
		} else {
			NoPilha<T> buffer = this.ultimo;
			this.ultimo = this.ultimo.getAnterior();
			return buffer;
		}
	}
	@Override
	public String toString() throws IllegalArgumentException {
		if (this.ultimo == null) {
			throw new IllegalArgumentException("Lista vazia.");
		} else {
			StringBuilder builder = new StringBuilder("[");
			NoPilha<T> buffer = this.ultimo;
			builder.append(buffer.getValor());
			while (buffer.getAnterior() != null) {
				builder.append("\n");
				buffer = buffer.getAnterior();
				builder.append(buffer.getValor());
			}
			builder.append("]");
			return builder.toString();
		}
	}
}