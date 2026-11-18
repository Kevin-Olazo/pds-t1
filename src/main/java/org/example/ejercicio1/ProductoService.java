package org.example.ejercicio1;

public class ProductoService {

    private final ProductoRepository repository;

    public ProductoService(ProductoRepository repository) {
        this.repository = repository;
    }

    public String consultarProducto(Integer id) {

        if (id == null) {
            return "Debe ingresar los datos requeridos";
        }

        if (id <= 0) {
            return "Ingrese un ID válido";
        }

        Producto producto = repository.buscarPorId(id);
        if (producto == null) {
            return "Producto no encontrado";
        }

        return producto.getNombre();
    }
}
