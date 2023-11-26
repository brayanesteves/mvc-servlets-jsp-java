package Domain;

import java.sql.Time;
import java.util.Date;

public class Person {
    
    private int  reference;
    private int  referencePerson;
    private int  referenceTypePerson;
    private int  condition;
    private int  removed;
    private int  locked;
    private Date dateAdmission;
    private Time checkTime;

    public Person() {
    }

    public Person(int reference) {
        this.reference = reference;
    }

    public Person(int reference, int referencePerson) {
        this.reference = reference;
        this.referencePerson = referencePerson;
    }

    public Person(int reference, int referencePerson, int referenceTypePerson) {
        this.reference = reference;
        this.referencePerson = referencePerson;
        this.referenceTypePerson = referenceTypePerson;
    }

    public Person(int reference, int referencePerson, int referenceTypePerson, int condition, int removed, int locked, Date dateAdmission, Time checkTime) {
        this.reference = reference;
        this.referencePerson = referencePerson;
        this.referenceTypePerson = referenceTypePerson;
        this.condition = condition;
        this.removed = removed;
        this.locked = locked;
        this.dateAdmission = dateAdmission;
        this.checkTime = checkTime;
    }

    public int getReference() {
        return this.reference;
    }

    public void setReference(int reference) {
        this.reference = reference;
    }

    public int getReferencePerson() {
        return this.referencePerson;
    }

    public void setReferencePerson(int referencePerson) {
        this.referencePerson = referencePerson;
    }

    public int getReferenceTypePerson() {
        return this.referenceTypePerson;
    }

    public void setReferenceTypePerson(int referenceTypePerson) {
        this.referenceTypePerson = referenceTypePerson;
    }

    public int getCondition() {
        return this.condition;
    }

    public void setCondition(int condition) {
        this.condition = condition;
    }

    public int getRemoved() {
        return this.removed;
    }

    public void setRemoved(int removed) {
        this.removed = removed;
    }

    public int getLocked() {
        return this.locked;
    }

    public void setLocked(int locked) {
        this.locked = locked;
    }

    public Date getDateAdmission() {
        return this.dateAdmission;
    }

    public void setDateAdmission(Date dateAdmission) {
        this.dateAdmission = dateAdmission;
    }

    public Time getCheckTime() {
        return this.checkTime;
    }

    public void setCheckTime(Time checkTime) {
        this.checkTime = checkTime;
    }

    @Override
    public String toString() {
        return "Person{" + "reference=" + reference + ", referencePerson=" + referencePerson + ", referenceTypePerson=" + referenceTypePerson + ", condition=" + condition + ", removed=" + removed + ", locked=" + locked + ", dateAdmission=" + dateAdmission + ", checkTime=" + checkTime + '}';
    }
    
}
