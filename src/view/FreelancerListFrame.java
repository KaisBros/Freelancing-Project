package view;

import controller.FreelancerController;
import model.Freelancer;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;
public class FreelancerListFrame extends JFrame {
    private JTable table;
    private DefaultTableModel tableModel;
    private FreelancerController controller;

    public FreelancerListFrame() {
        controller = new FreelancerController();

        setTitle("Danh sách Freelancer");
        setSize(800, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        initUI();
        loadData();
    }

    private void initUI() {
        JPanel panelTop = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JButton btnAdd = new JButton("➕ Thêm");
        JButton btnDelete = new JButton("🗑\uD83D\uDDD1\uFE0F Xoá");
        JButton btnEdit = new JButton("✏\uFE0F Sửa");
        JButton btnReload = new JButton("\uD83D\uDD04 Tải lại");

        panelTop.add(btnAdd);
        panelTop.add(btnEdit);
        panelTop.add(btnDelete);
        panelTop.add(btnReload);

        String[] cols = {"Mã", "Họ tên", "Email", "SĐT", "Kỹ năng", "Đánh giá"};
        tableModel = new DefaultTableModel(cols, 0);
        table = new JTable(tableModel);

        table.getColumnModel().getColumn(0).setPreferredWidth(50);  // Mã
        table.getColumnModel().getColumn(1).setPreferredWidth(150); // Họ tên
        table.getColumnModel().getColumn(2).setPreferredWidth(200); // Email
        table.getColumnModel().getColumn(3).setPreferredWidth(100); // SĐT
        table.getColumnModel().getColumn(4).setPreferredWidth(150); // Kỹ năng
        table.getColumnModel().getColumn(5).setPreferredWidth(50); // Đánh giá

        JScrollPane scrollPane = new JScrollPane(table);

        getContentPane().add(panelTop, BorderLayout.NORTH);
        getContentPane().add(scrollPane, BorderLayout.CENTER);

        btnAdd.addActionListener(e -> {
            FreelancerFormDialog dialog = new FreelancerFormDialog(this, null);
            dialog.setVisible(true);
            loadData();
        });

        btnEdit.addActionListener(e -> {
            int row = table.getSelectedRow();
            if (row == -1) {
                JOptionPane.showMessageDialog(this, "Chọn freelancer để sửa!");
                return;
            }
            String maFreelancer = tableModel.getValueAt(row, 0).toString();
            Freelancer f = controller.getAllFreelancers().stream()
                    .filter(frl -> frl.getMaFreelancer().equals(maFreelancer))
                    .findFirst()
                    .orElse(null);
            if (f != null) {
                FreelancerFormDialog dialog = new FreelancerFormDialog(this, f);
                dialog.setVisible(true);
                loadData();
            }
        });

        btnDelete.addActionListener(e -> {
            int row = table.getSelectedRow();
            if (row == -1) {
                JOptionPane.showMessageDialog(this, "Chọn freelancer để xóa!");
                return;
            }
            String maFreelancer = tableModel.getValueAt(row, 0).toString();
            int confirm = JOptionPane.showConfirmDialog(this, "Xóa Freelancer " + maFreelancer + "?", "Xác nhận", JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                controller.deleteFreelancer(maFreelancer);
                loadData();
            }
        });
    }

    public void loadData() {
        tableModel.setRowCount(0);
        List<Freelancer> list = controller.getAllFreelancers();
        for (Freelancer f : list) {
            tableModel.addRow(new Object[] {
                    f.getMaFreelancer(),
                    f.getHoTen(),
                    f.getEmail(),
                    f.getSoDienThoai(),
                    f.getKyNang(),
                    f.getDanhGia()
            });
        }
    }
}
