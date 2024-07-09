package avioes.apoo.app;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Voo {
	
	private String nVoo;
	private String aviao;
	private String aeroOrigem;
	private String aeroDestino;
	private LocalDate dataDePartida;
	private LocalDate dataDeChegada;
	private String horaDePartida;
	private String horaDeChegada;
	
	public Voo(String nVoo, String aviao, String aeroOrigem, String aeroDestino, LocalDate dataDePartida,LocalDate dataDeChegada,  
			String horaDePartida, String horaDeChegada) {
		super();
		this.nVoo = nVoo;
		this.aviao = aviao;
		this.aeroOrigem = aeroOrigem;
		this.aeroDestino = aeroDestino;
		this.dataDePartida = dataDePartida;
		this.dataDeChegada = dataDeChegada;
		this.horaDePartida = horaDePartida;
		this.horaDeChegada = horaDeChegada;			
	}

	public Voo() {
		
	}

	public String getnVoo() {
		return nVoo;
	}

	public void setnVoo(String nVoo) {
		this.nVoo = nVoo;
	}

	public String getAviao() {
		return aviao;
	}

	public void setAviao(String aviao) {
		this.aviao = aviao;
	}

	public String getAeroOrigem() {
		return aeroOrigem;
	}

	public void setAeroOrigem(String aeroOrigem) {
		this.aeroOrigem = aeroOrigem;
	}

	public String getAeroDestino() {
		return aeroDestino;
	}

	public void setAeroDestino(String aeroDestino) {
		this.aeroDestino = aeroDestino;
	}

	public LocalDate getDataDePartida() {
		return dataDePartida;
	}

	public void setDataDePartida(LocalDate dataDePartida) {
		this.dataDePartida = dataDePartida;
	}

	public LocalDate getDataDeChegada() {
		return dataDeChegada;
	}

	public void setDataDeChegada(LocalDate dataDeChegada) {
		this.dataDeChegada = dataDeChegada;
	}

	public String getHoraDePartida() {
		return horaDePartida;
	}

	public void setHoraDePartida(String horaDePartida) {
		this.horaDePartida = horaDePartida;
	}

	public String getHoraDeChegada() {
		return horaDeChegada;
	}

	public void setHoraDeChegada(String horaDeChegada) {
		this.horaDeChegada = horaDeChegada;
	}
		
	
	@Override
	public String toString() {
		return "Voo[\n  Voo: " + nVoo + " \n  Numero do aviao: " + aviao + " \n  Aeroporto de origem: " + aeroOrigem + " \n  Aeroporto de destino: "
				+ aeroDestino + " \n  Data de partida: " + dataDePartida + " \n  Data de chegada: " + dataDeChegada
				+ " \n  Hora de partida: " + horaDePartida + " \n  Hora de chegada: " + horaDeChegada + "\n]\n" + 
				"--------------------------------------------------------------------";
	}

	
	
}
