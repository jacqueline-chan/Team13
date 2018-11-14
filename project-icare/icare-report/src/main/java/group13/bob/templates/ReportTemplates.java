package group13.bob.templates;

import group13.bob.files.FileManager;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.*;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.*;

public class ReportTemplates {
  private static String[] columns = FormArray.getColumnNames();
  private static boolean[] includedInTemplate;
  private static JFrame templateFrame;
  private static boolean fieldsSelected;
  // A counter that keeps track of the amount of fields selected.
  private static int templateColumnNum;

  public static void CreateTemplatePopUp() {
    includedInTemplate = new boolean[columns.length];
    templateColumnNum = 0;
    fieldsSelected = false;
    templateFrame = new JFrame("Create new Template");
    templateFrame.setPreferredSize(new Dimension(500, 500));
    templateFrame.pack();
    templateFrame.setLocationRelativeTo(null);
    templateFrame.setVisible(true);

    JPanel combinePanel = new JPanel(new GridLayout(columns.length, 1));
    // Create an array of buttons that switch the color upon click.
    JButton[] buttons = new JButton[columns.length];
    for (int i = 0; i < columns.length; i++) {
      final int index = i;
      buttons[i] = new JButton(columns[i]);
      buttons[i].setBackground(Color.RED);
      buttons[i].setPreferredSize(new Dimension(40, 40));
      buttons[i].addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
          switchButton(buttons[index], index);
        }
      });
      combinePanel.add(buttons[i]);
    }

    JPanel submitPanel = new JPanel(new GridLayout(0, 1));
    JScrollPane scrollPane = new JScrollPane(combinePanel);
    scrollPane
        .setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
    templateFrame.add(scrollPane, BorderLayout.CENTER);

    // A check box that selects all the fields.
    JCheckBox selectAll = new JCheckBox("Select all fields");
    selectAll.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < columns.length; i++) {
          if (!((fieldsSelected) ^ (includedInTemplate[i]))) {
            switchButton(buttons[i], i);
          }
        }
        fieldsSelected = !(fieldsSelected);
      }
    });
    submitPanel.add(selectAll);

    // Add the button for submit.
    JButton submitButton = new JButton("Submit the template");
    submitButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        if (fieldsSelected) {
          FileManager.saveFilePopUp(columns);
        } else {
          String[] fields = new String[templateColumnNum];
          int index = 0;
          for (int i = 0; i < columns.length; i++) {
            if (includedInTemplate[i]) {
              fields[index] = columns[i];
              index++;
            }
          }
          FileManager.saveFilePopUp(fields);
        }
        templateFrame.dispose();
      }
    });
    submitPanel.add(submitButton);
    templateFrame.add(submitPanel, BorderLayout.PAGE_END);

  }

  private static void switchButton(JButton button, int index) {
    includedInTemplate[index] = !(includedInTemplate[index]);
    if (includedInTemplate[index]) {
      button.setBackground(Color.GREEN);
      templateColumnNum++;
    } else {
      button.setBackground(Color.RED);
      templateColumnNum--;
    }
  }
}
