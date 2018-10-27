package Utilitarios;

public class Corretores {
    public static String converterParaSQL(String Data) {
        
        return Data.substring(6, 10) + "-" + Data.substring(3, 5) + "-" + Data.substring(0, 2);
    }
    
    public static String converterParaJava(String Data) {
        
        return Data.substring(8, 10) + "/" + Data.substring(5, 7) + "/" + Data.substring(0, 4);
    }
    //public static void main (String args[]){
       // System.out.println(Corretores.ConverterParaJava("2018/02/03"));
    //} 
}