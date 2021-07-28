# TestRata1

################################  Soal Cerita:  ##########################

Mba Devi Pengen Bikin Usaha Kecil Kecilan Yakni Jualan Cangkir Unik Kekinian Top Markotop Di Instagram dan Tiktok,
Alhamdulillah setelah 3 bulan berjalan bisninsnya laris manis, setiap hari bisa ada 1000 order cangkirNah Tapi Dia Pusing Banget Nih Karena Setiap Harinya dia harus begadang ngurusin rekap penjualan, mana bonnya kadang ada yang lupa kecatat, kadang ada yang salah kirim
karena itu dia minta tolong nih sama kalian buat bikinin blue print sistem cangkir UKTM ini yang nantinya bisa diimplementasi dan menyelesaikan masalah mba Devi.

Berikut ini hasil wawancara sama Mba Devi terkait data data yang dibutuhkan/dihasilkan dalam membuat sistem produksi cangkir.

Sistem Produksi Cangkir:

[Invoice Produksi]
Invoice Number	: INV-73456
Kode Barang	: GTX-1212
Nama Barang	: Cangkir Gurame
Harga Barang	: 20000
Jumlah		: 12
Total		: 240000
Tanggal Pesan	: 12-11-2020
Penerima	: Mas Anton
Alamat Penerima	: Jalan Bunga no 24, Jakarta Barat

[Status Produksi]
Invoince Number	: INV-73456
Status		: [desain, konfirmasi, Cetak, Siap, Kirim, Sampai]
Catatan		: Sudah disetujui oleh customer
Tanggal Masuk	: 13-11-2020
Tanggal Produksi	: 13-11-2020
Tanggal Seleai	: 13-11-2020

[Pembayaran]
Invoice Number	: INV-73456
Metode Bayar	: Transfer [Transfer,CC,Shopee,Tokopedia]
Bukti Bayar	: <File Foto>
Status		: Lunas [Pending, Lunas, Batal]
Tanggal Bayar	: 12-11-2020


Note:
1. Barang akan di produksi ketika pembayaran telah lunas


Pertanyaan:
1. Tolong bikin model database sederhannya;
2. Tolong bikin query pada service tersebut untuk: 
	a. melihat list list status dan invoice produksi
	b. create, update, delete produksi
3. Tolong bikin model REST API sederhana pada service produksi untuk menunjang komunikasi antar service

