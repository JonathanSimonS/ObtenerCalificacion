/**
 * @author Jonathan Simón
 **/

package org.iesalandalus.programacion.obtenercalificacion;

public class Instrumento {

	// Atributos
	private static final float PESO_MINIMO = 0.1f;
	private static final float PESO_MAXIMO = 0.35f;
	private static final float CALIFICACION_MINIMA = 0;
	private static final float CALIFICACION_MAXIMA = 10;
	
	private String nombre;
	private float peso;
	private float calificacion;

	// Contructor
	public Instrumento(String nombre, float peso) {
		setNombre(nombre);
		setPeso(peso);
	}
	
	// Métodos
	public String getNombre() {
		return nombre;
	}
	private void setNombre(String nombre) {
		if (nombre==null) {
			throw new NullPointerException("ERROR: El nombre no puede ser nulo.");
		}
		this.nombre = nombre;
	}
	public float getPeso() {
		return peso;
	}
	private void setPeso(float peso) {
		if (peso<PESO_MINIMO) {
			throw new IllegalArgumentException("ERROR: El peso no puede ser menor al 10%.");
		}
		if (peso>PESO_MAXIMO) {
			throw new IllegalArgumentException("ERROR: El peso no puede ser mayor al 35%.");
		}
		this.peso = peso;
	}
	public float getCalificacion() {
		return calificacion;
	}
	public void setCalificacion(float calificacion) {
		if (calificacion<CALIFICACION_MINIMA) {
			throw new IllegalArgumentException("ERROR: La calificación no puede ser menor que 0.");
		}
		if (calificacion>CALIFICACION_MAXIMA) {
			throw new IllegalArgumentException("ERROR: La calificación no puede ser mayor que 10.");
		}
		this.calificacion = calificacion;
	}
	
	public float getCalificacionPonderada() {
		return peso*calificacion;
	}

	@Override
	public String toString() {
		return String.format("Instrumento [nombre=%s, peso=%s, calificacion=%s]", nombre, peso, calificacion, getCalificacionPonderada());
	}
	
}
