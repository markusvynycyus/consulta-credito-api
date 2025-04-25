package com.venicios.api_credito_nfse.controller;

import com.venicios.api_credito_nfse.assembler.CreditoModelAssembler;
import com.venicios.api_credito_nfse.dto.CreditoDTO;
import com.venicios.api_credito_nfse.service.CreditoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/creditos")
public class CreditoController {

    @Autowired
    private CreditoService creditoService;

    @Autowired
    private CreditoModelAssembler creditoModelAssembler;

    @GetMapping("/{numeroNfse}")
    public List<CreditoDTO> listarPorNumeroNfse(@PathVariable String numeroNfse) {
        return creditoService.buscarPorNumeroNfse(numeroNfse);
    }

    @GetMapping("/credito/{numeroCredito}")
    public List<CreditoDTO> buscarPorNumeroCredito(@PathVariable String numeroCredito) {
        return creditoService.buscarPorNumeroCredito(numeroCredito);
    }
}