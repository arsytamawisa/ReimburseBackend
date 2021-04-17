package com.enigma.reimbursment.online.entities;

import com.enigma.reimbursment.online.enums.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDate;

@Table(name = "employee")
@Entity
public class Employee extends AbstractEntity <String>{

    @Id
    @GenericGenerator(name="id",strategy = "uuid2")
    @GeneratedValue(generator = "id",strategy = GenerationType.IDENTITY)
    private String id;

    @OneToOne
    @JoinColumn(name = "id_login")
    private Login login;

    @Column
    private String fullname;

    @Enumerated(EnumType.STRING)
    @Column
    private Gender gender;

    @Column
    private String nik;

    @Column
    private String nip;

    @Column(name = "emergency_number")
    private String emergencyNumber;

    @Enumerated(EnumType.STRING)
    @Column(name = "employee_status")
    private EmployeeStatus employeeStatus;

    @Enumerated(EnumType.STRING)
    @Column(name = "employee_type")
    private EmployeeType employeeType;

    @Column
    private String npwp;

    public Employee(String id) {
        this.id = id;
    }

    public Employee() {
    }

    @OneToOne
    @JoinColumn(name = "grade_id")
    private Grade grade;

    @Enumerated(EnumType.STRING)
    @Column
    private Religion religion;

