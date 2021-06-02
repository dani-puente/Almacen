package almacen;

public class Producto {
	private String tipo;
	private double precio;
	private double pesoEspecifico;
	public double humedad;
	public int kilosIntroducidos;
	public Producto(String tipo, double precio, double pesoEspecifico, double humedad, int kilosIntroducidos) {
		this.tipo = tipo;
		this.precio = precio;
		this.pesoEspecifico = pesoEspecifico;
		this.humedad = humedad;
		this.kilosIntroducidos = kilosIntroducidos;
	}

	public String getTipo() {
		return tipo;
	}
	
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	public double getPrecio() {
		return precio;
	}
	
	public void setPrecio(int precio) {
		this.precio = precio;
	}
	
	public double getPesoEspecifico() {
		return pesoEspecifico;
	}
	
	public void setPesoEspecifico(double pesoEspecifico) {
		this.pesoEspecifico = pesoEspecifico;
	}
	
	public double getHumedad() {
		return humedad;
	}
	
	public void setHumedad(double humedad) {
		this.humedad = humedad;
	}
	
	public int getKilosIntroducidos() {
		return kilosIntroducidos;
	}
	
	public void setKilosIntroducidos(int kilosIntroducidos) {
		this.kilosIntroducidos = kilosIntroducidos;
	}
	
	public void getDetallesDescarga() {
		System.out.println("Se introduce en el almacen:\n");
		System.out.println(kilosIntroducidos + " kg de " + tipo + ".\n");
		System.out.println("Humedad: " + humedad + "%.\n");
		System.out.println("Peso especifico: " + pesoEspecifico + " Kg/m3.\n");
		System.out.println("Precio actual: " + precio + " €/T.\n");
	}
}
