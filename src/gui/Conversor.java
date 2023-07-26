/**
 * @author JosueBryan
 * @version V.1
 */
package gui;

import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import logica.Conversion;

public class Conversor {
	public static void main(String ... args) {
		
		String[] opcionesMoneda  = {"Dolar", "Euros", "Libras Esterlinas", "Yen Japonés", "Won sul-coreano"};
		String[] opcionesTemperatura  = {"De Celsius a Fahrenheit", "De Fahrenheit a Celsius", "De Kelvin a Celsius", "De Celsius a Kelvin", "De Kelvin a Fahrenheit", "De Fahrenheit a Kelvin"};
		String[] opcionesConversion = {"Conversion de Temperatura", "Conversion de Moneda"};
		
		JComboBox<String> comboBox = null;
		JComboBox<String> comboBoxConversion = new JComboBox<>(opcionesConversion);
		String[] opciones = {"Continuar"};
		Conversion con = new Conversion();
		
		
		String opcionSeleccionada;
		boolean continuar = true;

        do {
        	int selecciontipoConversion = JOptionPane.showOptionDialog(
                    null,
                    comboBoxConversion,
                    "Seleccione una opcion de conversion",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    null,
                    null
            );
    		
    		if (selecciontipoConversion != JOptionPane.CLOSED_OPTION) {
                opcionSeleccionada = (String) comboBoxConversion.getSelectedItem();
                con.opcionConver(opcionSeleccionada);
                if(con.getOpcionConversion() == 1) {
                	comboBox = new JComboBox<>(opcionesTemperatura);
                }else {
                	comboBox = new JComboBox<>(opcionesMoneda);
                }
            }else {
            	break;
            }
        	

        	int seleccionConversion = JOptionPane.showOptionDialog(
                    null,
                    comboBox,
                    "Seleccione una opcion para convertir",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    null,
                    null
            );
    		
    		if (seleccionConversion != JOptionPane.CLOSED_OPTION) {
                opcionSeleccionada = (String) comboBox.getSelectedItem();
                con.opcionesConversion(opcionSeleccionada);
            }else {
            	break;
            }
    		
    		String respuesta = JOptionPane.showInputDialog(null, con.getMessage());
    		if(respuesta == null) {
    			break;
    		}
    		if(con.conversion(respuesta) != null) {
    			JOptionPane.showMessageDialog(null, con.conversion(respuesta));
    		}else{
    			int seleccion = JOptionPane.showOptionDialog(
    					null, 
    					"Solo numeros porfavor.", 
    					"Error", 
    					JOptionPane.DEFAULT_OPTION, 
    					JOptionPane.INFORMATION_MESSAGE, 
    					null, 
    					opciones, 
    					opciones[0]);
    		}

            int seleccionContinuar = JOptionPane.showOptionDialog(
                    null,
                    "¿Deseas continuar?",
                    "Continuar",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    new Object[]{"Si", "No"},
                    "Si");

            switch (seleccionContinuar) {
                case JOptionPane.YES_OPTION:
                    continuar = true;
                    break;
                case JOptionPane.NO_OPTION:
                    continuar = false;
                    break;
                default:
                    continuar = false;
                    break;
            }
        } while (continuar);

        System.out.println("Fin del programa");
		
	}
}
