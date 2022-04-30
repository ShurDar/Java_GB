package ru.gb.shurupova.HomeWorkFive;

public class HomeWorkFive {

    public static void main(String[] args) {
        Employee[] employeeArray = new Employee[5];

        employeeArray[0] = new Employee("Колесников Михаил Лионидович", "Директор", "kolesnokov@gmail.com", "89264567136", 70000, 43);
        employeeArray[1] = new Employee("Кравченко Анна Александровна", "Бухгалтер", "kravchenko@gmail.com", "89052467513", 40000, 50);
        employeeArray[2] = new Employee("Иванов Иван Иванович", "Менеджер", "ivanov@gmail.com", "89055553555", 40000, 35);
        employeeArray[3] = new Employee("Петров Семен Сергеевич", "Оператор", "petrov@gmail.com", "89034467826", 30000, 38);
        employeeArray[4] = new Employee("Сидоров Василий Сергеевич", "Курьер", "sidirov@gmail.com", "89264597513", 25000, 25);

        for (int i = 0; i < employeeArray.length; i++) {
            if(employeeArray[i].getAge() > 40){
                employeeArray[i].print();
                System.out.println();
            }
        }
    }
}




