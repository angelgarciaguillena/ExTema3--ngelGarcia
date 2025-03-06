package fecha;

/**
 * Esta clase se encarga de comprobar si la fecha introducida es correcta
 * 
 * @author Antonio
 */
public class Fecha {
	
	public static final int DIEZ = 10;

	/**
	 * Atributo privado que almacena el dia
	 */
	private int diaFecha; //d�a
	
	/**
	 * Atributo privado que almacena el mes
	 */
	private int mesFecha; //mes
	
	/**
	 * Atributo privado que almacena el año
	 */
	private int añoFecha; //a�o

	/**
	 * Este metodo no se encarga de realizar ninguna funcion
	 */
	public Fecha() {

	}

	/**
	 * Constructor que inicializa los atributos d, m y a con los parametros que recibe
	 * 
	 * @param dia Dia introducido
	 * @param mes Mes introducido
	 * @param anio Anio introducido
	 */
	public Fecha(int dia, int mes, int anio) {
		this.diaFecha = dia;
		this.mesFecha = mes;
		this.añoFecha = anio;
	}

	
	/**
	 * Calcula y devuelve si el dia, el mes y el año introducidos son correctos
	 * 
	 * @return Devuelve el dia, el mes, y el año correctos
	 */
	public boolean fechaCorrecta() {
		boolean diaCorrecto;
		boolean mesCorrecto;
		boolean anioCorrecto;
		anioCorrecto = añoFecha > 0;
		mesCorrecto = mesFecha >= 1 && mesFecha <= 12;
		boolean diaMayor1 = diaFecha >= 1;
		switch (mesFecha) {
		case 2:
			if (esBisiesto()) {
				diaCorrecto = diaMayor1 && diaFecha <= 29;
			} else {
				diaCorrecto = diaMayor1 && diaFecha <= 28;
			}
			break;
		case 4:
		case 6:
		case 9:
		case 11:
			diaCorrecto = diaMayor1 && diaFecha <= 30;
			break;
		default:
			diaCorrecto = diaMayor1 && diaFecha <= 31;
		}
		return diaCorrecto && mesCorrecto && anioCorrecto;
	}

	// M�todo esBisiesto. Solo lo usa fechaCorrecta, por eso es privado
	/**
	 * Este metodo se encarga de calcular y devolver si nos encontramos en un año bisiesto
	 * 
	 * @return Devuelve true si el año es bisiesto o false si no lo es
	 */
	private boolean esBisiesto() {
		return añoFecha % 4 == 0 && añoFecha % 100 != 0 || añoFecha % 400 == 0;
	}

	// M�todo diaSiguiente
	/**
	 * Este metodo se encarga de calcular el dia siguiente al que nos encontramos
	 */
	public void nextDay() {
		diaFecha++;
		if (!fechaCorrecta()) {
			diaFecha = 1;
			mesFecha++;
			if (!fechaCorrecta()) {
				mesFecha = 1;
				añoFecha++;
			}
		}
	}

	// M�todo toString
	/**
	 * Este metodo se encarga de devolver como se debe mostrar la fecha por pantalla segun 
	 * la fecha en la que nos encontremos
	 * 
	 * @return Devuelve una cadena con la fecha
	 */
	public String toString() {
		String cadena;
		if (diaFecha < DIEZ && mesFecha < DIEZ) {
			cadena = "0" + diaFecha + "-0" + mesFecha + "-" + añoFecha;
		} else if (diaFecha < DIEZ && mesFecha >= DIEZ) {
			cadena = "0" + diaFecha + "-" + mesFecha + "-" + añoFecha;
		} else if (diaFecha >= DIEZ && mesFecha < DIEZ) {
			cadena = diaFecha + "-0" + mesFecha + "-" + añoFecha;
		} else {
			cadena = diaFecha + "-" + mesFecha + "-" + añoFecha;
		}
		return cadena;
	}

}
