package test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import service.DisponibilidadService;
import service.ReservaService;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class ReservaServiceTest {

    private DisponibilidadService disponibilidadService;
    private ReservaService reservaService;

    @BeforeEach
    void setUp() {
        disponibilidadService = mock(DisponibilidadService.class);
        reservaService = new ReservaService(disponibilidadService);
    }

    @Test
    void reservaConfirmadaCuandoHayDisponibilidad() {
        when(disponibilidadService.hayDisponibilidad("2025-05-01", 2)).thenReturn(true);

        boolean resultado = reservaService.realizarReserva("2025-05-01", 2);

        assertTrue(resultado);
        verify(disponibilidadService).hayDisponibilidad("2025-05-01", 2);
    }

    @Test
    void reservaRechazadaCuandoNoHayDisponibilidad() {
        when(disponibilidadService.hayDisponibilidad("2025-05-02", 5)).thenReturn(false);

        boolean resultado = reservaService.realizarReserva("2025-05-02", 5);

        assertFalse(resultado);
        verify(disponibilidadService).hayDisponibilidad("2025-05-02", 5);
    }

    @Test
    void reservaRechazadaCuandoPersonasSuperanLimite() {
        boolean resultado = reservaService.realizarReserva("2025-05-03", 12);

        assertFalse(resultado);
        verify(disponibilidadService, never()).hayDisponibilidad(anyString(), anyInt());
    }
}
