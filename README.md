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
