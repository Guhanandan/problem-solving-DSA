class Employee{
    int emp_id;
    String emp_name;
    String emp_address;
    float emp_salary;
    
    Employee(){
        this.emp_id = 0;
        this.emp_name = null;
        this.emp_address = null;
        this.emp_salary = 0;
    }
    Employee(int emp_id){
        this.emp_id = emp_id;
    }

    Employee(int emp_id,String emp_name){
        this.emp_id = emp_id;
        this.emp_name = emp_name;
    }
    Employee(int emp_id,String emp_name,String emp_address){
        this.emp_id = emp_id;
        this.emp_name = emp_name;
        this.emp_address = emp_address;
    }
    Employee(int emp_id,String emp_name,String emp_address,float emp_salary){
        this.emp_id = emp_id;
        this.emp_name = emp_name;
        this.emp_address = emp_address;
        this.emp_salary = emp_salary;
    }
    Employee(int emp_id,String emp_name,float emp_salary){
        this.emp_id = emp_id;
        this.emp_name = emp_name;
        this.emp_salary = emp_salary;
    }
    public void printDetails(){
        System.out.println("Employee ID : "+this.emp_id);
        System.out.println("Employee employee name : "+this.emp_name);
        System.out.println("Employee address : "+this.emp_address);
        System.out.println("Employee salary : "+this.emp_salary);
    }
}

class EpmloyeeTest{
    public static void main(String arg[]){
        Employee emp1 = new Employee(1001,"Guhanandan");
        Employee emp2 = new Employee(1002,"Naveen","05,3rd cross city,madurai");
        Employee emp3 = new Employee(1003,"Seetharaman","05,3rd cross city,madurai",30000);
        Employee emp4 = new Employee(1004,"RajKumar",30000);
        System.out.println("------->Employee 1----------");
        emp1.printDetails();
        System.out.println("------->Employee 2----------");
        emp2.printDetails();
        System.out.println("------->Employee 3----------");
        emp3.printDetails();
        System.out.println("------->Employee 4----------");
        emp4.printDetails();
    }
}