public class Aspiradora {
	Zona zona;
	Cepillo cepilloIzquierdo;
	Cepillo cepilloDerecho;
	String modoVelocidad;
	boolean encendido = false;
	int porcentajeBateria = 2;

	public Aspiradora(Cepillo cepilloIzquierdo, Cepillo cepilloDerecho) {
		super();
		this.cepilloIzquierdo = cepilloIzquierdo;
		this.cepilloDerecho = cepilloDerecho;
	}

	public void mover(String direccion) {
		Ambiente ambiente = zona.getAmbiente();
		int fila = zona.getFila();
		int columna = zona.getColumna();
		int limiteFila = ambiente.getAncho();
		int limiteColumna = ambiente.getAlto();
		Zona nuevaZona;

		// Se comprueba si esta encendida
		if (this.encendido) {

			// Si la ubicacion no es inicial, se modifican limites
			if (limiteFila != 0) {
				limiteFila = limiteFila - 1;
			}

			if (limiteColumna != 0) {
				limiteColumna = limiteColumna - 1;
			}

			switch (direccion) {
			case "ARRIBA":
				fila = fila - 1;
				break;
			case "ABAJO":
				fila = fila + 1;
				break;
			case "DERECHA":
				columna = columna + 1;
				break;
			case "IZQUIERDA":
				columna = columna - 1;
				break;
			default:
				// Declaraciones
			}

			// Se comprueba que la aspiradora no se exceda de los limites
			if (fila <= limiteFila && fila >= 0 && columna <= limiteColumna && columna >= 0) {
				// Se obtiene nueva zona
				nuevaZona = ambiente.getZona(fila, columna);
				
				if(nuevaZona.tieneObstaculo()) {
					//Logica para mover a otra zona
					
				}else {
					// Se carga nueva zona
					this.zona = nuevaZona;

					this.limpiarZona();
					System.out.print("Se movio aspiradora columna " + Integer.toString(columna) + " y fila "
							+ Integer.toString(fila) + "\n");

					// Se diminuye la bateria
					this.gastarBateria();			
				}


			} else {
				System.out.print("Se excedio de los limites !\n");
			}
		} else {
			System.out.print("La aspiradora esta apagada!\n");
		}
	}

	public void setZona(Zona zona) {
		this.zona = zona;
	}

	public void limpiarZona() {

		// Limpio zona con cada cepillo
		this.cepilloDerecho.limpiarZona(this.zona);

		this.cepilloIzquierdo.limpiarZona(this.zona);

		/*
		 * if(zona.estaLimpia()) { System.out.print("Se limpio zona\n"); }
		 */

	}

	public void cambiarModoVelocidad(String modoVelocidad) {
		this.modoVelocidad = modoVelocidad;
	}

	public void apagar() {
		this.encendido = false;
	}

	public void encender() {
		//Se comprueba si la aspiradora tiene bateria
		if (this.porcentajeBateria > 0) {
			//Se enciende aspiradora
			this.encendido = true;
		}else {
			System.out.print("La aspiradora no esta cargada!\n");
		}
	}

	public boolean estaEncendida() {
		return this.encendido;
	}

	private void gastarBateria() {
		this.porcentajeBateria -= 1;

		// Se comprueba si la aspiradora se quedo sin bateria
		if (this.porcentajeBateria <= 0) {
			// Se apaga aspiradora
			this.apagar();
		}
	}
}
