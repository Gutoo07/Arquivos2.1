package model;

public class NoListaDupla<T> {
	private T valor;
	private NoListaDupla<T> proximo;
	private NoListaDupla<T> anterior;
	
	public NoListaDupla (T valor) {
		this.valor = valor;
		this.anterior = null;
		this.proximo = null;
	}
	public T getValor() {
		return this.valor;
	}
	public void setValor(T valor) {
		this.valor = valor;
	}
	public NoListaDupla<T> getProximo() {
		return this.proximo;
	}
	public void setProximo(NoListaDupla<T> proximo) {
		this.proximo = proximo;
	}
	public NoListaDupla<T> getAnterior() {
		return this.anterior;
	}
	public void setAnterior(NoListaDupla<T> anterior) {
		this.anterior = anterior;
	}
	@Override
	public String toString() {
		return valor.toString();	
	}
}