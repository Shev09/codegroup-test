package com.codegroup.javatest.web.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codegroup.javatest.exception.model.ErrorDTO;
import com.codegroup.javatest.service.PessoaService;
import com.codegroup.javatest.web.model.PessoaDTO;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/v1/pessoa")
@AllArgsConstructor
@Tag(name = "Pessoa")
public class PessoaController {
	  
	private final PessoaService pessoaService;
	
	
	@GetMapping()
	@Operation(summary = "Get Pessoas")
	@ApiResponses(value = {
	        @ApiResponse(responseCode = "200", description = "Success",
	                content = @Content(schema = @Schema(implementation = PessoaDTO.class)))})
	public ResponseEntity<List<PessoaDTO>> getHosts() {
	    return new ResponseEntity<>(pessoaService.getPessoas(), HttpStatus.OK);
	}
	
	
    @PostMapping
    @Operation(summary = "Create")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Success",
                    content = @Content(schema = @Schema(implementation = PessoaDTO.class))),
            @ApiResponse(responseCode = "400", description = "Bad Request",
                    content = @Content(schema = @Schema(implementation = ErrorDTO.class))),
            @ApiResponse(responseCode = "409", description = "Conflict",
                    content = @Content(schema = @Schema(implementation = ErrorDTO.class)))})
    public ResponseEntity<PessoaDTO> createNewTemporalAggregator(
            @Valid @RequestBody PessoaDTO pessoaDTO) {
        return new ResponseEntity<PessoaDTO>(pessoaService
                .create(pessoaDTO), HttpStatus.CREATED);
    }
    
}
