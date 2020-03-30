import java.util.ArrayList;


public class Geometria
{
	public static void main(String[] args)
	{
		ArrayList<Figuras> figuras = new ArrayList<Figuras>();
		ArrayList<Figuras3D> figuras3D = new ArrayList<Figuras3D>();
	
		figuras.add(new Triangulo (4,6));
		figuras.add(new Circulo(5));
		figuras.add(new Losango(8,10));
		figuras.add(new Retangulo(10,13));
		figuras.add(new Quadrado(7,7));
		figuras.add(new Trapezio(5,11,9));
		
		figuras3D.add(new Cubo(10,10));
		figuras3D.add(new Cilindro(10,6));
		figuras3D.add(new Esfera(10,5));
		figuras3D.add(new Piramide(10,5));
		
		for(int i = 0; i < figuras.size(); i++)
		{
			System.out.println(figuras.get(i).toString());
		}
		
		for(int i = 0; i < figuras3D.size(); i++)
		{
			System.out.println(figuras3D.get(i).toString());
		}
	}
}