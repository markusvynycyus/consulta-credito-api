package com.venicios.api_credito_nfse.model;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "credito")
@NoArgsConstructor
@AllArgsConstructor
public class Credito {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty
    private Long id;
    @Column(name = "numero_credito", nullable = false, length = 50)
    @JsonProperty
    private String numeroCredito;
    @Column(name = "numero_nfse", nullable = false, length = 50)
    @JsonProperty
    private String numeroNfse;
    @Column(name = "data_constituicao", nullable = false)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate dataConstituicao;
    @Column(name = "valor_issqn", nullable = false, precision = 15, scale = 2)
    @JsonProperty
    private BigDecimal valorIssqn;
    @Column(name = "tipo_credito", nullable = false, length = 50)
    @JsonProperty
    private String tipoCredito;
    @Column(name = "simples_nacional", nullable = false)
    @JsonProperty
    private boolean simplesNacional;
    @Column(name = "aliquota", nullable = false, precision = 5, scale = 2)
    @JsonProperty
    private BigDecimal aliquota;
    @Column(name = "valor_faturado", nullable = false, precision = 15, scale = 2)
    @JsonProperty
    private BigDecimal valorFaturado;
    @Column(name = "valor_deducao", nullable = false, precision = 15, scale = 2)
    @JsonProperty
    private BigDecimal valorDeducao;
    @Column(name = "base_calculo", nullable = false, precision = 15, scale = 2)
    @JsonProperty
    private BigDecimal baseCalculo;

    // Getters
    public Long getId() {
        return id;
    }

    public String getNumeroCredito() {
        return numeroCredito;
    }

    public String getNumeroNfse() {
        return numeroNfse;
    }

    public LocalDate getDataConstituicao() {
        return dataConstituicao;
    }

    public BigDecimal getValorIssqn() {
        return valorIssqn;
    }

    public String getTipoCredito() {
        return tipoCredito;
    }

    public boolean isSimplesNacional() {
        return simplesNacional;
    }

    public BigDecimal getAliquota() {
        return aliquota;
    }

    public BigDecimal getValorFaturado() {
        return valorFaturado;
    }

    public BigDecimal getValorDeducao() {
        return valorDeducao;
    }

    public BigDecimal getBaseCalculo() {
        return baseCalculo;
    }
}
