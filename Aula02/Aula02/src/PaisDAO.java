
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PaisDAO
{
   //insert
	public int inserir(Pais pais)
	{
		String sqlInsert = "insert into pais(nome, populacao, area) values(?,?,?)";
      String sqlQuery = "select last_insert_id()";
		try(Connection conn = ConnectionFactory.conexao();
			PreparedStatement stm = conn.prepareStatement(sqlInsert);)
		{
			stm.setString(1,pais.getNome());
			stm.setLong(2,pais.getPopulacao());
			stm.setDouble(3,pais.getArea());
			stm.execute();
         try(PreparedStatement stm2 = conn.prepareStatement(sqlQuery);
            ResultSet rs = stm2.executeQuery();)
         {
            if(rs.next())
            {
               pais.setId(rs.getInt("id"));
            }
         }catch(Exception e)
         {
            e.printStackTrace();
         }
		}catch(SQLException e1)
		{
			System.out.println(e1.getStackTrace());
		}
      return pais.getId();
	}
   //delete
	public void excluir(int id)
	{
		String sqlDelete = "Delete from pais where id = ?";
		try(Connection conn = ConnectionFactory.conexao();
			PreparedStatement stm = conn.prepareStatement(sqlDelete);)
		{
			stm.setInt(1,id);
			stm.execute();
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
	}
   //update
	public void atualizar(Pais pais)
	{
		String sqlUpdate = "Update pais set nome = ?, populacao = ?, area = ? where id = ?";
		try(Connection conn = ConnectionFactory.conexao();
			PreparedStatement stm = conn.prepareStatement(sqlUpdate);)
		{
			stm.setString(1,pais.getNome());
			stm.setLong(2,pais.getPopulacao());
			stm.setDouble(3,pais.getArea());
			stm.setInt(4,pais.getId());
			stm.execute();
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
	}
   //select
	public Pais carregar(int id)
	{
      Pais pais = new Pais(id);
		String sqlSelect = "select nome, populacao, area from pais where id = ?";
		try(Connection conn = ConnectionFactory.conexao();
			PreparedStatement stm = conn.prepareStatement(sqlSelect);)
		{
         stm.setInt(1,pais.getId());
			try(ResultSet rs = stm.executeQuery();)
			{
				if(rs.next())
				{
					pais.setNome(rs.getString("Nome"));
					pais.setPopulacao(rs.getLong("Populacao"));
					pais.setArea(rs.getDouble("Área"));
				}else
				{
					pais.setId(-1);
					pais.setNome(null);
					pais.setPopulacao(-1);
					pais.setArea(-1);
				}
			}catch(Exception e)
			{
				e.printStackTrace();
			}
		}catch(SQLException e1)
		{
			System.out.println(e1.getStackTrace());
		}
      return pais;
	}
   //maiorPopulacao
   public Pais maiorPopulacao()
	{
		String sqlSelect = "select * from pais where populacao = (select max(populacao) from pais)";
		Pais pais = new Pais();
		try(Connection conn = ConnectionFactory.conexao();
			PreparedStatement stm = conn.prepareStatement(sqlSelect);)
		{
			try(ResultSet rs = stm.executeQuery())
			{
				if(rs.next())
				{
					pais.setId(rs.getInt("Id"));
					pais.setNome(rs.getString("Nome"));
					pais.setPopulacao(rs.getLong("Populacao"));
					pais.setArea(rs.getDouble("Área"));
				}
			}catch(Exception e)
			{
				e.printStackTrace();
			}
		}catch(SQLException e1)
		{
			System.out.println(e1.getStackTrace());
		}
		return pais;
	}
  
	public Pais menorArea()
	{
		String sqlSelect = "select * from pais where area = (select min(area) from pais)";
		Pais pais = new Pais();
		try(Connection conn = ConnectionFactory.conexao();
			PreparedStatement stm = conn.prepareStatement(sqlSelect);)
		{
			try(ResultSet rs = stm.executeQuery())
			{
				if(rs.next())
				{
					pais.setId(rs.getInt("Id"));
					pais.setNome(rs.getString("Nome"));
					pais.setPopulacao(rs.getLong("População"));
					pais.setArea(rs.getDouble("Área"));
				}
			}catch(Exception e)
			{
				e.printStackTrace();
			}
		}catch(SQLException e1)
		{
			System.out.println(e1.getStackTrace());
		}
		return pais;
	}
   
	public String[] vetorTresPaises()
	{
	    String[] vetor = new String[3];
       int i = 0;
	    String sqlSelect = "select * from pais";
	    try(Connection conn = ConnectionFactory.conexao();
	     		PreparedStatement stm = conn.prepareStatement(sqlSelect);)
	    {
	        try(ResultSet rs = stm.executeQuery();)
	        {
         	  while(rs.next() && i < vetor.length)
        		  {  
					  Pais pais = new Pais();
        			  pais.setId(rs.getInt("Id"));
           	  	  pais.setNome(rs.getString("Nome"));
           		  pais.setPopulacao(rs.getLong("População"));
           		  pais.setArea(rs.getDouble("Área"));
           	     vetor[i] = pais.toString();
                 i++;
           	  }
            }catch(SQLException e)
              {
                 e.printStackTrace();
              }
        }catch(SQLException e1)
        {
           System.out.println(e1.getStackTrace());
        }              
     return vetor;
	}
}