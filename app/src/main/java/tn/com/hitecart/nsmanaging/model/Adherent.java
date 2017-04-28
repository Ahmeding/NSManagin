package tn.com.hitecart.nsmanaging.model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Created by dellcapo on 26/04/17.
 */
@DatabaseTable(tableName = "adherent")
public class Adherent {

   @DatabaseField(generatedId = true)
    private int _id;
    @DatabaseField(columnName = "name")
    private String nameAdherent;
    @DatabaseField(columnName = "lastename")
    private String lastnameAdherent;
    @DatabaseField(columnName = "age")
    private int age;
    @DatabaseField(columnName = "proffesion")
    private String profession;
    @DatabaseField(columnName = "address")
    private String address;
    @DatabaseField(columnName = "email")
    private String email;
    @DatabaseField(columnName = "grade")
    private String grade;
    @DatabaseField(columnName = "inscritDate")
    private String inscritDate;
    @DatabaseField(columnName = "phone")
    private String phoneNum;

    public Adherent() {
    }

 public Adherent(String nameAdherent, String lastnameAdherent, int age, String profession, String address, String email, String grade, String inscritDate, String phoneNum) {
  this.nameAdherent = nameAdherent;
  this.lastnameAdherent = lastnameAdherent;
  this.age = age;
  this.profession = profession;
  this.address = address;
  this.email = email;
  this.grade = grade;
  this.inscritDate = inscritDate;
  this.phoneNum = phoneNum;
 }

 public int get_id() {
  return _id;
 }

 public void set_id(int _id) {
  this._id = _id;
 }

 public String getNameAdherent() {
  return nameAdherent;
 }

 public void setNameAdherent(String nameAdherent) {
  this.nameAdherent = nameAdherent;
 }

 public String getLastnameAdherent() {
  return lastnameAdherent;
 }

 public void setLastnameAdherent(String lastnameAdherent) {
  this.lastnameAdherent = lastnameAdherent;
 }

 public int getAge() {
  return age;
 }

 public void setAge(int age) {
  this.age = age;
 }

 public String getProfession() {
  return profession;
 }

 public void setProfession(String profession) {
  this.profession = profession;
 }

 public String getAddress() {
  return address;
 }

 public void setAddress(String address) {
  this.address = address;
 }

 public String getEmail() {
  return email;
 }

 public void setEmail(String email) {
  this.email = email;
 }

 public String getGrade() {
  return grade;
 }

 public void setGrade(String grade) {
  this.grade = grade;
 }

 public String getInscritDate() {
  return inscritDate;
 }

 public void setInscritDate(String inscritDate) {
  this.inscritDate = inscritDate;
 }

 public String getPhoneNum() {
  return phoneNum;
 }

 public void setPhoneNum(String phoneNum) {
  this.phoneNum = phoneNum;
 }
}
