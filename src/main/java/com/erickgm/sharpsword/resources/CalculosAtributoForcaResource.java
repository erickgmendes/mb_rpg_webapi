package com.erickgm.sharpsword.resources;

import com.erickgm.sharpsword.application.dto.response.CalculoAtributoForcaDtoResponse;
import com.erickgm.sharpsword.application.dto.response.ClasseDtoResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api")
@Api(value = "API REST Classes")
@CrossOrigin(origins = "*")
public class CalculosAtributoForcaResource {

    @GetMapping("/CalculosAtributoForcaAjuste/{valor}")
    @ApiOperation(value = "Este método retorna uma classe pelo seu identificador")
    public ResponseEntity<CalculoAtributoForcaDtoResponse> calcularAtributoForcaAjuste(@PathVariable(value = "valor") int valor) {

        String ajuste = "-5";

        switch (valor) {
            case 1:
                ajuste = "-5";
                break;
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
                ajuste =  "1";
                break;
            case 14: case 15:
                ajuste =  "2";
                break;
            case 16: case 17:
                ajuste =  "3";
                break;
            case 18: case 19:
                ajuste =  "4";
                break;
            case 20: case 21:
                ajuste =  "5";
                break;
            default:
                ajuste =  "-5";
                break;
        }

        CalculoAtributoForcaDtoResponse retorno = new CalculoAtributoForcaDtoResponse(ajuste);

        return new ResponseEntity<CalculoAtributoForcaDtoResponse>(retorno, HttpStatus.OK);
    }

}
