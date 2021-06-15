
package almacen;

import java.util.Scanner;
import java.util.InputMismatchException;
import java.io.*;

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

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		FileWriter fichero = new FileWriter("C:/Users/Dani_Asir2/Desktop/fichero.txt");
		System.out.println("Introduce el tipo; maiz(1), trigo(2): ");
		try {
			int tipoAIntroducir = sc.nextInt();
			boolean tipoCorrecto = false;
			while (tipoCorrecto == false) {
				try {
					if (validarNumero(tipoAIntroducir) == true) {
						if (tipoAIntroducir == 1) {
							tipo = "maiz";
						} else {
							tipo = "trigo";
						}
					}
					tipoCorrecto = true;

				} catch (ExcepcionNum e1) {
					System.out.println(e1);
					tipoAIntroducir = sc.nextInt();
				}
			}

			boolean valorGestion = false;
			while (valorGestion == false) {
				System.out.println("Gestiones de " + tipo + ":");
				System.out.println("1. Establecer precio.");
				System.out.println("2. Establecer humedad.");
				System.out.println("3. Establecer peso especifico.");
				System.out.println("4. Comprar kilos.");
				System.out.println("5. Vender kilos.");
				System.out.println("6. Crear fichero con detalles del producto.");
				System.out.println("7. Leer fichero con detalles del producto.");
				System.out.println("8. Salir y resetear valores.");
				int gestion = sc.nextInt();
				if (gestion > 0 && gestion < 10) {
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
						fichero.write(getDetallesDelProducto());
						fichero.close();
						break;
					case 7:
						System.out.println("Introduce la direccion del archivo a leer: ");
						String direccion = sc.next();
						System.out.println(leerFichero(direccion));
						break;
					case 8:
						valorGestion = true;
						break;
					}
				}
			}
		} catch (InputMismatchException letra) {
			System.out.println("Introduce un numero no una letra.");
			sc.next();
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

	public static String getDetallesDelProducto() {
		String ADevolver = "";
		if (tipo.equals("maiz")) {
			ADevolver = Maiz.getDetalles();
		} else {
			ADevolver = Trigo.getDetalles();
		}
		return ADevolver;
	}

	public static boolean validarNumero(int num) throws ExcepcionNum {
		boolean aDevolver = false;
		if (num < 0 || num > 3) {
			throw new ExcepcionNum("Introduce un producto valido (Maiz(1), trigo(2)");
		} else {
			aDevolver = true;
		}
		return aDevolver;
	}
	
	public static String leerFichero(String direccion) {
		String ADevolver = "";
		try {
			BufferedReader bf = new BufferedReader(new FileReader(direccion));
			String temp = "";
			String bfRead;
			while((bfRead = bf.readLine()) != null) {
				temp += bfRead + "\n";	
			}
			ADevolver = temp;
		} catch(Exception empty) {
			System.out.println("No se encontro el archivo");
		}
		return ADevolver;
	}
}