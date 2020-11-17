public class Cepillo {
	int cantidadDeBarridos = 0;

	public boolean estaSucio() {
		return cantidadDeBarridos >= 5;
	}

	public void limpiarZona(Zona zona) {

		if (this.estaSucio()) {
			System.out.print("El cepillo esta sucio\n");

		} else {
			zona.limpiar();
			this.cantidadDeBarridos += 1;// Limpia zona y aumenta el cepillo en cantidad de barrido
		}
	}

	public void limpiarManualmente() {
		this.cantidadDeBarridos = 0;// resetea la cantidad de barridos
	}

};
