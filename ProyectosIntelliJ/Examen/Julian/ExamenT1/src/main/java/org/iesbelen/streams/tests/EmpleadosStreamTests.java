package org.iesbelen.streams.tests;


import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;


import org.iesbelen.streams.dao.DepartamentoDAO;
import org.iesbelen.streams.dao.DepartamentoDAOImpl;
import org.iesbelen.streams.dao.EmpleadoDAO;
import org.iesbelen.streams.dao.EmpleadoDAOImpl;
import org.iesbelen.streams.entity.Departamento;
import org.iesbelen.streams.entity.Empleado;
import org.junit.jupiter.api.Test;

class EmpleadosStreamTests {

	@Test
	void testSkeletonDepartamento() {
	
		DepartamentoDAO depHome = new DepartamentoDAOImpl();
		
		try {
			((DepartamentoDAOImpl)depHome).beginTransaction();
	
			List<Departamento> listDep = depHome.findAll();
		
			
			//TODO STREAMS

		}
		catch (RuntimeException e) {
			((DepartamentoDAOImpl)depHome).rollbackTransaction();
		    throw e; // or display error message
		}
	}
	

	@Test
	void testSkeletonEmpleado() {
	
		EmpleadoDAO empHome = new EmpleadoDAOImpl();
		try {
			((EmpleadoDAOImpl)empHome).beginTransaction();
		
			List<Empleado> listProd = empHome.findAll();		
						
			//TODO STREAMS

		}
		catch (RuntimeException e) {
			((EmpleadoDAOImpl)empHome).rollbackTransaction();
		    throw e; // or display error message
		}
	}
	
	@Test
	void testAllDepartamento() {
	
		DepartamentoDAO depHome = new DepartamentoDAOImpl();
		
		try {
			((DepartamentoDAOImpl)depHome).beginTransaction();
	
			List<Departamento> listDep = depHome.findAll();
			listDep.forEach(System.out::println);
			
		}
		catch (RuntimeException e) {
			((DepartamentoDAOImpl)depHome).rollbackTransaction();
		    throw e; // or display error message
		}
	}
	
	@Test
	void testAllEmpleado() {
	
		EmpleadoDAO empHome = new EmpleadoDAOImpl();
		try {
			((EmpleadoDAOImpl)empHome).beginTransaction();
		
			List<Empleado> listEmp = empHome.findAll();		
			listEmp.forEach(System.out::println);

		}
		catch (RuntimeException e) {
			((EmpleadoDAOImpl)empHome).rollbackTransaction();
		    throw e; // or display error message
		}	
	
	}
	
	/**
	 * 1. Lista el código de los departamentos de los empleados, 
	 * eliminando los códigos que aparecen repetidos.
	 */
	@Test
	void test1() {
	
		EmpleadoDAO empHome = new EmpleadoDAOImpl();
		try {
			((EmpleadoDAOImpl)empHome).beginTransaction();
		
			List<Empleado> listEmp = empHome.findAll();

			listEmp.stream()
					.map(e -> e.getDepartamento().getCodigo())
					.distinct()
					.forEach(System.out::println);

		}
		catch (RuntimeException e) {
			((EmpleadoDAOImpl)empHome).rollbackTransaction();
		    throw e; // or display error message
		}
	}
	
	/**
	 * 2. Lista el nombre y apellidos de los empleados en una única columna,
	 * convirtiendo todos los caracteres en mayúsculas
	 */
	@Test
	void test2() {
	
		EmpleadoDAO empHome = new EmpleadoDAOImpl();
		try {
			((EmpleadoDAOImpl)empHome).beginTransaction();
		
			List<Empleado> listEmp = empHome.findAll();

			listEmp.stream()
					.map(e -> {
						String text = "Nombre: " + e.getNombre() +
								" Apellido1: " + e.getApellido1() +
								" Apellido2: " + e.getApellido2();
						return text.toUpperCase();
					}).forEach(System.out::println);

		}
		catch (RuntimeException e) {
			((EmpleadoDAOImpl)empHome).rollbackTransaction();
		    throw e; // or display error message
		}
	}

