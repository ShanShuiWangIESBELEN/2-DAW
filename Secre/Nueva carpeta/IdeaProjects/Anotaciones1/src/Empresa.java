import java.util.List;

@Empleados(empleados = {
        @EmpleadoAnotado(nombre = "Pablo" , apellidos = "Borrego", dni = "4326482", clase = "Directivo",direccion = "faefa", telefono = "3424242", codigoDespacho = 2),
        @EmpleadoAnotado(nombre = "Javi" , apellidos = "Gil", dni = "52347475", clase = "Tecnico",direccion = "gsahs", telefono = "1242385", codigoTaller = 5, perfil = "dgga<jh") ,
        @EmpleadoAnotado(nombre = "Adri" , apellidos = "Marin", dni = "97961412", clase = "Oficial",direccion = "uyfauygf", telefono = "89379742",  codigoTaller = 4, categoria = "sgdjga")
})

public class Empresa {

    public static String DIRECTIVO = "Directivo";
    public static String TECNICO = "Tecnico";

    public static String OFICIAL = "Oficial";

    private String nombre;

    private List<Empleado> empleados;
    public Empresa(String nombre) {
        this.nombre = nombre;
    }

    public static Empresa cargadorDeContexto(){

        Empresa empresa = new Empresa("Flores");

        EmpleadoAnotado[] anotadoEmpleados = Empresa.class.getAnnotationsByType(EmpleadoAnotado.class);

        for (EmpleadoAnotado anotadoEmpleado: anotadoEmpleados) {
            if (Empresa.DIRECTIVO.equals(anotadoEmpleado.clase())) {
                System.out.println(Empresa.DIRECTIVO);
                Directivo directivo = new Directivo();
                directivo.setNombre(anotadoEmpleado.nombre());
                directivo.setCodigoDirectivo(anotadoEmpleado.codigoDespacho());
                directivo.setApellidos(anotadoEmpleado.apellidos());
                directivo.setDni(anotadoEmpleado.dni());
                directivo.setDireccion(anotadoEmpleado.direccion());
                directivo.setTelefono(anotadoEmpleado.telefono());
                empresa.
            } else if (Empresa.OFICIAL.equals(anotadoEmpleado.clase())) {
                System.out.println(Empresa.OFICIAL);
                Oficial oficial = new Oficial();
                oficial.setNombre(anotadoEmpleado.nombre());
                oficial.setApellidos(anotadoEmpleado.apellidos());
                oficial.setDni(anotadoEmpleado.dni());
                oficial.setDireccion(anotadoEmpleado.direccion());
                oficial.setTelefono(anotadoEmpleado.telefono());
            }
        }

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
