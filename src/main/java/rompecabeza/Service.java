package rompecabeza;

public class Service {

	int matriz[][];
	static int matres[][];
	int x;
	int y;

	public Service(int x, int y) {
		this.x = x;
		this.y = y;
		matriz = new int[x][y];
		matres = new int[x][y];
	}

	static void PosicionBoton(int x1, int y1, int dato) {
		matres[x1][y1] = dato;
	}

	static boolean comparar() {
		int cont = 1;
		boolean bn = true;
		for (int x1 = 0; x1 < matres.length; x1++) {
			for (int y1 = 0; y1 < matres[x1].length; y1++) {
				if (matres[x1][y1] != cont) {
					bn = false;
					break;
				}
				cont++;
			}
			if (bn == false)
				break;
		}
		return bn;
	}

	public int[][] MatrizAleatoria() {
		int numale;
		boolean bn;
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[i].length; j++) {
				do {
					numale = (int) (Math.random() * (x * y) + 1);
					bn = false;
					for (int r = 0; r < matriz.length; r++) {
						for (int s = 0; s < matriz[r].length; s++) {
							if (numale == matriz[r][s]) {
								bn = true;
								break;
							}
						}
						if (bn)
							break;
					}
				} while (bn);
				matriz[i][j] = numale;
			}
		}
		return matriz;
	}

}