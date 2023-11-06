package com.tourbooking.model.account;

import com.tourbooking.model.tour.Tour;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "account_id")
    private int accountId;
    private String accountEmail;
    private String accountPassword;
    private String employeeName;
    @Column(columnDefinition = "varchar(10)")
    private String employeePhone;
    private int employeeGender;
    @Column(columnDefinition = "LONGTEXT")
    private String employeeImg;
    @Column(columnDefinition = "varchar(12)")
    private String employeeIdCard;
    @Column(columnDefinition = "bit(1) default 1")
    private boolean isEnabled;

    @ManyToMany
    @JoinTable(name = "account_role", joinColumns = @JoinColumn(name = "account_id"),
    inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;

    @OneToMany(mappedBy = "account", cascade = CascadeType.ALL)
    private Set<Tour> tour;
}