	/**
	 * 3. Lista el código de los empleados junto al nif, pero el nif deberá aparecer en dos columnas, 
	 * una mostrará únicamente los dígitos del nif y la otra la letra.
	 */
	@Test
	void test3() {
	
		EmpleadoDAO empHome = new EmpleadoDAOImpl();
		try {
			((EmpleadoDAOImpl)empHome).beginTransaction();
		
			List<Empleado> listEmp = empHome.findAll();	

			listEmp.stream()
					.map(e -> "Codigo: " + e.getCodigo() +
							" NumeroNIF: " + e.getNif().substring(0,8) +
							" LetraNIF: " + e.getNif().substring(8))
					.forEach(System.out::println);
			
		}
		catch (RuntimeException e) {
			((EmpleadoDAOImpl)empHome).rollbackTransaction();
		    throw e; // or display error message
		}
	}
	
	/**
	 * 4. Lista el nombre de cada departamento y el valor del presupuesto actual del que dispone. 
	 * Para calcular este dato tendrá que restar al valor del presupuesto inicial (columna presupuesto)
	 * los gastos que se han generado (columna gastos).
	 *  Tenga en cuenta que en algunos casos pueden existir valores negativos, para darle una salida correcta.
	 */
	@Test
	void test4() {
		
		DepartamentoDAO depHome = new DepartamentoDAOImpl();
		
		try {
			((DepartamentoDAOImpl)depHome).beginTransaction();
	
			List<Departamento> listDep = depHome.findAll();
			
			listDep.stream()
					.map(d -> {
						String text = "Nombre: " + d.getNombre() +
								" Presupuesto: ";

						double	pres = d.getPresupuesto() - d.getGastos();

						if (pres < 0){
							text += "0.0";
						} else {
							text += pres;
						}

						return text;
					})
					.forEach(System.out::println);

		}
		catch (RuntimeException e) {
			((DepartamentoDAOImpl)depHome).rollbackTransaction();
		    throw e; // or display error message
		}
	}
	
	/**
	 * 5. Lista el nombre de los departamentos y el valor del presupuesto actual
	 * ordenado de forma ascendente.
	 */
	@Test
	void test5() {
		
		DepartamentoDAO depHome = new DepartamentoDAOImpl();
		
		try {
			((DepartamentoDAOImpl)depHome).beginTransaction();
	
			List<Departamento> listDep = depHome.findAll();

			listDep.stream()
					.sorted((d1,d2) -> (int)(d2.getPresupuesto() - d2.getGastos()) - (int) (d1.getPresupuesto() - d1.getGastos()))
					.map(d -> {
						String text = "Nombre: " + d.getNombre() +
								" Presupuesto: ";

						double	pres = d.getPresupuesto() - d.getGastos();

						if (pres < 0){
							text += "0.0";
						} else {
							text += pres;
						}

						return text;
					})
					.forEach(System.out::println);

		}
		catch (RuntimeException e) {
			((DepartamentoDAOImpl)depHome).rollbackTransaction();
		    throw e; // or display error message
		}
	}
	
	/**
	 * 6. Devuelve una lista con el nombre y el presupuesto, de los 3 departamentos
	 * que tienen mayor presupuesto
	 */
	@Test
	void test6() {
		
		DepartamentoDAO depHome = new DepartamentoDAOImpl();
		
		try {
			((DepartamentoDAOImpl)depHome).beginTransaction();
	
			List<Departamento> listDep = depHome.findAll();
			
			listDep.stream()
					.sorted(Comparator.comparing(Departamento::getPresupuesto).reversed())
					.map(d -> "Nombre: " + d.getNombre() + " Presupuesto: " + d.getPresupuesto())
					.limit(3)
					.forEach(System.out::println);

		}
		catch (RuntimeException e) {
			((DepartamentoDAOImpl)depHome).rollbackTransaction();
		    throw e; // or display error message
		}
	}
	
