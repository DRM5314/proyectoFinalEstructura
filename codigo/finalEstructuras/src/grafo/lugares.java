package grafo;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import manejadorArchivo.salidaMapa;

public class lugares {

    private origen origenes [];
    private List <String> lugares;
    private List <String> datosOrigen = new ArrayList<>();

    public List<String> getDatosOrigen() {
        return datosOrigen;
    }
    public lugares (JTextArea areaTexto) {
        lugares = new ArrayList<>();
        List <Integer> errores = new ArrayList<>();
        String separacionLineas[] = areaTexto.getText().split("\n");
        for (int i = 0; i < separacionLineas.length; i++) {
            if (!separacionLineas[i].isEmpty()) {
                String separacionO[] = separacionLineas[i].split("\\|");
                try {                    
                    Double.parseDouble(separacionO[2]);
                    Double.parseDouble(separacionO[3]);
                    Double.parseDouble(separacionO[4]);
                    Double.parseDouble(separacionO[5]);
                    Double.parseDouble(separacionO[6]);
                } catch (Exception e) {
                    System.out.println("Error en linea "+i);                    
                    errores.add(i);
                    continue;
                }
                if (!datosOrigen.contains(separacionO[0])) {
                    datosOrigen.add(separacionO[0]);
                }
                if (!lugares.contains(separacionO[0])) {
                    lugares.add(separacionO[0]);                    
                }
                if (!lugares.contains(separacionO[1])) {
                    lugares.add(separacionO[1]);                    
                }
            }
        }
        origenes = new origen[datosOrigen.size()];
        List<Integer> posicionesDestino = new ArrayList<>();
        for (int i = 0; i < datosOrigen.size(); i++) {
            for (int j = 0; j < separacionLineas.length; j++) {
                if(errores.contains(j))continue;
                if (!separacionLineas[j].isEmpty()) {
                    String separacionO[] = separacionLineas[j].split("\\|");
                    if (separacionO[0].equals(datosOrigen.get(i))) {
                        posicionesDestino.add(j);
                    }
                }
            }
            destino[] destinos = new destino[posicionesDestino.size()];            
            origenes[i] = new origen(datosOrigen.get(i), destinos);
            for (int j = 0; j < posicionesDestino.size(); j++) {
                if (!separacionLineas[posicionesDestino.get(j)].isEmpty()) {
                    String separacionO[] = separacionLineas[posicionesDestino.get(j)].split("\\|");
                    destinos[j] = new destino(separacionO, origenes[i]);
                    origenes[i].agregarNombreDestino(destinos[j].getDestino());
                }
            }
            posicionesDestino.clear();
        }
        if(errores.size()>0){
            String infoErrores ="";
            for (int i = 0; i < errores.size(); i++) {
                infoErrores+=separacionLineas[errores.get(i)]+" \t Linea: "+(errores.get(i)+1)+"\n";
            }
            JOptionPane.showMessageDialog(null, "Errores encontrados :\n"+infoErrores+"\n\tNo fueron producidos dichos lugares por sus errores");
        }
        salidaMapa.escribirMapaCompleto(origenes);        
    }
    public JComboBox <String> listados (JComboBox <String> listadoEntrada){
        listadoEntrada.removeAllItems();
        for (int i = 0; i < this.lugares.size(); i++) {
            listadoEntrada.addItem(this.lugares.get(i));
        }
        return listadoEntrada;
    }

    public origen[] getOrigenes() {
        return origenes;
    }

    public List<String> getLugares() {
        return lugares;
    }
}
