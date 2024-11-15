package org.iesbelen.streams.tests;


import java.util.Comparator;
import java.util.List;


import org.iesbelen.streams.dao.DepartamentoDAO;
import org.iesbelen.streams.dao.DepartamentoDAOImpl;
import org.iesbelen.streams.dao.EmpleadoDAO;
import org.iesbelen.streams.dao.EmpleadoDAOImpl;
import org.iesbelen.streams.entity.Departamento;
import org.iesbelen.streams.entity.Empleado;
import org.junit.jupiter.api.Test;

import static java.util.Comparator.comparing;

class EmpleadosStreamTests {

    @Test
    void testSkeletonDepartamento() {

        DepartamentoDAO depHome = new DepartamentoDAOImpl();

        try {
            ((DepartamentoDAOImpl) depHome).beginTransaction();

            List<Departamento> listDep = depHome.findAll();


            //TODO STREAMS

        } catch (RuntimeException e) {
            ((DepartamentoDAOImpl) depHome).rollbackTransaction();
            throw e; // or display error message
        }
    }


    @Test
    void testSkeletonEmpleado() {

        EmpleadoDAO empHome = new EmpleadoDAOImpl();
        try {
            ((EmpleadoDAOImpl) empHome).beginTransaction();

            List<Empleado> listProd = empHome.findAll();

            //TODO STREAMS

        } catch (RuntimeException e) {
            ((EmpleadoDAOImpl) empHome).rollbackTransaction();
            throw e; // or display error message
        }
    }

    @Test
    void testAllDepartamento() {

        DepartamentoDAO depHome = new DepartamentoDAOImpl();

        try {
            ((DepartamentoDAOImpl) depHome).beginTransaction();

            List<Departamento> listDep = depHome.findAll();
            listDep.forEach(System.out::println);

        } catch (RuntimeException e) {
            ((DepartamentoDAOImpl) depHome).rollbackTransaction();
            throw e; // or display error message
        }
    }

    @Test
    void testAllEmpleado() {

        EmpleadoDAO empHome = new EmpleadoDAOImpl();
        try {
            ((EmpleadoDAOImpl) empHome).beginTransaction();

            List<Empleado> listEmp = empHome.findAll();
            listEmp.forEach(System.out::println);

        } catch (RuntimeException e) {
            ((EmpleadoDAOImpl) empHome).rollbackTransaction();
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
            ((EmpleadoDAOImpl) empHome).beginTransaction();

            List<Empleado> listEmp = empHome.findAll();

            listEmp.stream()
                    .filter(empleado -> empleado.getDepartamento() != null)
                    .map(empleado -> empleado.getDepartamento().getCodigo())
                    .distinct()
                    .forEach(System.out::println);

        } catch (RuntimeException e) {
            ((EmpleadoDAOImpl) empHome).rollbackTransaction();
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
            ((EmpleadoDAOImpl) empHome).beginTransaction();

            List<Empleado> listEmp = empHome.findAll();

            listEmp.stream()
                    .filter(empleado -> empleado.getApellido2() != null)
                    .map(empleado -> empleado.getNombre().toUpperCase() + " " + empleado.getApellido1().toUpperCase()
                            + " " + empleado.getApellido2().toUpperCase())
                    .forEach(System.out::println);

        } catch (RuntimeException e) {
            ((EmpleadoDAOImpl) empHome).rollbackTransaction();
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
            ((EmpleadoDAOImpl) empHome).beginTransaction();

            List<Empleado> listEmp = empHome.findAll();
            listEmp.stream()
                    .filter(empleado -> empleado.getNif() != null)
                    .map(empleado -> empleado.getCodigo() + " " + empleado.getNif().substring(0, 8) + " " + empleado.getNif().substring(8))
                    .forEach(System.out::println);

            //

        } catch (RuntimeException e) {
            ((EmpleadoDAOImpl) empHome).rollbackTransaction();
            throw e; // or display error message
        }
    }

