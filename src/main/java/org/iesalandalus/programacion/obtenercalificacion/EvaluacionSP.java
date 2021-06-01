/**
 * @author Jonathan Simón
 **/

package org.iesalandalus.programacion.obtenercalificacion;

public class EvaluacionSP {

	// Atributos
	private static final float PESO_PARTICIPACION = 0.10f;
	private static final float PESO_CUESTIONARIOS = 0.05f;
	private static final float PESO_TAREAS_ONLINE = 0.25f;
	private static final float PESO_TAREA_PRESENCIAL = 0.25f;
	private static final float PESO_EXAMEN = 0.35f;
	private String nombre;
	private static final float CALIFICACION_ALGUN_INSTRUMENTO_NO_SUPERADO = 4;
	private static final float CALIFICACION_CORTE = 5;

	private Instrumento cuestionarios;
	private Instrumento examen;
	private Instrumento tareasOnline;
	private Instrumento tareaPresencial;
	private Instrumento participacion;

	// Constructor
	public EvaluacionSP(String nombre) {
		setNombre(nombre);
		cuestionarios = new Instrumento("Cuestionarios", 0.1f);
		examen = new Instrumento("Examen", 0.35f);
		tareaPresencial = new Instrumento("Tarea Presencial", 0.25f);
		tareasOnline = new Instrumento("Tareas Online", 0.25f);
		participacion = new Instrumento("Participación", 0.1f);
	}

	// Métodos
	public String getNombre() {
		return nombre;
	}
	private void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Instrumento getCuestionarios() {
		return cuestionarios;
	}
	public Instrumento getExamen() {
		return examen;
	}
	public Instrumento getTareasOnline() {
		return tareasOnline;
	}
	public Instrumento getTareaPresencial() {
		return tareaPresencial;
	}
	public Instrumento getParticipacion() {
		return participacion;
	}

	private boolean superaCalificacionCorte(Float calificacion) {
		if (calificacion >= CALIFICACION_CORTE)
			return true;
		return false;
	}

	public boolean superaInstrumentosObligatorios() {
		if (superaCalificacionCorte(tareaPresencial.getCalificacion())
				&& superaCalificacionCorte(tareasOnline.getCalificacion())
				&& superaCalificacionCorte(examen.getCalificacion())) {
			return true;
		}
		return false;
	}

	public float getCalificacion() {
		float suma = tareaPresencial.getCalificacionPonderada() + tareasOnline.getCalificacionPonderada()
				+ examen.getCalificacionPonderada() + cuestionarios.getCalificacionPonderada()
				+ participacion.getCalificacionPonderada();
		if (superaCalificacionCorte(suma) && !superaInstrumentosObligatorios())
			return CALIFICACION_ALGUN_INSTRUMENTO_NO_SUPERADO;
		return suma;
	}

	public Resultado getResultado() {
		if (getCalificacion() >= CALIFICACION_CORTE)
			return Resultado.APROBADO;

		return Resultado.SUSPENSO;
	}

	@Override
	public String toString() {
		return String.format("Calificacion=%s, Resultado=%s", getCalificacion(),
				getResultado());
	}

}