	/**
	 * 7. Devuelve una lista con el nombre de los departamentos y el presupesto,
	 * de aquellos que tienen un presupuesto entre 100000 y 200000 euros
	 */
	@Test
	void test7() {
		
		DepartamentoDAO depHome = new DepartamentoDAOImpl();
		
		try {
			((DepartamentoDAOImpl)depHome).beginTransaction();
	
			List<Departamento> listDep = depHome.findAll();
			
			listDep.stream()
					.filter(d -> d.getPresupuesto() >= 100000 && d.getPresupuesto() <=200000)
					.map(d -> "Nombre: " + d.getNombre() + " Presupuesto: " + d.getPresupuesto())
					.forEach(System.out::println);

		}
		catch (RuntimeException e) {
			((DepartamentoDAOImpl)depHome).rollbackTransaction();
		    throw e; // or display error message
		}
	}
	
	/**
	 * 8. Devuelve una lista con 5 filas a partir de la tercera fila de empleado ordenado
	 * por código de empleado. La tercera fila se debe incluir en la respuesta.
	 */
	@Test
	void test8() {
	
		EmpleadoDAO empHome = new EmpleadoDAOImpl();
		try {
			((EmpleadoDAOImpl)empHome).beginTransaction();
		
			List<Empleado> listEmp = empHome.findAll();	

			listEmp.stream()
					.sorted(Comparator.comparing(Empleado::getCodigo))
					.skip(2)
					.limit(5)
					.map(Empleado::getCodigo)
					.forEach(System.out::println);

		}
		catch (RuntimeException e) {
			((EmpleadoDAOImpl)empHome).rollbackTransaction();
		    throw e; // or display error message
		}	
	
	}
	
	/**
	 * 9. Devuelve una lista con el nombre de los departamentos y el gasto,
	 * de aquellos que tienen menos de 5000 euros de gastos.
	 * Ordenada de mayor a menor gasto.
	 */
	@Test
	void test9() {
		
		DepartamentoDAO depHome = new DepartamentoDAOImpl();
		
		try {
			((DepartamentoDAOImpl)depHome).beginTransaction();
	
			List<Departamento> listDep = depHome.findAll();
			
			listDep.stream()
					.filter(d -> d.getGastos() < 5000)
					.sorted(Comparator.comparing(Departamento::getGastos).reversed())
					.map(d -> "Nombre: " + d.getNombre() + " Gastos: " + d.getGastos())
					.forEach(System.out::println);

		}
		catch (RuntimeException e) {
			((DepartamentoDAOImpl)depHome).rollbackTransaction();
		    throw e; // or display error message
		}
	}
	
	/**
	 * 10. Lista todos los datos de los empleados cuyo segundo apellido sea Díaz o Moreno
	 */
	@Test
	void test10() {
	
		EmpleadoDAO empHome = new EmpleadoDAOImpl();
		try {
			((EmpleadoDAOImpl)empHome).beginTransaction();
		
			List<Empleado> listEmp = empHome.findAll();	

			listEmp.stream()
					.filter(e -> e.getApellido2() != null)
					.filter(e -> "Moreno".equals(e.getApellido2()) || "Díaz".equals(e.getApellido2()))
					.forEach(System.out::println);

		}
		catch (RuntimeException e) {
			((EmpleadoDAOImpl)empHome).rollbackTransaction();
		    throw e; // or display error message
		}	
	
	}
	
	/**
	 * 11. Lista los nombres, apellidos y nif de los empleados que
	 * trabajan en los departamentos 2, 4 o 5
	 */
	@Test
	void test11() {
	
		EmpleadoDAO empHome = new EmpleadoDAOImpl();
		try {
			((EmpleadoDAOImpl)empHome).beginTransaction();
		
			List<Empleado> listEmp = empHome.findAll();	

			listEmp.stream()
					.filter(e -> e.getDepartamento() != null)
					.filter(e -> e.getDepartamento().getCodigo() == 2 ||
							e.getDepartamento().getCodigo() == 4 ||
							e.getDepartamento().getCodigo() == 5)
					.map(e -> {
						String apellido2 = "";
						if (e.getApellido2() != null) { apellido2 = e.getApellido2();}

								String text = "Nombre: " + e.getNombre() +
										" Apellido1: " + e.getApellido1() +
										" Apellido2: " + apellido2 +
										" NIF: " + e.getNif();
							return text;
					})
					.forEach(System.out::println);

		}
		catch (RuntimeException e) {
			((EmpleadoDAOImpl)empHome).rollbackTransaction();
		    throw e; // or display error message
		}	
	
	}

