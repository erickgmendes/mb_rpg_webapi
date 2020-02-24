package com.erickgm.sharpsword.resources;

import com.erickgm.sharpsword.application.dto.response.ForcaDtoResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api")
@Api(value = "API REST Força")
@CrossOrigin(origins = "*")
public class ForcaResource {

    @GetMapping("/forca/{valor}")
    @ApiOperation(value = "Este método retorna os cálculos para o atributo força")
    public ResponseEntity<ForcaDtoResponse> calcularForca(@PathVariable(value = "valor") int valor) {

        String ajuste = "-5";
        String cargaLeve = "0";
        String cargaPesada = "0";
        String cargaMaxima = "0";

        switch (valor) {
            case 2: case 3:
                ajuste = "-4";
                break;
            case 4: case 5:
                ajuste =  "-3";
                break;
            case 6: case 7:
                ajuste =  "-2";
                break;
            case 8: case 9:
                ajuste =  "-1";
                break;
            case 10: case 11:
                ajuste =  "0";
                break;
            case 12: case 13:
                ajuste =  "+1";
                break;
            case 14: case 15:
                ajuste =  "+2";
                break;
            case 16: case 17:
                ajuste =  "+3";
                break;
            case 18: case 19:
                ajuste =  "+4";
                break;
            case 20: case 21:
                ajuste =  "+5";
                break;
        }

        ForcaDtoResponse retorno = new ForcaDtoResponse(ajuste, cargaLeve, cargaPesada, cargaMaxima);

        return new ResponseEntity<>(retorno, HttpStatus.OK);
    }

}
