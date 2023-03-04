package br.com.cotiinformatica.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.cotiinformatica.entities.Cliente;

@Repository
public interface IClienteRepository extends JpaRepository<Cliente, Integer> {

	/*
	 * Consulta JPQL - Java Persistence Query Language
	 * para retornar 1 cliente do banco de dados através do email
	 * se nenhum cliente for encontrado, o método retorna null
	 */
	@Query("select c from Cliente c where c.email = :pEmail")
	Cliente findByEmail(@Param("pEmail") String email);
	
	/*
	 * Consulta JPQL - Java Persistence Query Language
	 * para retornar 1 cliente do banco de dados através do cpf
	 * se nenhum cliente for encontrado, o método retorna null
	 */
	@Query("select c from Cliente c where c.cpf = :pCpf")
	Cliente findByCpf(@Param("pCpf") String cpf);
}



