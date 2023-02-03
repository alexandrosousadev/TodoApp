/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Project;
import util.ConnectionFactory;


/**
 *
 * @author ALEXANDRO
 */
public class ProjectController {
     public void save(Project project){
        String sql = "INSERT INTO Projects (name,"
                + "description,"
                + "createdAt,"
                + "updatedAt) VALUES (?,?,?,?)";
        Connection connection = null;
        PreparedStatement statement = null;
        
        try {
            
            //cria uma conexao com o banco
            connection = ConnectionFactory.getConnection();
            //cria um PreparedStament, classe usada para executar a query
            statement = connection.prepareStatement(sql);
            
            statement.setString(1, project.getName());
            statement.setString(2, project.getDescription());
            statement.setDate(3, new java.sql.Date (project.getCreatedAt().getTime()));
            statement.setDate(4, new java.sql.Date(project.getUpdatedAt().getTime()));
            //Executa a sql para inserção dos dados
            statement.execute();
        } catch (SQLException ex) {
            throw new RuntimeException("Erro ao salvar a tarefa", ex);
        } finally {
            ConnectionFactory.closeConnection(connection, statement);
                     
        }
    }
    
     
        public void update(Project project) {
             String sql = "UPDATE projects SET name = ?, description = ?, createdAt = ?, updatedAt = ? WHERE id = ?";
        
        Connection connection = null;
        PreparedStatement statement = null;
         try {
            //estabelecendo a conexão com o banco de dados
            connection = ConnectionFactory.getConnection();
            
            //Preparando a query
            statement = connection.prepareStatement(sql);
            
            //Setando os valores do Statement
            statement.setString(1, project.getName());
            statement.setString(2, project.getDescription() );
            statement.setDate(3, new Date(project.getCreatedAt().getTime()));
            statement.setDate(4, new Date(project.getUpdatedAt().getTime()));         
            statement.setInt(5, project.getId());
            
            //Executando a query
            statement.execute();
        } catch (SQLException ex) {
            
            throw new RuntimeException("Erro ao atualizar a tarefa" ,ex);  
        }finally {
            try {
                if (statement!= null) {
                    statement.close();
                }
                if (connection!= null) {
                    connection.close();
                }
            } catch (SQLException ex) {
                throw new RuntimeException("Erro ao fechar a conexÃ£o", ex);
            }
        }
        
    }
        
        public List<Project> getAll(){
             String sql = "SELECT * from projects";
             
        List<Project> projects = new ArrayList<>();     
        
        Connection connection = null;
        PreparedStatement statement = null;
        
        ResultSet resultSet = null;
        
            try {
                 connection = ConnectionFactory.getConnection();
                 statement = connection.prepareStatement(sql);
                 
                 resultSet = statement.executeQuery();
                 
            while (resultSet.next()) {
                
                Project project = new Project();
                project.setId(resultSet.getInt("id"));
                project.setName(resultSet.getString("name"));
                project.setDescription(resultSet.getString("description"));
                project.setCreatedAt(resultSet.getDate("createdAt"));
                project.setUpdatedAt(resultSet.getDate("updatedAt"));
                
                //Adiciono o contato recuperado, a lista de contatos
                projects.add(project);
            }     
            } catch (SQLException ex) {
                 throw new RuntimeException("Erro ao buscar os projetos" ,ex);
        }finally {
            ConnectionFactory.closeConnection(connection, statement, resultSet);
        }  
           
         return projects;
            
        }
        
       public void removeById(int IdProject) {
        
        String sql = "DELETE FROM projects WHERE id = ?";
        
        Connection connection  = null;
        PreparedStatement statement = null;
        
        //tratamento de erro
        try { 
            //Criaçao da conexão com o banco de dados
           connection = ConnectionFactory.getConnection();
           
           //Preparando a query
           statement = connection.prepareStatement(sql);
           
           //Setando os valores
           statement.setInt(1, IdProject);
           
           //Executando a query
           statement.execute(); 
           
        } catch (SQLException ex) {
            throw new RuntimeException("Erro ao deletar o projeto" + ex);
        } finally {
            ConnectionFactory.closeConnection(connection, statement);
            
            
        }     
}
}

    
    
    
    
    
    

