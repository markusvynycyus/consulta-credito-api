package com.venicios.api_credito_nfse.controller;

import com.venicios.api_credito_nfse.assembler.CreditoModelAssembler;
import com.venicios.api_credito_nfse.dto.CreditoDTO;
import com.venicios.api_credito_nfse.service.CreditoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/creditos")
public class CreditoController {

    @Autowired
    private CreditoService creditoService;

    @Autowired
    private KafkaTemplate<String, String >kafkaTemplate;

    @GetMapping("/{numeroNfse}")
    public List<CreditoDTO> listarPorNumeroNfse(@PathVariable String numeroNfse) {
        kafkaTemplate.send("nota_fiscal_topico", numeroNfse);
        return creditoService.buscarPorNumeroNfse(numeroNfse);
    }

    @GetMapping("/credito/{numeroCredito}")
    public CreditoDTO buscarPorNumeroCredito(@PathVariable String numeroCredito) {
        kafkaTemplate.send("credito_topico", numeroCredito);
        return creditoService.buscarPorNumeroCredito(numeroCredito);
    }

}