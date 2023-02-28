package br.com.cotiinformatica.dtos;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class GetClientesDTO {

	private Integer idCliente;
	private String nome;
	private String cpf;
	private String email;
	private String telefone;
	private Date dataCadastro;

}



