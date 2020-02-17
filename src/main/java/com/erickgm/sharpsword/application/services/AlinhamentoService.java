package com.erickgm.sharpsword.application.services;

import com.erickgm.sharpsword.application.dto.request.AlinhamentoDtoRequest;
import com.erickgm.sharpsword.application.dto.response.AlinhamentoDtoResponse;
import com.erickgm.sharpsword.application.mappers.AlinhamentoMapper;
import com.erickgm.sharpsword.domain.entities.Alinhamento;
import com.erickgm.sharpsword.repository.AlinhamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AlinhamentoService {

    @Autowired
    private AlinhamentoRepository alinhamentoRepository;

    public String cargaInicial() {
        List<Alinhamento> itens = new ArrayList<>();

        if (alinhamentoRepository.count() == 0) {
            itens.add(new Alinhamento(null, "Caótico"));
            itens.add(new Alinhamento(null, "Neutro"));
            itens.add(new Alinhamento(null, "Ordeiro"));

            for (Alinhamento item : itens) {
                alinhamentoRepository.save(item);
            }

            return "Alinhamentos carregados";
        }
        return "Não foi possível carregar Alinhamentos";
    }

    public Page<Alinhamento> listarAlinhamentosPaginacao(Integer pagina) {
        return alinhamentoRepository.findAll(PageRequest.of(pagina, 10));
    }

    public List<Alinhamento> listarAlinhamentos() {
        return alinhamentoRepository.findByOrderByNomeAsc();
    }

    public AlinhamentoDtoResponse obterAlinhamentoPeloId(long id) {
        Alinhamento alinhamento = alinhamentoRepository.findById(id);
        return AlinhamentoMapper.mapToDtoResponse(alinhamento);
    }

    public AlinhamentoDtoResponse incluirAlinhamento(AlinhamentoDtoRequest dto) {
        if (dto == null) {
            return null;
        }

        Alinhamento alinhamento = alinhamentoRepository.findByNome(dto.getNome());
        if (alinhamento != null) {
            return AlinhamentoMapper.mapToDtoResponse(alinhamento);
        }

        alinhamento = new Alinhamento(null, dto.getNome());
        alinhamento.modificaValores(dto.getNome());
        alinhamento = alinhamentoRepository.save(alinhamento);

        return AlinhamentoMapper.mapToDtoResponse(alinhamento);
    }

    public AlinhamentoDtoResponse alterarAlinhamento(long id, AlinhamentoDtoRequest dto) {
        Alinhamento alinhamento = alinhamentoRepository.findById(id);

        alinhamento.modificaValores(dto.getNome());

        alinhamentoRepository.save(alinhamento);

        return AlinhamentoMapper.mapToDtoResponse(alinhamento);
    }

    public boolean excluirAlinhamento(long id) {
        Alinhamento alinhamento = alinhamentoRepository.findById(id);

        if (alinhamento == null) {
            return false;
        }

        alinhamentoRepository.delete(alinhamento);

        return true;
    }

}
