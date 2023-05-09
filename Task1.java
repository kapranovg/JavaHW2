package Homework.HW2;

import java.io.FileWriter;
import java.io.IOException;

// Дана json строка[{ "фамилия":"Иванов","оценка":"5","предмет":"Математика"},
// {"фамилия":"Петрова","оценка":"4","предмет":"Информатика"},
// {"фамилия":"Краснов","оценка":"5","предмет":"Физика"}]
// Задача написать метод(ы), который распарсит строку и выдаст ответ вида:
// Студент Иванов получил 5 по предмету Математика.
// Студент Петрова получил 4 по предмету Информатика.
// Студент Краснов получил 5 по предмету Физика.

// Используйте StringBuilder для подготовки ответа

// Исходная json строка это просто String !!! 
// Для работы используйте методы String, такие как replace, split, substring и т.д. по необходимости

// Создать метод, который запишет результат работы в файл. 
// Обработайте исключения и запишите ошибки в лог файл.

public class Task1 {
    public static void main(String[] args) {
        String js = "[{\"фамилия\":\"Иванов\",\"оценка\":\"5\",\"предмет\":\"Математика\"},{\"фамилия\":\"Петрова\",\"оценка\":\"4\",\"предмет\":\"Информатика\"},{\"фамилия\":\"Краснов\",\"оценка\":\"5\",\"предмет\":\"Физика\"}]";
        String[] records = js.replace("[", "").replace("]", "").split("\\},\\{");

        StringBuilder result = new StringBuilder();

        for (String record : records) {
            String[] fields = record.replace("{", "").replace("}", "").split(",");
            String surname = fields[0].split(":")[1].replace("\"", "");
            String grade = fields[1].split(":")[1].replace("\"", "");
            String subject = fields[2].split(":")[1].replace("\"", "");
            result.append("Студент ")
                    .append(surname)
                    .append(" получил ")
                    .append(grade)
                    .append(" по предмету ")
                    .append(subject)
                    .append(".\n");
        }

        try {
            FileWriter writer = new FileWriter("result.txt");
            writer.write(result.toString());
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}