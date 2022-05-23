package ru.gb.shurupova.homework8;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator extends JFrame {

    private Double leftOperand;
    private String operation;

    public Calculator() {
        setTitle("Calculator");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); // ��������� ������ ��������� ��� �������� �����
        setBounds(300, 300, 400, 400);
        setLayout(new BorderLayout()); // ��������� �������� �� �����

// ������� ������� (�� ��������� �� ������� ������ 0)
        JLabel display = new JLabel("0");
        display.setHorizontalAlignment(SwingConstants.RIGHT); // ����������� ��������� ����� � ����� �� ����
        display.setFont(new Font("Arial", Font.PLAIN, 50)); // ������� �����
        add(display, BorderLayout.NORTH); // ��������� ������� �� ���� ������

// ����� �������� ��� ������ 0-9 � [.]
        ActionListener numberListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JButton button = (JButton) e.getSource(); // ����� ����������� ������, ������� ������
                String text = button.getText(); // � text ����� ������ ��, ��� �������� �� ������
                String displayText = display.getText();

                // ���� ����� � ������� ��� �������� �����, �� ������� �� ������
                if (".".equals(text) && display.getText().contains(".")) {
                    return;
                }

                // ���� ���� ���� �� ������� � ���� �� ����� �����, �� �� ������� �����
                if ("0".equals(displayText) && !".".equals(text)) { // ������ ���������� ���� � �������� ��� ���� ������ ��� ������ �����, �� ������������ 0,
                    displayText = "";
                }

                displayText += text;
                display.setText(displayText);
            }
        };

// ����� �������� ��� ������ "C+-*/="
        ActionListener buttonListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JButton source = (JButton) e.getSource(); //��������� ���� �����, ������� ���� ������
                String action = source.getText(); // ������, ���. ������ ��� �������� ���. ���� �������
                Double rightOperand = Double.parseDouble(display.getText());
                // ����� parseDouble ���������� ������ � �����, ��������� �� ���� ������ � ���������� �� � �����
                // leftOperand - �� ��������, ������� �� �������
                // rightOperand - �� ��������, ������� ���� �� ����, ��� �� ������ ��������

                if ("=".equals(action)) { // ���� action ����� "="
                    if (leftOperand != null) {
                        switch (operation) {
                            case "+":
                                display.setText(String.valueOf(leftOperand + rightOperand));
                                break;
                            case "-":
                                display.setText(String.valueOf(leftOperand - rightOperand));
                                break;
                            case "*":
                                display.setText(String.valueOf(leftOperand * rightOperand));
                                break;
                            case "/":
                                display.setText(String.valueOf(leftOperand / rightOperand));
                                break;
                        }
                        // ��������� leftOperand �� ��� ����� �� ������� ��� �����
                        leftOperand = Double.parseDouble(display.getText());
                        operation = null;
                    }
                    return;
                }
                // ��������� leftOperand �� ��� ����� �� ������� ��� �����
                leftOperand = Double.parseDouble(display.getText());
                operation = action;
                display.setText("0");
            }
        };


        JPanel numberPanel = new JPanel(); // ��������� ������������� �� ����� ������
        GridLayout numberLayout = new GridLayout(5, 4, 5, 5);
        numberPanel.setLayout(numberLayout);

        JButton percentButton = new JButton("%");
        JButton bracketButton = new JButton("( )");
        JButton deleteButton = new JButton("C");
        numberPanel.add(percentButton);
        numberPanel.add(bracketButton);
        numberPanel.add(deleteButton);
        deleteButton.addActionListener(buttonListener);

// ��������� ������ �� ������ numberPanel
        for (int i = 1; i < 10; i++) {
            JButton button = new JButton(String.valueOf(i)); // ������������ ���������� int � String
            button.addActionListener(numberListener); // �������� ����� �������� �� ������ � �����
            numberPanel.add(button);
        }

// ������� ������ � ������ [.], �� ������ ����� [+/-] � ����
        JButton pointButton = new JButton(".");
        pointButton.addActionListener(numberListener);

        JButton nullButton = new JButton("0");
        nullButton.addActionListener(numberListener);

        JButton negativeButton = new JButton("+/-");



// ������� ����� ������ �� ���� ������������
        numberPanel.add(negativeButton);
        numberPanel.add(nullButton);
        numberPanel.add(pointButton);


// ������� ������ ��� ������ ��������/���������/���������
        JPanel buttonPanel = new JPanel();
        GridLayout buttonLayout = new GridLayout(5, 1, 5, 5);
        buttonPanel.setLayout(buttonLayout);

        for (char c : "/*-+=".toCharArray()) {
            JButton button = new JButton(String.valueOf(c));
            button.addActionListener(buttonListener);
            buttonPanel.add(button);
        }

        add(numberPanel, BorderLayout.CENTER); // �������� ������ � ����
        add(buttonPanel, BorderLayout.EAST); // �������� ������ � �������� "C+-*/="

        setVisible(true); // ���������� ���� ����� ����������
    }


    public static void main(String[] args) {
        new Calculator();
    }
}
