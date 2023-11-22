package com.codegroup.javatest.web.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codegroup.javatest.exception.model.ErrorDTO;
import com.codegroup.javatest.service.ProjetoService;
import com.codegroup.javatest.web.model.NovoMembroDTO;
import com.codegroup.javatest.web.model.NovoProjetoDTO;
import com.codegroup.javatest.web.model.PessoaDTO;
import com.codegroup.javatest.web.model.ProjetoDTO;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/v1/projeto")
@AllArgsConstructor
@Tag(name = "Projeto")
public class ProjetoController {
	  
	private final ProjetoService projetoService;
	
	@GetMapping()
	@Operation(summary = "Get Projetos")
	@ApiResponses(value = {
	        @ApiResponse(responseCode = "200", description = "Success",
	                content = @Content(schema = @Schema(implementation = ProjetoDTO.class)))})
	public ResponseEntity<List<ProjetoDTO>> getProjetos() {
	    return new ResponseEntity<>(projetoService.getProjetos(), HttpStatus.OK);
	}
	
    @PostMapping
    @Operation(summary = "Create")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Success",
                    content = @Content(schema = @Schema(implementation = PessoaDTO.class))),
            @ApiResponse(responseCode = "400", description = "Bad Request",
                    content = @Content(schema = @Schema(implementation = ErrorDTO.class)))})
    public ResponseEntity<ProjetoDTO> createProjeto(
            @Valid @RequestBody NovoProjetoDTO novoProjetoDTO) {
        return new ResponseEntity<ProjetoDTO>(projetoService
                .create(novoProjetoDTO), HttpStatus.CREATED);
    }
    
    @PostMapping("/{idProjeto}/membro/")
    @Operation(summary = "Add Membro")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Success",
                    content = @Content(schema = @Schema(implementation = PessoaDTO.class))),
            @ApiResponse(responseCode = "400", description = "Bad Request",
                    content = @Content(schema = @Schema(implementation = ErrorDTO.class)))})
    public ResponseEntity<ProjetoDTO> addMembro(
    		@Valid @RequestBody NovoMembroDTO novoMembroDTO, 
            @PathVariable Long idProjeto) {
        return new ResponseEntity<ProjetoDTO>(projetoService
                .addMembro(novoMembroDTO, idProjeto), HttpStatus.CREATED);
    }
    
    @PutMapping("/{idProjeto}")
    @Operation(summary = "Update")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Success",
                    content = @Content(schema = @Schema(implementation = PessoaDTO.class))),
            @ApiResponse(responseCode = "400", description = "Bad Request",
                    content = @Content(schema = @Schema(implementation = ErrorDTO.class)))})
    public ResponseEntity<ProjetoDTO> updateProjeto(
            @Valid @RequestBody NovoProjetoDTO novoProjetoDTO,
            @PathVariable Long idProjeto) {
        return new ResponseEntity<ProjetoDTO>(projetoService
                .update(novoProjetoDTO, idProjeto), HttpStatus.CREATED);
    }
    
    @DeleteMapping("/{idProjeto}")
    @Operation(summary = "Create")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Success",
                    content = @Content(schema = @Schema(implementation = PessoaDTO.class))),
            @ApiResponse(responseCode = "400", description = "Bad Request",
                    content = @Content(schema = @Schema(implementation = ErrorDTO.class)))})
    public ResponseEntity<Void> deleteProjeto(@PathVariable Long idProjeto) {
        return new ResponseEntity<Void>(projetoService
                .delete(idProjeto), HttpStatus.NO_CONTENT);
    }
    
}
