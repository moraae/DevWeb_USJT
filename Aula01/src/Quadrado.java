
public class Quadrado extends Poligonos implements Diagonal
{	
	public Quadrado(double base, double altura)
	{
		super(base, altura);
	}
	
	
	public double perimetro()
	{
		return getBase() * 4;
	}
	
	
	public double area()
	{
		return getBase() * getAltura();
	}
	
	@Override
	public double diagonal()
	{
		return getBase() * (Math.sqrt(2));
	}
	
	public String toString()
	{
		return "\n\nQuadrado:\nArea: "+area()+"\nPerimetro: "+perimetro()+"\nDiagonal: "+diagonal();
	}
}