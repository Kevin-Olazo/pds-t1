package org.example.ejercicio2;

public class LibroService {

    private final LibroRepository repository;

    public LibroService(LibroRepository repository) {
        this.repository = repository;
    }

    public String consultarLibro(Integer id) {

        if (id == null) {
            return "Debe ingresar los datos requeridos";
        }

        if (id <= 0) {
            return "Ingrese un ID válido";
        }

        Libro libro = repository.buscarPorId(id);
        if (libro == null) {
            return "Libro no encontrado";
        }

        return libro.getTitulo();
    }
}
