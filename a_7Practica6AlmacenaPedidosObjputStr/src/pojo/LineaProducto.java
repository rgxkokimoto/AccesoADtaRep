package pojo;

import java.io.Serializable;

public class LineaProducto implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int idPedido;
	private Producto producto;
	private int cantidad;
	private double precioTotal;
	private String fechaPedido;
	
	
	public LineaProducto(int idPedido, Producto producto, int cantidad, double precioTotal, String fechaPedido) {
		super();
		this.idPedido = idPedido;
		this.producto = producto;
		this.cantidad = cantidad;
		this.precioTotal = precioTotal;
		this.fechaPedido = fechaPedido;
	}


	public int getIdPedido() {
		return idPedido;
	}


	public Producto getProducto() {
		return producto;
	}


	public int getCantidad() {
		return cantidad;
	}


	public double getPrecioTotal() {
		return precioTotal;
	}


	public String getFechaPedido() {
		return fechaPedido;
	}


	@Override
	public String toString() {
		return "lineaProducto [idPedido=" + idPedido + ", producto=" + producto + ", cantidad=" + cantidad
				+ ", precioTotal=" + precioTotal + ", fechaPedido=" + fechaPedido + "]";
	}
	
	
	
	
	
	

}