	/**
	 * 12. Devuelve el nombre del departamento donde trabaja el empleado
	 * que tiene el nif 38382980M
	 */
	@Test
	void test12() {
	
		EmpleadoDAO empHome = new EmpleadoDAOImpl();
		try {
			((EmpleadoDAOImpl)empHome).beginTransaction();
		
			List<Empleado> listEmp = empHome.findAll();	

			listEmp.stream()
					.filter(e -> "38382980M".equals(e.getNif()))
					.map(e -> e.getDepartamento().getNombre())
					.forEach(System.out::println);

		}
		catch (RuntimeException e) {
			((EmpleadoDAOImpl)empHome).rollbackTransaction();
		    throw e; // or display error message
		}
	}
	
	/**
	 * 13. Devuelve una lista con el nombre de los empleados que tienen los departamentos 
	 * que no tienen un presupuesto entre 100000 y 200000 euros.
	 */
	@Test
	void test13() {
	
		EmpleadoDAO empHome = new EmpleadoDAOImpl();
		try {
			((EmpleadoDAOImpl)empHome).beginTransaction();
		
			List<Empleado> listEmp = empHome.findAll();	

			listEmp.stream()
					.filter(e -> e.getDepartamento() != null)
					.filter(e -> e.getDepartamento().getPresupuesto() < 100000 ||
							e.getDepartamento().getPresupuesto() > 200000)
					.map(Empleado::getNombre)
					.forEach(System.out::println);

		}
		catch (RuntimeException e) {
			((EmpleadoDAOImpl)empHome).rollbackTransaction();
		    throw e; // or display error message
		}
	}
	
	/**
	 * 14. Calcula el valor máximo y mínimo del presupuesto de los departamentos.
	 * Debes indicar el nombre del departamento junto con el valor y, a continuación, la palabra
	 * MÁXIMO o MÍNIMO en cada caso.
	 */
	@Test
	void test14() {
		
		DepartamentoDAO depHome = new DepartamentoDAOImpl();
		
		try {
			((DepartamentoDAOImpl)depHome).beginTransaction();
	
			List<Departamento> listDep = depHome.findAll();
			
			listDep.stream()
					.max(Comparator.comparing(Departamento::getPresupuesto))
					.map(d -> "Nombre: " + d.getNombre() + " " + d.getPresupuesto() + " MAXIMO")
					.ifPresent(System.out::println);

			listDep.stream()
					.min(Comparator.comparing(Departamento::getPresupuesto))
					.map(d -> "Nombre: " + d.getNombre() + " " + d.getPresupuesto() + " MINIMO")
					.ifPresent(System.out::println);

		}
		catch (RuntimeException e) {
			((DepartamentoDAOImpl)depHome).rollbackTransaction();
		    throw e; // or display error message
		}
	}
	
	/**
	 * 15. Calcula el número de empleados que hay en cada departamento. 
	 * Tienes que devolver dos columnas, una con el nombre del departamento 
	 * y otra con el número de empleados que tiene asignados.
	 */
	@Test
	void test15() {
		
		DepartamentoDAO depHome = new DepartamentoDAOImpl();
		
		try {
			((DepartamentoDAOImpl)depHome).beginTransaction();
	
			List<Departamento> listDep = depHome.findAll();
			
			listDep.stream()
					.map(d -> "Nombre: " + d.getNombre() +
							" Numero de empleados: " + d.getEmpleados().size())
					.forEach(System.out::println);

		}
		catch (RuntimeException e) {
			((DepartamentoDAOImpl)depHome).rollbackTransaction();
		    throw e; // or display error message
		}
	}
	
