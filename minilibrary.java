import java.util.*;
class Book{
    int Id;
    String Title;
    String Author;
    boolean isissued;
    Book(int Id,String Title,String Author){
        this.Id=Id;
        this.Title=Title;
        this.Author=Author;
        this.isissued=false;
    } 
}
public class minilibrary{
      static ArrayList<Book> books=new ArrayList<>();
       static Scanner sc=new Scanner(System.in);

        public static void Addbook(){                                  //ADD BOOk
            System.out.println("Enter Book Id:- ");
            int Id=sc.nextInt();
           sc.nextLine();
             System.out.println("Enter Book Author:-");
              String Author=sc.nextLine();
              System.out.println("Enter Book Title:-");
         String Title=sc.nextLine();

             books.add(new Book(Id,Title,Author));
              System.out.println("Book Added Successfully");
        }
        public static void Viewbook(){                                           // View Book
            if (books.isEmpty()) {
            System.out.println("No books available.");
            return;
        }

        System.out.println("\nID\tTitle\t\tAuthor\t\tStatus");
        for(Book b : books){
            System.out.println(b.Id + "\t" + b.Title + "\t\t" + b.Author + "\t\t" +
                    (b.isissued ? "Issued" : "Available"));
        }
        }
        public static void issuebook(){                                             //Issue Book
             System.out.print("Enter Book ID to issue: ");
        int Id = sc.nextInt();

        for (Book b : books) {
            if (b.Id == Id && !b.isissued) {
                b.isissued = true;
                System.out.println("Book Issued Successfully!");
                return;
            }
        }
        System.out.println("Book not available or already issued!");
        }
        public static void returnbook(){                                         //Return Book
            System.out.print("Enter Book ID to return: ");
        int Id = sc.nextInt();

        for (Book b : books) {
            if (b.Id == Id && b.isissued) {
                b.isissued = false;
                System.out.println("Book Returned Successfully!");
                return;
            }
        }
        System.out.println("Invalid Book ID or Book not issued!");
    }
        
        
    public static void main(String[] args){
      while(true){
        System.out.println("\n===== Library Management System =====");
        System.out.println("1.Add Book");
        System.out.println("2.View Book");
        System.out.println("3.Issue Book");
        System.out.println("4.Return Book");
        System.out.println("5.EXIT");
        
        int choice=sc.nextInt();
        switch(choice){
            case 1:
                Addbook();
                break;
            case 2:
                Viewbook();
                break;
            case 3:
                issuebook();
                break;
            case 4:
                returnbook();
                break;
            case 5:
                System.out.println("Exitting! Thank You");
                return;
            default:
                System.out.println("Invalid Choice!");
        }
        
        
      }

    }
}