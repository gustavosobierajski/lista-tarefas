package br.com.desafiojava.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;

import br.com.desafiojava.model.Tarefa;
import br.com.desafiojava.repository.TarefaRepository;

@Api(value = "tarefa") //Diz ao Swagger que esse é um endpoint e REST deve ser documentado
@RestController
@RequestMapping("/tarefa")
public class TarefaController {
    
	//delega ao Spring Boot a inicialização do objeto 
	@Autowired
    private TarefaRepository _tarefaRepository;

	@ApiOperation(value = "Listar Tarefa" )
    @RequestMapping(value = "/tarefa", method = RequestMethod.GET, 
            produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Tarefa> Get() {	
		
		return _tarefaRepository.findAll();	
    }
	
	@ApiOperation(value = "Adicionar Tarefa" )
    @RequestMapping(value = "/tarefa", method =  RequestMethod.POST,
    	    //Mapeia as requisições POST 
            consumes = MediaType.APPLICATION_JSON_VALUE)
            // Consome JSON enviado no corpo da requisição
	@ResponseStatus(HttpStatus.OK)
    public Tarefa Post(@Valid @RequestBody Tarefa tarefa){
		
		return _tarefaRepository.save(tarefa);	
    }

	@ApiOperation(value = "Concluir Tarefa" )
    @RequestMapping(value = "/tarefa/{id}", method =  RequestMethod.PUT,
    consumes = MediaType.APPLICATION_JSON_VALUE,
            // Consome JSON enviado no corpo da requisição
            produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Tarefa> ConcluirTarefa(@PathVariable(value = "id") long id,
    		@Valid @RequestBody Tarefa newTarefa) {
		
		Tarefa tarefa = _tarefaRepository.findOne(id);
		if(tarefa != null){                  
			tarefa.setFl_status(1);
			_tarefaRepository.save(tarefa);
			return new ResponseEntity<Tarefa>(tarefa, HttpStatus.OK);
		}
		else {
			return new ResponseEntity<Tarefa>(HttpStatus.NOT_FOUND);					
		}
    }

	@ApiOperation(value = "Deletar Tarefa" )
    @RequestMapping(value = "/tarefa/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Tarefa> Delete(@PathVariable(value = "id") long id){
		
		Tarefa tarefa = _tarefaRepository.findOne(id);
		if(tarefa != null){
			_tarefaRepository.delete(tarefa);
			return new ResponseEntity<Tarefa>(HttpStatus.OK);
		}
		else {
			return new ResponseEntity<Tarefa>(HttpStatus.NOT_FOUND);			
		}		
    }
}