package com.venicios.api_credito_nfse.repository;

import com.venicios.api_credito_nfse.model.Credito;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CreditoRepositoryTest {

    @Autowired
    private CreditoRepository creditoRepository;

    @Test
    public void deveRetornarCreditoPorNumeroNfse() {
        // Criar um crédito para testar
        Credito credito = new Credito();
        credito.setNumeroNfse("123456");
        credito.setNumeroCredito("654321");
        credito.setDataConstituicao(LocalDate.now());
        credito.setValorIssqn(BigDecimal.valueOf(100.00));
        credito.setTipoCredito("Tipo de Crédito");
        credito.setSimplesNacional(false);
        credito.setAliquota(BigDecimal.valueOf(5.00));
        credito.setValorFaturado(BigDecimal.valueOf(1000.00));
        credito.setValorDeducao(BigDecimal.valueOf(0.00));
        credito.setBaseCalculo(BigDecimal.valueOf(1000.00));
        creditoRepository.save(credito);

        // Buscar créditos por número de NFSE
        List<Credito> creditos = creditoRepository.findByNumeroNfse("123456");

        // Verificar se o crédito foi encontrado
        assertEquals(1, creditos.size());
        assertEquals("123456", creditos.get(0).getNumeroNfse());
   }

    @Test
    public void deveRetornarCreditoPorNumeroCredito() {
        // Criar um crédito para testar
        Credito credito = new Credito();
        credito.setNumeroNfse("123456");
        credito.setNumeroCredito("654321");
        credito.setDataConstituicao(LocalDate.now());
        credito.setValorIssqn(BigDecimal.valueOf(100.00));
        credito.setTipoCredito("ISSQN");
        credito.setSimplesNacional(false);
        credito.setAliquota(BigDecimal.valueOf(5.00));
        credito.setValorFaturado(BigDecimal.valueOf(1000.00));
        credito.setValorDeducao(BigDecimal.valueOf(0.00));
        credito.setBaseCalculo(BigDecimal.valueOf(1000.00));

        creditoRepository.save(credito);

        // Buscar créditos por número de crédito
        List<Credito> creditos = creditoRepository.findByNumeroCredito("654321");

        // Verificar se o crédito foi encontrado
        assertTrue(creditos.size() > 0);
        assertEquals("654321", creditos.get(0).getNumeroCredito());
    }

    @Test
    public void deveRetornarListaVaziaQuandoNumeroNfseEhNulo() {
        List<Credito> creditos = creditoRepository.findByNumeroNfse(null);
        assertTrue(creditos.isEmpty());
    }

    @Test
    public void deveRetornarListaVaziaQuandoNumeroCreditoEhVazio() {
        List<Credito> creditos = creditoRepository.findByNumeroCredito("");
        assertTrue(creditos.isEmpty());
    }

}