    @Enumerated(EnumType.STRING)
    @Column(name = "blood_type")
    private BloodType  bloodType;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "account_number")
    private String accountNumber;

    @Column(name = "account_name") //Nama Rekening Bank
    private String accountName;

    @Column(name = "place_of_birth")
    private String placeOfBirth;

    @Column(name = "date_of_birth")
    private LocalDate dateOfBirth;

    @Enumerated(EnumType.STRING)
    @Column(name = "marital_status")
    private MaritalStatus maritalStatus;

    @Column(name = "number_of_children")
    private Integer numberOfChildren;

    @Column(name = "join_date")
    private LocalDate joinDate;

    @Column(name = "biological_mother_name")
    private String biologicalMothersName;

    @Column(name = "spouse_name")
    private String spouseName;

    @Column(name = "email_verification_token")
    private String emailVerificationToken;

    @Column(name = "is_verified_email")
    private Boolean isVerifiedEmail = false;

    @Column(name = "ktp_address")
    private String ktpAddress;

    @Column(name = "npwp_address")
    private String npwpAddress;

    @Column(name = "residence_address")
    private String residenceAddress;

    @Column(name = "postal_code_of_id_card")
    private String postalCodeOfIdCard;

    @Column(name = "is_verified_hc")
    private Boolean isVerifiedHc = false;

    @Override
    public String toString() {
        return "Employee{" +
                "id='" + id + '\'' +
                ", login=" + login +
                ", fullname='" + fullname + '\'' +
                ", gender=" + gender +
                ", nik='" + nik + '\'' +
                ", nip='" + nip + '\'' +
                ", emergencyNumber='" + emergencyNumber + '\'' +
                ", employeeStatus=" + employeeStatus +
                ", employeeType=" + employeeType +
                ", npwp='" + npwp + '\'' +
                ", grade=" + grade +
                ", religion=" + religion +
                ", bloodType=" + bloodType +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", accountNumber='" + accountNumber + '\'' +
                ", accountName='" + accountName + '\'' +
                ", placeOfBirth='" + placeOfBirth + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", maritalStatus=" + maritalStatus +
                ", numberOfChildren=" + numberOfChildren +
                ", joinDate=" + joinDate +
                ", biologicalMothersName='" + biologicalMothersName + '\'' +
                ", spouseName='" + spouseName + '\'' +
                ", emailVerificationToken='" + emailVerificationToken + '\'' +
                ", isVerifiedEmail=" + isVerifiedEmail +
                ", ktpAddress='" + ktpAddress + '\'' +
                ", npwpAddress='" + npwpAddress + '\'' +
                ", residenceAddress='" + residenceAddress + '\'' +
                ", postalCodeOfIdCard='" + postalCodeOfIdCard + '\'' +
                ", isVerifiedHc=" + isVerifiedHc +
                ", isCompleted=" + isCompleted +
                '}';
    }

    public Boolean getCompleted() {
        return isCompleted;
    }

    public void setCompleted(Boolean completed) {
        isCompleted = completed;
    }

    @Column(name = "is_completed")
    private Boolean isCompleted = false;

    /* Getter & Setter */
    @Override
    public String getId() {
        return id;
    }

    @Override
    public void setId(String id) {
        this.id = id;
    }

    public Login getLogin() {
        return login;
    }

    public void setLogin(Login login) {
        this.login = login;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getNik() {
        return nik;
    }

    public void setNik(String nik) {
        this.nik = nik;
    }

    public String getNip() {
        return nip;
    }

    public void setNip(String nip) {
        this.nip = nip;
    }

    public String getEmergencyNumber() {
        return emergencyNumber;
    }

    public void setEmergencyNumber(String emergencyNumber) {
        this.emergencyNumber = emergencyNumber;
    }

    public EmployeeStatus getEmployeeStatus() {
        return employeeStatus;
    }

    public void setEmployeeStatus(EmployeeStatus employeeStatus) {
        this.employeeStatus = employeeStatus;
    }

    public EmployeeType getEmployeeType() {
        return employeeType;
    }

    public void setEmployeeType(EmployeeType employeeType) {
        this.employeeType = employeeType;
    }

    public String getNpwp() {
        return npwp;
    }

    public void setNpwp(String npwp) {
        this.npwp = npwp;
    }

    public Grade getGrade() {
        return grade;
    }

    public void setGrade(Grade grade) {
        this.grade = grade;
    }

    public Religion getReligion() {
        return religion;
    }

    public void setReligion(Religion religion) {
        this.religion = religion;
    }

    public BloodType getBloodType() {
        return bloodType;
    }

    public void setBloodType(BloodType bloodType) {
        this.bloodType = bloodType;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getPlaceOfBirth() {
        return placeOfBirth;
    }

    public void setPlaceOfBirth(String placeOfBirth) {
        this.placeOfBirth = placeOfBirth;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public MaritalStatus getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(MaritalStatus maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public Integer getNumberOfChildren() {
        return numberOfChildren;
    }

    public void setNumberOfChildren(Integer numberOfChildren) {
        this.numberOfChildren = numberOfChildren;
    }

    public LocalDate getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(LocalDate joinDate) {
        this.joinDate = joinDate;
    }

    public String getBiologicalMothersName() {
        return biologicalMothersName;
    }

    public void setBiologicalMothersName(String biologicalMothersName) {
        this.biologicalMothersName = biologicalMothersName;
    }

    public String getSpouseName() {
        return spouseName;
    }

    public void setSpouseName(String spouseName) {
        this.spouseName = spouseName;
    }

    public String getEmailVerificationToken() {
        return emailVerificationToken;
    }

    public void setEmailVerificationToken(String emailVerificationToken) {
        this.emailVerificationToken = emailVerificationToken;
    }

    public Boolean getVerifiedEmail() {
        return isVerifiedEmail;
    }

    public void setVerifiedEmail(Boolean verifiedEmail) {
        isVerifiedEmail = verifiedEmail;
    }

    public String getKtpAddress() {
        return ktpAddress;
    }

    public void setKtpAddress(String ktpAddress) {
        this.ktpAddress = ktpAddress;
    }

    public String getNpwpAddress() {
        return npwpAddress;
    }

    public void setNpwpAddress(String npwpAddress) {
        this.npwpAddress = npwpAddress;
    }

    public String getResidenceAddress() {
        return residenceAddress;
    }

    public void setResidenceAddress(String residenceAddress) {
        this.residenceAddress = residenceAddress;
    }

    public String getPostalCodeOfIdCard() {
        return postalCodeOfIdCard;
    }

    public void setPostalCodeOfIdCard(String postalCodeOfIdCard) {
        this.postalCodeOfIdCard = postalCodeOfIdCard;
    }

    public Boolean getVerifiedHc() {
        return isVerifiedHc;
    }

    public void setVerifiedHc(Boolean verifiedHc) {
        isVerifiedHc = verifiedHc;
    }

}