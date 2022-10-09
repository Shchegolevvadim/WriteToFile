// Напишите приложение, которое будет запрашивать у пользователя следующие данные в произвольном порядке, разделенные пробелом:
// Фамилия Имя Отчество датарождения номертелефона пол
// Форматы данных:
// фамилия, имя, отчество - строки

// дата_рождения - строка формата dd.mm.yyyy

// номер_телефона - целое беззнаковое число без форматирования

// пол - символ латиницей f или m.

// Приложение должно проверить введенные данные по количеству. Если количество не совпадает с требуемым, вернуть код ошибки,
//  обработать его и показать пользователю сообщение, что он ввел меньше или больше данных, чем требуется.

// Приложение должно попытаться распарсить полученные значения и выделить из них требуемые параметры. 
// Если форматы данных не совпадают, нужно бросить исключение, соответствующее типу проблемы.
//  Можно использовать встроенные типы java и создать свои. Исключение должно быть корректно обработано,
//  пользователю выведено сообщение с информацией, что именно неверно.

// Если всё введено и обработано верно, должен создаться файл с названием, равным фамилии,
//  в него в одну строку должны записаться полученные данные, вида

// <Фамилия><Имя><Отчество><датарождения> <номертелефона><пол>
import java.util.InputMismatchException;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class TaskWriteToFile {
    public static void main(String[] args) throws StringTooLongException, DateToLong, PhoneToLong, MaleFemale {
        {
            final int MAX_STRING_LENGTH = 30;
            try {
                System.out.println("Введите Фамилию строкой");
                Scanner sc = new Scanner(System.in);
                String surname = sc.next();
                String nameOfFile = surname;
                if (surname.length() > MAX_STRING_LENGTH)
                    throw new StringTooLongException();
                File file = new File(nameOfFile);
                System.out.println("Введите имя строкой");
                String name = sc.next();
                if (name.length() > MAX_STRING_LENGTH)
                    throw new StringTooLongException();
                System.out.println("Введите Отчество строкой");
                String patronymic = sc.next();
                if (patronymic.length() > MAX_STRING_LENGTH)
                    throw new StringTooLongException();

                System.out.println("Введите дату рождения в формате дд.мм.гггг");
                String DateOfBirth = sc.next();
                if (DateOfBirth.length() > 10)
                    throw new DateToLong();
                System.out.println("Введите номер телефона цифрами без знаков");
                String PhoneNumber = sc.next();
                if (PhoneNumber.length() > 12)
                    throw new PhoneToLong();
                System.out.println("Введите пол знаком M или F");
                String MaleFemale = sc.next();
                if (MaleFemale.length() > 1)
                    throw new MaleFemale();

                PrintWriter fileWriter = null;

                try {
                    file.createNewFile();
                    fileWriter = new PrintWriter(file);
                    fileWriter.print("<");
                    fileWriter.print(surname);
                    fileWriter.print("><");
                    fileWriter.print(name);
                    fileWriter.print("><");
                    fileWriter.print(patronymic);
                    fileWriter.print("><");
                    fileWriter.print(DateOfBirth);
                    fileWriter.print("><");
                    fileWriter.print(PhoneNumber);
                    fileWriter.print("><");
                    fileWriter.print(MaleFemale);
                    fileWriter.print(">");
                } catch (IOException e) {
                    System.out.println("Не смогли создать файл");
                }

                finally {
                    fileWriter.close();
                }
            } catch (NullPointerException e) {
                throw new MyNullElement("Нельзя ввести пустое значение");
            }
        }
    }
}
