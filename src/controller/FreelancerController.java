package controller;

import dao.FreelancerDAO;
import model.Freelancer;

import java.sql.SQLException;
import java.util.List;

public class FreelancerController {
    private FreelancerDAO dao;

    public FreelancerController() {
        dao = new FreelancerDAO();
    }

    public boolean addFreelancer(Freelancer f) {
        try {
            return dao.insert(f);
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean deleteFreelancer(String maFreelancer) {
        try {
            return dao.delete(maFreelancer);
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean updateFreelancer(Freelancer f) {
        try {
            return dao.update(f);
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<Freelancer> getAllFreelancers() {
        try {
            return dao.getAll();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public Freelancer findById(String id) {
        try {
            return dao.findById(id);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
