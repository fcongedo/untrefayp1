public class diasLluviosos {

	private boolean[] precipitaciones;

	public diasLluviosos() {

		this.precipitaciones = new boolean[365];

	}

	public void registrarQueLlovioElDia(int diaDeAņo, boolean llovio) {
		validarDiaDeAņo(diaDeAņo);
		this.precipitaciones[diaDeAņo - 1] = llovio;

	}

	private void validarDiaDeAņo(int diaDelAņo) {
		if (diaDelAņo < 1 || diaDelAņo > 365) {
			throw new Error(
					"los dias deben estar comprendidos en el rango de 1 a 365");
		}
	}

	public boolean consultarSiLlovioElDia(int diaDeAņo) {
		validarDiaDeAņo(diaDeAņo);
		return this.precipitaciones[diaDeAņo - 1];

	}

	public int contarDiasLluviosos() {
		int contadorDiasLluviosos = 0;
		for (int i = 0; i < this.precipitaciones.length; i++) {
			if (this.precipitaciones[i] == true) {
				contadorDiasLluviosos++;
			}
		}
		return contadorDiasLluviosos;

	}

	public int consultarCuatrimestreMasLluvioso() {
		int cuatrimestreMasLluvioso = 0;
		int[] cuatrimestres = new int[3];

		for (int i = 0; i < 122; i++) {
			if (this.precipitaciones[i] == true) {
				cuatrimestres[1]++;
			}
		}
		for (int i = 122; i < 244; i++) {
			if (this.precipitaciones[i] == true) {
				cuatrimestres[2]++;
			}
		}

		for (int i = 244; i < 365; i++) {
			if (this.precipitaciones[i] == true) {
				cuatrimestres[1]++;
			}
		}
		for (int i = 0; i < cuatrimestres.length; i++) {
			if (cuatrimestres[i] > cuatrimestreMasLluvioso) {
				cuatrimestreMasLluvioso = cuatrimestres[i];
			}
		}
		return cuatrimestreMasLluvioso;

	}

	public int consultarPrimerDiaConLluvia() {
		int primerDiaQueLlovio = 0;
		for (int i = 0; i < this.precipitaciones.length
				&& primerDiaQueLlovio == 0; i++) {
			if (this.precipitaciones[i] == true) {
				primerDiaQueLlovio = i + 1;
			}
		}
		return primerDiaQueLlovio;

	}

}
