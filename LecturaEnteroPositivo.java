import java.util.*;

public class LecturaEnteroPositivo
{
	public static void main(String[] args) 
	{
	    int[] vec = {20,45,76,1,34,567,423,6,3,5};
	    Scanner teclado = new Scanner(System.in);
		int indice;
		try{
		    System.out.print("Ingrese un valor entre 0 y 9: ");
		    indice = teclado.nextInt();
		    System.out.print ("En el vector se almacena la posición " + indice + "el valor " + vec[indice]);
		}
		catch(InputMismatchException ex){
		    System.out.println("Debes ingresar obligatoriamente número entero");
		}
		catch(IndexOutOfBoundsException ex){
		    System.out.println("El valor debe estar entre 0 y 9");
		}
	}
}
