package Clases;

public class Productos {

 private int 	codigoProducto;
 private String nombre;
 private double precio;
 private int  	stockActual;
 private int 	stockMinimo;
 private int 	stockMaximo;
 
 //metodo constructor con parametros 
 public Productos (String nombre, double precio, int stockActual, int stockMinimo, int stockMaximo) {
     this.nombre= nombre;
     this.precio = precio;
     this.stockActual = stockActual;
     this.stockMinimo = stockMinimo;
     this.stockMaximo = stockMaximo;
 }

 //get y set
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

	public int getStockMinimo() {
		return stockMinimo;
	}

	public void setStockMinimo(int stockMinimo) {
		this.stockMinimo = stockMinimo;
	}

	public int getStockMaximo() {
		return stockMaximo;
	}

	public void setStockMaximo(int stockMaximo) {
		this.stockMaximo = stockMaximo;
	}

	//toString
	@Override
	public String toString() {
		return "Productos" + 
				"\ncodigoProducto=" + codigoProducto + 
				"\nnombre=" + nombre + 
				"\nprecio=" + precio + 
				"\nstockActual=" + stockActual + 
				"\nstockMinimo=" + stockMinimo + 
				"\nstockMaximo=" + stockMaximo;
	}








 

 
 
}