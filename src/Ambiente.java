
public class Ambiente {
	String nombre;
	int ancho;
	int alto;
	Zona[][] zonas;
	Aspiradora aspiradora;
	
	public Ambiente(String nombre, int ancho, int alto) {
		super();
		this.nombre = nombre;
		this.ancho = ancho;
		this.alto = alto;
		this.zonas = new Zona[ancho][alto];
	}

	public void agregarZona(Zona zona) {
		boolean zonaAgregada = false;
		// Se recorre matriz hasta que se agrego una zona
		for (int i = 0; i < zonas.length && !zonaAgregada; i++) {

			// Loop through all elements of current row
			for (int j = 0; j < zonas[i].length && !zonaAgregada; j++) {
				// Se comprueba que el espacio este diponible
				if (zonas[i][j] == null) {
					//Se asigna ambiente en donde se esta laa zona
					zona.setAmbiente(this);
					//Se asigna ubicacion de la zona
					zona.setColumna(j);
					zona.setFila(i);
					// Se agrega zona
					zonas[i][j] = zona;
					// Se marca que se agrego zona
					zonaAgregada = true;
					
					 System.out.print("Zona agregada en columna:"+ Integer.toString(j)  +  " y fila: " + Integer.toString(i) + "\n"); 
				}
			}
		}

		// Si no se agrego zona, mandar excepcion
		if (!zonaAgregada) {
			// mandar excepcion
			 System.out.print("No hay mas espacio !\n");
		}

	}
	public void agregarAspiradora(Aspiradora aspiradora) {
		Zona zonaInicial = zonas[0][0];
		//Se posiciona la aspiradora en posicion 0 0
		aspiradora.setZona(zonaInicial);
		
		//Se limpia zona inicial
		aspiradora.limpiarZona();
		
		this.aspiradora  = aspiradora;
	}
	public int getAncho() {
		return ancho;
	}

	public int getAlto() {
		return alto;
	}

	public Zona getZona(int fila, int columna) {
		return this.zonas[fila][columna];
	}


	
}
