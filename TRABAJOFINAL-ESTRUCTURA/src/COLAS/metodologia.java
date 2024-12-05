package COLAS;


/**
 *
 * @author JorgeBrayham
 */
public class metodologia {
    Object cola [] = new Object[11];
    int bola = 0;
    
    public  void Push(String x) {
        if(bola<11){
            cola[bola] = x;
            bola++;
            
        }
    }
    
    public void Pop(){
        if(bola>0){
            cola[0]=null;
            for(int z = 1;z<bola;z++)
                cola[z-1]=cola[z];
        }
            bola--;
        }
            
    
    
    public String VerCola(){
        String v="";
        if(bola==0){
           v="elemento : " ;
        } 
        else{
            for(int o=0;o<bola;o++)
                v+=("elemento: "+ (o+1) + " " + cola [o] + "\n");
            }
            return v;
    }
    
    public String Elementos(){
        String elementos="";
        elementos=("Elementos: " + bola);
        return elementos;
    }
    
    public String EstaLLena(){
        String llena = "";
        if(bola==0){
            llena="LLena";
        }
        else{
            llena= " esta llena";
        }
        return llena;
    }
    
     public String EstaVacia(){
        String vacia = "";
        if(bola==11){
            vacia="No";
        }
        else{
            vacia= "si";
        }
        return vacia;
    }
    
      public String Primero(){
        String prim = "";
        if(cola[0] != null){
           prim=("primero: " + cola[0]);
        }
        else{
            prim= ("no hay elementos");
        }
        return prim;
    }
    
       public String Ultimo(){
        String ul = "";
        if(cola[0] != null){
           ul=("Ultimo: " + cola[bola-1]);
        }
        else{
            ul= ("no hay elementos");
        }
        return ul;
    }
    
       public void VaciarCola(){
           for(int t = bola-1; t>=0 ; t--){
               cola[t]= null;
               bola=0;
           }
       }
    
    
    
    
    
}





















