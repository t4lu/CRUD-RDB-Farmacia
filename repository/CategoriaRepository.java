package br.com.generation.farmarcia.repository;
/*Função: CRUD e RDB em Farmácia "farMárcia" (testagem no Postman)
 * Autora: Talu - Turma 25
 * Data: 01.07.2021
*/
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.generation.farmarcia.model.Categoria;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long>{

	public List<Categoria> findAll ();
	
	public List<Categoria> findAllByDescricaoContainingIgnoreCase (String descricao);
	
	public Categoria findById (long id);
	
	public Categoria deleteById (long id);
} 