	/**
	 * 16. Calcula el número total de empleados que trabajan en cada
	 * unos de los departamentos que tienen un presupuesto mayor a 200000 euros.
	 */
	@Test
	void test16() {
		
		DepartamentoDAO depHome = new DepartamentoDAOImpl();
		
		try {
			((DepartamentoDAOImpl)depHome).beginTransaction();
	
			List<Departamento> listDep = depHome.findAll();

			int suma = listDep.stream()
					.filter(d -> d.getPresupuesto() > 200000)
					.mapToInt(d -> d.getEmpleados().size())
					.sum();

			System.out.println("Suma empleados: " + suma);
		}
		catch (RuntimeException e) {
			((DepartamentoDAOImpl)depHome).rollbackTransaction();
		    throw e; // or display error message
		}
	}
	
	/**
	 * 17. Calcula el nombre de los departamentos que tienen más de 2 empleados. 
	 * El resultado debe tener dos columnas, una con el nombre del departamento y
	 *  otra con el número de empleados que tiene asignados
	 */
	@Test
	void test17() {
		
		DepartamentoDAO depHome = new DepartamentoDAOImpl();
		
		try {
			((DepartamentoDAOImpl)depHome).beginTransaction();
	
			List<Departamento> listDep = depHome.findAll();

			listDep.stream()
					.filter(d -> d.getEmpleados().size() > 2)
					.map(d -> "Nombre: " + d.getNombre() + " Numero empleados: " + d.getEmpleados().size())
					.forEach(System.out::println);

		}
		catch (RuntimeException e) {
			((DepartamentoDAOImpl)depHome).rollbackTransaction();
		    throw e; // or display error message
		}
	}
	
	/** 18. Lista todos los nombres de departamentos junto con los nombres y apellidos
	 * de los empleados.
	 */
	@Test
	void test18() {
		
		DepartamentoDAO depHome = new DepartamentoDAOImpl();
		StringBuilder cadena = new StringBuilder();
		
		try {
			((DepartamentoDAOImpl)depHome).beginTransaction();
	
			List<Departamento> listDep = depHome.findAll();

			listDep.stream()
					.map(d -> "Nombre: " + d.getNombre() + " " +
							d.getEmpleados().stream()
									.map(e -> {
										String apellido2 = "";
										if (e.getApellido2() != null) { apellido2 = e.getApellido2();}

										String text = "Nombre: " + e.getNombre() +
												" Apellido1: " + e.getApellido1() +
												" Apellido2: " + apellido2 +
												" NIF: " + e.getNif();
										return text;
									}).toList())
					.forEach(System.out::println);


		}
		catch (RuntimeException e) {
			((DepartamentoDAOImpl)depHome).rollbackTransaction();
		    throw e; // or display error message
		}
	}
	
	/**
	 * 19. Devuelve la media de empleados que trabajan en los departamentos
	 */
	@Test
	void test19() {
		
		DepartamentoDAO depHome = new DepartamentoDAOImpl();
		
		try {
			((DepartamentoDAOImpl)depHome).beginTransaction();
	
			List<Departamento> listDep = depHome.findAll();
			
			 listDep.stream()
					.mapToDouble(d -> d.getEmpleados().size())
					.average().ifPresent(System.out::println);

		}
		catch (RuntimeException e) {
			((DepartamentoDAOImpl)depHome).rollbackTransaction();
		    throw e; // or display error message
		}
	}
	
	/**
	 * 20. Muestra el nombre de los departamentos y los empleados (en otra fila) de aquellos departamentos
	 * cuyo presupuesto sea inferior a la media de los presupuestos.
	 */
	@Test
	void test20() {
		
		DepartamentoDAO depHome = new DepartamentoDAOImpl();
		
		try {
			((DepartamentoDAOImpl)depHome).beginTransaction();
	
			List<Departamento> listDep = depHome.findAll();

			OptionalDouble media = listDep.stream()
							.mapToDouble(Departamento::getPresupuesto)
									.average();
			
			listDep.stream()
					.filter(d -> d.getPresupuesto() < media.getAsDouble())
					.map(d -> "Nombre: " + d.getNombre() + "\n" +
							d.getEmpleados().stream().map(e -> "Nombre Empleado: " + e.getNombre()).toList())
					.forEach(System.out::println);

		}
		catch (RuntimeException e) {
			((DepartamentoDAOImpl)depHome).rollbackTransaction();
		    throw e; // or display error message
		}
	}
}
