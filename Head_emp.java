import java.util.*;

interface Employee {
    void getDetails();
}

interface Manager extends Employee {
    void getDeptDetails();
}

class Head implements Manager {
    private int EmpId;
    private String Ename;
    private int DeptId;
    private String Deptname;

    public Head(int EmpId, String Ename, int DeptId, String Deptname) {
        this.EmpId = EmpId;
        this.Ename = Ename;
        this.DeptId = DeptId;
        this.Deptname = Deptname;
    }

    public void getDetails() {
        System.out.println("Employee Id = " + EmpId);
        System.out.println("Employee name = " + Ename);
    }

    public void getDeptDetails() {
        System.out.println("Department Id = " + DeptId);
        System.out.println("Department name = " + Deptname);
    }
}

public class Head_emp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Employee Id: ");
        int EmpId = sc.nextInt();
        System.out.print("Enter Employee Name: ");
        String Ename = sc.next();
        System.out.print("Enter Department Id: ");
        int DeptId = sc.nextInt();
        System.out.print("Enter Department Name: ");
        String Deptname = sc.next();
        System.out.println();

        Head ob = new Head(EmpId, Ename, DeptId, Deptname);
        ob.getDetails();
        ob.getDeptDetails();
    }
}