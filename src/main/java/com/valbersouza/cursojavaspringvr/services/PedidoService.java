package com.valbersouza.cursojavaspringvr.services;

import com.valbersouza.cursojavaspringvr.domain.Categoria;
import com.valbersouza.cursojavaspringvr.domain.ItemPedido;
import com.valbersouza.cursojavaspringvr.domain.PagamentoComBoleto;
import com.valbersouza.cursojavaspringvr.domain.Pedido;
import com.valbersouza.cursojavaspringvr.domain.enums.EstadoPagamento;
import com.valbersouza.cursojavaspringvr.repositories.ItemPedidoRepository;
import com.valbersouza.cursojavaspringvr.repositories.PagamentoRepository;
import com.valbersouza.cursojavaspringvr.repositories.PedidoRepository;
import com.valbersouza.cursojavaspringvr.repositories.ProdutoRepository;
import com.valbersouza.cursojavaspringvr.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.Optional;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository repo;

    @Autowired
    private BoletoService boletoService;

    @Autowired
    private PagamentoRepository pagamentoRepository;

    @Autowired
    private ProdutoService produtoService;

    @Autowired
    private ItemPedidoRepository itemPedidoRepository;

    public Pedido find(Integer id){
        Optional<Pedido> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
                "Objeto não encontrado! Id: " + id + " Tipo:  " + Pedido.class.getName()));
    }

    @Transactional
    public Pedido insert(Pedido obj) {
        obj.setId(null);
        obj.setInstante(new Date());
        obj.getPagamento().setEstado(EstadoPagamento.PENDENTE);
        obj.getPagamento().setPedido(obj);
        if (obj.getPagamento() instanceof PagamentoComBoleto) {
            PagamentoComBoleto pagto = (PagamentoComBoleto) obj.getPagamento();
            boletoService.preencherPagamentoComBoleto(pagto, obj.getInstante());
        }
        obj = repo.save(obj);
        pagamentoRepository.save(obj.getPagamento());
        for (ItemPedido ip : obj.getItens()) {
            ip.setDesconto(0.0);
            ip.setPreco(produtoService.find(ip.getProduto().getId()).getPreco());
            ip.setPedido(obj);
        }
        itemPedidoRepository.saveAll(obj.getItens());
        return obj;
    }
}
