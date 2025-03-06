package fecha;

/**
 * Esta clase se encarga de comprobar si la fecha introducida es correcta
 * 
 * @author Antonio
 */
public class Fecha {
	
	/**
	 * Atributo privado que almacena el dia
	 */
	private int d; //d�a
	
	/**
	 * Atributo privado que almacena el mes
	 */
	private int m; //mes
	
	/**
	 * Atributo privado que almacena el año
	 */
	private int a; //a�o

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
		this.d = dia;
		this.m = mes;
		this.a = anio;
	}

	
	/**
	 * Calcula y devuelve si el dia, el mes y el año introducidos son correctos
	 * 
	 * @return Devuelve el dia, el mes, y el año correctos
	 */
	public boolean fechaCorrecta() {
		boolean diaCorrecto, mesCorrecto, anioCorrecto;
		anioCorrecto = a > 0;
		mesCorrecto = m >= 1 && m <= 12;
		switch (m) {
		case 2:
			if (esBisiesto()) {
				diaCorrecto = d >= 1 && d <= 29;
			} else {
				diaCorrecto = d >= 1 && d <= 28;
			}
			break;
		case 4:
		case 6:
		case 9:
		case 11:
			diaCorrecto = d >= 1 && d <= 30;
			break;
		default:
			diaCorrecto = d >= 1 && d <= 31;
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
		boolean esBisiesto = (a % 4 == 0 && a % 100 != 0 || a % 400 == 0);
		return esBisiesto;
	}

	// M�todo diaSiguiente
	/**
	 * Este metodo se encarga de calcular el dia siguiente al que nos encontramos
	 */
	public void diaSiguiente() {
		d++;
		if (!fechaCorrecta()) {
			d = 1;
			m++;
			if (!fechaCorrecta()) {
				m = 1;
				a++;
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
		if (d < 10 && m < 10) {
			return "0" + d + "-0" + m + "-" + a;
		} else if (d < 10 && m >= 10) {
			return "0" + d + "-" + m + "-" + a;
		} else if (d >= 10 && m < 10) {
			return d + "-0" + m + "-" + a;
		} else {
			return d + "-" + m + "-" + a;
		}
	}

}
