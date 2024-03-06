# adpro-tutorial

## 1. Reflection 1

Menurut saya, sejauh ini saya telah menerapkan beberapa konsep clean code. Contohnya adalah:
- Penamaan variable yang bermakna, agar semua variabel dapat dengan mudah dipahami gunanya
- Penamaan fungsi yang deskriptif, agar garis besar dari setiap fungsi dapat dipahami dengan cepat
Terdapat beberapa standar yang belum saya ikuti, yaitu penamaan branch yang dapat dioptimalkan dengan penggunaan prefix seperti `feat/<nama_fitur>` dan `fix:<hal_yang_diperbaiki>`. Serta penambahan dokumentasi pada bagian repository dan service agar mudah dipahami.

Dalam aspek secure coding, terdapat beberapa *security measures* yang saya terapkan, seperti pembuatan ID random ketika pembuatan entity Product baru dan memastikan form create dan edit diisi sebelum di-submit. Berikutnya saya ingin mencoba menerapkan autorisasi dan autentikasi, agar setiap produk yang dimasukkan hanya dapat dilihat oleh pengguna yang memasukkan data tersebut awalnya.

## Reflection 2

1. Setelah membuat unit test pada tutorial ini, saya merasa bahwa terlalu banyak unit test tidak terlalu baik, karena dengan code coverage 100% pun tak menjamin nihilnya bug atau error pada program. Sehingga menurut saya membuat test case yang banyak pada suatu class justru *counterproductive*.
2. Terdapat kemungkinan kualitas kode akan menurun, hal ini disebabkan oleh adanya logika yang sama digunakan ulang, tidak menerapkan prinsip DRY (Don't Repeat Yourself). Cara yang dapat digunakan untuk menghindari penurunan kualitas adalah membuat test yang menggabungkan beberapa fitur / fungsi suatu class, sehingga jumlah test case yang dibuat menurun dan tidak ada kode yang terulang-ulang.

## Reflection 3
1. Code quality issue yang saya alami adalah adanya penggunaan fungsi yang tidak terlalu sesuai, contohnya penggunaan fungsi assert yang tidak optimal. Beberapa tempat saya menggunakan `assertEquals(null, product)`, padahal lebih baik menggunakan `assertNull(product)`. Solusinya adalah mengubah function tersebut untuk menggunakan function yang benar.
2. Menurut saya implementasi CI/CD workflows yang ada sekarang sudah mencakup semua definisi dari CI dan CD. Bagian CI yang diterapkan sudah memenuhi standar CI, karena setiap adanya *Pull Request* akan menjalankan *Github Action* yang bertugas untuk memastikan tak ada code yang tidak sesuai standar. Bagian CD yang diterapkan sudah memenuhi standar CD, karena setiap kali adanya perubahan pada branch `main` akan terjadi *deployment* ulang. Sehingga dengan alasan yang telah disebutkan sebelumnya, saya rasa implementasi sekarang sudah memenuhi standar CI CD.

## Reflection 
1. Berikut adalah list dari prinsip-prinsip dari SOLID yang saya terapkan
   1. Single Responsibilty Principle:
      1. File `ProductController.java` awalnya berisi 2 class controller yang berbeda, hal ini bertolak-belakang dengan prinsip Single Responsibilty. SRP menyatakan bahwa suatu class harus men. Dengan demikian, saya membuat file baru yang bernama `CarController.java` untuk menyimpan class `CarController`.
   2. Dependency Inversion: 
      1. Class `CarController` awalnya mempunyai *dependency* kepada class `CarServiceImpl`. Menurut prinsip Dependency Inversion, seharusnya class yang ada *depend* / bergantung kepada *interface* ataupun *abstract class*, bukan bergantung langsung kepada class konkrit. Dengan demikian, saya mengubah class `CarController` untuk bergantung kepada interface `CarService`.
2. Kelebihan dari masing-masing prinsip pada SOLID adalah:
   1. Single Responsibilty Principle: Lebih mudah untuk dipahami, dimodifikasi, dan diuji tanpa mempengaruhi bagian lain.
   2. Open-Closed Principle: Meningkatkan code robustness dengan memungkinkan adaptasi yang lebih mudah kepada fitur baru tanpa mengubah code yang sudah ada.
   3. Liskov Substitution: Memungkinkan code reuse serta memudahkan pemahaman atas codebase.
   4. Interface Segregation: Mencegah adanya interface yang *bloated* dan menurunkan kemungkinan adanya code duplication.
   5. Dependency Inversion: Membuat relasi antar class *loosely coupled* sehingga perubahan pada 1 class tidak mengubah fungsi apapun pada class lainnya.
3. Kekurangan dari tidak menerapkan prinsip SOLID adalah:
   1. Menggabungkan tanggungjawab antar kelas akan menyebabkan sulitnya codebase untuk di-*maintain*.
   2. Dengan tidak menerapkan Interface Segregation, memungkinkan code yang sama diulang berkali-kali (code duplication).
   3. Minimnya *reusability* karena semua bagian saling bergantungan / *tightly coupled* sehingga memanjangkan waktu pengembangan aplikasi.

## Reflection
1. TDD tidak membantu dalam kasus ini, malah menghambat progress. Hal ini disebabkan untuk membuat flow TDD yang baik, diperlukan jumlah anggota minimal lebih dari 1. Sedangkan pada kasus ini hanya sendirian sehingga menghambat.
2. Semua prinsip telah dipenuhi kecuali aspek Fast (F). Hal ini disebabkan oleh kurangnya orang untuk membuat flow TDD yang cepat.