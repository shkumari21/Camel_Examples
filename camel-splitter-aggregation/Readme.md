CAMEL SPLITTER AGGREGATION
===========================

To run this example:

1.mvn clean install

2.mvn compile exec:java -Dexec.mainClass=com.javainuse.aggregatesplit.DepartmentApp


O/P
------
handle employee department:Employee [empId=1, name=emp1, department=Finance, salary=0.0]
IT dept employee processed
Aggregate first employee: Employee [empId=1, name=emp1, department=Finance, salary=10000.0]
handle employee department:Employee [empId=2, name=emp2, department=IT, salary=0.0]
Finance dept employee processed
Aggregate old employees: Department, Employees=[Employee [empId=1, name=emp1, department=Finance, salary=10000.0]], totalSalary=10000.0]
Aggregate new department: Employee [empId=2, name=emp2, department=IT, salary=5000.0]
handle employee department:Employee [empId=2, name=emp3, department=IT, salary=0.0]
Finance dept employee processed
Aggregate old employees: Department, Employees=[Employee [empId=1, name=emp1, department=Finance, salary=10000.0], Employee [empId=2, name=emp2, department=IT, salary=5000.0]], totalSalary=15000.0]
Aggregate new department: Employee [empId=2, name=emp3, department=IT, salary=5000.0]
Department Details - Department, Employees=[Employee [empId=1, name=emp1, department=Finance, salary=10000.0], Employee [empId=2, name=emp2, department=IT, salary=5000.0], Employee [empId=2, name=emp3, department=IT, salary=5000.0]], totalSalary=20000.0]

