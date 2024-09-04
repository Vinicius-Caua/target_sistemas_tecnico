import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        HashMap<String, Double> estado = new HashMap<>();

        estado.put("SP", 67836.43);
        estado.put("RJ", 36678.66);
        estado.put("MG", 29229.88);
        estado.put("ES", 27165.48);
        estado.put("OUTROS", 19849.53);

        double somaTotalEstados = 0.0;
        for (double valor : estado.values()){
            somaTotalEstados += valor;
        }
        System.out.println("Total: " + somaTotalEstados);

        for (Map.Entry<String, Double> entry : estado.entrySet()) {
            String estados = entry.getKey();
            double valor = entry.getValue();
            double taxaPercentual = (valor / somaTotalEstados) * 100.0;
            System.out.printf(" %-15s | %.2f%%\n", entry.getKey(), taxaPercentual);
        }
    }
}