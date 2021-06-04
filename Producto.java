
package almacen;

import java.util.Scanner;
import java.util.InputMismatchException;

public class Producto {
	public static String tipo;
	public static double precio;
	public static double pesoEspecifico;
	public static double humedad;
	public int kilos;

	public Producto() {
		tipo = null;
		precio = 0;
		pesoEspecifico = 0;
		humedad = 0;
		kilos = 0;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduce el tipo; maiz(1), trigo(2): ");
		try {
			int tipoAIntroducir = sc.nextInt();
			boolean tipoCorrecto = false;
			while (tipoCorrecto == false) {
				if (tipoAIntroducir > 0 && tipoAIntroducir < 3) {
					if (tipoAIntroducir == 1) {
						tipo = "maiz";
					} else {
						tipo = "trigo";
					}
					tipoCorrecto = true;
				} else {
					System.out.println("Introduce un producto valido (Maiz(1), trigo(2)");
					tipoAIntroducir = sc.nextInt();
				}
			}
		} catch (InputMismatchException letra) {
			System.out.println("Introduce un numero no una letra.");
		}

		boolean valorGestion = false;
		while (valorGestion == false) {
			System.out.println("Gestiones de " + tipo + ":");
			System.out.println("1. Establecer precio.");
			System.out.println("2. Establecer humedad.");
			System.out.println("3. Establecer peso especifico.");
			System.out.println("4. Comprar kilos.");
			System.out.println("5. Vender kilos.");
			System.out.println("6. Ver detalles del producto.");
			System.out.println("7. Salir y resetear valores.");
			int gestion = sc.nextInt();
			if (gestion > 0 && gestion < 9) {
				switch (gestion) {
				case 1:
					try {
						System.out.println("Introduce el precio: ");
						double precioAIntroducir = sc.nextDouble();
						setPrecio(precioAIntroducir);
					} catch (InputMismatchException letra) {
						System.out.println("Introduce los datos con comas, no con puntos.");
					}
					break;
				case 2:
					try {
						System.out.println("Introduce la humedad: ");
						double humedadAIntroducir = sc.nextDouble();
						setHumedad(humedadAIntroducir);
					} catch (InputMismatchException letra) {
						System.out.println("Introduce los datos con comas, no con puntos.");
					}
					break;
				case 3:
					try {
						System.out.println("Introduce el peso especifico: ");
						double pesoEspecificoAIntroducir = sc.nextDouble();
						setPesoEspecifico(pesoEspecificoAIntroducir);
					} catch (InputMismatchException letra) {
						System.out.println("Introduce los datos con comas, no con puntos.");
					}

					break;
				case 4:
					try {
						System.out.println("Introduce los kilos a comprar: ");
						int kilosAComprar = sc.nextInt();
						comprarKilos(kilosAComprar);
					} catch (InputMismatchException letra) {
						System.out.println("Introduce numeros no caracteres,");
					}
					break;
				case 5:
					try {
						System.out.println("Introduce los kilos a vender: ");
						int kilosAVender = sc.nextInt();
						venderKilos(kilosAVender);
					} catch (InputMismatchException letra) {
						System.out.println("Introduce numeros no caracteres,");
					}
					break;
				case 6:
					getDetallesDelProducto();
					break;
				case 7:
					valorGestion = true;
					break;
				}
			}
		}

	}

	public static double getPrecio() {
		if (tipo.equals("maiz")) {
			Maiz.getPrecio();
		} else {
			Trigo.getPrecio();
		}
		return precio;
	}

	private static void setPrecio(double precioIntroducido) {
		precio = precioIntroducido;
		if (tipo.equals("maiz")) {
			Maiz.setPrecio(precioIntroducido);
		} else {
			Trigo.setPrecio(precioIntroducido);
		}

	}

	public static double getPesoEspecifico() {
		if (tipo.equals("maiz")) {
			Maiz.getPesoEspecifico();
		} else {
			Trigo.getPesoEspecifico();
		}
		return pesoEspecifico;
	}

	private static void setPesoEspecifico(double pesoEspecificoIntroducido) {
		pesoEspecifico = pesoEspecificoIntroducido;
		if (tipo.equals("maiz")) {
			Maiz.setPesoEspecifico(pesoEspecifico);
		} else {
			Trigo.setPesoEspecifico(pesoEspecifico);
		}
	}

	public static double getHumedad() {
		if (tipo.equals("maiz")) {
			Maiz.getHumedad();
		} else {
			Trigo.getHumedad();
		}
		return humedad;
	}

	private static void setHumedad(double humedadIntroducida) {
		humedad = humedadIntroducida;
		if (tipo.equals("maiz")) {
			Maiz.setHumedad(humedad);
		} else {
			Trigo.setHumedad(humedad);
		}
	}

	public int getKilos() {
		if (tipo.equals("maiz")) {
			Maiz.getKilosAlmacenados();
		} else {
			Trigo.getKilosAlmacenados();
		}
		return kilos;
	}

	protected static void comprarKilos(int kilosIntroducidos) {
		if (tipo.equals("maiz")) {
			Maiz.sumarKilos(kilosIntroducidos);
		} else {
			Trigo.sumarKilos(kilosIntroducidos);
		}
	}

	protected static void venderKilos(int kilosIntroducidos) {
		if (tipo.equals("maiz")) {
			Maiz.restarKilos(kilosIntroducidos);
		} else {
			Trigo.restarKilos(kilosIntroducidos);
		}
	}

	public static void getDetallesDelProducto() {
		if (tipo.equals("maiz")) {
			Maiz.getDetalles();
		} else {
			Trigo.getDetalles();
		}
	}
}