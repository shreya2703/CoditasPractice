package org.example;

import javax.persistence.*;

@Entity
//@DiscriminatorValue("full_time")
@Table(name="full_time")
@AttributeOverrides({
        @AttributeOverride(name="id", column=@Column(name="id")),
        @AttributeOverride(name="name", column=@Column(name="name"))
})
public class FulltimeEmp extends Employee{

    private int fix_sal,extra_no_of_hrs,extra_hrs_sal;

    public FulltimeEmp(int id, String name, int fix_sal, int extra_no_of_hrs, int extra_hrs_sal) {
        super(id, name);
        this.fix_sal = fix_sal;
        this.extra_no_of_hrs = extra_no_of_hrs;
        this.extra_hrs_sal = extra_hrs_sal;
    }
}
