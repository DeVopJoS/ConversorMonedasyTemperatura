package logica;

public class Conversion {
	private int opcionConversion;
	private String conversionSeleccionada;
	private String message;
	private String tipoResultado;
	private double conversionResultado;
	
	public String getTipoResultado() {
		return tipoResultado;
	}

	public String getMessage() {
		return this.message;
	}
	
	public void setMessage(String message) {
		this.message = message;
	}
	
	public int getOpcionConversion() {
		return this.opcionConversion;
	}
	
	public void opcionConver(String opcion) {
		if(opcion == "Conversion de Temperatura") {
			opcionConversion = 1; // temperatura
			this.message = "Ingrese el valor de la temperatura que desea convertir";
		}else {
			opcionConversion = 0; // Moneda
			this.message = "Ingrese la cantidad de dinero en Bolivianos que desea convertir";
		}
	}
	
	public void opcionesConversion(String opcion) {
		this.conversionSeleccionada = opcion;
	}
	
	public String conversion(String valor) {
		int err = 0;
		try {
			Float.parseFloat(valor);
		}catch(NumberFormatException e) {
			err = 1;
		}
		if(err != 1) {
			if(this.opcionConversion == 1) {
				return conversionTemp(valor);
			}else {
				return "Tienes: " + (Math.round(conversionMoneda(valor)*100.0)/100.0) +" "+ getTipoResultado();
			}
		}else {
			return null;
		}
	}
	
	public String conversionTemp(String valorStr) {
		float valor = Float.parseFloat(valorStr);
		String de = "";
		String a = "";
		
		switch (conversionSeleccionada) {
		case "De Celsius a Fahrenheit": 
			de = " Grados Celsius";
			a = " Grados Fahrenheit";
			this.conversionResultado = Math.round(((valor * 9/5) + 32)*100.0)/100.0;
			
			break;
		case "De Fahrenheit a Celsius":
			de = " Grados Fahrenheit";
			a = " Grados Celsius";
			this.conversionResultado = Math.round(((valor - 32) * 5/9)*100.0)/100.0;

			break;
		case "De Kelvin a Celsius":
			de = " Grados Kelvin";
			a = " Grados Celsius";
			this.conversionResultado = Math.round((valor - 273.15f)*100.0)/100.0;
			
			break;
		case "De Celsius a Kelvin":
			de = " Grados Celsius";
			a = " Grados Kelvin";
			this.conversionResultado = Math.round((valor + 273.15f)*100.0)/100.0;
			
			break;
		case "De Kelvin a Fahrenheit":
			de = " Grados Kelvin";
			a = " Grados Fahrenheit";
			this.conversionResultado = Math.round(((valor - 273.15f) * 9/5 + 32)*100.0)/100.0;
			
			break;
		case "De Fahrenheit a Kelvin":
			de = " Grados Fahrenheit";
			a = " Grados Kelvin";
			this.conversionResultado = Math.round(((valor - 32) * 5/9 + 273.15f)*100.0)/100.0;
			
			break;
		}
		
		this.tipoResultado = valor + de + " equivale a "+ this.conversionResultado + a;
		return this.tipoResultado;
	}
	
	public double conversionMoneda(String valorStr) {
		float valor = Float.parseFloat(valorStr);
		switch (conversionSeleccionada) {
		case "Dolar": 
			this.conversionResultado = valor / 6.91; 
			this.tipoResultado = "Dolares";
			break;
		case "Euros":
			this.conversionResultado = valor / 7.6; 
			this.tipoResultado = "Euros";
			break;
		case "Libras Esterlinas":
			this.conversionResultado = valor * 8.89;
			this.tipoResultado = "Libras Esterlinas";
			break;
		case "Yen Japonés":
			this.conversionResultado = valor / 0.049;
			this.tipoResultado = "Yen Japonés";
			break;
		case "Won sul-coreano":
			this.conversionResultado = valor / 0.0053;
			this.tipoResultado = "Won sul-coreano";
			break;
		}
		
		return this.conversionResultado;
	}
}
