import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;
import  com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.util.HashMap;

public class Principal {
    public static void main(String[] args) {

       while (true){
           Scanner lectura = new Scanner(System.in);
           ConsultaAPI consulta = new ConsultaAPI();
           System.out.println("""
               Escriba una opcion entre 1 y 2:
               ********************************************
               1. DOLAR (USD) ==> PESOS COLOMBIANOS (COP)
               2. EURO (EUR) ==> PESOS COLOMBIANOS (COP)
               3. Salir
               ********************************************
               """);
           var opcion = lectura.nextLine();
            if (opcion.equalsIgnoreCase("3")){
                System.out.println("Entre al if y se cancela todo");
                break;
            }

           try {
               String tipoDeCambio = "COP";

               System.out.println("Ingrese la cantidad a cambiar\n");
               Integer monto = Integer.valueOf(lectura.nextLine());
               if (opcion.equalsIgnoreCase("1")){
                   tipoDeCambio = "USD";
               } else if (opcion.equalsIgnoreCase("2")) {
                    tipoDeCambio = "EUR";
               }
               Moneda moneda = consulta.consultaMoneda(tipoDeCambio);
               System.out.println("**********************************************************************");
               System.out.println("la cantidad de "+ monto+" " + tipoDeCambio + " es: " + (monto*moneda.conversion_rates().get("COP")) + " Pesos colombianos");
               System.out.println("**********************************************************************");
               Thread.sleep(2000);
//               System.out.println("El valor en USD es: " + rate);


               //    VisualizadorDeJson visualizador = new VisualizadorDeJson();
               //   visualizador.visualizarJson(moneda);
           } catch (Exception e){
               System.out.println("Hubo un error en la moneda a consultar: " + e.getMessage());
           }
       }

    }
}
