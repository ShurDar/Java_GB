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
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); // завершает работу программы при закрытии формы
        setBounds(300, 300, 400, 400);
        setLayout(new BorderLayout()); // размещает элементы по кра€м

// добавим дисплей (по умолчанию на дисплее ставим 0)
        JLabel display = new JLabel("0");
        display.setHorizontalAlignment(SwingConstants.RIGHT); // ориентируем написание цифра с права на лево
        display.setFont(new Font("Arial", Font.PLAIN, 50)); // зададим шрифт
        add(display, BorderLayout.NORTH); // добавл€ем дисплей на верх панели

// экшен листинер дл€ кнопок 0-9 и [.]
        ActionListener numberListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JButton button = (JButton) e.getSource(); // чтобы отбражалась кнопка, которую нажали
                String text = button.getText(); // в text будет лежать то, что написано на кнопке
                String displayText = display.getText();

                // если точка и дисплей уже сожержит точку, то выходим из метода
                if (".".equals(text) && display.getText().contains(".")) {
                    return;
                }

                // если ноль есть на дисплее и тект не равен точке, то на дисплее пусто
                if ("0".equals(displayText) && !".".equals(text)) { // убрали лидирующий ноль и добавили что если первый раз нажать точку, то софрмируетс€ 0,
                    displayText = "";
                }

                displayText += text;
                display.setText(displayText);
            }
        };

// экшен листинер дл€ кнопок "C+-*/="
        ActionListener buttonListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JButton source = (JButton) e.getSource(); //передадим туда текст, который этой кнопке
                String action = source.getText(); // кнопка, кот. нажали или действие кот. надо сделать
                Double rightOperand = Double.parseDouble(display.getText());
                // метод parseDouble превращает строку в число, принимает на вход строку и превращает ее в число
                // leftOperand - то значение, которое на дисплее
                // rightOperand - то значение, которое было до того, как мы нажали операцию

                if ("=".equals(action)) { // если action равен "="
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
                        // присовили leftOperand то что лежит на дисплее как число
                        leftOperand = Double.parseDouble(display.getText());
                        operation = null;
                    }
                    return;
                }
                // присовили leftOperand то что лежит на дисплее как число
                leftOperand = Double.parseDouble(display.getText());
                operation = action;
                display.setText("0");
            }
        };


        JPanel numberPanel = new JPanel(); // несколько компоновщиков на одной панели
        GridLayout numberLayout = new GridLayout(5, 4, 5, 5);
        numberPanel.setLayout(numberLayout);

        JButton percentButton = new JButton("%");
        JButton bracketButton = new JButton("( )");
        JButton deleteButton = new JButton("C");
        numberPanel.add(percentButton);
        numberPanel.add(bracketButton);
        numberPanel.add(deleteButton);
        deleteButton.addActionListener(buttonListener);

// добавл€ем кнопки на панель numberPanel
        for (int i = 1; i < 10; i++) {
            JButton button = new JButton(String.valueOf(i)); // переобразуем переменную int в String
            button.addActionListener(numberListener); // добавили экшен листинер на кнопки в цикле
            numberPanel.add(button);
        }

// добавим кнопки с точкой [.], со сменой знака [+/-] и ноль
        JButton pointButton = new JButton(".");
        pointButton.addActionListener(numberListener);

        JButton nullButton = new JButton("0");
        nullButton.addActionListener(numberListener);

        JButton negativeButton = new JButton("+/-");



// добавим новые кнопки на поле калькул€тора
        numberPanel.add(negativeButton);
        numberPanel.add(nullButton);
        numberPanel.add(pointButton);


// создаем панель дл€ кнопок сложени€/вычитани€/умножени€
        JPanel buttonPanel = new JPanel();
        GridLayout buttonLayout = new GridLayout(5, 1, 5, 5);
        buttonPanel.setLayout(buttonLayout);

        for (char c : "/*-+=".toCharArray()) {
            JButton button = new JButton(String.valueOf(c));
            button.addActionListener(buttonListener);
            buttonPanel.add(button);
        }

        add(numberPanel, BorderLayout.CENTER); // добавили панель в окно
        add(buttonPanel, BorderLayout.EAST); // добавили панель с кнопками "C+-*/="

        setVisible(true); // отображает окно после компел€ции
    }


    public static void main(String[] args) {
        new Calculator();
    }
}
