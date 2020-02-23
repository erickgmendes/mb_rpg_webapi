package com.erickgm.sharpsword.resources;

import com.erickgm.sharpsword.application.dto.response.ForcaDtoResponse;
import com.erickgm.sharpsword.application.dto.response.SabedoriaDtoResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api")
@Api(value = "API REST Sabedoria")
@CrossOrigin(origins = "*")
public class SabedoriaResource {

    @GetMapping("/sabedoria/{valor}")
    @ApiOperation(value = "Este método retorna os cálculos para o atributo sabedoria")
    public ResponseEntity<SabedoriaDtoResponse> calcularSabedoria(@PathVariable(value = "valor") int valor) {

        String ajusteProtecao = "-5";
        String magiasAdicionais = "-";

        switch (valor) {
            case 2: case 3:
                ajusteProtecao = "-4";
                break;
            case 4: case 5:
                ajusteProtecao =  "-3";
                break;
            case 6: case 7:
                ajusteProtecao =  "-2";
                break;
            case 8: case 9:
                ajusteProtecao =  "-1";
                break;
            case 10: case 11:
                ajusteProtecao =  "0";
                break;
            case 12: case 13:
                ajusteProtecao =  "+1";
                break;
            case 14: case 15:
                ajusteProtecao =  "+2";
                magiasAdicionais = "0";
                break;
            case 16: case 17:
                ajusteProtecao =  "+3";
                magiasAdicionais = "1 de 1º círculo";
                break;
            case 18: case 19:
                ajusteProtecao =  "+4";
                magiasAdicionais = "2 de 1º círculo";
                break;
            case 20: case 21:
                ajusteProtecao =  "+5";
                magiasAdicionais = "1 de 2º círculo e 2 de 1º círculo";
                break;
        }

        SabedoriaDtoResponse retorno = new SabedoriaDtoResponse(ajusteProtecao, magiasAdicionais);

        return new ResponseEntity<>(retorno, HttpStatus.OK);
    }

}
