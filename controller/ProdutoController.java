package br.com.generation.farmarcia.controller;
/*Função: CRUD e RDB em Farmácia "farMárcia" (testagem no Postman)
 * Autora: Talu - Turma 25
 * Data: 01.07.2021
*/
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.generation.farmarcia.model.Produto;
import br.com.generation.farmarcia.repository.ProdutoRepository;

@RestController
@RequestMapping ("/produto")
@CrossOrigin (origins = "*", allowedHeaders = "*")
public class ProdutoController {
	
	@Autowired
	private ProdutoRepository produtos;
	
	@GetMapping ("/listar")
	public List<Produto> listar (){
		return produtos.findAll();
	}
	@GetMapping ("/id/{id}")
	public Produto getById (@PathVariable long id) {
		return produtos.findById(id);
	}
	@GetMapping ("/produto/{produto}")
	public List<Produto> getByNomeDoProduto (@PathVariable String nome){
		return produtos.findAllByProdutoContainingIgnoreCase(nome);
	}
	@GetMapping ("/marca/{marca}")
	public List<Produto> getByMarca (@PathVariable String marca) {
		return produtos.findAllByMarcaContainingIgnoreCase(marca);
	}
	@GetMapping ("/preco/{preco}")
	public List<Produto> getByPreco (@PathVariable double preco){
		return produtos.findAllByPreco(preco);
	}
	@PostMapping ("/criar")
	public Produto novoProduto (@RequestBody Produto novo) {
	return produtos.save(novo);
	}
	@PutMapping("/editar")
	public Produto editarProduto (@RequestBody Produto edicao) {
		return produtos.save(edicao);
	}
	@DeleteMapping ("/excluir/{id}")
	public Produto apagaAgoraaaa (@PathVariable long id) {
	return produtos.deleteById(id);
	}
}