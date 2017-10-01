package modelo.dominio;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import modelo.dominio.exception.DadosException;
import modelo.dominio.exception.ErroDeDominio;

@Entity
@Table(name = "tab_cliente")
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CLIENTE")
	@SequenceGenerator(name = "CLIENTE", allocationSize = 1, sequenceName = "SEQ_CLIENTE")
	private Integer codigo;

	@Column(name = "nome", length = 100)
	private String nome;

	@Column(name = "endereco", length = 100)
	private String endereco;

	@Column(name = "telefone", length = 100)
	private String telefone;

	@Column(name = "data_nascimento", length = 100)
	private String data_nascimento;

	@Column(name = "profissao", length = 100)
	private String profissao;

	@OneToMany(mappedBy = "cliente")
	private List<Agenda> agendas;

	@ManyToOne
	@JoinColumn(name = "convenio_fk", nullable = true)
	private Convenio convenio;

	public Cliente(Integer codigo, String nome, String endereco, String telefone, String data_nascimento,
			String profissao) {
		super();

		this.nome = nome;
		this.endereco = endereco;
		this.telefone = telefone;
		this.data_nascimento = data_nascimento;
		this.profissao = profissao;
	}

	public Cliente() {
		super();

	}

	public Convenio getConvenio() {
		return convenio;
	}

	public void setConvenio(Convenio convenio) {
		this.convenio = convenio;
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

	public String getNome()  {
		return nome;
	}

	public String getNomeStr() {
		if (this.nome == null)
			return "";

		return this.nome.toString();

	}

	public void setNome(String nome) throws DadosException {
		validaNome(nome);
		this.nome = nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public String getEnderecoStr() {
		if (this.endereco == null)
			return "";

		return this.endereco.toString();

	}

	public void setEndereco(String endereco) throws DadosException {
		validaEndereco(endereco);
		this.endereco = endereco;
	}

	public String getTelefone() {
		return telefone;
	}

	public String getTelefoneStr() {
		if (this.telefone == null)
			return "";

		return this.telefone.toString();

	}

	public void setTelefone(String telefone) throws DadosException {
		validaTelefone(telefone);
		this.telefone = telefone;
	}

	public String getData_nascimento() {
		return data_nascimento;
	}

	public String getData_nascimentoStr() {
		if (this.data_nascimento == null)
			return "";

		return this.data_nascimento.toString();

	}

	public void setData_nascimento(String data_nascimento) throws DadosException {
		validaDataNascimento(data_nascimento);
		this.data_nascimento = data_nascimento;
	}

	public String getProfissao() {
		return profissao;
	}

	public String getProfissaoStr() {
		if (this.profissao == null)
			return "";

		return this.profissao.toString();

	}

	public void setProfissao(String profissao) throws DadosException {
		validaProfissao(profissao);
		this.profissao = profissao;
	}

	public List<Agenda> getAgendas() {
		return agendas;
	}

	public void setAgendas(List<Agenda> agendas) {
		this.agendas = agendas;
	}

	@Override
	public String toString() {
		return "Cliente [codigo=" + codigo + ", nome=" + nome + ", endereco=" + endereco + ", telefone=" + telefone
				+ ", data_nascimento=" + data_nascimento + ", profissao=" + profissao + "]";
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
		Cliente other = (Cliente) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}

	// Bloco com os metodos de excecoes

	//Valida Nome
	public static void validaNome(String nome) throws DadosException {

		if (nome == null || nome.length() == 0)
			throw new DadosException(new ErroDeDominio(1, Cliente.class, "O nome nao pode estar em branco. Favor preencher o campo"));

	}

	//Valida Endereco
	public static void validaEndereco(String endereco) throws DadosException {

		if (endereco == null || endereco.length() == 0)
			throw new DadosException(new ErroDeDominio(1, Cliente.class, "O endereco nao pode estar em branco. Favor preencher o campo"));

	}
	
	//valida Data de Nascimento
	public static void validaDataNascimento (String dataNascimento) throws DadosException {
		if (dataNascimento == null || dataNascimento.length() == 0)
			throw new DadosException(new ErroDeDominio(1,Cliente.class,"A data de nascimento nao pode ficar em branco."));
		if (dataNascimento.length() > 8)
			throw new DadosException(new ErroDeDominio(2,Cliente.class,"Favor inserir uma data valida! Verifique o numero de carateres."));
		
	}
	
	//Valida Telefone
	public static void validaTelefone (String telefone) throws DadosException {
		if (telefone.length() < 8 || telefone.length() > 11)
			throw new DadosException (new ErroDeDominio(1, Cliente.class,"Favor inserir um telefone valido! Verifique o numero de caracteres."));
		
	}
	
	//Valida Profissao
	public static void validaProfissao (String profissao) throws DadosException {
		if (profissao == null || profissao.length() == 0)
			throw new DadosException (new ErroDeDominio(1, Cliente.class, "O campo nao pode ficar vazio."));
		
	}
	
	

}
