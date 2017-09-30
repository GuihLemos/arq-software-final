package modelo.dao;

import java.util.List;

import javax.persistence.TypedQuery;


import modelo.dominio.Convenio;

public class ConvenioDAO extends JpaDAO<Convenio> {
	
public List<Convenio> buscarNome(String filtro) {
		
		String consulta ="from Convenio c where c.nome_convenio like :filtro order by c.codigo";
		TypedQuery<Convenio> query = this.getEntityManager().createQuery(consulta,Convenio.class);
		
		query.setParameter("filtro", "%" + filtro + "%");
		
		return query.getResultList();
	}

}
