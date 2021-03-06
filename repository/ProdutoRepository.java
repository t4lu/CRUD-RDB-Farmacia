package br.com.generation.farmarcia.repository;
/*Função: CRUD e RDB em Farmácia "farMárcia" (testagem no Postman)
 * Autora: Talu - Turma 25
 * Data: 01.07.2021
*/
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.generation.farmarcia.model.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto,Long>{
	
	public List<Produto> findAll();
	
	public List<Produto> findAllByProdutoContainingIgnoreCase (String produtos);
	
	public List<Produto> findAllByMarcaContainingIgnoreCase (String marca);
	
	public List<Produto> findAllByPreco (double preco);
	
	public Produto findById (long id);
	
	public Produto deleteById (long id);
}