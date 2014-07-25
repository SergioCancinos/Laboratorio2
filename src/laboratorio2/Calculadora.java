/*
	Universidad del Valle de Guatemala
	Ana Bartra 13643
	Sergio Cancinos 13062 
	Calculadora.java
	Se encarga de revisar la cade y realizar las operaciones adem�s de utilizar la interfaz stack.java	
*/
package laboratorio2;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
@SuppressWarnings("unchecked")

public class Calculadora {
    static File archivo = new File("C:\\HDT2\\datos.txt"); //Almacena el archivo en donde se guardaran los datos
    java.io.File directorio = new File("C:\\HDT2"); 
    public static String data=new String();
    static Stack pila = new StackArrayList(); //Variable para utilizar la pila
    static int result=0; //Guardara el resutaldo de las operaciones
    static int dat1=0; // Dato 1 Que se saca de la pila
    static int dat2=0; // Dato2 que se saca de la pila
    
public static void main(String[] args) {
    
    data=leerDatos();
    int largo = data.length(); //largo de la lista
    for(int i=0;i<largo;i++){ //Se encarga de recorrer la lista 
        
		//En caso de que se encuentre una multiplicación
        if(Character.toString(data.charAt(i)).equals("*") && !pila.empty()){ 
            dat1=(int)pila.pop();
            dat2=(int)pila.pop();
            result=dat2*dat1;
            pila.push(result);
        }
		//En caso de que se encuentre una suma
		else if(Character.toString(data.charAt(i)).equals("+") && !pila.empty()){ 
            dat1=(int)pila.pop();
            dat2=(int)pila.pop();
            result=dat2+dat1;
            pila.push(result);
        }
		//En caso de que se encuentre una resta
		else if(Character.toString(data.charAt(i)).equals("-") && !pila.empty()){ 
            dat1=(int)pila.pop();
            dat2=(int)pila.pop();
            result=dat2-dat1;
            pila.push(result);
        }
		//En caso de que se encuentre una división
		else if(Character.toString(data.charAt(i)).equals("/") && !pila.empty()){
            dat1=(int)pila.pop();
            dat2=(int)pila.pop();
            result=dat2/dat1;
            pila.push(result);
        }
		//En caso de que se encuentre un espacio en blanco
		else if(!Character.toString(data.charAt(i)).equals(" ")){
            int ingresar=(int)data.charAt(i)-48; //Se le resta el 48 para que sea el número correcto de asciz
            pila.push(ingresar); 
            
        }
    }
    System.out.println("el resultado es: "+pila.pop()); //Se imprime el resultado
}
    public static String leerDatos(){//Se encarga de recolectar los datos del dato.txt
            FileReader fr = null;  
            BufferedReader br = null; 
            String datos = new String(); //el dato se guarda como string
            
            try{
                    fr = new FileReader(archivo);
                    br = new BufferedReader(fr);
                    String linea;
                    if ((linea = br.readLine())!=null){

                        datos=linea;
                    }
                    if(datos == null){
                        datos=" "; // si es espacio en blanco
                    }
                    return datos;
            }
			// En caso de errores
            catch(Exception e){
                    e.printStackTrace();
            }
            finally{
                    try{
                            if(null != fr ){
                                    fr.close();
                            }
                    }
                    catch(Exception e2){
                            e2.printStackTrace();
                    }
            }
            return datos;
    }
}    
    