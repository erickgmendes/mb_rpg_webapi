package com.erickgm.sharpsword.resources;

import com.erickgm.sharpsword.application.dto.response.DestrezaDtoResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api")
@Api(value = "API REST Destreza")
@CrossOrigin(origins = "*")
public class DestrezaResource {

    @GetMapping("/destreza/{valor}")
    @ApiOperation(value = "Este método retorna os cálculos para o atributo destreza")
    public ResponseEntity<DestrezaDtoResponse> calcularDestreza(@PathVariable(value = "valor") int valor) {

        String ajuste = "-5";
        String localizarDesarmarArmadilhas = "-25%";
        String moverSeEmSilecioEabrirFechaduras = "-25%";
        String esconderSeNasSombrasEPungar = "-25%";

        switch (valor) {
            case 2: case 3:
                ajuste = "-4";
                localizarDesarmarArmadilhas = "-20%";
                moverSeEmSilecioEabrirFechaduras = "-20%";
                esconderSeNasSombrasEPungar = "-20%";
                break;
            case 4: case 5:
                ajuste =  "-3";
                localizarDesarmarArmadilhas = "-15%";
                moverSeEmSilecioEabrirFechaduras = "-15%";
                esconderSeNasSombrasEPungar = "-15%";
                break;
            case 6: case 7:
                ajuste =  "-2";
                localizarDesarmarArmadilhas = "-10%";
                moverSeEmSilecioEabrirFechaduras = "-10%";
                esconderSeNasSombrasEPungar = "-10%";
                break;
            case 8: case 9:
                ajuste =  "-1";
                localizarDesarmarArmadilhas = "-5%";
                moverSeEmSilecioEabrirFechaduras = "-5%";
                esconderSeNasSombrasEPungar = "-5%";
                break;
            case 10: case 11:
                ajuste =  "0";
                localizarDesarmarArmadilhas = "0";
                moverSeEmSilecioEabrirFechaduras = "0";
                esconderSeNasSombrasEPungar = "0";
                break;
            case 12: case 13:
                ajuste =  "+1";
                localizarDesarmarArmadilhas = "0";
                moverSeEmSilecioEabrirFechaduras = "+5%";
                esconderSeNasSombrasEPungar = "0";
                break;
            case 14: case 15:
                ajuste =  "+2";
                localizarDesarmarArmadilhas = "0";
                moverSeEmSilecioEabrirFechaduras = "+10%";
                esconderSeNasSombrasEPungar = "+5%";
                break;
            case 16: case 17:
                ajuste =  "+3";
                localizarDesarmarArmadilhas = "+5%";
                moverSeEmSilecioEabrirFechaduras = "+15%";
                esconderSeNasSombrasEPungar = "+10%";
                break;
            case 18: case 19:
                ajuste =  "+4";
                localizarDesarmarArmadilhas = "+10%";
                moverSeEmSilecioEabrirFechaduras = "+20%";
                esconderSeNasSombrasEPungar = "+15%";
                break;
            case 20: case 21:
                ajuste =  "+5";
                localizarDesarmarArmadilhas = "+15%";
                moverSeEmSilecioEabrirFechaduras = "+25%";
                esconderSeNasSombrasEPungar = "+20%";
                break;
        }

        DestrezaDtoResponse retorno = new DestrezaDtoResponse(ajuste,moverSeEmSilecioEabrirFechaduras,
                localizarDesarmarArmadilhas, esconderSeNasSombrasEPungar);

        return new ResponseEntity<>(retorno, HttpStatus.OK);
    }

}
