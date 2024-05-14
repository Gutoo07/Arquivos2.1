package model;

public class NoPilha<T> {
	private NoPilha<T> anterior;
	private T valor;
	
	public NoPilha (T valor) {
		this.valor = valor;
		this.anterior = null;
	}
	public NoPilha (T valor, NoPilha<T> anterior) {
		this.valor = valor;
		this.anterior = anterior;
	}
	public void setValor(T valor) {
		this.valor = valor;
	}
	public T getValor() {
		return this.valor;
	}
	public void setAnterior (NoPilha<T> anterior) {
		this.anterior = anterior;
	}
	public NoPilha<T> getAnterior() {
		return this.anterior;
	}
	@Override
	public String toString() {
		return this.valor.toString();
	}
}