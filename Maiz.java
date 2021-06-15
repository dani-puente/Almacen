package almacen;
import java.util.Scanner;
public class Maiz extends Producto {
	public static int kilosAlmacenados;

	public Maiz() {
		super();
		kilosAlmacenados = 0;
	}
	static Scanner sc = new Scanner(System.in);

	public static double getPrecio() {
		return precio;
	}

	public static void setPrecio(double precioIntroducido) {
		precio = precioIntroducido;
	}

	public static double getPesoEspecifico() {
		return pesoEspecifico;
	}

	public static void setPesoEspecifico(double pesoEspecificoIntroducido) {
		pesoEspecifico = pesoEspecificoIntroducido;
	}

	public static double getHumedad() {
		return humedad;
	}

	public static void setHumedad(double humedadIntroducida) {
		humedad = humedadIntroducida;
	}

	public static void sumarKilos(int valor) {
		if (valor < 0) {
			System.out.println("No se pueden sumar numeros negativos, intentalo de nuevo:");
			int kilosAComprar = sc.nextInt();
			comprarKilos(kilosAComprar);
		} else {
			kilosAlmacenados += valor;
		}
	}

	public static void restarKilos(int valor) {
		if (valor < 0 || kilosAlmacenados < valor) {
			System.out.println("Operacion no valida/Fuera de existencias");
			int kilosAVender = sc.nextInt();
			venderKilos(kilosAVender);
		} else {
			kilosAlmacenados -= valor;
		}
	}

	public static int getKilosAlmacenados() {
		return kilosAlmacenados;
	}

	public static String getDetalles() {
		String ADevolver = "############################################################\n"
				+ "## Se tienen en el almacen:\n"
				+ "## "+getKilosAlmacenados() + " kg de maiz.\n"
				+ "## Humedad: " + getHumedad() + "%.\n"
				+ "## Peso especifico: " + getPesoEspecifico() + " Kg/m3.\n"
				+ "## Precio actual: " + getPrecio() + " €/T.\n"
				+ "############################################################";
		
		return ADevolver;
		/*
		 * System.out.println(
		 * "############################################################");
		 * System.out.println("## Se tienen en el almacen:");
		 * System.out.println("## "+getKilosAlmacenados() + " kg de maiz.");
		 * System.out.println("## Humedad: " + getHumedad() + "%.");
		 * System.out.println("## Peso especifico: " + getPesoEspecifico() + " Kg/m3.");
		 * System.out.println("## Precio actual: " + getPrecio() + " €/T.");
		 * System.out.println(
		 * "############################################################");
		 */
	}
}
