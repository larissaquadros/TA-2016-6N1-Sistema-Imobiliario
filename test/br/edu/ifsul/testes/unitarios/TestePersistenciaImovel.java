/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.testes.unitarios;

import br.edu.ifsul.modelo.Caracteristica;
import br.edu.ifsul.modelo.Cidade;
import br.edu.ifsul.modelo.Condominio;
import br.edu.ifsul.modelo.Estado;
import br.edu.ifsul.modelo.Imovel;
import br.edu.ifsul.modelo.Imovel_;
import br.edu.ifsul.modelo.Pessoa;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Larissa
 */
public class TestePersistenciaImovel {
    
    EntityManagerFactory emf;
    EntityManager em;
    
    public TestePersistenciaImovel() {
    }
    
    @Before
    public void setUp() {
        emf =  Persistence.createEntityManagerFactory("TA-2016-6N1-Model-Sistema-ImobiliarioPU");
        em = emf.createEntityManager();
    }
    
    @After
    public void tearDown() {
        em.close();
        emf.close();
    }
    
    @Test
    public void teste(){
        boolean exception = false; //meu teste nao vai ter exessão é isso que significa isso

        //testar persistencia
        try{
                  
            Imovel i = new Imovel();
            
            i.setCondominio(em.find(Condominio.class, 1));
            i.setCidade(em.find(Cidade.class, 1));
            i.setProprietario(em.find(Pessoa.class, 1));
            i.setBairro("Petrópolis");
            i.setEndereco("Avenida Brasil Leste");
            i.setNumero("544");
                       
                    
            em.getTransaction().begin();
            em.persist(i);            
            em.getTransaction().commit();
        }catch(Exception e){
            exception = true;
            e.printStackTrace();
        }
        
        Assert.assertEquals(false, exception); //verifico se o esperado ocorreu 
        
    }
    
}