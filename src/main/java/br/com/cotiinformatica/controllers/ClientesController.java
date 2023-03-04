package br.com.cotiinformatica.controllers;

import java.util.List;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
import br.com.cotiinformatica.dtos.ResponseClientesDTO;
import br.com.cotiinformatica.entities.Cliente;
import br.com.cotiinformatica.services.ClienteService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags = "Clientes")
@RestController
public class ClientesController {

	// injeção de dependência
	@Autowired
	private ClienteService clienteService;

	@ApiOperation("Serviço para cadastro de clientes.")
	@PostMapping("/api/clientes")
	public ResponseEntity<ResponseClientesDTO> post(@Valid @RequestBody PostClientesDTO dto) {

		ResponseClientesDTO response = new ResponseClientesDTO();

		try {

			ModelMapper modelMapper = new ModelMapper();
			Cliente cliente = modelMapper.map(dto, Cliente.class);

			clienteService.cadastrar(cliente);

			response.setStatus(201);
			response.setMensagem("Cliente cadastrado com sucesso.");
			response.setCliente(modelMapper.map(cliente, GetClientesDTO.class));

			return ResponseEntity.status(HttpStatus.CREATED).body(response);
		} catch (IllegalArgumentException e) {

			response.setStatus(400);
			response.setMensagem(e.getMessage());

			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
		} catch (Exception e) {

			response.setStatus(500);
			response.setMensagem(e.getMessage());

			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
		}
	}

	@ApiOperation("Serviço para edição de clientes.")
	@PutMapping("/api/clientes")
	public ResponseEntity<ResponseClientesDTO> put(@Valid @RequestBody PutClientesDTO dto) {

		ResponseClientesDTO response = new ResponseClientesDTO();

		try {

			ModelMapper modelMapper = new ModelMapper();
			Cliente cliente = modelMapper.map(dto, Cliente.class);
			
			clienteService.atualizar(cliente);
			
			response.setStatus(200);
			response.setMensagem("Cliente atualizado com sucesso.");
			response.setCliente(modelMapper.map(cliente, GetClientesDTO.class));

			return ResponseEntity.status(HttpStatus.OK).body(response);
			
		} catch (IllegalArgumentException e) {

			response.setStatus(400);
			response.setMensagem(e.getMessage());

			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
			
		} catch (Exception e) {

			response.setStatus(500);
			response.setMensagem(e.getMessage());

			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
		}
	}

	@ApiOperation("Serviço para exclusão de clientes.")
	@DeleteMapping("/api/clientes/{id}")
	public ResponseEntity<ResponseClientesDTO> delete(@PathVariable("id") Integer idCliente) {

		ResponseClientesDTO response = new ResponseClientesDTO();

		try {

			Cliente cliente = clienteService.excluir(idCliente);

			ModelMapper modelMapper = new ModelMapper();
			
			response.setStatus(200);
			response.setMensagem("Cliente excluído com sucesso.");
			response.setCliente(modelMapper.map(cliente, GetClientesDTO.class));
			
			return ResponseEntity.status(HttpStatus.OK).body(response);
			
		} catch (IllegalArgumentException e) {

			response.setStatus(400);
			response.setMensagem(e.getMessage());

			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
			
		} catch (Exception e) {

			response.setStatus(500);
			response.setMensagem(e.getMessage());

			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
		}
	}

	@ApiOperation("Serviço para consulta de clientes.")
	@GetMapping("/api/clientes")
	public ResponseEntity<List<GetClientesDTO>> getAll() {

		ModelMapper modelMapper = new ModelMapper();
		
		List<Cliente> clientes = clienteService.consultarTodos();
		List<GetClientesDTO> clientesDTO = modelMapper.map(clientes, new TypeToken<List<GetClientesDTO>>() {}.getType());
		
		return ResponseEntity.status(HttpStatus.OK).body(clientesDTO);
	}

	@ApiOperation("Serviço para consulta de cliente por id.")
	@GetMapping("/api/clientes/{id}")
	public ResponseEntity<GetClientesDTO> getById(@PathVariable("id") Integer idCliente) {

		Cliente cliente = clienteService.obterPorId(idCliente);
		
		if(cliente != null) {
			
			ModelMapper modelMapper = new ModelMapper();
			GetClientesDTO clienteDTO = modelMapper.map(cliente, GetClientesDTO.class);
			
			return ResponseEntity.status(HttpStatus.OK).body(clienteDTO);
		}
		else {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
		}			
	}
}










