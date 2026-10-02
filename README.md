# Computer Architecture Simulators 

Bu repo, Bilgisayar Mimarisi dersi kapsamında donanım seviyesindeki haberleşme algoritmalarını simüle etmek için geliştirilmiş Java projelerini içermektedir.

## Proje 1: DMA ve Bus Arbitration Simülatörü
Direct Memory Access (DMA) mimarisinde, veriyolu (bus) kontrolünün cihazlar arasında nasıl paylaşıldığını görselleştiren Java Swing tabanlı bir masaüstü uygulamasıdır.

### Kullanılan Algoritmalar:
*   **Round-Robin:** Cihazlara sırayla ve eşit zaman dilimlerinde (time quantum) veriyolu hakkı verilir.
*   **Fixed Priority:** Cihazların donanımsal öncelik seviyelerine göre veriyolu tahsis edilir.

*Not: Simülasyonun teorik altyapısı, sistem mimarisi tasarımı ve detaylı analizleri repoda bulunan Türkçe PDF proje raporunda mevcuttur.*

## Teknolojiler
*   Java (Core)
*   Java Swing (GUI)
*   Data Structures (Kuyruk mimarisi için LinkedList)

## Proje 2: Mano Makinesi Assembler (Çevirici)
Mano Temel Bilgisayarı (Basic Computer) mimarisi için yazılmış sembolik Assembly kodlarını (Örn: `LDA 045`, `ADD 046 I`) okuyup, bunları 16-bitlik Hexadecimal makine kodlarına dönüştüren algoritmik bir çevirici programdır.

### Temel Özellikler:
*   Bellek referanslı (MRI) ve bellek referanssız (Register & I/O) komut setlerini tanıma (Opcode Map).
*   Dolaylı (Indirect - I bit) ve Doğrudan (Direct) adresleme modlarını ayırt etme.
*   Dışarıdan verilen `Program.txt` dosyasını satır satır ayrıştırıp (parsing) anlık çeviri yapma.

## Proje 3: Boole İfadeleri Çözümleyici (Boole Evaluator)
Kullanıcıdan String olarak alınan mantıksal (Boolean) ifadeleri ayrıştırarak (parsing) sonucunu hesaplayan Java tabanlı bir algoritmadır.

### Temel Özellikler:
*   `AND`, `OR`, `NOT` mantıksal kapı operatörlerini string manipülasyonu ile tanıma.
*   Mantıksal önceliklendirme (önce NOT kapısının işlenmesi) simülasyonu.
