package org.example.ejercicio3;

public class ClienteService {

    private final ClienteRepository repository;

    public ClienteService(ClienteRepository repository) {
        this.repository = repository;
    }

    public String consultarCliente(Integer id) {

        if (id == null) {
            return "Debe ingresar los datos requeridos";
        }

        if (id <= 0) {
            return "Ingrese un ID correcto";
        }

        Cliente cliente = repository.buscarPorId(id);
        if (cliente == null) {
            return "Cliente no registrado";
        }

        if (!cliente.isActivo()) {
            return "Cliente inactivo";
        }

        return cliente.getNombre() + " " + cliente.getApellido() + " - " + cliente.getCorreo();
    }
}