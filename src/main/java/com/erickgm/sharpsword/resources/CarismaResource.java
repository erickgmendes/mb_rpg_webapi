package com.erickgm.sharpsword.resources;

import com.erickgm.sharpsword.application.dto.response.CarismaDtoResponse;
import com.erickgm.sharpsword.application.dto.response.ConstituicaoDtoResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api")
@Api(value = "API REST Carisma")
@CrossOrigin(origins = "*")
public class CarismaResource {

    @GetMapping("/carisma/{valor}")
    @ApiOperation(value = "Este método retorna os cálculos para o atributo carisma")
    public ResponseEntity<CarismaDtoResponse> calcularCarisma(@PathVariable(value = "valor") int valor) {

        String numeroSeguidores = "0";
        String ajuste = "-25";
        String mortosVivos = "0";

        switch (valor) {
            case 2: case 3:
                ajuste = "-20%";
                break;
            case 4: case 5:
                ajuste =  "-15%";
                break;
            case 6: case 7:
                ajuste =  "-10%";
                break;
            case 8: case 9:
                ajuste =  "-5%";
                mortosVivos = "1";
                break;
            case 10: case 11:
                ajuste =  "0";
                numeroSeguidores = "1";
                mortosVivos = "1d2";
                break;
            case 12: case 13:
                ajuste =  "+5%";
                numeroSeguidores = "2";
                mortosVivos = "1d3";
                break;
            case 14: case 15:
                ajuste =  "+10%";
                numeroSeguidores = "3";
                mortosVivos = "1d4";
                break;
            case 16: case 17:
                ajuste =  "+15%";
                numeroSeguidores = "4";
                mortosVivos = "1d6";
                break;
            case 18: case 19:
                ajuste =  "+20%";
                numeroSeguidores = "5";
                mortosVivos = "1d8";
                break;
            case 20: case 21:
                ajuste =  "+25%";
                numeroSeguidores = "6";
                mortosVivos = "2d4";
                break;
        }

        CarismaDtoResponse retorno = new CarismaDtoResponse(ajuste, numeroSeguidores, mortosVivos);

        return new ResponseEntity<>(retorno, HttpStatus.OK);
    }

}
