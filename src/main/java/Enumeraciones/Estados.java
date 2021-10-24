
package Enumeraciones;


public enum Estados {

   
    DISPONIBLE("Disponible"),OCUPADO("Ocupado"),EN_ESPERA("En espera");
     private final String estado;
   Estados(String estado){
       this.estado = estado;
    }
   public String getEstado(){
       return this.estado;
   }
}
