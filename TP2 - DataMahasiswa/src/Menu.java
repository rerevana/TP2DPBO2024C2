import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Menu extends JFrame{
    public static void main(String[] args) {
        // buat object window
        Menu window = new Menu();

        // atur ukuran window
        window.setSize(600, 680);

        // letakkan window di tengah layar
        window.setLocationRelativeTo(null);

        // isi window
        window.setContentPane(window.mainPanel);

        // ubah warna background
        window.getContentPane().setBackground(Color.white);

        // tampilkan window
        window.setVisible(true);

        // agar program ikut berhenti saat window diclose
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    // index baris yang diklik
    private int selectedIndex = -1;
    // list untuk menampung semua mahasiswa
    private ArrayList<Mahasiswa> listMahasiswa;
    private  Database database;
    private JPanel mainPanel;
    private JTextField nimField;
    private JTextField namaField;
    private JTable mahasiswaTable;
    private JButton addUpdateButton;
    private JButton cancelButton;
    private JComboBox jenisKelaminComboBox;
    private JButton deleteButton;
    private JLabel titleLabel;
    private JLabel nimLabel;
    private JLabel namaLabel;
    private JLabel jenisKelaminLabel;
    private JComboBox prodiComboBox;

    // constructor
    public Menu() {
        // buat objek database
        database = new Database();

        // isi tabel mahasiswa
        mahasiswaTable.setModel(setTable());

        // ubah styling title
        titleLabel.setFont(titleLabel.getFont().deriveFont(Font.BOLD, 20f));

        // atur isi combo box
        String[] jenisKelaminData = {"", "Laki-laki", "Perempuan"};
        jenisKelaminComboBox.setModel(new DefaultComboBoxModel(jenisKelaminData));

        // atur isi combo box prodi
        String[] prodiData = {"", "Pendidikan Matematika", "Matematika", "Pendidikan Fisika", "Fisika", "Pendidikan Biologi", "Biologi", "Pendidikan Kimia", "Kimia", "Pendidikan Ilmu Komputer", "Ilmu Komputer", "International Program of Science Education (IPSE)"};
        prodiComboBox.setModel(new DefaultComboBoxModel(prodiData));

        // sembunyikan button delete
        deleteButton.setVisible(false);

        // saat tombol add/update ditekan
        addUpdateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(selectedIndex == -1){
                    insertData();
                }else{
                    updateData();
                }
            }
        });

        // saat tombol delete ditekan
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(selectedIndex >= 0){
                    deleteData();
                }
            }
        });

        // saat tombol cancel ditekan
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clearForm();
            }
        });

        // saat salah satu baris tabel ditekan
        mahasiswaTable.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {

                // ubah selectedIndex menjadi baris tabel yang diklik
                selectedIndex = mahasiswaTable.getSelectedRow();

                // simpan value textfield dan combo box
                String selectedNim = mahasiswaTable.getModel().getValueAt(selectedIndex, 1).toString();
                String selectedNama = mahasiswaTable.getModel().getValueAt(selectedIndex, 2).toString();
                String selectedJenisKelamin = mahasiswaTable.getModel().getValueAt(selectedIndex, 3).toString();
                String selectedProdi = mahasiswaTable.getModel().getValueAt(selectedIndex, 4).toString();

                // ubah isi textfield dan combo box
                nimField.setText(selectedNim);
                namaField.setText(selectedNama);
                jenisKelaminComboBox.setSelectedItem(selectedJenisKelamin);
                prodiComboBox.setSelectedItem(selectedProdi);

                // ubah button "Add" menjadi "Update"
                addUpdateButton.setText("Update");

                // tampilkan button delete
                deleteButton.setVisible(true);
            }
        });
    }

    public final DefaultTableModel setTable() {
        // tentukan kolom tabel
        Object[] column = {"No", "NIM", "Nama", "Jenis Kelamin", "Program Studi"};

        // buat objek tabel dengan kolom yang sudah dibuat
        DefaultTableModel temp = new DefaultTableModel(null, column);

        try{
            ResultSet resultSet = database.selectQuery("SELECT * FROM mahasiswa");

            int i = 0;
            while (resultSet.next()){
                Object[] row = new Object[5];

                row[0] = i + 1;
                row[1] = resultSet.getString("nim");
                row[2] = resultSet.getString("nama");
                row[3] = resultSet.getString("jenis_kelamin");
                row[4] = resultSet.getString("prodi");

                temp.addRow(row);
                i++;
            }
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
        return temp;
    }

    public void insertData() {
        // ambil data dari form
        String nim = nimField.getText();
        String nama = namaField.getText();
        String jenisKelamin = jenisKelaminComboBox.getSelectedItem().toString();
        String prodi = prodiComboBox.getSelectedItem().toString();

        // validasi input kosong
        if (nim.isEmpty() || nama.isEmpty() || jenisKelamin.isEmpty() || prodi.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Semua field nya harus diisi yaa!");
            return;
        }

        // validasi NIM yang sama
        if (checkDuplicateNIM(nim)) {
            JOptionPane.showMessageDialog(null, "Tidak dapat menambahkan data, NIM sudah ada!");
            return;
        }

        // tambahkan data ke dalam list
        String sql = "INSERT INTO mahasiswa VALUES (null, '" + nim + "', '" + nama + "', '" + jenisKelamin + "', '" + prodi + "');";
        database.insertUpdateDeleteQuery(sql);

        // update tabel
        mahasiswaTable.setModel(setTable());

        // bersihkan form
        clearForm();

        // feedback
        System.out.println("Insert berhasil!");
        JOptionPane.showMessageDialog(null, "Data berhasil ditambahkan!");
    }

    private boolean checkDuplicateNIM(String nim) {
        try {
            ResultSet resultSet = database.selectQuery("SELECT * FROM mahasiswa WHERE nim = '" + nim + "'");
            return resultSet.next(); // return true jika NIM sudah ada
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void updateData() {
        // ambil data dari form
        String nim = nimField.getText();
        String nama = namaField.getText();
        String jenisKelamin = jenisKelaminComboBox.getSelectedItem().toString();
        String prodi = prodiComboBox.getSelectedItem().toString();

        // validasi input kosong
        if (nim.isEmpty() || nama.isEmpty() || jenisKelamin.isEmpty() || prodi.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Semua field nya harus diisi yaa!");
            return;
        }

        // cek apakah ada baris yang dipilih untuk diubah
        if (selectedIndex >= 0 && selectedIndex < mahasiswaTable.getRowCount()) {
            try {
                // ambil nim dari baris yang dipilih
                String selectedNim = mahasiswaTable.getModel().getValueAt(selectedIndex, 1).toString();

                // buat prepared statement untuk update data
                PreparedStatement statement = database.prepareStatement("UPDATE mahasiswa SET nim = ?, nama = ?, jenis_kelamin = ?, prodi = ? WHERE nim = ?");
                statement.setString(1, nim);
                statement.setString(2, nama);
                statement.setString(3, jenisKelamin);
                statement.setString(4, prodi);
                statement.setString(5, selectedNim);

                int rowsUpdated = statement.executeUpdate();

                if (rowsUpdated > 0) {
                    // update tabel
                    mahasiswaTable.setModel(setTable());

                    // bersihkan form
                    clearForm();

                    // feedback
                    System.out.println("Update berhasil!");
                    JOptionPane.showMessageDialog(null, "Data berhasil diubah!");
                } else {
                    JOptionPane.showMessageDialog(null, "Tidak ada data yang diubah nihh. Periksa lagi NIM nya yaa.");
                }
            } catch (SQLException e) {
                System.out.println("Error: " + e.getMessage());
                JOptionPane.showMessageDialog(null, "Error saat mengubah data!");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Pilih baris yang valid untuk diubah!");
        }
    }

    public void deleteData() {
        // cek apakah ada baris yang dipilih untuk diubah
        if (selectedIndex >= 0) {
            // ambil nim dari baris yang dipilih
            String selectedNim = mahasiswaTable.getModel().getValueAt(selectedIndex, 1).toString();

            int yakin = JOptionPane.showConfirmDialog(null, "Yakin ni pen dihapus bro?",
                    "Delete Confirmation", JOptionPane.YES_NO_OPTION);

            if (yakin == JOptionPane.YES_OPTION) {

                int confirm = JOptionPane.showConfirmDialog(null, "Yang benerrr??",
                        "Delete Confirmation", JOptionPane.YES_NO_OPTION);

                if (confirm == JOptionPane.YES_OPTION) {

                    try {
                        // buat prepared statement untuk delete data
                        PreparedStatement statement = database.prepareStatement("DELETE FROM mahasiswa WHERE nim = ?");
                        statement.setString(1, selectedNim);

                        int rowsDeleted = statement.executeUpdate();

                        if (rowsDeleted > 0) {
                            // update tabel
                            mahasiswaTable.setModel(setTable());

                            // bersihkan form
                            clearForm();

                            // feedback
                            System.out.println("Delete berhasil!");
                            JOptionPane.showMessageDialog(null, "Selamatt, data dah dihapus brouu!");

                            // atur selectedIndex menjadi -1
                            selectedIndex = -1;
                        } else {
                            JOptionPane.showMessageDialog(null, "Tidak ada data yang dihapus nihh. Periksa lagi NIM nya yaa.");
                        }
                    } catch (SQLException e) {
                        System.out.println("Error: " + e.getMessage());
                        JOptionPane.showMessageDialog(null, "Error saat menghapus data!");
                    }
                } else {
                    System.out.println("Delete ga jadii!");
                    JOptionPane.showMessageDialog(null, "AHAHAHAH OKEIII");
                }
            } else {
                System.out.println("Delete batal uhuyy!!");
                JOptionPane.showMessageDialog(null, "okeiii, data kamu ga jadi dihapuss!");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Pilih baris untuk dihapus!");
        }
    }

    public void clearForm() {
        // kosongkan semua texfield dan combo box
        nimField.setText("");
        namaField.setText("");
        jenisKelaminComboBox.setSelectedItem("");
        prodiComboBox.setSelectedItem("");

        // ubah button "Update" menjadi "Add"
        addUpdateButton.setText("Add");

        // sembunyikan button delete
        deleteButton.setVisible(false);

        // ubah selectedIndex menjadi -1 (tidak ada baris yang dipilih)
        selectedIndex = -1;
    }
}
