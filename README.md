# Unit Testing Dasar - Java

Proyek ini merupakan implementasi **Unit Testing Dasar** menggunakan **JUnit 5** untuk sistem manajemen buku sederhana.

## Fitur Utama
- **Tambah Buku** ke koleksi
- **Hapus Buku** dari koleksi
- **Cari Buku** berdasarkan penulis dan tahun terbit
- **Validasi Data** buku (judul, penulis, tahun)

## Struktur Project
```text
unit-testing-java/
├── src/
│   ├── main/java/org/example/
│   │   ├── Book.java
│   │   └── BookManager.java
│   └── test/java/
│       └── BookManagerTest.java
└── pom.xml
```

## Tools dan Teknologi
- **Java 11+**
- **Maven** (manajemen dependensi & build)
- **JUnit 5** (unit testing)

## Cara Menjalankan Unit Test
1. Pastikan **Java 11+** dan **Maven** sudah terinstal.
2. Clone repository:
```bash
git clone [URL_REPOSITORY]
cd unit-testing-java
```
3. Install dependencies:
```bash
mvn clean install
```
4. Jalankan test:
```bash
mvn test
```

## Test Cases
- ✅ Tambah buku ke koleksi
- ✅ Hapus buku yang ada
- ✅ Hapus buku yang tidak ada
- ✅ Cari buku berdasarkan penulis
- ✅ Ambil semua buku
- ✅ Validasi tahun terbit (2000-2100)
- ✅ Validasi judul dan penulis kosong

## Catatan
- Tahun terbit harus antara **2000-2100**
- Judul dan penulis **tidak boleh kosong**
- Test menggunakan pattern **Arrange-Act-Assert**

---
**Politeknik Negeri Cilacap** - Modul Praktikum 1: Unit Testing Dasar
