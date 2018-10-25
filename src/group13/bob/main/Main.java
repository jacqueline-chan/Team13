package group13.bob.main;


import group13.bob.table.Table;

import java.awt.*;

import static group13.bob.sqlite.SqlConnect.connect;

public class Main {

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Table frame = new Table();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
	    connect();
    }
}