    /**
     * 4. Lista el nombre de cada departamento y el valor del presupuesto actual del que dispone.
     * Para calcular este dato tendrá que restar al valor del presupuesto inicial (columna presupuesto)
     * los gastos que se han generado (columna gastos).
     * Tenga en cuenta que en algunos casos pueden existir valores negativos, para darle una salida correcta.
     */
    @Test
    void test4() {

        DepartamentoDAO depHome = new DepartamentoDAOImpl();

        try {
            ((DepartamentoDAOImpl) depHome).beginTransaction();

            List<Departamento> listDep = depHome.findAll();
            listDep.stream()
                    .filter(departamento -> departamento.getGastos() != 0)
                    .map(departamento -> departamento.getNombre() + " " + (departamento.getPresupuesto() - departamento.getGastos()))
                    .forEach(System.out::println);

        } catch (RuntimeException e) {
            ((DepartamentoDAOImpl) depHome).rollbackTransaction();
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
            ((DepartamentoDAOImpl) depHome).beginTransaction();

            List<Departamento> listDep = depHome.findAll();
            listDep.stream()
                    .filter(departamento -> departamento.getPresupuesto() - departamento.getGastos() != 0)
                    .map(departamento -> departamento.getNombre() + " " + (departamento.getPresupuesto() - departamento.getGastos()))
                    .sorted()
                    .forEach(System.out::println);

            //

        } catch (RuntimeException e) {
            ((DepartamentoDAOImpl) depHome).rollbackTransaction();
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
            ((DepartamentoDAOImpl) depHome).beginTransaction();

            List<Departamento> listDep = depHome.findAll();
            listDep.stream()
                    //Yo aqui deduzco que el presupuesto es lo que viene en la tabla
                    .filter(departamento -> departamento.getPresupuesto() != 0)
                    .sorted(Comparator.comparing(Departamento::getPresupuesto).reversed())
                    .map(departamento -> departamento.getNombre() + " " + departamento.getPresupuesto())
                    .limit(3)
                    .forEach(System.out::println);


            //

        } catch (RuntimeException e) {
            ((DepartamentoDAOImpl) depHome).rollbackTransaction();
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
            ((DepartamentoDAOImpl) depHome).beginTransaction();

            List<Departamento> listDep = depHome.findAll();

            listDep.stream()
                    .filter(departamento -> departamento.getPresupuesto() >= 100000 && departamento.getPresupuesto() <= 200000)
                    .map(departamento -> departamento.getNombre() + " " + departamento.getPresupuesto())
                    .forEach(System.out::println);

            //

        } catch (RuntimeException e) {
            ((DepartamentoDAOImpl) depHome).rollbackTransaction();
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
            ((EmpleadoDAOImpl) empHome).beginTransaction();

            List<Empleado> listEmp = empHome.findAll();

            listEmp.stream()
                    .sorted(Comparator.comparing(Empleado::getCodigo))
                    .limit(5)
                    .skip(2)
                    .forEach(System.out::println);

            //

        } catch (RuntimeException e) {
            ((EmpleadoDAOImpl) empHome).rollbackTransaction();
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
            ((DepartamentoDAOImpl) depHome).beginTransaction();

            List<Departamento> listDep = depHome.findAll();

            listDep.stream()
                    .filter(departamento -> departamento.getGastos() < 5000)
                    .sorted(Comparator.comparing(Departamento::getGastos).reversed())
                    .map(departamento -> departamento.getNombre() + " " + departamento.getGastos())
                    .forEach(System.out::println);
            //

        } catch (RuntimeException e) {
            ((DepartamentoDAOImpl) depHome).rollbackTransaction();
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
            ((EmpleadoDAOImpl) empHome).beginTransaction();

            List<Empleado> listEmp = empHome.findAll();
            listEmp.stream()
                    .filter(empleado -> empleado.getApellido2() != null)
                    .filter(empleado -> empleado.getApellido2().equals("Díaz") || empleado.getApellido2().equals("Moreno"))
                    .forEach(System.out::println);


            //

        } catch (RuntimeException e) {
            ((EmpleadoDAOImpl) empHome).rollbackTransaction();
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
            ((EmpleadoDAOImpl) empHome).beginTransaction();

            List<Empleado> listEmp = empHome.findAll();

            listEmp.stream()
                    .filter(empleado -> empleado.getDepartamento() != null)
                    .filter(empleado -> empleado.getDepartamento().getCodigo() == 2
                            || empleado.getDepartamento().getCodigo() == 4
                            || empleado.getDepartamento().getCodigo() == 5)
                    .map(empleado -> empleado.getNombre() + " " + empleado.getApellido1() + " " + empleado.getApellido2() + " " + empleado.getNif())
                    .forEach(System.out::println);
            //

        } catch (RuntimeException e) {
            ((EmpleadoDAOImpl) empHome).rollbackTransaction();
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
            ((EmpleadoDAOImpl) empHome).beginTransaction();

            List<Empleado> listEmp = empHome.findAll();
            listEmp.stream()
                    .filter(empleado -> empleado.getNif().equals("38382980M"))
                    .map(empleado -> empleado.getDepartamento().getNombre())
                    .forEach(System.out::println);

            //

        } catch (RuntimeException e) {
            ((EmpleadoDAOImpl) empHome).rollbackTransaction();
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
            ((EmpleadoDAOImpl) empHome).beginTransaction();

            List<Empleado> listEmp = empHome.findAll();
            listEmp.stream()
                    .filter(empleado ->empleado.getDepartamento() != null)
                    .filter(empleado -> empleado.getDepartamento().getPresupuesto()<100000 || empleado.getDepartamento().getPresupuesto()>200000)
                    .map(Empleado::getNombre)
					.forEach(System.out::println);

            //

        } catch (RuntimeException e) {
            ((EmpleadoDAOImpl) empHome).rollbackTransaction();
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
            ((DepartamentoDAOImpl) depHome).beginTransaction();

            List<Departamento> listDep = depHome.findAll();

            //

        } catch (RuntimeException e) {
            ((DepartamentoDAOImpl) depHome).rollbackTransaction();
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
            ((DepartamentoDAOImpl) depHome).beginTransaction();

            List<Departamento> listDep = depHome.findAll();

            listDep.stream()
                    .map(departamento -> departamento.getNombre() +" "+departamento.getEmpleados().size())
					.forEach(System.out::println);
            //

        } catch (RuntimeException e) {
            ((DepartamentoDAOImpl) depHome).rollbackTransaction();
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
            ((DepartamentoDAOImpl) depHome).beginTransaction();

            List<Departamento> listDep = depHome.findAll();

			listDep.stream()
                    .filter(departamento ->departamento.getPresupuesto()>200000)
					.map(departamento -> departamento.getNombre() +" "+ departamento.getEmpleados().size())
					.forEach(System.out::println);

            //

        } catch (RuntimeException e) {
            ((DepartamentoDAOImpl) depHome).rollbackTransaction();
            throw e; // or display error message
        }
    }

