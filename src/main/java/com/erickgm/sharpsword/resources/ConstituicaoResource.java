package com.erickgm.sharpsword.resources;

import com.erickgm.sharpsword.application.dto.response.ConstituicaoDtoResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api")
@Api(value = "API REST Constituição")
@CrossOrigin(origins = "*")
public class ConstituicaoResource {

    @GetMapping("/constituicao/{valor}")
    @ApiOperation(value = "Este método retorna os cálculos para o atributo constituição")
    public ResponseEntity<ConstituicaoDtoResponse> calcularConstituicao(@PathVariable(value = "valor") int valor) {

        String pontosDeVidaEProtecao = "-5";
        String percentualRessurreicao = "0%";

        switch (valor) {
            case 2: case 3:
                pontosDeVidaEProtecao = "-4";
                break;
            case 4: case 5:
                pontosDeVidaEProtecao =  "-3";
                break;
            case 6: case 7:
                pontosDeVidaEProtecao =  "-2";
                percentualRessurreicao = "1%";
                break;
            case 8: case 9:
                pontosDeVidaEProtecao =  "-1";
                percentualRessurreicao = "5%";
                break;
            case 10: case 11:
                pontosDeVidaEProtecao =  "0";
                percentualRessurreicao = "10%";
                break;
            case 12: case 13:
                pontosDeVidaEProtecao =  "+1";
                percentualRessurreicao = "25%";
                break;
            case 14: case 15:
                pontosDeVidaEProtecao =  "+2";
                percentualRessurreicao = "50%";
                break;
            case 16: case 17:
                pontosDeVidaEProtecao =  "+3";
                percentualRessurreicao = "75%";
                break;
            case 18: case 19:
                pontosDeVidaEProtecao =  "+4";
                percentualRessurreicao = "95%";
                break;
            case 20: case 21:
                pontosDeVidaEProtecao =  "+5";
                percentualRessurreicao = "100%";
                break;
        }

        ConstituicaoDtoResponse retorno = new ConstituicaoDtoResponse(pontosDeVidaEProtecao, percentualRessurreicao);

        return new ResponseEntity<>(retorno, HttpStatus.OK);
    }

}
