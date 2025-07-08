package model;

public class Freelancer {
    private String maFreelancer;
    private String hoTen;
    private String email;
    private String soDienThoai;
    private String kyNang;
    private float danhGia;

    public Freelancer(String maFreelancer, String hoTen, String email, String soDienThoai, String kyNang, float danhGia) {
        this.maFreelancer = maFreelancer;
        this.hoTen = hoTen;
        this.email = email;
        this.soDienThoai = soDienThoai;
        this.kyNang = kyNang;
        this.danhGia = danhGia;
    }

    // Getter Setter ở đây
    public String getMaFreelancer() { return maFreelancer; }
    public void setMaFreelancer(String maFreelancer) { this.maFreelancer = maFreelancer; }

    public String getHoTen() { return hoTen; }
    public void setHoTen(String hoTen) { this.hoTen = hoTen; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getSoDienThoai() { return soDienThoai; }
    public void setSoDienThoai(String soDienThoai) { this.soDienThoai = soDienThoai; }

    public String getKyNang() { return kyNang; }
    public void setKyNang(String kyNang) { this.kyNang = kyNang; }

    public float getDanhGia() { return danhGia; }
    public void setDanhGia(float danhGia) { this.danhGia = danhGia; }
}