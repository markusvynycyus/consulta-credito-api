package com.venicios.api_credito_nfse.service;

import com.venicios.api_credito_nfse.assembler.CreditoModelAssembler;
import com.venicios.api_credito_nfse.dto.CreditoDTO;
import com.venicios.api_credito_nfse.exception.CreditoNotFoundException;
import com.venicios.api_credito_nfse.model.Credito;
import com.venicios.api_credito_nfse.repository.CreditoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CreditoService {
    private final CreditoRepository repository;
    private final CreditoModelAssembler assembler;

    @Autowired
    public CreditoService(CreditoRepository repository, CreditoModelAssembler assembler) {
        this.repository = repository;
        this.assembler = assembler;
    }

    public List<CreditoDTO> buscarPorNumeroNfse(String numeroNfse) {
        List<Credito> creditos = repository.findByNumeroNfse(numeroNfse);

        if (creditos.isEmpty()) {
            throw new CreditoNotFoundException("Nenhum crédito encontrado para a NFSe: " + numeroNfse);
        }

        return assembler.toCollectionModel(creditos);
    }


    public CreditoDTO buscarPorNumeroCredito(String numeroCredito) {
        Credito credito = repository.findByNumeroCredito(numeroCredito)
                .orElseThrow(() -> new CreditoNotFoundException("Crédito com número " + numeroCredito + " não encontrado."));
        return assembler.toModel(credito);
    }
}