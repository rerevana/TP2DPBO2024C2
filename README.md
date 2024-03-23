### TP2DPBO2024C2
#### Saya Revana Faliha Salma NIM 2202869 mengerjakan Soal Tugas Praktikum 2 dalam mata kuliah DPBO untuk keberkahanNya maka saya tidak melakukan kecurangan seperti yang telah dispesifikasikan. Aamiin.

Kode di atas merupakan kode untuk mengelola data mahasiswa menggunakan fungsi CRUD. Pada kode di atas,terdapat deklarasikan kelas Menu untuk membuat antarmuka grafis. Di dalamnya, terdapat deklarasi variabel seperti panel, field teks, tabel, tombol, dan label yang digunakan dalam antarmuka. Selain itu juga, terdapat konstruktor Menu yang digunakan untuk inisialisasi objek database, pengaturan model tabel, pengaturan tampilan combo box, dan implementasi aksi pada tombol dan baris tabel.

Di dalam kode tersebut juga terdapat beberapa metode, ada metode setTable yang digunakan untuk membuat model tabel, serta mengambil data mahasiswa dari database dan menambahkannya ke dalam model tabel. Ada juga metode insertData yang digunakan untuk memasukkan data mahasiswa baru ke dalam database dengan melakukan validasi input kosong dan duplikasi NIM. Metode checkDuplicateNIM digunakan untuk memeriksa apakah NIM yang dimasukkan sudah ada sebelumnya. Selain itu, terdapat metode updateData untuk memperbarui data mahasiswa yang sudah ada dengan melakukan validasi input dan pemilihan baris yang akan diperbarui. Selanjutnya, ada metode deleteData digunakan untuk menghapus data mahasiswa dari database dengan konfirmasi penghapusan dan validasi pemilihan baris. Terakhir, terdapat metode clearForm digunakan untuk membersihkan form input, mengubah tombol "Update" menjadi "Add", dan menyembunyikan tombol delete setelah operasi selesai.

#### Dokumentasi
##### Insert data
![Screenshot (1027)](https://github.com/rerevana/TP2DPBO2024C2/assets/113984261/469fafec-9637-4cb7-9ae7-60fa740d802c)
![Screenshot (1028)](https://github.com/rerevana/TP2DPBO2024C2/assets/113984261/e93a91ec-29f5-459d-bc46-2be3e686e2da)
![Screenshot (1029)](https://github.com/rerevana/TP2DPBO2024C2/assets/113984261/66d0bab1-b9cd-4a87-accf-9802ae97f6c6)
![Screenshot (1034)](https://github.com/rerevana/TP2DPBO2024C2/assets/113984261/41dd1882-8a98-485d-b60f-40e65f849dc0)
![Screenshot (1035)](https://github.com/rerevana/TP2DPBO2024C2/assets/113984261/5260775b-2188-43b5-b892-af247d546ded)

##### Show dialog/prompt error jika ada input yang kosong saat insert
![Screenshot (1030)](https://github.com/rerevana/TP2DPBO2024C2/assets/113984261/eac42d03-1c93-42a3-811c-f5f8aeafa3a1)
![Screenshot (1031)](https://github.com/rerevana/TP2DPBO2024C2/assets/113984261/36ede695-97ab-4fbe-82eb-4474cff181e5)
![Screenshot (1032)](https://github.com/rerevana/TP2DPBO2024C2/assets/113984261/2a6ca3b7-4e5e-40a9-8322-736b6e6419fb)
![Screenshot (1033)](https://github.com/rerevana/TP2DPBO2024C2/assets/113984261/f0d00d20-b695-4657-82ae-b9fab0e345f2)

##### Show dialog/prompt error jika ada input yang kosong saat update
![Screenshot (1036)](https://github.com/rerevana/TP2DPBO2024C2/assets/113984261/0131484d-37d5-4276-8086-be1e4028e836)
![Screenshot (1037)](https://github.com/rerevana/TP2DPBO2024C2/assets/113984261/1ef12bf5-73cf-410e-b579-82d45bfc1179)
![Screenshot (1038)](https://github.com/rerevana/TP2DPBO2024C2/assets/113984261/bb538da5-75ce-41a3-8d0b-984ed73c02ae)
![Screenshot (1039)](https://github.com/rerevana/TP2DPBO2024C2/assets/113984261/2156a1be-ebea-44c4-900b-26b1ea7e529d)

##### Update data
![Screenshot (1040)](https://github.com/rerevana/TP2DPBO2024C2/assets/113984261/f21f86a9-cf4a-4ec7-bb9f-d22f55b4be1f)
![Screenshot (1041)](https://github.com/rerevana/TP2DPBO2024C2/assets/113984261/71ef2bd2-bbd8-401b-b8bf-31885e1213ca)
![Screenshot (1042)](https://github.com/rerevana/TP2DPBO2024C2/assets/113984261/3cdc9a49-c064-4170-a269-81a920b3a89b)

##### Delete data
![Screenshot (1043)](https://github.com/rerevana/TP2DPBO2024C2/assets/113984261/65b63ce4-1bda-4cf8-976d-2c7b0d98bc69)
![Screenshot (1044)](https://github.com/rerevana/TP2DPBO2024C2/assets/113984261/b39100d2-3191-4e1f-8871-2a1be218fdeb)
![Screenshot (1045)](https://github.com/rerevana/TP2DPBO2024C2/assets/113984261/26182b92-7799-4890-940c-d2ef743c58dc)
![Screenshot (1046)](https://github.com/rerevana/TP2DPBO2024C2/assets/113984261/3d8abd27-5d82-40a6-bce2-a5b89deb2815)
![Screenshot (1047)](https://github.com/rerevana/TP2DPBO2024C2/assets/113984261/435c6646-307d-4dba-b3c2-7d1ea7e94444)

##### Show dialog/prompt error jika sudah ada NIM yang sama saat insert
![Screenshot (1048)](https://github.com/rerevana/TP2DPBO2024C2/assets/113984261/d022dfed-a8d0-48b0-b141-f0e30b863ad4)
