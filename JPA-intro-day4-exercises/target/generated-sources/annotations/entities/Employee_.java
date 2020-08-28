package entities;

import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-08-28T15:52:30")
@StaticMetamodel(Employee.class)
public class Employee_ { 

    public static volatile SingularAttribute<Employee, BigDecimal> Salary;
    public static volatile SingularAttribute<Employee, String> Address;
    public static volatile SingularAttribute<Employee, String> name;
    public static volatile SingularAttribute<Employee, Integer> id;

}