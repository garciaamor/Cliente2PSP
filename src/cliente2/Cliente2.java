
package cliente2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import javax.swing.JOptionPane;

public class Cliente2 {
//Hacer en casa
    
    public static void main(String[] args) {
        int num1=0;
        int num2=0;
        int result=0;
        char signo;
        
       try{
            System.out.println("Creando socket cliente");
            Socket clienteSocket=new Socket("localhost",5556);
            System.out.println("Estableciendo la conexion");

                        
            BufferedReader asdas = new BufferedReader(new InputStreamReader(clienteSocket.getInputStream()));
            
            
            OutputStream os= clienteSocket.getOutputStream();

            System.out.println("Enviando mensaje");
            
            num1 = Integer.parseInt(JOptionPane.showInputDialog("Escribe el primer número"));
            num2 = Integer.parseInt(JOptionPane.showInputDialog("Escriba el segundo número"));
            result = Integer.parseInt(JOptionPane.showInputDialog("Que operación quieres realizar? \n1= +\n2= -\n3= X\n4= / "));
            
            os.write(num1);
            os.write(num2);
            os.write(result);
            os.flush();

            int resRecib=asdas.read();
            System.out.println(resRecib);
            
            System.out.println("Cerrando el socket cliente");
            

            clienteSocket.close();

            System.out.println("Terminado");

            }catch (IOException e) {
                    e.printStackTrace();
            }
	}
}	