import java.util.Dictionary;
import java.util.HashMap;
import java.util.Map;
public class Aspiradora {
	Zona zona;
	Cepillo cepilloIzquierdo;
	Cepillo cepilloDerecho;
	String modoVelocidad;
	boolean encendido = false;
	int porcentajeBateria = 100;

	public Aspiradora(Cepillo cepilloIzquierdo, Cepillo cepilloDerecho) {
		super();
		this.cepilloIzquierdo = cepilloIzquierdo;
		this.cepilloDerecho = cepilloDerecho;
	}

	public void mover(String direccion) {
		Zona zonaActual = this.zona;
		Zona zonaNueva;
		Map <String,Integer> ubicacion = new HashMap<String,Integer>();

		//Se carga obtiene ubicacion actual de la aspiradora
		ubicacion = this.obtenerUbicacionActual();
		
		// Se comprueba si esta encendida
		if (this.encendido) {
			
			//Se cambia la ubicacion dependiendo de la direccion
			ubicacion = this.obtenerNuevaUbicacion(direccion);

			// Obtengo nueva zona, si, la zona que devuelve es la misma,
			// quiere decir que la aspiradora no se pudo mover
			zonaNueva = this.obtenerNuevaZona(ubicacion);

			// Compruebo si la aspiradora se movio de zona
			if (zonaNueva == zonaActual) {

				// Se reinicia ubicacion
				ubicacion = this.obtenerUbicacionActual();

				// Mover hacia arriba
				ubicacion = this.obtenerNuevaUbicacion("ARRIBA");

				// Obtengo nueva zona
				zonaNueva = this.obtenerNuevaZona(ubicacion);
				// Compruebo si la aspiradora se movio de zona
				if (zonaNueva == zonaActual) {
					// La aspiradora no se movio de zona

					// Se reinicia ubicacion
					ubicacion = this.obtenerUbicacionActual();

					// Mover hacia abajo
					ubicacion = this.obtenerNuevaUbicacion("ABAJO");

					// Obtengo nueva zona
					zonaNueva = this.obtenerNuevaZona(ubicacion);
				}
			}

			// Compruebo si la aspiradora se movio de zona
			if (zonaNueva == zonaActual) {
				// Se apaga aspiradora si no pudo mover hacia arriba ni hacia abajo
				this.apagar();
			} else {
				// La aspiradora se pudo mover exitosamente

				// Se diminuye la bateria
				this.gastarBateria();

				// Se asigna nueva zona a la aspiradora
				this.setZona(zonaNueva);
				System.out.print("Se movio aspiradora columna " + ubicacion.get("COLUMNA") + " y fila "
						+ ubicacion.get("FILA") + "\n");

				// Se limpia la zona
				this.limpiarZona();

				if (this.ambienteEstaLimpio()) {
					// Se apaga aspiradora si el ambiente esta limpio
					this.apagar();
				}

			}
		} else {
			System.out.print("La aspiradora esta apagada!\n");
		}
	}

	private Zona obtenerNuevaZona(Map <String,Integer> ubicacion) {
		Ambiente ambiente = zona.getAmbiente();
		int limiteFila = ambiente.getAncho();
		int limiteColumna = ambiente.getAlto();
		Zona nuevaZona = this.zona;
		Zona zonaTemporal;
		int fila = ubicacion.get("FILA");
		int columna = ubicacion.get("COLUMNA");
		
		// Si la ubicacion no es inicial, se modifican limites
		if (limiteFila != 0) {
			limiteFila = limiteFila - 1;
		}

		if (limiteColumna != 0) {
			limiteColumna = limiteColumna - 1;
		}

		// Se comprueba que la aspiradora no se exceda de los limites
		if (fila <= limiteFila && fila >= 0 && columna <= limiteColumna && columna >= 0) {
			// Se obtiene nueva zona
			zonaTemporal = ambiente.getZona(fila, columna);
			// Si la zona obtenida no tiene obstaculo, entonces se carga la nueva zona
			if (!zonaTemporal.tieneObstaculo()) {
				// Se carga la nueva zona
				nuevaZona = zonaTemporal;
			}
		}

		return nuevaZona;
	}
	
	private Map <String,Integer> obtenerUbicacionActual() {
		Zona zonaActual = this.zona;
		int fila = zonaActual.getFila();
		int columna = zonaActual.getColumna();
		Map <String,Integer> ubicacion = new HashMap<String,Integer>();
		
		ubicacion.put("FILA", fila);
		ubicacion.put("COLUMNA", columna);
		
		return ubicacion;
	}
	
	private Map <String,Integer> obtenerNuevaUbicacion(String direccion) {
		Zona zonaActual = this.zona;
		int fila = zonaActual.getFila();
		int columna = zonaActual.getColumna();
		Map <String,Integer> ubicacion = new HashMap<String,Integer>();

		switch (direccion) {
		case "ARRIBA":
			fila -= 1;
			break;
		case "ABAJO":
			fila += 1;
			break;
		case "DERECHA":
			columna += 1;
			break;
		case "IZQUIERDA":
			columna -= 1;
			break;
		default:
			// Declaraciones
		}
		
		ubicacion.put("FILA", fila);
		ubicacion.put("COLUMNA", columna);
		
		return ubicacion;
	}
	
	public void setZona(Zona zona) {
		this.zona = zona;
	}

	public void limpiarZona() {
		if (this.cepilloDerecho.estaSucio() || this.cepilloIzquierdo.estaSucio()) {
			System.out.print("El cepillo esta sucio hay que limpiarlo\n");

			this.apagar();
		} else {
			// Limpio zona con cada cepillo
			this.cepilloDerecho.limpiarZona(this.zona);

			this.cepilloIzquierdo.limpiarZona(this.zona);

			/*
			 * if(zona.estaLimpia()) { System.out.print("Se limpio zona\n"); }
			 */
		}
		//System.out.print("Barridos Cepillo Derecho: " + cepilloDerecho.cantidadDeBarridos + "\n");
		//System.out.print("Barridos Cepillo Izquierdo: " + cepilloDerecho.cantidadDeBarridos + "\n");
	}

	public void cambiarModoVelocidad(String modoVelocidad) {
		this.modoVelocidad = modoVelocidad;
	}

	public void apagar() {
		this.encendido = false;
	}

	public void encender() {
		// Se comprueba si la aspiradora tiene bateria
		if (this.porcentajeBateria > 0) {
			if(this.cepilloDerecho.estaSucio() || this.cepilloIzquierdo.estaSucio()) {
				System.out.print("La aspiradora tiene cepillos sucios!\n");
			}else {
				// Se enciende aspiradora
				this.encendido = true;

				// Se limpia zona inicial
				this.limpiarZona();
			}

		} else {
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

	// cargar manualmente
	public void cargarBateria() {
		if (this.porcentajeBateria == 0) {
			// Se carga
			this.porcentajeBateria = 100;
		} /*
			 * else { System.out.print("Todavia tiene bateria!\n"); }
			 */
	}

	private boolean ambienteEstaLimpio() {
		Ambiente ambiente = zona.getAmbiente();
		return ambiente.estaLimpio();
	}
	
	public void limpiarCepillosManualmente() {
		this.cepilloDerecho.limpiarManualmente();
		this.cepilloIzquierdo.limpiarManualmente();
	}

}
