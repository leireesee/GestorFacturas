package clases;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

public class Factura {
	private int numero;
	private String nombreEmpresa;
	private Date fecha;
	private String concepto;
	private ArrayList<LineaFactura> lineas = new ArrayList<LineaFactura>();
	
	public double precioTotal() {
		double total = 0;
		for(int i = 0; i<lineas.size(); i++) {
			total = total + lineas.get(i).precioTotal();
		}
		return total;
	}
	
	public void addLinea(LineaFactura linea) {
		lineas.add(linea);
	}
	
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public String getNombreEmpresa() {
		return nombreEmpresa;
	}
	public void setNombreEmpresa(String nombreEmpresa) {
		this.nombreEmpresa = nombreEmpresa;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public String getConcepto() {
		return concepto;
	}
	public void setConcepto(String concepto) {
		this.concepto = concepto;
	}
	public ArrayList<LineaFactura> getLineas() {
		return lineas;
	}
	public void setLineas(ArrayList<LineaFactura> lineas) {
		this.lineas = lineas;
	}

	public void mostrarEnPantalla() {
		
		System.out.println("Numero factura: " + this.numero + "\t\t" + this.nombreEmpresa);
		System.out.println("Fecha: " + new SimpleDateFormat("dd/MM/yyyy").format(this.fecha));
		System.out.println(this.concepto);
		
		System.out.println("num\tart.\tprecio\tcant.\ttotal");
		System.out.println("---\t----\t------\t-----\t-----");
		for (LineaFactura lineaFactura : this.lineas) {
			lineaFactura.mostrarEnPantalla();
		}
		
		System.out.println("\t\t\t---Total: " + this.precioTotal());
		
		
	}

}
