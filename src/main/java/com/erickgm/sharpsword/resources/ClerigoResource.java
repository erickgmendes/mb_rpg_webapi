package com.erickgm.sharpsword.resources;

import com.erickgm.sharpsword.application.dto.response.ClerigoDtoResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api")
@Api(value = "API REST Classes")
@CrossOrigin(origins = "*")
public class ClerigoResource {

    @GetMapping("/calculosClerigo/{nivel}")
    @ApiOperation(value = "Este método retorna os cálculos para a classe clérigo")
    public ResponseEntity<ClerigoDtoResponse> calcularClerigo(@PathVariable(value = "nivel") int nivel) {

        String xpMinimo = "0";
        String dvQuantidade = Integer.toString(nivel);
        String ba = "0";
        String jp = "15";
        String magiasNivel1 = "1";
        String magiasNivel2 = "-";
        String magiasNivel3 = "-";
        String esqueleto = "13";
        String zumbi = "17";
        String carnical = "19";
        String inumano = "Nenhum";
        String aparicao = "Nenhum";

        switch (nivel) {
            case 2:
                xpMinimo = "1500";
                ba = "+1";
                magiasNivel1 = "2";
                esqueleto = "11";
                zumbi = "15";
                carnical = "18";
                inumano = "20";
                break;
            case 3:
                xpMinimo = "3000";
                ba = "+2";
                magiasNivel1 = "2";
                magiasNivel2 = "1";
                esqueleto = "9";
                zumbi = "13";
                carnical = "17";
                inumano = "19";
                break;
            case 4:
                xpMinimo = "6000";
                ba = "+2";
                jp = "14";
                magiasNivel1 = "3";
                magiasNivel2 = "2";
                esqueleto = "7";
                zumbi = "11";
                carnical = "15";
                inumano = "18";
                aparicao = "20";
                break;
            case 5:
                xpMinimo = "12000";
                ba = "+3";
                jp = "14";
                magiasNivel1 = "3";
                magiasNivel2 = "2";
                magiasNivel3 = "1";
                esqueleto = "5";
                zumbi = "9";
                carnical = "13";
                inumano = "17";
                aparicao = "19";
                break;
        }

        ClerigoDtoResponse retorno = new ClerigoDtoResponse(xpMinimo, dvQuantidade, ba, jp, magiasNivel1, magiasNivel2, magiasNivel3, esqueleto, zumbi, carnical, inumano, aparicao);

        return new ResponseEntity<>(retorno, HttpStatus.OK);
    }

}
