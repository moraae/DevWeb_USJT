
public class PaisService
{
	PaisDAO dao = new PaisDAO();

	public int inserir(Pais pais)
	{
		return dao.inserir(pais);
	}
 
	public void atualizar(Pais pais)
	{
		dao.atualizar(pais);
	}
 
	public Pais carregar(int id)
	{
		return dao.carregar(id);
	}
	
	public void excluir(int id)
	{
		dao.excluir(id);
	}
  
	public Pais maiorPopulacao()
	{
		return dao.maiorPopulacao();
	}

	public Pais menorArea()
	{
		return dao.menorArea();
	}
  
	public String[] vetorTresPaises()
	{
		return dao.vetorTresPaises();
	}
}