import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) throws IOException {
		InputStream is = new FileInputStream("dia7.csv");
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);
		
		Character c;
		String linha;
		linha = br.readLine();
		linha = br.readLine();
		
		String valor;
		int virgulas;
		Atendimento atend;
		ArrayList<Atendimento> atendimentos = new ArrayList<Atendimento>();
		
		while (linha != null) {
			valor = "";
			virgulas=0;
			atend = new Atendimento();
			
			for (int i=0; i<linha.length(); i++) {
				c = linha.charAt(i);
				
				if (virgulas == 10) {
					virgulas = 0;
					atend.setTipo_atendimento(valor);
					valor="";
					atendimentos.add(atend);
				} else if (c == ';' && virgulas == 0) {
					virgulas++;
				} else if (c == ';' && virgulas == 1) {
					virgulas++;
					atend.setNome_profissional(valor);
					valor="";
				} else if (c == ';' && virgulas == 2) {
					virgulas++;
					atend.setEspecialidade(valor);
					valor="";
				} else if (c == ';' && virgulas == 3) {
					virgulas++;
					atend.setHorario_entrada(valor);
					valor="";
				} else if (c == ';' && virgulas == 4) {
					virgulas++;
					atend.setInicio_atendimento(valor);
					valor="";
				} else if (c == ';' && virgulas == 5) {
					virgulas++;
					atend.setFim_atendimento(valor);
					valor="";
				} else if (c == ';' && virgulas == 6) {
					virgulas++;
					atend.setNome_paciente(valor);
					valor="";
				} else if (c == ';' && virgulas == 7) {
					virgulas++;
					atend.setIdade(valor);
					valor="";
				} else if (c == ';' && virgulas == 8) {
					virgulas++;
					atend.setSexo(valor);
					valor="";
				} else if (c == ';' && virgulas == 9) {
					virgulas++;
					atend.setTempo(valor);
					valor="";
				} else {
					valor+=c;
				}
			}
			linha = br.readLine();
		}
		
		int index;
		int index2;
		String hora;
		int tam;
		
		for (int i=0; i<atendimentos.size(); i++) {
			index = atendimentos.get(i).getHorario_entrada().indexOf(' ');
			tam = atendimentos.get(i).getHorario_entrada().length();
			
			if (atendimentos.get(i).getHorario_entrada().substring(index+1, index+3).charAt(1) == ':') {
				hora = atendimentos.get(i).getHorario_entrada().substring(index+1, index+2);
				atendimentos.get(i).setHora(hora);
				
				index2 = atendimentos.get(i).getHorario_entrada().indexOf(':');
				atendimentos.get(i).setMinuto(atendimentos.get(i).getHorario_entrada().substring(index2+1, index2+3));
			} else {
				hora = atendimentos.get(i).getHorario_entrada().substring(index+1, index+3);
				atendimentos.get(i).setHora(hora);
				
				index2 = atendimentos.get(i).getHorario_entrada().indexOf(':');
				atendimentos.get(i).setMinuto(atendimentos.get(i).getHorario_entrada().substring(index2+1, index2+3));
			}
		}
		
		for(int i=0; i<atendimentos.size(); i++) {
			String data = atendimentos.get(i).getHorario_entrada();
			valor = "";
			
			for (int j=0; j<data.length(); j++) {
				c = data.charAt(j);
				
				if (c == '/') {
					atendimentos.get(i).setData(valor);
					j=data.length();
				} else {
					valor+=c;
				}
			}
		}
		
		// SELECIONAR DIAS DO RELATORIO
		String data_ini="7";
		String data_fim="8";
		ArrayList<Atendimento> diario = new ArrayList<Atendimento>();
		atend = null;
		for (int i=0; i<atendimentos.size(); i++) {
			atend = atendimentos.get(i);
			
			if ((atend.getData().equals(data_ini) && Integer.parseInt(atend.getHora()) >= 7) || (atend.getData().equals(data_fim) && Integer.parseInt(atend.getHora()) <= 6 && Integer.parseInt(atend.getMinuto()) <= 59)) {
				diario.add(atend);
				System.out.println("Médico: "+atend.getNome_profissional()+" | Paciente: "+atend.getNome_paciente()+" | Horário: "+atend.getHora()+":"+atend.getMinuto());
			}
		}
		
		// Apresentar quantas criancas, adultos, quantos do sexo masculino e quantos do sexo feminino
		int quant_crianca=0;
		int quant_adulto=0;
		int quant_masculino=0;
		int quant_feminino=0;
		int quant_geral = diario.size();
		
		for (int i=0; i<quant_geral; i++) {
			if (diario.get(i).getSexo().equals("M")) {
				quant_masculino++;
			} else if (diario.get(i).getSexo().equals("F")) {
				quant_feminino++;
			}
		}
		
		for (int i=0; i<quant_geral; i++) {
			if (Integer.parseInt(diario.get(i).getIdade()) <= 12) {
				quant_crianca++;
			} else if (Integer.parseInt(diario.get(i).getIdade()) > 12) {
				quant_adulto++;
			}
		}
		
		System.out.println("\nPLANTÃO DO DIA: "+data_ini+"/12/2019");
		System.out.println("Quantidade Geral de Atendimentos: "+quant_geral+"\n"
				+"Quantidade Criança: "+quant_crianca+"\nQuantidade Adulto: "+ quant_adulto+
				"\nQuantidade Sexo Masculino: "+quant_masculino+"\nQuantidade Sexo Feminino: "+quant_feminino);
	}
}
