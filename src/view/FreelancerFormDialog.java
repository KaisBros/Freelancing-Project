package view;

import controller.FreelancerController;
import model.Freelancer;

import javax.swing.*;
import java.awt.*;

public class FreelancerFormDialog extends JDialog {
    private JTextField tfMa, tfHoTen, tfEmail, tfSDT, tfKyNang, tfDanhGia;
    private FreelancerController controller;
    private boolean isNew;
    private Freelancer freelancer;

    public FreelancerFormDialog(JFrame parent, Freelancer f) {
        super(parent, true);
        controller = new FreelancerController();
        this.freelancer = f;
        this.isNew = (f == null);

        setTitle(isNew ? "Thêm Freelancer" : "Cập nhật Freelancer");
        setSize(400, 300);
        setLocationRelativeTo(parent);
        initUI();
        if (!isNew) loadData();
    }

    private void initUI() {
        JPanel panel = new JPanel(new GridLayout(7, 2, 5, 5));

        panel.add(new JLabel("Mã Freelancer:"));
        tfMa = new JTextField();
        panel.add(tfMa);

        panel.add(new JLabel("Họ tên:"));
        tfHoTen = new JTextField();
        panel.add(tfHoTen);

        panel.add(new JLabel("Email:"));
        tfEmail = new JTextField();
        panel.add(tfEmail);

        panel.add(new JLabel("SĐT:"));
        tfSDT = new JTextField();
        panel.add(tfSDT);

        panel.add(new JLabel("Kỹ năng:"));
        tfKyNang = new JTextField();
        panel.add(tfKyNang);

        panel.add(new JLabel("Đánh giá (0-5):"));
        tfDanhGia = new JTextField();
        panel.add(tfDanhGia);

        JButton btnSave = new JButton("Lưu");
        JButton btnCancel = new JButton("Hủy");

        panel.add(btnSave);
        panel.add(btnCancel);

        getContentPane().add(panel);

        if (!isNew) tfMa.setEditable(false);

        btnSave.addActionListener(e -> saveFreelancer());
        btnCancel.addActionListener(e -> dispose());
    }

    private void loadData() {
        tfMa.setText(freelancer.getMaFreelancer());
        tfHoTen.setText(freelancer.getHoTen());
        tfEmail.setText(freelancer.getEmail());
        tfSDT.setText(freelancer.getSoDienThoai());
        tfKyNang.setText(freelancer.getKyNang());
        tfDanhGia.setText(String.valueOf(freelancer.getDanhGia()));
    }

    private void saveFreelancer() {
        try {
            Freelancer f = new Freelancer(
                    tfMa.getText().trim(),
                    tfHoTen.getText().trim(),
                    tfEmail.getText().trim(),
                    tfSDT.getText().trim(),
                    tfKyNang.getText().trim(),
                    Float.parseFloat(tfDanhGia.getText().trim())
            );

            boolean success = isNew
                    ? controller.addFreelancer(f)
                    : controller.updateFreelancer(f);

            if (success) {
                JOptionPane.showMessageDialog(this, "Lưu thành công!");
                dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Lưu thất bại. Kiểm tra lại dữ liệu!");
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Lỗi dữ liệu: " + ex.getMessage());
        }
    }
}
