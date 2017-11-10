package controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JOptionPane;

import model.Empleado;
import model.Persona;
import modelDao.EmpleadoDao;
import modelDao.PersonaDao;

public class Main {

	public static void main(String[] args) {
		Persona personita1=new Persona();
		Empleado empleadito1=new Empleado();
		PersonaDao perDao=new PersonaDao();
		EmpleadoDao empDao=new EmpleadoDao();
		String n="",a="",f="",id="";
		
		Object [] opciones=new Object[] {"1.- Registrar Persona", "2.- Actualizar Persona","3.- Eliminar Persona",
				"4.- Registrar Empleado"};
		
		Object seleccion = JOptionPane.showInputDialog(
				   null, "Seleccione una opcion", "Sistema de Empleados",
				   JOptionPane.QUESTION_MESSAGE, null,opciones,"1.- Ingresar Persona");
		
		switch (String.valueOf(seleccion).charAt(0)) {
			case '1':
				while(n.equals("")) {
					n=JOptionPane.showInputDialog("Ingrese el Nombre de la Persona");
				}
				personita1.setPerNombre(n);
				while(a.equals("")) {
					a=JOptionPane.showInputDialog("Ingrese los Apellidos de la Persona");
				}
				personita1.setPerApellido(a);
				
				f=JOptionPane.showInputDialog("Ingrese la Fecha de Nacimiento ej. 2000-12-31");
				personita1.setPerFechaNacimiento(f);
	
				if(perDao.ingresar(personita1)) {
					JOptionPane.showMessageDialog(null, "Persona ingresada con Exito");
				}else {
					JOptionPane.showMessageDialog(null, "Persona NO ingresada");
				}
				break;
			case '2':
				id=JOptionPane.showInputDialog("Ingrese el Id de la Persona a Modificar");
				n=JOptionPane.showInputDialog("Ingrese el Nombre de la Persona");
				a=JOptionPane.showInputDialog("Ingrese los Apellidos de la Persona");
				f=JOptionPane.showInputDialog("Ingrese la Fecha de Nacimiento ej. 1900-05-31");
				personita1.setPerId(Integer.parseInt(id));
				personita1.setPerNombre(n);
				personita1.setPerApellido(a);
				personita1.setPerFechaNacimiento(f);
				if(perDao.actualizar(personita1)){
					JOptionPane.showMessageDialog(null, "Persona Actualizada con Exito");
				}else {
					JOptionPane.showMessageDialog(null, "Persona NO actualizada");
				}
			case '3':
				id=JOptionPane.showInputDialog("Ingrese Id Persona a Modificar");
				int idInt=Integer.parseInt(id);
				personita1.setPerId(idInt);
				if(perDao.eliminar(personita1)) {
					JOptionPane.showMessageDialog(null, "Persona Eliminada exitosamente");
				}else {
					JOptionPane.showMessageDialog(null, "Persona No Eliminada");
				}
			case '4':
				id=JOptionPane.showInputDialog("Ingrese Id de Persona ya Registrada");
				String s=JOptionPane.showInputDialog("Ingrese el sueldo del Empleado");
				int sueldo=Integer.parseInt(s);
				empleadito1.setPerId(Integer.parseInt(id));
				empleadito1.setEmpSueldoBruto(sueldo);
				if(empDao.ingresar(empleadito1)) {
					JOptionPane.showMessageDialog(null, "Empleado Ingresado");
				}else {
					JOptionPane.showMessageDialog(null, "Hubo un error al momento de ingresar al Empleado");
				}
				
				
		default:
			System.out.println("Opcion no valida.");
			break;
		}
		
		
		
		
		

	}

}
