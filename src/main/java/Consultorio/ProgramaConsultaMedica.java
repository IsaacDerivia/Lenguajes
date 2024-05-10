package Consultorio;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Paciente {
    private String nombre;
    private String apellido;
    private String fechaNacimiento;
    private String telefono;
    private String direccion;
    private String historial;

    public Paciente(String nombre, String apellido, String fechaNacimiento, String telefono, String direccion) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNacimiento = fechaNacimiento;
        this.telefono = telefono;
        this.direccion = direccion;
        this.historial = "";
    }


    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getHistorial() {
        return historial;
    }

    public void agregarHistorial(String entrada) {
        historial += entrada + "\n";
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre + " " + apellido +
                "\nFecha de Nacimiento: " + fechaNacimiento +
                "\nTeléfono: " + telefono +
                "\nDirección: " + direccion;
    }
}

class ConsultaMedica {
    private Paciente paciente;
    private String fecha;
    private String motivo;
    private String diagnostico;

    public ConsultaMedica(Paciente paciente, String fecha, String motivo) {
        this.paciente = paciente;
        this.fecha = fecha;
        this.motivo = motivo;
        this.diagnostico = "";
    }

    // Getters y setters

    public Paciente getPaciente() {
        return paciente;
    }

    public String getFecha() {
        return fecha;
    }

    public String getMotivo() {
        return motivo;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

    @Override
    public String toString() {
        return "Consulta Médica" +
                "\nPaciente: " + paciente.getNombre() + " " + paciente.getApellido() +
                "\nFecha: " + fecha +
                "\nMotivo: " + motivo +
                "\nDiagnóstico: " + diagnostico;
    }
}

public class ProgramaConsultaMedica {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Paciente> pacientes = new ArrayList<>();
        List<ConsultaMedica> consultas = new ArrayList<>();

        int opcion;
        do {
            System.out.println("\n=== Sistema de Consulta Médica ===");
            System.out.println("1. Agregar Paciente");
            System.out.println("2. Agendar Consulta");
            System.out.println("3. Registrar Diagnóstico");
            System.out.println("4. Mostrar Pacientes");
            System.out.println("5. Mostrar Consultas");
            System.out.println("6. Salir");
            System.out.print("Ingrese la opción deseada: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer

            switch (opcion) {
                case 1:
                    agregarPaciente(scanner, pacientes);
                    break;
                case 2:
                    agendarConsulta(scanner, pacientes, consultas);
                    break;
                case 3:
                    registrarDiagnostico(scanner, consultas);
                    break;
                case 4:
                    mostrarPacientes(pacientes);
                    break;
                case 5:
                    mostrarConsultas(consultas);
                    break;
                case 6:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción inválida. Por favor, ingrese una opción válida.");
            }
        } while (opcion != 6);

        scanner.close();
    }

    public static void agregarPaciente(Scanner scanner, List<Paciente> pacientes) {
        boolean salir = false;
        //se crean las variables para almacenar los datos del paciente
        String nombre = "";
        String apellido = "";
        String fechaNacimiento = "";
        String telefono = "";
        String direccion = "";

        do {
            // Se solicita al usuario que ingrese los datos del paciente, todas las validaciones se hacen en el método
            System.out.println("\n=== Agregar Paciente ===");

            System.out.print("Ingrese el nombre del paciente: ");
            nombre = scanner.nextLine();
            //se valida que el nombre solo contenga letras
            if (!nombre.matches("[a-zA-Z]+")) {
                System.out.println("El nombre solo puede contener letras.");
                continue;
            }

            System.out.print("Ingrese el apellido del paciente: ");
            apellido = scanner.nextLine();
            //se valida que el apellido solo contengan letras
            if (!apellido.matches("[a-zA-Z]+")) {
                System.out.println("El apellido solo puede contener letras.");
                continue;
            }

            System.out.print("Ingrese la fecha de nacimiento del paciente (dd/mm/aaaa): ");
            fechaNacimiento = scanner.nextLine();
            // Se valida que la fecha de nacimiento tenga el formato correcto
            if (!fechaNacimiento.matches("\\d{2}/\\d{2}/\\d{4}")) {
                System.out.println("El formato de la fecha de nacimiento no es válido. Debe ser dd/mm/aaaa.");
                continue;
            }

            System.out.print("Ingrese el teléfono del paciente: ");
            telefono = scanner.nextLine();
            // Se valida que el teléfono tenga solo números
            if (!telefono.matches("\\d+")) {
                System.out.println("El teléfono solo puede contener números.");
                continue;
            }

            System.out.print("Ingrese la dirección del paciente: ");
            direccion = scanner.nextLine();
            // validaciones de los datos ingresados
            if (direccion.isEmpty()) {
                System.out.println("La dirección es obligatoria.");
                continue;
            }

            salir = true;

        } while (!salir);





        // Se crea un objeto de tipo Paciente con los datos ingresados por el usuario
        Paciente paciente = new Paciente(nombre, apellido, fechaNacimiento, telefono, direccion);
        pacientes.add(paciente);
        System.out.println("Paciente agregado correctamente.");




    }

