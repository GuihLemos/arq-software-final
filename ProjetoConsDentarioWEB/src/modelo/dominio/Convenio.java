package modelo.dominio;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "tab_convenio")
public class Convenio {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CONVENIO")
	@SequenceGenerator(name = "CONVENIO", allocationSize = 1, sequenceName = "SEQ_CONVENIO")
	private Integer codigo;

	@Column(name = "nome_convenio", length = 20)
	private String nome_convenio;

	@Column(name = "data_adesao", length = 12)
	private String data_adesao;
	@Column(name = "inadiplente", length = 10)
	private String inadiplente;

	@OneToMany(mappedBy = "convenio")
	private List<Cliente> cliente;

	public Convenio(Integer codigo, String nome_convenio, String data_adesao, String inadiplente) {
		super();
		this.codigo = codigo;
		this.nome_convenio = nome_convenio;
		this.data_adesao = data_adesao;
		this.inadiplente = inadiplente;

	}

	public Convenio() {
		super();

	}

	public List<Cliente> getCliente() {
		return cliente;
	}

	public void setCliente(List<Cliente> cliente) {
		this.cliente = cliente;
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

	public String getNome_convenio() {
		return nome_convenio;
	}

	public String getNome_convenioStr() {
		if (this.nome_convenio == null)
			return "";

		return this.nome_convenio.toString();
	}

	public void setNome_convenio(String nome_convenio) {
		this.nome_convenio = nome_convenio;
	}

	public String getData_adesao() {
		return data_adesao;
	}

	public String getData_adesaoStr() {
		if (this.data_adesao == null)
			return "";

		return this.data_adesao.toString();
	}

	public void setData_adesao(String data_adesao) {
		this.data_adesao = data_adesao;
	}

	public String getInadiplente() {
		return inadiplente;
	}

	public String getInadiplenteStr() {
		if (this.inadiplente == null)
			return "";

		return this.inadiplente.toString();
	}

	public void setInadiplente(String inadiplente) {
		this.inadiplente = inadiplente;
	}

	@Override
	public String toString() {
		return "Convenio [codigo=" + codigo + ", nome_convenio=" + nome_convenio + ", data_adesao=" + data_adesao
				+ ", inadiplente=" + inadiplente + "]";
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
		Convenio other = (Convenio) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}

}
