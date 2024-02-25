import java.util.*;
public class StudentGrade {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.println("\n");
        System.out.println("* * WELCOME TO STUDENT GRADE TRACKING PLATFORM * * ");
        System.out.println("\n");
        System.out.println("Enter the number of students in the Class: ");
        int n=sc.nextInt();
        int[] Reg_no=new int[n];
 
        int[] Grades=new int[n];
        for(int i=0;i<n;i++){
            System.out.println("Enter the Registration Number of Student "+(i+1)+": ");
            Reg_no[i]=sc.nextInt();

            System.out.println("Enter the Grade of Student "+(i+1)+": ");
            Grades[i]=sc.nextInt(); 
        }
        
        float total=0;
        for(int i=0;i<n;i++){
            total+=Grades[i];
        }
        System.out.println("Average Grade of the Class: "+(total/n));

        //Finding highest and lowest grade
        Arrays.sort(Grades);
        int Max=Grades[n-1];
        int Min=Grades[0];
        System.out.println("\nHighest Grade in the Class: "+Max);
        System.out.println("Lowest Grade in the Class: "+Min);
        sc.close();
    }
}