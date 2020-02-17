package com.erickgm.sharpsword.resources;

import com.erickgm.sharpsword.application.dto.request.AlinhamentoDtoRequest;
import com.erickgm.sharpsword.application.dto.response.AlinhamentoDtoResponse;
import com.erickgm.sharpsword.application.services.AlinhamentoService;
import com.erickgm.sharpsword.domain.entities.Alinhamento;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api")
@Api(value = "API REST Alinhamento")
@CrossOrigin(origins = "*")
public class AlinhamentoResource {
    @Autowired
    private AlinhamentoService alinhamentoService;

    @GetMapping("/alinhamentos")
    @ApiOperation(value = "Este método retorna uma lista de alinhamentos")
    public ResponseEntity<List<Alinhamento>> listarAlinhamento() {
        List<Alinhamento> response = alinhamentoService.listarAlinhamentos();
        return new ResponseEntity<List<Alinhamento>>(response, HttpStatus.OK);
    }

    @GetMapping("/alinhamentos/{id}")
    @ApiOperation(value = "Este método retorna uma alinhamento pelo seu identificador")
    public ResponseEntity<AlinhamentoDtoResponse> obterAlinhamentoPeloId(@PathVariable(value = "id") long id) {
        AlinhamentoDtoResponse response = alinhamentoService.obterAlinhamentoPeloId(id);

        if (response == null)
            return new ResponseEntity<AlinhamentoDtoResponse>(HttpStatus.NOT_FOUND);

        return new ResponseEntity<AlinhamentoDtoResponse>(response, HttpStatus.OK);
    }

    @PostMapping("/alinhamentos")
    @ApiOperation(value = "Este método adiciona um alinhamento")
    public ResponseEntity<AlinhamentoDtoResponse> incluirAlinhamento(@RequestBody AlinhamentoDtoRequest dto) {
        AlinhamentoDtoResponse response = alinhamentoService.incluirAlinhamento(dto);

        if (response == null)
            return new ResponseEntity<AlinhamentoDtoResponse>(HttpStatus.BAD_REQUEST);

        return new ResponseEntity<AlinhamentoDtoResponse>(response, HttpStatus.OK);
    }

    @PutMapping("/alinhamentos/{id}")
    @ApiOperation(value = "Este método atualiza uma alinhamento")
    public ResponseEntity<AlinhamentoDtoResponse> alterarAlinhamento(@PathVariable(value = "id") long id, @RequestBody AlinhamentoDtoRequest dto) {
        AlinhamentoDtoResponse response = alinhamentoService.alterarAlinhamento(id, dto);

        if (response == null)
            return new ResponseEntity<AlinhamentoDtoResponse>(HttpStatus.BAD_REQUEST);

        return new ResponseEntity<AlinhamentoDtoResponse>(response, HttpStatus.OK);
    }

    @DeleteMapping("/alinhamentos/{id}")
    @ApiOperation(value = "Este método exclui uma alinhamento")
    public ResponseEntity<Boolean> excluirAlinhamento(@PathVariable(value = "id") long id) {
        if(!alinhamentoService.excluirAlinhamento(id))
            return new ResponseEntity<Boolean>(false, HttpStatus.BAD_REQUEST);
        
        return new ResponseEntity<Boolean>(true, HttpStatus.OK);
    }
}