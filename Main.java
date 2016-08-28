/**
 * @author carlos
 *
 */
import static java.lang.System.*;
import java.util.Scanner;
import java.util.Set;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int set = 0;
		Scanner sc = new Scanner(System.in);
		Factory factor = new Factory();
		Set<String>[] deve = new Set[4];
		while (set != 4) {
			out.println("Elegir Set");
			out.println("1. HashSet");
			out.println("2. TreeSet");
			out.println("3. LinkedHashSet");
			out.println("4. Salir");
			try {
				set = sc.nextInt();
				if (set < 4 && set > 0) {
					for (int i = 0; i != deve.length; i++) {
						deve[i] = factor.create(set-1);
					}
					String ans = "S";
					while (ans.equals("S")) {
						out.println("Agregar desarrollador: ");
						String developer = "";
						developer = sc.next();
						int dev = 0;
						while (dev != 4) {
							out.println("Ambiente del desarrollador:");
							out.println("1. Desarrollador Java");
							out.println("2. Desarrollador Web");
							out.println("3. Desarrollador móvil");
							out.println("4. Finalizar");
							set = 4;
							try {
								dev = sc.nextInt();
								if (dev < 4 && dev > 0) {
									deve[dev-1].add(developer);
								}
							}catch (Exception e) {
								out.println("Ingrese un número válido");
								sc.nextLine();
							}
						}
						out.println("¿Desea ingresar otro desarrollador? S/N");
						ans = sc.next().toUpperCase();	
					}
					out.println("Java: " + deve[0].toString().toUpperCase());
					out.println("Web: " + deve[1].toString().toUpperCase());
					out.println("Móvil: " + deve[2].toString().toUpperCase());
					out.println("Desarrolladores con experiencia Java, Web y Móvil:");
					deve[3].addAll(deve[0]);
					deve[3].retainAll(deve[1]);
					deve[3].retainAll(deve[2]);
					out.println(deve[3].toString().toUpperCase());
					
					out.println("Desarrolladores con experiencia Java y no Móvil:");
					deve[3].clear();
					deve[3].addAll(deve[0]);
					deve[3].addAll(deve[2]);
					deve[3].removeAll(deve[2]);
					out.println(deve[3].toString().toUpperCase());
					
					out.println("Desarrolladores con experiencia Web y Móvil, pero no Java:");
					deve[3].containsAll(deve[2]);
					deve[3].clear();
					deve[3].addAll(deve[1]);
					deve[3].retainAll(deve[2]);
					deve[3].removeAll(deve[0]);
					out.println(deve[3].toString().toUpperCase());
					
					out.println("Desarrolladores con experiencia Web o Móvil, pero no Java:");
					deve[3].clear();
					deve[3].addAll(deve[1]);
					deve[3].addAll(deve[2]);
					deve[3].removeAll(deve[0]);
					out.println(deve[3].toString().toUpperCase());
					
					out.println("¿Es el conjunto de programadores Java un subconjunto de Desarrolladores Web?");
					out.println(deve[1].containsAll(deve[0]) ? "Es un subconjunto" : "No es subconjunto");
				}
			} catch (Exception e) {
				out.println("Ingrese un número válido");
				sc.nextLine();
			}
		}
		sc.close();
	}
}
