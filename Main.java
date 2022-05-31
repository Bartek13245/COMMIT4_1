import java.io.IOException;
import java.util.Scanner;
import java.io.IOException;

class WrongStudentName extends Exception { }
class WrongAge extends Exception { }
class WrongDateOfBirth extends Exception { }

class Main {
    public static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        while(true) {
            try {
                int ex = menu();
                switch(ex) {
                    case 1: exercise1(); break;
                    case 2: exercise2(); break;
                    case 3: exercise3(); break;
                    default: return;
                }
            } catch(IOException e) {

            } catch(WrongStudentName e) {
                System.out.println("Bledne imie studenta!");
            }
              catch (WrongAge e) {
                System.out.println("Bledny wiek studenta!");
            } 
               catch (WrongDateOfBirth e){
                System.out.println("Bledna data urodzenia studenta!");
                 }
          }
      }

    public static int menu() { 
        System.out.println("Wciśnij:");
        System.out.println("1 - aby dodać studenta");
        System.out.println("2 - aby wypisać wszystkich studentów");
        System.out.println("3 - aby wyszukać studenta ");
        System.out.println("4 - wyjscie");
        return scan.nextInt();
    }

    public static String ReadName() throws WrongStudentName {
        scan.nextLine();
        System.out.println("Podaj imie: ");
        String name = scan.nextLine();
        if(name.contains(" "))
            throw new WrongStudentName();

        return name;
    }
    public static int ReadAge() throws WrongAge {
        scan.nextLine();
        System.out.println("Podaj wiek: ");
        int age = scan.nextInt();
        if (age > 100 || age < 0)
            throw new WrongAge();
        
      return age;
      }
    public static String ReadDate() throws WrongDateOfBirth {
        scan.nextLine();
        System.out.println("Podaj datę urodzenia (DD-MM-YYYY): ");
        String date = scan.nextLine();
        if (date.length() != 10 || date.charAt(2) != '-' || date.charAt(5) != '-'
            || (date.charAt(0) > '3' && date.charAt(1) > '1') || (date.charAt(3) >       '1' && date.charAt(4) > '2'))
            throw new WrongDateOfBirth();

    return date;
  }

    public static void exercise1() throws IOException, WrongStudentName, WrongAge, WrongDateOfBirth {
        var name = ReadName();
       var age = ReadAge();
       var date = ReadDate();
        (new Service1()).addStudent(new Student(name, age, date));
    }

    public static void exercise2() throws IOException {
        var students = (new Service1()).getStudents();
        for(Student current : students) {
            System.out.println(current.ToString());
        }
    }

    public static void exercise3() throws IOException {
        scan.nextLine();
        System.out.println("Podaj imie: ");
        var name = scan.nextLine();
        var wanted = (new Service1()).findStudentByName(name);
        if(wanted == null)
            System.out.println("Nie znaleziono...");
        else {
            System.out.println("Znaleziono: ");
            System.out.println(wanted.ToString());
        }
    }
}