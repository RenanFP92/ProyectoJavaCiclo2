package Clases;

public class Producto {
	// campos o atributos
	private int codigoProducto;
	private String nombre;
	private double precio;
	private int stockActual;
	private int stockMinimo;
	private int stockMaximo;
	
	// Métodos constructores
	public Producto() {
	}

	public Producto(int codigoProducto, String nombre, double precio, int stockActual, int stockMaximo,int stockMinimo) {
		this.codigoProducto = codigoProducto;
		this.nombre = nombre;
		this.precio = precio;
		this.stockActual = stockActual;
		this.stockMaximo = stockMaximo;
		this.stockMinimo = stockMinimo;
	}
	
	//Propiedades set/get

	public int getCodigoProducto() {
		return codigoProducto;
	}

	public void setCodigoProducto(int codigoProducto) {
		this.codigoProducto = codigoProducto;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public int getStockActual() {
		return stockActual;
	}

	public void setStockActual(int stockActual) {
		this.stockActual = stockActual;
	}

	public int getStockMaximo() {
		return stockMaximo;
	}

	public void setStockMaximo(int stockMaximo) {
		this.stockMaximo = stockMaximo;
	}
	
	public int getStockMinimo() {
		return stockMinimo;
	}

	public void setStockMinimo(int stockMinimo) {
		this.stockMinimo = stockMinimo;
	}

	

	@Override
	public String toString() {
		return "Producto [codigoProducto=" + codigoProducto + ", nombre=" + nombre + ", precio=" + precio
				+ ", stockActual=" + stockActual + ", stockMaximo=" + stockMaximo
				+ ", stockMinimo=" + stockMinimo +  "]";
	}
	
	
		
}