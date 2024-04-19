package impl;

import dao.userdao;

public class userdaoimpl implements userdao {

    @Override
    public void insert() {
        System.out.println("User inserted successfully");
    }

    @Override
    public void delete() {
        System.out.println("User deleted successfully");
    }

    @Override
    public void update() {
        System.out.println("User updated successfully");
    }

    @Override
    public void select() {
        System.out.println("User selected successfully");
    }
}
