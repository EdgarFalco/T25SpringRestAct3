package main.dto;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "caja")
public class Caja {

	@Id
	private char numReferencia;
	private String contenido;
	private int valor;

	@ManyToOne
	@JoinColumn(name = "almacen")
	private Almacen almacen;

	// Constructores
	public Caja() {
	}

	public Caja(char numReferencia, String contenido, int valor, Almacen almacen) {
		this.numReferencia = numReferencia;
		this.contenido = contenido;
		this.valor = valor;
		this.almacen = almacen;
	}

	//Getters and Setters
	public char getNumReferencia() {
		return numReferencia;
	}

	public void setNumReferencia(char numReferencia) {
		this.numReferencia = numReferencia;
	}

	public String getContenido() {
		return contenido;
	}

	public void setContenido(String contenido) {
		this.contenido = contenido;
	}

	public int getValor() {
		return valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}

	public Almacen getAlmacen() {
		return almacen;
	}

	public void setAlmacen(Almacen almacen) {
		this.almacen = almacen;
	}

	//ToString
	@Override
	public String toString() {
		return "Caja [numReferencia=" + numReferencia + ", contenido=" + contenido + ", valor=" + valor + "]";
	}
}
