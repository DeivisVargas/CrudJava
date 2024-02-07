package br.com.agenda.dao;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.CompoundName;

import br.com.agenda.factory.ConnectionFactory;
import br.com.agenda.model.Contato;


public class ContatoDAO {
	//crud
	public void save(Contato contato) {
		
		String sql = "insert into contatos(nome,idade,dataCadastro) values(?,?,?)" ;
		Connection conn = null; 
		PreparedStatement pstm = null ;
		try {
			conn = ConnectionFactory.conectar();
			pstm = conn.prepareStatement(sql);
			//cria a conexao 
			pstm.setString(1, contato.getNome() );
			pstm.setInt(2, contato.getIdade() );
			pstm.setDate(3, new Date(contato.getdataCadastro().getTime()) );
			
			//executar a query 
			pstm.execute();
			System.out.println("Cadastro realizado ");
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			//fechando as conexoes
			try {
				if(pstm != null) {
					pstm.close();
				}
				if(conn != null) {
					conn.close();
				}
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}
	} 
	
	public void update(Contato contato) {
		String sql = "update contatos set nome = ? , idade = ? , dataCadastro = ?"+
	    "WHERE id = ? ";
		Connection conn = null; 
		PreparedStatement pstm = null ;
		try {
			conn = ConnectionFactory.conectar();
			pstm = conn.prepareStatement(sql);
			//cria a conexao 
			pstm.setString(1, contato.getNome() );
			pstm.setInt(2, contato.getIdade() );
			pstm.setDate(3, new Date(contato.getdataCadastro().getTime()) );
			pstm.setInt(4, contato.getId());
			
			//executar a query 
			pstm.execute();
			System.out.println("Cadastro alterado com sucesso ");
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			//fechando as conexoes
			try {
				if(pstm != null) {
					pstm.close();
				}
				if(conn != null) {
					conn.close();
				}
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}
	}
	
	public void deleteById(int id) {
		String sql = "delete from  contatos where id =  ?";
			    
				Connection conn = null; 
				PreparedStatement pstm = null ;
				try {
					conn = ConnectionFactory.conectar();
					pstm = conn.prepareStatement(sql);
					pstm.setInt(1, id);
					
					//executar a query 
					pstm.execute();
					System.out.println("Cadastro deletado com sucesso ");
					
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}finally {
					//fechando as conexoes
					try {
						if(pstm != null) {
							pstm.close();
						}
						if(conn != null) {
							conn.close();
						}
					} catch (Exception e2) {
						// TODO: handle exception
						e2.printStackTrace();
					}
				}
	}
	public List<Contato> getContatos(){
		String sql = "select * from contatos" ;
		List<Contato> contatos = new ArrayList<Contato>();
		
		Connection conn = null; 
		PreparedStatement pstm = null ;
		
		//classe que recupera os dados do banco de dados 
		ResultSet rset = null ; 
		try {
			conn = ConnectionFactory.conectar();
			pstm = conn.prepareStatement(sql);
			rset = pstm.executeQuery();
			
			while(rset.next()){
				Contato contato = new Contato();
				
				contato.setId(rset.getInt("id"));
				contato.setNome(rset.getString("nome"));
				contato.setIdade(rset.getInt("idade"));
				contato.setdataCadastro(rset.getDate("dataCadastro"));
				
				contatos.add(contato);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			try {
				if(rset != null) {
					rset.close();
				}
				if(pstm != null) {
					pstm.close();
				}
				if(conn != null) {
					conn.close();
				}
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}
		
		return contatos;
		
	}
}
