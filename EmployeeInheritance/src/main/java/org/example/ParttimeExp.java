package org.example;

import javax.persistence.*;

@Entity
//@DiscriminatorValue("part_time")
@Table(name="part_time")
@AttributeOverrides({
        @AttributeOverride(name="id", column=@Column(name="id")),
        @AttributeOverride(name="name", column=@Column(name="name"))
})
public class ParttimeExp extends Employee{


    private int hrs_sal,no_of_sal;

    public ParttimeExp(int id, String name, int hrs_sal, int no_of_sal) {
        super(id, name);
        this.hrs_sal = hrs_sal;
        this.no_of_sal = no_of_sal;
    }
}
//we use descriminator in this