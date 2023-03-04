package br.com.cotiinformatica.dtos;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

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
public class PutClientesDTO {

	@Min(value = 1, message = "Por favor, informe um id maior do que zero.")
	private Integer idCliente;
	
	@Size(min = 6, max = 150, message = "Nome do cliente deve ter de 6 a 150 caracteres.")
	@NotBlank(message = "Por favor, informe o nome do cliente.")
	private String nome;
	
	@Pattern(regexp = "^[0-9]{11}$", message = "CPF deve ter exatamente 11 dígitos numéricos.")
	@NotBlank(message = "Por favor, informe o cpf do cliente.")
	private String cpf;
	
	@Email(message = "Informe um endereço de email válido.")
	@NotBlank(message = "Por favor, informe o email do cliente.")
	private String email;
	
	@Pattern(regexp = "^[0-9]{11}$", message = "Telefone deve ter 11 dígitos numéricos (DDD + Telefone)")
	@NotBlank(message = "Por favor, informe o telefone do cliente.")
	private String telefone;
}