    /**
     * Este método se utiliza para agendar una consulta médica para un paciente.
     *
     * @param scanner   El objeto Scanner se utiliza para obtener la entrada del usuario.
     * @param pacientes La lista de pacientes registrados.
     * @param consultas La lista de consultas médicas agendadas.
     */
    public static void agendarConsulta(Scanner scanner, List<Paciente> pacientes, List<ConsultaMedica> consultas) {
        System.out.println("\n=== Agendar Consulta ===");

        // Verificar si hay pacientes registrados
        if (pacientes.isEmpty()) {
            System.out.println("No hay pacientes registrados. Por favor, registre un paciente primero.");
            return;
        }

        // Mostrar la lista de pacientes registrados
        System.out.println("Pacientes registrados:");
        for (int i = 0; i < pacientes.size(); i++) {
            System.out.println((i + 1) + ". " + pacientes.get(i).getNombre() + " " + pacientes.get(i).getApellido());
        }

        // Solicitar al usuario que seleccione un paciente
        System.out.print("Seleccione el número de paciente para agendar la consulta: ");
        int indicePaciente = scanner.nextInt();

        // Validar la entrada del usuario
        if (indicePaciente < 1 || indicePaciente > pacientes.size()) {
            System.out.println("Número de paciente no válido.");
            return;
        }

        // Limpiar el buffer
        scanner.nextLine();

        // Obtener el paciente seleccionado
        Paciente paciente = pacientes.get(indicePaciente - 1);

        // Solicitar al usuario que ingrese la fecha de la consulta
        System.out.print("Ingrese la fecha de la consulta (dd/mm/aaaa): ");
        String fechaConsulta = scanner.nextLine();

        // Validar la fecha de la consulta
        if (!fechaConsulta.matches("\\d{2}/\\d{2}/\\d{4}")) {
            System.out.println("Formato de fecha no válido. Debe ser dd/mm/aaaa.");
            return;
        }

        // Solicitar al usuario que ingrese el motivo de la consulta
        System.out.print("Ingrese el motivo de la consulta: ");
        String motivoConsulta = scanner.nextLine();

        // Crear una nueva consulta médica y agregarla a la lista de consultas
        ConsultaMedica consulta = new ConsultaMedica(paciente, fechaConsulta, motivoConsulta);
        consultas.add(consulta);

        System.out.println("Consulta agendada correctamente.");
    }


    /**
     * Este método se utiliza para registrar un diagnóstico para una consulta médica.
     *
     * @param scanner   El objeto Scanner se utiliza para obtener la entrada del usuario.
     * @param consultas La lista de consultas médicas agendadas.
     */
    public static void registrarDiagnostico(Scanner scanner, List<ConsultaMedica> consultas) {
        System.out.println("\n=== Registrar Diagnóstico ===");

        // Verificar si hay consultas agendadas
        if (consultas.isEmpty()) {
            System.out.println("No hay consultas agendadas.");
            return;
        }

        // Mostrar la lista de consultas agendadas
        System.out.println("Consultas agendadas:");
        for (int i = 0; i < consultas.size(); i++) {
            System.out.println((i + 1) + ". " + consultas.get(i).getPaciente().getNombre() + " " +
                    consultas.get(i).getPaciente().getApellido() + " - " + consultas.get(i).getFecha());
        }

        // Solicitar al usuario que seleccione una consulta
        System.out.print("Seleccione el número de consulta para registrar el diagnóstico: ");
        int indiceConsulta = scanner.nextInt();

        // Validar la entrada del usuario
        if (indiceConsulta < 1 || indiceConsulta > consultas.size()) {
            System.out.println("Número de consulta no válido.");
            return;
        }

        // Limpiar el buffer
        scanner.nextLine();

        // Obtener la consulta seleccionada
        ConsultaMedica consulta = consultas.get(indiceConsulta - 1);

        // Solicitar al usuario que ingrese el diagnóstico de la consulta
        System.out.print("Ingrese el diagnóstico de la consulta: ");
        String diagnostico = scanner.nextLine();

        // Validar que el diagnóstico no esté vacío
        if (diagnostico.isEmpty()) {
            System.out.println("El diagnóstico no puede estar vacío.");
            return;
        }

        // Registrar el diagnóstico y agregarlo al historial del paciente
        consulta.setDiagnostico(diagnostico);
        consulta.getPaciente().agregarHistorial("Fecha: " + consulta.getFecha() + " - Diagnóstico: " + diagnostico);

        System.out.println("Diagnóstico registrado correctamente.");
    }



    /**
     * Este método se utiliza para imprimir la lista de pacientes.
     *
     * @param pacientes La lista de pacientes registrados.
     */
    public static void mostrarPacientes(List<Paciente> pacientes) {
        System.out.println("\n=== Lista de Pacientes ===");

        // Verificar si hay pacientes registrados
        if (pacientes == null || pacientes.isEmpty()) {
            System.out.println("No hay pacientes registrados.");
            return;
        }

        // Imprimir la lista de pacientes
        for (Paciente paciente : pacientes) {
            if (paciente != null) {
                System.out.println(paciente);
            }
        }
    }


    /**
     * Este método se utiliza para imprimir la lista de consultas médicas.
     *
     * @param consultas La lista de consultas médicas agendadas.
     */
    public static void mostrarConsultas(List<ConsultaMedica> consultas) {
        System.out.println("\n=== Lista de Consultas ===");

        // Verificar si hay consultas agendadas
        if (consultas == null || consultas.isEmpty()) {
            System.out.println("No hay consultas agendadas.");
            return;
        }

        // Imprimir la lista de consultas
        for (ConsultaMedica consulta : consultas) {
            if (consulta != null) {
                System.out.println(consulta);
            }
        }
    }
}
