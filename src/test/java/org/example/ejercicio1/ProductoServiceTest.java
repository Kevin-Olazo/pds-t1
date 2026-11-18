package org.example.ejercicio1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class ProductoServiceTest {

    @Test
    void shouldReturnName_WhenProductExists() {
        ProductoRepository mockProducto = mock(ProductoRepository.class);
        ProductoService productoService = new ProductoService(mockProducto);

        Producto producto = new Producto(1, "iPhone 18 Pro Max");
        when(mockProducto.buscarPorId(1)).thenReturn(producto);

        String result = productoService.consultarProducto(1);

        assertEquals("iPhone 18 Pro Max", result);
        verify(mockProducto).buscarPorId(1);
    }

    @Test
    void shouldReturnInvalidId_WhenIdIsZero() {
        ProductoRepository mockProducto = mock(ProductoRepository.class);
        ProductoService productoService = new ProductoService(mockProducto);

        String result = productoService.consultarProducto(0);

        assertEquals("Ingrese un ID válido", result);
        verify(mockProducto, never()).buscarPorId(anyInt());
    }

    @Test
    void shouldReturnInvalidId_WhenIdIsNegative() {
        ProductoRepository mockProducto = mock(ProductoRepository.class);
        ProductoService productoService = new ProductoService(mockProducto);

        String result = productoService.consultarProducto(-5);

        assertEquals("Ingrese un ID válido", result);
        verify(mockProducto, never()).buscarPorId(anyInt());
    }

    @Test
    void shouldReturnNotFound_WhenProductDoesNotExist() {
        ProductoRepository mockProducto = mock(ProductoRepository.class);
        ProductoService productoService = new ProductoService(mockProducto);

        when(mockProducto.buscarPorId(99)).thenReturn(null);

        String result = productoService.consultarProducto(99);

        assertEquals("Producto no encontrado", result);
        verify(mockProducto).buscarPorId(99);
    }

    @Test
    void shouldReturnRequired_WhenIdIsNull() {
        ProductoRepository mockProducto = mock(ProductoRepository.class);
        ProductoService productoService = new ProductoService(mockProducto);

        String result = productoService.consultarProducto(null);

        assertEquals("Debe ingresar los datos requeridos", result);
        verify(mockProducto, never()).buscarPorId(anyInt());
    }
}
