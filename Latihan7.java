/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pertemuan7;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
/**
 *
 * @author wdead
 */

// Subkelas dari kelas JFrame
public class Latihan7 extends JFrame {
    
    
    // Deklarasi variabel-variabel yang akan digunakan dalam kelas
    private JFrame frame;
    private JTextField nameField;
    private JComboBox<String> genderComboBox;
    private JTextField phoneNumberField;
    private JTextArea addressArea;
    private JTable table;
    private DefaultTableModel tableModel;

    // Konstruktor
    public Latihan7() {
        frame = new JFrame("Biodata");
        // Mengatur perilaku penutupan jendela
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        // Menambahkan pemantau jendela yang menampilkan dialog konfirmasi saat pengguna mencoba menutup jendela. Jika pengguna memilih "Yes," aplikasi akan ditutup
        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                int option = JOptionPane.showConfirmDialog(frame, "Apakah Anda yakin ingin keluar?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
                if (option == JOptionPane.YES_OPTION) {
                    System.exit(0);
                }
            }
        });

        // Membuat komponen-komponen input
        nameField = new JTextField(20);
        genderComboBox = new JComboBox<>(new String[]{"Pria", "Wanita"});
        phoneNumberField = new JTextField(20);
        addressArea = new JTextArea(5, 20);

        // Membuat model tabel default
        tableModel = new DefaultTableModel();
        tableModel.addColumn("Nama");
        tableModel.addColumn("Jenis Kelamin");
        tableModel.addColumn("Nomor HP");
        tableModel.addColumn("Alamat");

        // Membuat tabel
        table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);

        // Membuat tombol-tombol 
        JButton saveButton = new JButton("Simpan");
        JButton editButton = new JButton("Edit");
        JButton deleteButton = new JButton("Hapus");

        // Menambahkan action listener ke tombol-tombol
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveBiodata();
            }
        });

        // Untuk mengedit biodata
        editButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                editBiodata();
            }
        });

        // Untuk menghapus biodata
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteBiodata();
            }
        });

        // Mengatur tampilan jendela dengan menggunakan GridBagLayout dan BorderLayout
        JPanel inputPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(5, 5, 5, 5);

        inputPanel.add(new JLabel("Nama:"), gbc);
        gbc.gridx = 1;
        inputPanel.add(nameField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        inputPanel.add(new JLabel("Jenis Kelamin:"), gbc);
        gbc.gridx = 1;
        inputPanel.add(genderComboBox, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        inputPanel.add(new JLabel("Nomor HP:"), gbc);
        gbc.gridx = 1;
        inputPanel.add(phoneNumberField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        inputPanel.add(new JLabel("Alamat:"), gbc);
        gbc.gridx = 1;
        inputPanel.add(new JScrollPane(addressArea), gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        inputPanel.add(saveButton, gbc);

        JPanel tablePanel = new JPanel(new BorderLayout());
        tablePanel.add(scrollPane, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(saveButton);
        buttonPanel.add(editButton);
        buttonPanel.add(deleteButton);

        frame.setLayout(new BorderLayout());
        frame.add(inputPanel, BorderLayout.NORTH);
        frame.add(tablePanel, BorderLayout.CENTER);
        frame.add(buttonPanel, BorderLayout.SOUTH);

        // Mem-packing jendela dan menjadikannya terlihat
        frame.pack();
        frame.setVisible(true);
    }

    //  Untuk menyimpan biodata baru ke dalam tabel setelah pengguna mengisi informasi dan mengeklik tombol "Simpan"
    private void saveBiodata() {
        String name = nameField.getText();
        String gender = (String) genderComboBox.getSelectedItem();
        String phoneNumber = phoneNumberField.getText();
        String address = addressArea.getText();

        if (name.isEmpty() || phoneNumber.isEmpty() || address.isEmpty()) {
            JOptionPane.showMessageDialog(frame, "Semua input harus diisi", "Peringatan", JOptionPane.WARNING_MESSAGE);
            return;
        }

        tableModel.addRow(new String[]{name, gender, phoneNumber, address});
        nameField.setText("");
        genderComboBox.setSelectedIndex(0);
        phoneNumberField.setText("");
        addressArea.setText("");
    }

    // Untuk mengedit biodata yang telah ada dalam tabel. Pengguna harus memilih baris yang ingin diubah, kemudian data diubah dengan data dari komponen input.
    private void editBiodata() {
        int selectedRow = table.getSelectedRow();
        if (selectedRow != -1) {
            String name = nameField.getText();
            String gender = (String) genderComboBox.getSelectedItem();
            String phoneNumber = phoneNumberField.getText();
            String address = addressArea.getText();

            if (name.isEmpty() || phoneNumber.isEmpty() || address.isEmpty()) {
                JOptionPane.showMessageDialog(frame, "Semua input harus diisi", "Peringatan", JOptionPane.WARNING_MESSAGE);
                return;
            }

            tableModel.setValueAt(name, selectedRow, 0);
            tableModel.setValueAt(gender, selectedRow, 1);
            tableModel.setValueAt(phoneNumber, selectedRow, 2);
            tableModel.setValueAt(address, selectedRow, 3);
            nameField.setText("");
            genderComboBox.setSelectedIndex(0);
            phoneNumberField.setText("");
            addressArea.setText("");
        } else {
            JOptionPane.showMessageDialog(frame, "Pilih baris untuk diedit", "Peringatan", JOptionPane.WARNING_MESSAGE);
        }
    }

    // Untuk menghapus biodata dari tabel. Pengguna harus memilih baris yang ingin dihapus.
    private void deleteBiodata() {
        int selectedRow = table.getSelectedRow();
        if (selectedRow != -1) {
            tableModel.removeRow(selectedRow);
        } else {
            JOptionPane.showMessageDialog(frame, "Pilih baris untuk dihapus", "Peringatan", JOptionPane.WARNING_MESSAGE);
        }
    }

    // Main Metode
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Latihan7();
            }
        });
    }
    
}
