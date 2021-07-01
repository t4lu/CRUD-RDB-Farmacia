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

import br.com.generation.farmarcia.model.Categoria;
import br.com.generation.farmarcia.repository.CategoriaRepository;

@RestController
@RequestMapping ("/categoria")
@CrossOrigin ("*")
public class CategoriaController {
	
	@Autowired
	private CategoriaRepository categoria;
	
	@GetMapping ("/listar")
	public List<Categoria> listar (){
		return categoria.findAll();
	}
	@GetMapping ("/id/{id}")
	public Categoria getById (@PathVariable long id) {
		return categoria.findById(id);
	}
	@GetMapping ("/descricao/{descricao}")
	public List<Categoria> findByDescricao (@PathVariable String descricao) {
		return categoria.findAllByDescricaoContainingIgnoreCase(descricao);
	}
	@PostMapping ("/criar")
	public Categoria novaCategoria (@RequestBody Categoria nova) {
		return categoria.save(nova);
	}
	@PutMapping ("/editar")
	public Categoria editarCategoria (@RequestBody Categoria edicao) {
		return categoria.save(edicao);
	}
	@DeleteMapping ("/excluir/{id}")
	public Categoria apagaAgoraaa (@PathVariable long id) {
		return categoria.deleteById(id);
	}
}