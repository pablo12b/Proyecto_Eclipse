package ec.edu.ups.modelo;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class Detalle {
	@Id 
    private int id;
    private String mes;
    private double deudas;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMes() {
		return mes;
	}

	public void setMes(String mes) {
		this.mes = mes;
	}

	public double getDeudas() {
		return deudas;
	}

	public void setDeudas(double deudas) {
		this.deudas = deudas;
	}

	@Override
	public String toString() {
		return "Detalle [id=" + id + ", mes=" + mes + ", deudas=" + deudas + "]";
	}
    

}
