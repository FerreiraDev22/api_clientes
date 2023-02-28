package br.com.cotiinformatica.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.cotiinformatica.dtos.GetClientesDTO;
import br.com.cotiinformatica.dtos.PostClientesDTO;
import br.com.cotiinformatica.dtos.PutClientesDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags = "Clientes")
@RestController
public class ClientesController {

	@ApiOperation("Serviço para cadastro de clientes.")
	@PostMapping("/api/clientes")
	public ResponseEntity<GetClientesDTO> post(@RequestBody PostClientesDTO dto) {
		return null;
	}

	@ApiOperation("Serviço para edição de clientes.")
	@PutMapping("/api/clientes")
	public ResponseEntity<GetClientesDTO> put(@RequestBody PutClientesDTO dto) {
		return null;
	}

	@ApiOperation("Serviço para exclusão de clientes.")
	@DeleteMapping("/api/clientes/{id}")
	public ResponseEntity<GetClientesDTO> delete(@PathVariable("id") Integer idCliente) {
		return null;
	}

	@ApiOperation("Serviço para consulta de clientes.")
	@GetMapping("/api/clientes")
	public ResponseEntity<List<GetClientesDTO>> getAll() {
		return null;
	}

	@ApiOperation("Serviço para consulta de cliente por id.")
	@GetMapping("/api/clientes/{id}")
	public ResponseEntity<GetClientesDTO> getById(@PathVariable("id") Integer idCliente) {
		return null;
	}
}



