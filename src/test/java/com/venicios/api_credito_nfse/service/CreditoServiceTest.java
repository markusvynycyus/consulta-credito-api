package com.venicios.api_credito_nfse.service;

import com.venicios.api_credito_nfse.assembler.CreditoModelAssembler;
import com.venicios.api_credito_nfse.dto.CreditoDTO;
import com.venicios.api_credito_nfse.model.Credito;
import com.venicios.api_credito_nfse.repository.CreditoRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
class CreditoServiceTest {
    @Autowired
    private CreditoService creditoService;

    @MockBean
    private CreditoRepository creditoRepository;

    @MockBean
    private CreditoModelAssembler creditoModelAssembler;

    @Test
    public void deveRetornarCreditoPorNumeroNfse() {
        // Criar um crédito para testar
        Credito credito = new Credito();
        credito.setNumeroNfse("123456");

        // Mockar o resultado do método findByNumeroNfse
        when(creditoRepository.findByNumeroNfse("123456")).thenReturn(List.of(credito));

        // Mockar o resultado do método toCollectionModel
        CreditoDTO creditoDTO = new CreditoDTO();
        when(creditoModelAssembler.toCollectionModel(List.of(credito))).thenReturn(List.of(creditoDTO));

        // Buscar créditos por número de NFSE
        List<CreditoDTO> creditos = creditoService.buscarPorNumeroNfse("123456");

        // Verificar se o crédito foi encontrado
        assertEquals(1, creditos.size());
    }

    @Test
    public void deveRetornarCreditoPorNumeroCredito() {
        // Criar um crédito para testar
        Credito credito = new Credito();
        credito.setNumeroCredito("654321");

        // Mockar o resultado do método findByNumeroCredito
        when(creditoRepository.findByNumeroCredito("654321")).thenReturn(List.of(credito));

        // Mockar o resultado do método toCollectionModel
        CreditoDTO creditoDTO = new CreditoDTO();
        when(creditoModelAssembler.toCollectionModel(List.of(credito))).thenReturn(List.of(creditoDTO));

        // Buscar créditos por número de crédito
        List<CreditoDTO> creditos = creditoService.buscarPorNumeroCredito("654321");

        // Verificar se o crédito foi encontrado
        assertEquals(1, creditos.size());
    }

    @Test
    public void deveRetornarListaVaziaQuandoNumeroNfseEhNulo() {
        // Mockar o resultado do método findByNumeroNfse
        when(creditoRepository.findByNumeroNfse(null)).thenReturn(List.of());

        // Mockar o resultado do método toCollectionModel
        when(creditoModelAssembler.toCollectionModel(List.of())).thenReturn(List.of());

        // Buscar créditos por número de NFSE
        List<CreditoDTO> creditos = creditoService.buscarPorNumeroNfse(null);

        // Verificar se a lista está vazia
        assertTrue(creditos.isEmpty());
    }

    @Test
    public void deveRetornarListaVaziaQuandoNumeroCreditoEhVazio() {
        // Mockar o resultado do método findByNumeroCredito
        when(creditoRepository.findByNumeroCredito("")).thenReturn(List.of());

        // Mockar o resultado do método toCollectionModel
        when(creditoModelAssembler.toCollectionModel(List.of())).thenReturn(List.of());

        // Buscar créditos por número de crédito
        List<CreditoDTO> creditos = creditoService.buscarPorNumeroCredito("");

        // Verificar se a lista está vazia
        assertTrue(creditos.isEmpty());
    }
}