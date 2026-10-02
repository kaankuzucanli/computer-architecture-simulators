import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Bilgisayar Mimarisi Dersi - DMA ve Bus Arbitration Simülatörü
 * Algoritmalar: Round-Robin ve Fixed Priority
 */
public class DMASimulatorGUI extends JFrame {

    private JTextArea logArea;
    private JButton btnRoundRobin;
    private JButton btnFixedPriority;
    private Queue<String> requestQueue;

    public DMASimulatorGUI() {
        // Arayüz temel ayarları
        setTitle("DMA & Bus Arbiter Simülatörü");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        requestQueue = new LinkedList<>();
        
        // Log ekranı kurulumu
        logArea = new JTextArea();
        logArea.setEditable(false);
        logArea.setFont(new Font("Monospaced", Font.PLAIN, 12));
        JScrollPane scrollPane = new JScrollPane(logArea);
        
        // Buton paneli
        JPanel buttonPanel = new JPanel();
        btnRoundRobin = new JButton("Round-Robin Çalıştır");
        btnFixedPriority = new JButton("Fixed Priority Çalıştır");
        
        buttonPanel.add(btnRoundRobin);
        buttonPanel.add(btnFixedPriority);

        add(scrollPane, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        // Action Listener'lar 
        btnRoundRobin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                runRoundRobinSimulation();
            }
        });

        btnFixedPriority.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                runFixedPrioritySimulation();
            }
        });
    }

    // Round-Robin mantığı simülasyonu
    private void runRoundRobinSimulation() {
        logArea.setText(""); // Ekranı temizle
        logArea.append("--- ROUND-ROBIN SİMÜLASYONU BAŞLIYOR ---\n");
        
        // Cihazları kuyruğa ekle
        requestQueue.clear();
        requestQueue.add("Cihaz_1 (Disk)");
        requestQueue.add("Cihaz_2 (Ağ Kartı)");
        requestQueue.add("Cihaz_3 (Ses Kartı)");

        // Zaman dilimi (Time Quantum) mantığıyla hatta erişim ver
        while (!requestQueue.isEmpty()) {
            String currentDevice = requestQueue.poll();
            logArea.append("[Bus Arbiter] Veriyolu erişimi verildi: " + currentDevice + "\n");
            logArea.append(currentDevice + " veri aktarımını tamamladı.\n\n");
        }
        logArea.append("Tüm cihazlar isteğini tamamladı.\n");
    }

    // Fixed Priority simülasyonu
    private void runFixedPrioritySimulation() {
        logArea.setText("");
        logArea.append("--- FIXED PRIORITY SİMÜLASYONU BAŞLIYOR ---\n");
        logArea.append("Kural: Öncelik seviyesi yüksek olan cihaz veriyolunu alır.\n\n");

        // Basit bir öncelik sıralaması simülasyonu (Ağ kartı > Disk > Ses)
        logArea.append("[Donanım İsteği] Cihaz_3 (Ses Kartı) erişim istiyor. (Öncelik: Düşük)\n");
        logArea.append("[Donanım İsteği] Cihaz_2 (Ağ Kartı) erişim istiyor. (Öncelik: Yüksek)\n");
        logArea.append("Arbiter Kararı: Veriyolu Cihaz_2'ye tahsis edildi!\n");
        logArea.append("Cihaz_2 işlemi bitirdi.\n");
        logArea.append("Arbiter Kararı: Veriyolu Cihaz_3'e tahsis edildi!\n");
    }

    public static void main(String[] args) {
        // Uygulamayı başlat
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new DMASimulatorGUI().setVisible(true);
            }
        });
    }
}
