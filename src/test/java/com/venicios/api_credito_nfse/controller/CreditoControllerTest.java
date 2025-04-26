package com.venicios.api_credito_nfse.controller;

import com.venicios.api_credito_nfse.assembler.CreditoModelAssembler;
import com.venicios.api_credito_nfse.dto.CreditoDTO;
import com.venicios.api_credito_nfse.service.CreditoService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@WebMvcTest(CreditoController.class)
public class CreditoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CreditoService creditoService;

    @MockBean
    private CreditoModelAssembler creditoModelAssembler;

    @Test
    public void deveRetornarCreditosQuandoBuscarPorNumeroNfse() throws Exception {
        // Arrange
        CreditoDTO dto = new CreditoDTO();
        when(creditoService.buscarPorNumeroNfse("1122334")).thenReturn(List.of(dto));

        // Act + Assert
        mockMvc.perform(get("/api/creditos/1122334"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)));
    }

    @Test
    public void deveRetornarCreditosQuandoBuscarPorNumeroCredito() throws Exception {
        // Arrange
        CreditoDTO dto = new CreditoDTO();
        when(creditoService.buscarPorNumeroCredito("654321")).thenReturn(List.of(dto));

        // Act + Assert
        mockMvc.perform(get("/api/creditos/credito/654321"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)));
    }

    @Test
    public void deveRetornarListaVazia_QuandoNaoEncontrarCreditosPorNumeroNfse() throws Exception {
        when(creditoService.buscarPorNumeroNfse("00000")).thenReturn(List.of());

        mockMvc.perform(get("/api/creditos/00000"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(0)));
    }

    @Test
    public void deveRetornarListaVaziaQuandoNaoEncontrarCreditosPorNumeroNfse() throws Exception {
        when(creditoService.buscarPorNumeroCredito("11111")).thenReturn(List.of());

        mockMvc.perform(get("/api/creditos/credito/11111"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(0)));
    }

}
