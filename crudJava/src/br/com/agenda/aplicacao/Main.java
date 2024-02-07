package br.com.agenda.aplicacao;

import java.util.Date;

import br.com.agenda.dao.ContatoDAO;
import br.com.agenda.model.Contato;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ContatoDAO contatodao = new ContatoDAO();
		
		Contato contato = new Contato();
		
		contato.setId(1);
		contato.setNome("Deivis Vargas Pereira");
		contato.setIdade(35);
		contato.setdataCadastro(new Date());
		
		//contatodao.save(contato);
		//contatodao.update(contato);
		//contatodao.deleteById(4);
		
		
		//visualizacao dos registros  todos
		for (Contato c  : contatodao.getContatos()) {
			System.out.println("#"+c.getId()+"Contato:" + c.getNome()+" Idade"+c.getIdade());
		}
		
		
		
		
	}

}