    /**
     * 17. Calcula el nombre de los departamentos que tienen más de 2 empleados.
     * El resultado debe tener dos columnas, una con el nombre del departamento y
     * otra con el número de empleados que tiene asignados
     */
    @Test
    void test17() {

        DepartamentoDAO depHome = new DepartamentoDAOImpl();

        try {
            ((DepartamentoDAOImpl) depHome).beginTransaction();

            List<Departamento> listDep = depHome.findAll();

			listDep.stream()
					.filter(departamento ->departamento.getEmpleados().size()>2)
					.map(departamento -> departamento.getNombre() +" "+departamento.getEmpleados().size())
					.forEach(System.out::println);

            //

        } catch (RuntimeException e) {
            ((DepartamentoDAOImpl) depHome).rollbackTransaction();
            throw e; // or display error message
        }
    }

    /**
     * 18. Lista todos los nombres de departamentos junto con los nombres y apellidos
     * de los empleados.
     */
    @Test
    void test18() {

        DepartamentoDAO depHome = new DepartamentoDAOImpl();
        StringBuilder cadena = new StringBuilder();

        try {
            ((DepartamentoDAOImpl) depHome).beginTransaction();

            List<Departamento> listDep = depHome.findAll();


            //

        } catch (RuntimeException e) {
            ((DepartamentoDAOImpl) depHome).rollbackTransaction();
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
            ((DepartamentoDAOImpl) depHome).beginTransaction();

            List<Departamento> listDep = depHome.findAll();

            listDep.stream()
					.map(departamento -> departamento.getEmpleados().size())
					.mapToDouble(Integer::doubleValue)
					.average()
					.ifPresent(System.out::println);

            //

        } catch (RuntimeException e) {
            ((DepartamentoDAOImpl) depHome).rollbackTransaction();
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
            ((DepartamentoDAOImpl) depHome).beginTransaction();

            List<Departamento> listDep = depHome.findAll();

            //

        } catch (RuntimeException e) {
            ((DepartamentoDAOImpl) depHome).rollbackTransaction();
            throw e; // or display error message
        }
    }
}
