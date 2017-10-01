package modelo.dominio;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import modelo.dominio.exception.DadosException;
import modelo.dominio.exception.ErroDeDominio;



@Entity
@Table(name="tab_agenda")
public class Agenda {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="AGENDA")
	@SequenceGenerator(name="AGENDA", allocationSize=1,
						sequenceName="SEQ_AGENDA")
	private Integer codigo;
	@Column(name="data",length=100)
	private String data;
	@Column(name="horario",length=100)
	private String horario;
	
	@ManyToOne
	@JoinColumn(name="cliente_fk", nullable=true)
	private Cliente cliente;
	
		


	public Agenda(Integer codigo, String data, String horario) {
		super();
		this.codigo = codigo;
		this.data = data;
		this.horario = horario;
		
	}

	public Agenda() {
		super();
		
	}

	public Integer getCodigo() {
		return codigo;
	}
	
	public String getCodigoStr() {
		if (this.codigo == null)
			return "";
		
		return this.codigo.toString();
	}
	

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getData() {
		return data;
	}
	public String getDataStr() {
		if (this.data == null)
			return "";
		
		return this.data.toString();
	}

	public void setData(String data) throws DadosException {
		validaData(data);
		this.data = data;
	}

	public String getHorario() {
		return horario;
	}
	public String getHorarioStr() {
		if (this.horario == null)
			return "";
		
		return this.horario.toString();
	}

	

	public void setHorario(String horario) {
		this.horario = horario;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	
	
	

	@Override
	public String toString() {
		return "Agenda [codigo=" + codigo + ", data=" + data + ", horario=" + horario + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Agenda other = (Agenda) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}
	
	//Bloco com metodos de validacao
	
	//valida Data
		public static void validaData (String data) throws DadosException {
			if (data == null || data.length() == 0)
				throw new DadosException(new ErroDeDominio(1,Agenda.class,"A data nao pode ficar em branco."));
			if (data.length() > 8)
				throw new DadosException(new ErroDeDominio(2,Agenda.class,"Favor inserir uma data valida! Verifique o numero de carateres."));
			
		}

	
	
	

}
