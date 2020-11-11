public class Cepillo {
	boolean estaSucio = false;

	private boolean estaSucio() {

		return false;
	}

	public void limpiarZona(Zona zona) {

		if (this.estaSucio()) {
			System.out.print("El cepillo esta sucio\n");
		} else {
			zona.limpiar();
		}
	}
};
