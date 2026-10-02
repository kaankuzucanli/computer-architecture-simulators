import java.io.*;
import java.util.HashMap;

public class ManoCevirici {

    private static HashMap<String, String> mriMap = new HashMap<>();
    private static HashMap<String, String> nonMriMap = new HashMap<>();

    public static void main(String[] args) {
        setupOpcodeMaps();
        
        try (BufferedReader br = new BufferedReader(new FileReader("Program.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                line = line.trim();
                if (!line.isEmpty()) {
                    String result = parseInstruction(line);
                    System.out.println("Komut: " + line + " -> Makine Kodu (Hex): " + result);
                }
            }
        } catch (IOException e) {
            System.out.println("Hata: Program.txt dosyasi bulunamadi.");
        }
    }

    private static void setupOpcodeMaps() {
        mriMap.put("AND", "0"); mriMap.put("ADD", "1");
        mriMap.put("LDA", "2"); mriMap.put("STA", "3");
        mriMap.put("BUN", "4"); mriMap.put("BSA", "5");
        mriMap.put("ISZ", "6");

        nonMriMap.put("CLA", "7800"); nonMriMap.put("CLE", "7400");
        nonMriMap.put("CMA", "7200"); nonMriMap.put("CME", "7100");
        nonMriMap.put("CIR", "7080"); nonMriMap.put("CIL", "7040");
        nonMriMap.put("INC", "7020"); nonMriMap.put("SPA", "7010");
        nonMriMap.put("SNA", "7008"); nonMriMap.put("SZA", "7004");
        nonMriMap.put("SZE", "7002"); nonMriMap.put("HLT", "7001");
        
        nonMriMap.put("INP", "F800"); nonMriMap.put("OUT", "F400");
        nonMriMap.put("SKI", "F200"); nonMriMap.put("SKO", "F100");
        nonMriMap.put("ION", "F080"); nonMriMap.put("IOF", "F040");
    }

    private static String parseInstruction(String instruction) {
        String[] parts = instruction.split("\\s+");
        String opcode = parts[0].toUpperCase();

        if (nonMriMap.containsKey(opcode)) {
            return nonMriMap.get(opcode);
        } else if (mriMap.containsKey(opcode)) {
            String address = parts.length > 1 ? parts[1] : "000";
            String iBit = (parts.length > 2 && parts[2].equalsIgnoreCase("I")) ? "1" : "0";
            
            int baseOpcode = Integer.parseInt(mriMap.get(opcode));
            if (iBit.equals("1")) {
                baseOpcode += 8;
            }
            
            return Integer.toHexString(baseOpcode).toUpperCase() + address;
        }
        return "GECERSIZ_KOMUT";
    }
}
