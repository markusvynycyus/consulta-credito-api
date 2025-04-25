package com.venicios.api_credito_nfse.assembler;

import com.venicios.api_credito_nfse.dto.CreditoDTO;
import com.venicios.api_credito_nfse.model.Credito;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CreditoModelAssembler {

    @Autowired
    private ModelMapper modelMapper;

    public CreditoDTO toModel(Credito credito) {
        return modelMapper.map(credito, CreditoDTO.class);
    }
    public List<CreditoDTO> toCollectionModel(List<Credito> creditos) {
        return creditos.stream()
                .map(credito->toModel(credito))  // Convertendo cada 'Credito' para 'CreditoDTO'
                .collect(Collectors.toList());
    }
}
