/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cadastroveiculos;

/**
 *
 * @author charlistonrodrigo
 */
public class Cadastro {
    
}


public class CadastroVeiculos {
       public int tamanho = 0;
       Veiculos cabeca, cauda;
       
    public void criarLista(){
        cabeca = new Veiculos();
        cabeca.prox = cauda = null;
    }
    
    public void inserirNoFinal(Veiculos v) throws Exception{
        if (tamanho == 0 && v.codigo!=1) 
            throw new Exception ("O cÃƒÂ³digo do veÃƒÂ­culo estÃƒÂ¡ incorreto.");
        if ((tamanho > 0 ) && (v.codigo!=cauda.codigo+1))
            throw new Exception ("O cÃƒÂ³digo do veÃƒÂ­culo estÃƒÂ¡ incorreto.");
        if (tamanho == 0)
            cabeca.prox = v;
        else
            cauda.prox = v;
        
        cauda = v;
        
        tamanho++;      
    }
    
    public void inserirEspecial(Veiculos v)throws Exception{
        
        if(v.codigo > cauda.codigo)
            throw new Exception("Codigo incorreto");
        if(tamanho == 0){
            cabeca.prox = v;
            cauda = v;
            
        } else{
            Veiculos ant,at;
            ant = null;
            at = cabeca.prox;
            
            while(at.codigo != v.codigo){
                ant = at;
                at = at.prox;
            }
            v.prox = ant.prox;
            ant.prox = v;
            
            while(at != null){
                at.codigo++;
                at = at.prox;
            }
        }
        tamanho++;
    }
    
    public void excluirPorCodigo(int codigo)throws Exception{
        if(tamanho == 0)
            throw new Exception("Cadastro vazio");
        
        Veiculos ant,at;
        boolean achou = false;
        ant = null;
        at = cabeca.prox;
        
        while(at != null){
            if(at.codigo == codigo){
               achou = true;
               break;
            }
            ant = at;
            at = at.prox;
        }
        if(!achou)
            throw new Exception("Codigo invalido");
         tamanho--;
        if (tamanho == 0) // apagou o ÃƒÂºnico que tinha
            cabeca.prox = cauda = null;
        else if (at == cauda) { // O cÃƒÂ³digo era do ÃƒÂºltimo
            cauda = ant;
            ant.prox = null;
        } else if (at == cabeca.prox) { // O cÃƒÂ³digo era do primeiro
            cabeca.prox = at.prox;
      
        } else {
            ant.prox = at.prox;
        }
        // Atualizando os cÃƒÂ³digos
        at = at.prox;
        while (at!=null){
            at.codigo--;
            at = at.prox;
        }
        
    }
    public void print(){
        Veiculos v = cabeca.prox;
        while (v!=null){
            System.out.println(v.codigo + " " + v.marca);
            v = v.prox;
        }
        System.out.println("-------------------------------------\n\n\n");
                
    }
    public static void main(String[]args) throws Exception{
        Veiculos v1 = new Veiculos(1, "HHH", "Monza", "Wv", 11, 12, 25000);
        Veiculos v2 = new Veiculos(2, "HHH", "Voyage", "Wv", 11, 12, 35000);
        Veiculos v3 = new Veiculos(3, "HHH", "Fusca", "Wv", 11, 12, 35000);
        Veiculos v4 = new Veiculos(2, "HHH", "Chevete", "Wv", 11, 12, 35000);
        Veiculos v5 = new Veiculos(4, "HHH", "Opala", "Wv", 11, 12, 35000);
        CadastroVeiculos lista = new CadastroVeiculos();
        lista.criarLista();
        lista.inserirNoFinal(v1);
        lista.inserirNoFinal(v2);
        lista.inserirNoFinal(v3);
        lista.inserirEspecial(v4);
        lista.inserirEspecial(v5);
        lista.print();
        lista.excluirPorCodigo(1);
        lista.print();
        lista.excluirPorCodigo(1);
        lista.print();
        lista.excluirPorCodigo(3);
        lista.print();
        lista.excluirPorCodigo(1);
        
        lista.print();
    }
}

       
  

    
