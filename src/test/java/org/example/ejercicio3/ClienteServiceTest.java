package org.example.ejercicio3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class ClienteServiceTest {

    @Test
    void shouldReturnNameAndEmail_WhenClientIsActive() {
        ClienteRepository mockCliente = mock(ClienteRepository.class);
        ClienteService clienteService = new ClienteService(mockCliente);

        Cliente cliente = new Cliente(1, "Luis", "Santillana", "luis.santi@gmail.com", true);
        when(mockCliente.buscarPorId(1)).thenReturn(cliente);

        String result = clienteService.consultarCliente(1);

        assertEquals("Luis Santillana - luis.santi@gmail.com", result);
        verify(mockCliente).buscarPorId(1);
    }

    @Test
    void shouldReturnIncorrectId_WhenIdIsZero() {
        ClienteRepository mockCliente = mock(ClienteRepository.class);
        ClienteService clienteService = new ClienteService(mockCliente);

        String result = clienteService.consultarCliente(0);

        assertEquals("Ingrese un ID correcto", result);
        verify(mockCliente, never()).buscarPorId(anyInt());
    }

    @Test
    void shouldReturnIncorrectId_WhenIdIsNegative() {
        ClienteRepository mockCliente = mock(ClienteRepository.class);
        ClienteService clienteService = new ClienteService(mockCliente);

        String result = clienteService.consultarCliente(-5);

        assertEquals("Ingrese un ID correcto", result);
        verify(mockCliente, never()).buscarPorId(anyInt());
    }

    @Test
    void shouldReturnNotRegistered_WhenClientDoesNotExist() {
        ClienteRepository mockCliente = mock(ClienteRepository.class);
        ClienteService clienteService = new ClienteService(mockCliente);

        when(mockCliente.buscarPorId(99)).thenReturn(null);

        String result = clienteService.consultarCliente(99);

        assertEquals("Cliente no registrado", result);
        verify(mockCliente).buscarPorId(99);
    }

    @Test
    void shouldReturnInactive_WhenClientIsInactive() {
        ClienteRepository mockCliente = mock(ClienteRepository.class);
        ClienteService clienteService = new ClienteService(mockCliente);

        Cliente cliente = new Cliente(2, "Maria", "Lopez", "maria.lopez@gmail.com", false);
        when(mockCliente.buscarPorId(2)).thenReturn(cliente);

        String result = clienteService.consultarCliente(2);

        assertEquals("Cliente inactivo", result);
        verify(mockCliente).buscarPorId(2);
    }

    @Test
    void shouldReturnRequired_WhenIdIsNull() {
        ClienteRepository mockCliente = mock(ClienteRepository.class);
        ClienteService clienteService = new ClienteService(mockCliente);

        String result = clienteService.consultarCliente(null);

        assertEquals("Debe ingresar los datos requeridos", result);
        verify(mockCliente, never()).buscarPorId(anyInt());
    }
}