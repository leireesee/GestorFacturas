package principal;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

import clases.Factura;
import clases.LineaFactura;

public class GestorFacturas {

	public void run() throws ParseException {
		Scanner scan = new Scanner(System.in);

		//crear la facturaaa
		Factura factura = new Factura();

		//pedir datos de facatura
		//setter de datos de la factura
		System.out.println("Introduce el numero de factura");
		factura.setNumero(Integer.parseInt(scan.nextLine()));
		
		System.out.println("Nombre de empresa: ");
		factura.setNombreEmpresa(scan.nextLine());
		
		System.out.println("Fecha de factura (dd/MM/yyyy)");
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		factura.setFecha(sdf.parse(scan.nextLine()));
		
		System.out.println("Concepto:");
		factura.setConcepto(scan.nextLine());
		
		//pedir introducir las opcioens L o I
		String opcion;
		do {
			imprimirOpciones();
			opcion = scan.nextLine();
			
			if(opcion.equals("L")) {
				LineaFactura lineaF = new LineaFactura();
				
				System.out.println("Introduce el numero de liea");
				lineaF.setNumero(Integer.parseInt(scan.nextLine()));
				
				System.out.println("Articulo:");
				lineaF.setArticulo(scan.nextLine());
				
				System.out.println("Precio:");
				lineaF.setPrecio(Double.parseDouble(scan.nextLine()));
				
				System.out.println("Cantidad:");
				lineaF.setCantidad(Integer.parseInt(scan.nextLine()));
				
				factura.addLinea(lineaF);
				
			}
		}while(!opcion.equals("I"));
		
		//imprimir la factura en pantalla
		factura.mostrarEnPantalla();
		
		

	}

	private void imprimirOpciones() {
		System.out.println("I - Imprimir Factura");
		System.out.println("L - introducir linea de factura");
	}

}
