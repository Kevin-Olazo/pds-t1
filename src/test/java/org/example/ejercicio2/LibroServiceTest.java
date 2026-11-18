package org.example.ejercicio2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class LibroServiceTest {

    @Test
    void shouldReturnTitle_WhenBookExists() {
        LibroRepository mockLibro = mock(LibroRepository.class);
        LibroService libroService = new LibroService(mockLibro);

        Libro libro = new Libro(1, "El principito");
        when(mockLibro.buscarPorId(1)).thenReturn(libro);

        String result = libroService.consultarLibro(1);

        assertEquals("El principito", result);
        verify(mockLibro).buscarPorId(1);
    }

    @Test
    void shouldReturnInvalidId_WhenIdIsZero() {
        LibroRepository mockLibro = mock(LibroRepository.class);
        LibroService libroService = new LibroService(mockLibro);

        String result = libroService.consultarLibro(0);

        assertEquals("Ingrese un ID válido", result);
        verify(mockLibro, never()).buscarPorId(anyInt());
    }

    @Test
    void shouldReturnInvalidId_WhenIdIsNegative() {
        LibroRepository mockLibro = mock(LibroRepository.class);
        LibroService libroService = new LibroService(mockLibro);

        String result = libroService.consultarLibro(-5);

        assertEquals("Ingrese un ID válido", result);
        verify(mockLibro, never()).buscarPorId(anyInt());
    }

    @Test
    void shouldReturnNotFound_WhenBookDoesNotExist() {
        LibroRepository mockLibro = mock(LibroRepository.class);
        LibroService libroService = new LibroService(mockLibro);

        when(mockLibro.buscarPorId(99)).thenReturn(null);

        String result = libroService.consultarLibro(99);

        assertEquals("Libro no encontrado", result);
        verify(mockLibro).buscarPorId(99);
    }

    @Test
    void shouldReturnRequired_WhenIdIsNull() {
        LibroRepository mockLibro = mock(LibroRepository.class);
        LibroService libroService = new LibroService(mockLibro);

        String result = libroService.consultarLibro(null);

        assertEquals("Debe ingresar los datos requeridos", result);
        verify(mockLibro, never()).buscarPorId(anyInt());
    }
}