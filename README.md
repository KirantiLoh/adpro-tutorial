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
1. 