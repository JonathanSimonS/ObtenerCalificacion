/**
 * @author Jonathan Simón
 **/

package org.iesalandalus.programacion.obtenercalificacion;

import org.iesalandalus.programacion.utilidades.Entrada;

public class Consola {

	public Consola() {
		// Evitamos que se puedan crear objetos
	}

	private static void leerCalificacionInstrumento(Instrumento instrumento) {
		if (instrumento == null) {
			throw new NullPointerException("ERROR: El instrumento no puede ser nulo.");
		}
		boolean valor = true;
		do {
			System.out.print("Introduce la calificación para " + instrumento.getNombre() + ":");
			float calificacion = Entrada.real();
			try {
				instrumento.setCalificacion(calificacion);
				valor = false;
			} catch (IllegalArgumentException e) {
				System.out.println(e.getMessage());
			}
		} while (valor);
	}

	public static void leerCalificacionesEvaluacionSP(EvaluacionSP evaluacion) {
		leerCalificacionInstrumento(evaluacion.getCuestionarios());
		leerCalificacionInstrumento(evaluacion.getParticipacion());
		leerCalificacionInstrumento(evaluacion.getTareaPresencial());
		leerCalificacionInstrumento(evaluacion.getTareasOnline());
		leerCalificacionInstrumento(evaluacion.getExamen());
	}

	public static float sumaCalificacionTotal(EvaluacionSP evaluacion1, EvaluacionSP evaluacion2,
			EvaluacionSP evaluacion3) {
		float suma = evaluacion1.getCalificacion() + evaluacion2.getCalificacion() + evaluacion3.getCalificacion();
		if (evaluacion1.getCalificacion() < 5 || evaluacion2.getCalificacion() < 5
				|| evaluacion3.getCalificacion() < 5) {
			return 4;
		}
		return suma / 3;
	}
}
