
public class Atendimento {
	private String risco;
	private String nome_profissional;
	private String especialidade;
	private String horario_entrada;
	private String inicio_atendimento;
	private String fim_atendimento;
	private String nome_paciente;
	private String idade;
	private String sexo;
	private String tempo;
	private String tipo_atendimento;
	private String hora;
	private String minuto;
	private String data;
	
	public Atendimento() {}
	public Atendimento(String risco, String nome_profissional, String especialidade, String horario_entrada,
			String inicio_atendimento, String fim_atendimento, String nome_paciente, String idade, String sexo,
			String tempo, String tipo_atendimento, String hora, String minuto, String data) {
		super();
		this.risco = risco;
		this.nome_profissional = nome_profissional;
		this.especialidade = especialidade;
		this.horario_entrada = horario_entrada;
		this.inicio_atendimento = inicio_atendimento;
		this.fim_atendimento = fim_atendimento;
		this.nome_paciente = nome_paciente;
		this.idade = idade;
		this.sexo = sexo;
		this.tempo = tempo;
		this.tipo_atendimento = tipo_atendimento;
		this.hora = hora;
		this.minuto = minuto;
		this.data = data;
	}
	public String getRisco() {
		return risco;
	}
	public void setRisco(String risco) {
		this.risco = risco;
	}
	public String getNome_profissional() {
		return nome_profissional;
	}
	public void setNome_profissional(String nome_profissional) {
		this.nome_profissional = nome_profissional;
	}
	public String getEspecialidade() {
		return especialidade;
	}
	public void setEspecialidade(String especialidade) {
		this.especialidade = especialidade;
	}
	public String getHorario_entrada() {
		return horario_entrada;
	}
	public void setHorario_entrada(String horario_entrada) {
		this.horario_entrada = horario_entrada;
	}
	public String getInicio_atendimento() {
		return inicio_atendimento;
	}
	public void setInicio_atendimento(String inicio_atendimento) {
		this.inicio_atendimento = inicio_atendimento;
	}
	public String getFim_atendimento() {
		return fim_atendimento;
	}
	public void setFim_atendimento(String fim_atendimento) {
		this.fim_atendimento = fim_atendimento;
	}
	public String getNome_paciente() {
		return nome_paciente;
	}
	public void setNome_paciente(String nome_paciente) {
		this.nome_paciente = nome_paciente;
	}
	public String getIdade() {
		return idade;
	}
	public void setIdade(String idade) {
		this.idade = idade;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public String getTempo() {
		return tempo;
	}
	public void setTempo(String tempo) {
		this.tempo = tempo;
	}
	public String getTipo_atendimento() {
		return tipo_atendimento;
	}
	public void setTipo_atendimento(String tipo_atendimento) {
		this.tipo_atendimento = tipo_atendimento;
	}
	public String getHora() {
		return hora;
	}
	public void setHora(String hora) {
		this.hora = hora;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public String getMinuto() {
		return minuto;
	}
	public void setMinuto(String minuto) {
		this.minuto = minuto;
	}
	
}
