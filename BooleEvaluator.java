import java.util.Scanner;

/**
 * Bilgisayar Mimarisi - Mantık Devreleri Çözümleyici
 * Kullanıcıdan alınan String tabanlı Boolean ifadeleri işler ve sonucunu üretir.
 */
public class BooleEvaluator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("--- Boole Fonksiyonu Çözümleyici ---");
        System.out.println("Kullanılabilir mantık kapıları: AND, OR, NOT");
        System.out.println("Değerler: 1 (True), 0 (False)");
        System.out.println("Örnek giriş: 1 AND NOT 0 OR 1");
        System.out.print("Çözümlenecek ifadeyi giriniz: ");
        
        String ifade = scanner.nextLine();
        
        try {
            boolean sonuc = evaluateExpression(ifade);
            System.out.println("\nHesaplanan Sonuç: " + (sonuc ? "1 (TRUE)" : "0 (FALSE)"));
        } catch (Exception e) {
            System.out.println("\nHata: Geçersiz veya eksik bir Boole ifadesi girdiniz.");
        }
        
        scanner.close();
    }

    // String manipülasyonu ile mantık çözücü
    private static boolean evaluateExpression(String expression) {
        expression = expression.toUpperCase().trim();
        
        // Önce NOT işlemlerini öncelikli olarak hallet
        while (expression.contains("NOT 0")) {
            expression = expression.replace("NOT 0", "1");
        }
        while (expression.contains("NOT 1")) {
            expression = expression.replace("NOT 1", "0");
        }
        
        // Kalan ifadeyi boşluklardan parçalayıp (AND, OR) soldan sağa hesapla
        String[] tokens = expression.split("\\s+");
        boolean currentResult = tokens[0].equals("1");
        
        for (int i = 1; i < tokens.length - 1; i += 2) {
            String operator = tokens[i];
            boolean nextVal = tokens[i+1].equals("1");
            
            if (operator.equals("AND")) {
                currentResult = currentResult && nextVal;
            } else if (operator.equals("OR")) {
                currentResult = currentResult || nextVal;
            }
        }
        
        return currentResult;
    }
}
