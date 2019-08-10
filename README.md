<h2>Kriteria</h2>
<p>Fitur yang harus ada pada aplikasi:</p>
<ol>
<li><strong>Daftar film<br /></strong>Syarat:
<ul>
<li>Terdapat 2 (dua) halaman yang menampilkan daftar film (<strong>Movies</strong>&nbsp;dan&nbsp;<strong>Tv Show</strong>)</li>
<li>Menggunakan&nbsp;Fragment&nbsp;untuk menampung halaman&nbsp;<strong>Movies</strong>&nbsp;dan&nbsp;<strong>Tv Show</strong>.</li>
<li>Menggunakan&nbsp;RecyclerView&nbsp;untuk menampilkan daftar film.</li>
<li>Menggunakan&nbsp;TabLayout,&nbsp;BottomNavigationView&nbsp;atau yang lainnya sebagai navigasi antara halaman&nbsp;<strong>Movies</strong>&nbsp;dan&nbsp;<strong>Tv Show</strong>.</li>
<li>Menampilkan indikator loading ketika data sedang dimuat.<br /><br /></li>
</ul>
</li>
<li><strong>Detail film<br /></strong>Syarat:
<ul>
<li>Menampilkan poster dan informasi film pada halaman detail film.</li>
<li>Menggunakan&nbsp;ConstraintLayout&nbsp;untuk menyusun layout.</li>
<li>Menampilkan indikator loading ketika data sedang dimuat.<br /><br /></li>
</ul>
</li>
<li><strong>Localization</strong><br />Syarat:
<ul>
<li>Aplikasi harus mendukung bahasa Indonesia dan bahasa Inggris.<br /><br /></li>
</ul>
</li>
<li><strong>Configuration Changes<br /></strong>Syarat:
<ul>
<li>Aplikasi harus bisa menjaga data yang sudah dimuat ketika terjadi pergantian orientasi dari potrait ke landscape atau sebaliknya.</li>
</ul>
</li>
</ol>
<p title="">Kesempatan untuk submission Anda diterima akan lebih besar jika:</p>
<ul>
<li title="">Menggunakan library pihak ketiga seperti Retrofit, Fast Android Networking, dsb.</li>
<li title="">Menerapkan design pattern seperti MVP, MVVM, Arch Component, dsb.</li>
<li title="">Aplikasi bisa memberikan pesan eror jika data tidak berhasil ditampilkan.</li>
<li dir="ltr" title="">Menuliskan kode dengan bersih.</li>
</ul>
<p>&nbsp;</p>
<p dir="ltr" title="">Submission Anda akan ditolak jika:</p>
<ul>
<li dir="ltr" title="">
<p dir="ltr" title="">Tidak menggunakan&nbsp;Fragment&nbsp;untuk menampung halaman&nbsp;<strong>Movies</strong>&nbsp;dan&nbsp;<strong>Tv</strong>&nbsp;<strong>Show</strong><strong>.</strong></p>
</li>
<li>
<p dir="ltr" title="">Tidak menggunakan&nbsp;RecyclerView&nbsp;untuk menampilkan daftar film.</p>
</li>
<li title="">Tidak menggunakan&nbsp;TabLayout,&nbsp;BottomNavigationView&nbsp;atau yang lainnya sebagai navigasi antara&nbsp;<strong>Movies</strong>&nbsp;dan&nbsp;<strong>Tv</strong>&nbsp;<strong>Show</strong>.</li>
<li title="">Tidak menggunakan&nbsp;ConstraintLayout&nbsp;untuk menyusun layout pada halaman detail film.</li>
<li title="">Tidak terdapat indikator loading.</li>
<li title="">Aplikasi tidak mendukung bahasa Indonesia dan bahasa Inggris.</li>
<li title="">Aplikasi tidak bisa menjaga data yang sudah dimuat ketika terjadi pergantian orientasi dari potrait ke landscape atau sebaliknya.</li>
<li title="">Menangani perubahan konfigurasi menggunakan tag&nbsp;android:configChanges&nbsp;pada berkas&nbsp;AndroidManifest.xml</li>
<li title="">Poster tidak berhasil ditampilkan.</li>
<li dir="ltr" title="">
<p dir="ltr" title="">Informasi yang ditampilkan pada daftar ataupun detail film, tidak relevan.</p>
</li>
<li dir="ltr" title="">
<p dir="ltr" title="">Project tidak bisa di-build.</p>
</li>
<li>
<p dir="ltr" title="">Aplikasi force closed.</p>
</li>
<li dir="ltr" title="">
<p dir="ltr" title="">Mengirimkan file selain proyek Android Studio.</p>
</li>
<li dir="ltr" title="">
<p dir="ltr" title="">Mengirimkan proyek yang bukan karya sendiri.</p>
</li>
</ul>
<p>&nbsp;</p>
<h2>Resources</h2>
<ul>
<li>Untuk mendapatkan&nbsp;<strong>API Key</strong>&nbsp;silakan ikuti tutorial pada tautan berikut:<br /><a href="https://blog.dicoding.com/registrasi-testing-themoviedb-api/" target="_blank" rel="noreferrer noopener">https://blog.dicoding.com/registrasi-testing-themoviedb-api/</a></li>
<li>Gunakan endpoint berikut untuk mendapatkan data&nbsp;<strong>Movies</strong>:<br />https://api.themoviedb.org/3/discover/movie?api_key=<strong>{API KEY}</strong>&amp;language=en-US</li>
<li>Gunakan endpoint berikut untuk mendapatkan data&nbsp;<strong>Tv Show</strong>:<br />https://api.themoviedb.org/3/discover/tv?api_key=<strong>{API KEY}</strong>&amp;language=en-US</li>
<li>Gunakan url berikut untuk mendapatkan poster film.
<p>https://image.tmdb.org/t/p/<strong>{POSTER SIZE}</strong><strong>{POSTER FILENAME}</strong></p>
<p><strong>POSTER SIZE</strong>&nbsp;di atas adalah ukuran dari poster yang ingin didapatkan. Tersedia beberapa ukuran yang dapat digunakan&nbsp;<strong>w92</strong>,&nbsp;<strong>w154</strong>,&nbsp;<strong>w185</strong>,&nbsp;<strong>w342</strong>,&nbsp;<strong>w500</strong>,&nbsp;<strong>w780</strong>, dan&nbsp;<strong>original</strong>. Sedangkan&nbsp;<strong>POSTER FILENAME</strong>&nbsp;adalah path poster yang bisa didapatkan dari response<em>&nbsp;</em>JSON dengan key&nbsp;poster_path.<br /><strong>Contoh:</strong><br /><a href="https://image.tmdb.org/t/p/w185/kSBXou5Ac7vEqKd97wotJumyJvU.jpg" target="_blank" rel="noreferrer noopener">https://image.tmdb.org/t/p<strong>/</strong><strong>w185</strong><strong>/</strong><strong>kSBXou5Ac7vEqKd97wotJumyJvU.jpg</strong></a></p>
</li>
<li>
<p>Penjelasan mengenai poster dapat Anda lihat pada tautan berikut:<br /><a href="https://developers.themoviedb.org/3/configuration/get-api-configuration" target="_blank" rel="noreferrer noopener">https://developers.themoviedb.org/3/configuration/get-api-configuration</a></p>
</li>
</ul>
<p>&nbsp;</p>
<h2><strong>Ketentuan</strong></h2>
<p dir="ltr" title="">Beberapa ketentuan umum dari proyek aplikasi:</p>
<ul>
<li dir="ltr" title="">
<p dir="ltr" title="">Menggunakan&nbsp;<strong>Android Studio.</strong></p>
</li>
<li dir="ltr" title="">
<p dir="ltr" title="">Menggunakan bahasa pemrograman&nbsp;<strong>Kotlin</strong>&nbsp;atau&nbsp;<strong>Java</strong>.</p>
</li>
<li dir="ltr" title="">
<p dir="ltr" title="">Mengirimkan pekerjaan Anda dalam bentuk folder Proyek Android Studio yang telah diarsipkan (<strong>ZIP</strong>).</p>
</li>
<li dir="ltr" title="">Tim penilai akan mengulas submission Anda dalam waktu&nbsp;<strong>selambatnya</strong><strong>&nbsp;3 (tiga) hari kerja</strong>&nbsp;(tidak termasuk Sabtu, Minggu, dan hari libur nasional).</li>
<li dir="ltr" title="">Tidak disarankan untuk melakukan submit berkali-kali karena akan memperlama proses penilaian.</li>
<li dir="ltr" title="">Anda akan mendapat notifikasi hasil pengumpulan submission Anda via email, atau Anda dapat mengecek status submission pada akun Dicoding Anda.</li>
</ul>
