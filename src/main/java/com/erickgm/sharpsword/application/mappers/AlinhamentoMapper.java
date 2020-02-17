package com.erickgm.sharpsword.application.mappers;

import com.erickgm.sharpsword.application.dto.response.AlinhamentoDtoResponse;
import com.erickgm.sharpsword.domain.entities.Alinhamento;

import java.util.ArrayList;
import java.util.List;

public class AlinhamentoMapper {
    public static AlinhamentoDtoResponse mapToDtoResponse(Alinhamento alinhamento) {
        AlinhamentoDtoResponse response = new AlinhamentoDtoResponse();

        response.setId(alinhamento.getId());
        response.setNome(alinhamento.getNome());

        return response;
    }

    public static List<AlinhamentoDtoResponse> mapToListDtoResponse(List<Alinhamento> alinhamentos) {

        List<AlinhamentoDtoResponse> listaResponse = new ArrayList<>();

        for (Alinhamento alinhamento : alinhamentos) {
            AlinhamentoDtoResponse response = mapToDtoResponse(alinhamento);
            listaResponse.add(response);
        }

        return listaResponse;
    }
}