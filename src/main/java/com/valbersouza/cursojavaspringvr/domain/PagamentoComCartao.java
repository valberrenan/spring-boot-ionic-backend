package com.valbersouza.cursojavaspringvr.domain;

import com.fasterxml.jackson.annotation.JsonTypeName;
import com.valbersouza.cursojavaspringvr.domain.enums.EstadoPagamento;

import javax.persistence.Entity;

@Entity
@JsonTypeName("pagamentoComCartao")
public class PagamentoComCartao extends Pagamento{
    private  static final long serialVersionUid = 1L;


    private Integer numeroDeParcelas;


    public PagamentoComCartao(){
    }

    public PagamentoComCartao(Integer id, EstadoPagamento estado, Pedido pedido, Integer numeroDeParcelas) {
        super(id, estado, pedido);
        this.numeroDeParcelas = numeroDeParcelas;
    }

    public Integer getNumeroDeParcelas() {
        return numeroDeParcelas;
    }

    public void setNumeroDeParcelas(Integer numeroDeParcelas) {
        this.numeroDeParcelas = numeroDeParcelas;
    }
}
