package entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-08-28T13:51:31")
@StaticMetamodel(BankCustomer.class)
public class BankCustomer_ { 

    public static volatile SingularAttribute<BankCustomer, String> firstName;
    public static volatile SingularAttribute<BankCustomer, String> lastName;
    public static volatile SingularAttribute<BankCustomer, Integer> customerRanking;
    public static volatile SingularAttribute<BankCustomer, Double> balance;
    public static volatile SingularAttribute<BankCustomer, Integer> id;
    public static volatile SingularAttribute<BankCustomer, String> accountNumber;
    public static volatile SingularAttribute<BankCustomer, String> internalInfo;

}