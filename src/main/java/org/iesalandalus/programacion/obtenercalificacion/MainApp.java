/**
 * @author Jonathan Simón
 **/

package org.iesalandalus.programacion.obtenercalificacion;

public class MainApp {

	public static void main(String[] args) {
		EvaluacionSP primeraEvaluacion = new EvaluacionSP("Primera evaluación");
		EvaluacionSP segundaEvaluacion = new EvaluacionSP("Segunda evaluacion");
		EvaluacionSP terceraEvaluacion = new EvaluacionSP("Tercera evaluacion");
		
		System.out.println("\nCALIFICACIONES PARA LA "+primeraEvaluacion.getNombre().toUpperCase()+ "\n");
		Consola.leerCalificacionesEvaluacionSP(primeraEvaluacion);
		System.out.println(primeraEvaluacion);
		
		System.out.println("\nCALIFICACIONES PARA LA "+segundaEvaluacion.getNombre().toUpperCase()+ "\n");
		Consola.leerCalificacionesEvaluacionSP(segundaEvaluacion);
		System.out.println(segundaEvaluacion);
		
		System.out.println("\nCALIFICACIONES PARA LA "+terceraEvaluacion.getNombre().toUpperCase()+ "\n");
		Consola.leerCalificacionesEvaluacionSP(terceraEvaluacion);
		System.out.println(terceraEvaluacion);
		
		System.out.println("\nCALIFICACIÓN FINAL : "+ Consola.sumaCalificacionTotal(primeraEvaluacion, segundaEvaluacion, terceraEvaluacion));
	}

}
