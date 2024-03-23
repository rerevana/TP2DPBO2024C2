### TP2DPBO2024C2

Pada kode di atas,terdapat deklarasikan kelas Menu untuk membuat antarmuka grafis. Di dalamnya, terdapat deklarasi variabel seperti panel, field teks, tabel, tombol, dan label yang digunakan dalam antarmuka. Selain itu juga, terdapat konstruktor Menu yang digunakan untuk inisialisasi objek database, pengaturan model tabel, pengaturan tampilan combo box, dan implementasi aksi pada tombol dan baris tabel.

Selain itu, ada metode setTable yang digunakan untuk membuat model tabel, serta mengambil data mahasiswa dari database dan menambahkannya ke dalam model tabel. Ada juga metode insertData yang digunakan untuk memasukkan data mahasiswa baru ke dalam database dengan melakukan validasi input kosong dan duplikasi NIM. Metode checkDuplicateNIM digunakan untuk memeriksa apakah NIM yang dimasukkan sudah ada sebelumnya.

Selain itu, terdapat metode updateData untuk memperbarui data mahasiswa yang sudah ada dengan melakukan validasi input dan pemilihan baris yang akan diperbarui. Selanjutnya, ada metode deleteData digunakan untuk menghapus data mahasiswa dari database dengan konfirmasi penghapusan dan validasi pemilihan baris. Terakhir, terdapat metode clearForm digunakan untuk membersihkan form input, mengubah tombol "Update" menjadi "Add", dan menyembunyikan tombol delete setelah operasi selesai.
