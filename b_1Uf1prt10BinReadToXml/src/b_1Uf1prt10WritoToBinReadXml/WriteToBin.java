package b_1Uf1prt10WritoToBinReadXml;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class WriteToBin {

	public static void main(String[] args) {
		
		String[] nombres = {"Alberto", "Guillermo", "Alejandro", "Ana", "Patricia"}; 
		int[] departamentos = {10, 20, 30, 20, 10}; 
		double[] salarios = {2000.00, 1500.50, 3000.40, 2300.60, 1900.10};
		
		ArrayList<Empleado> listAEmple = new ArrayList<Empleado>();
		for (int i = 0; i < salarios.length; i++) {
			listAEmple.add(new Empleado(i, nombres[i], departamentos[i], salarios[i]));
		}
		
//		Paso 2: Crear el archivo binario
//		Aquí creamos un archivo binario llamado empleadosObj.dat que almacena la información de los empleados.
		
		try {
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("empleadosObj.dat"));
			
			for (Empleado emp : listAEmple) {
				oos.writeObject(emp);
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	
	}

}
