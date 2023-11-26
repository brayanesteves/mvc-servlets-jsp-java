package Domain;

import java.sql.Time;
import java.util.Date;

public class NaturalPerson {
    
    private int    reference;
    private int    referenceNacionality;
    private int    referenceCountry;
    private String identificationDocument;
    private String names;
    private String surnames;
    private String referentialPhoneNumber;
    private String taxAddress;
    private int    condition;
    private int    removed;
    private int    locked;
    private Date   dateAdmission;
    private Time   checkTime;

    public NaturalPerson() {
    }

    public NaturalPerson(int reference) {
        this.reference = reference;
    }

    public NaturalPerson(int reference, int referenceNacionality, int referenceCountry) {
        this.reference = reference;
        this.referenceNacionality = referenceNacionality;
        this.referenceCountry = referenceCountry;
    }
    
    public NaturalPerson(int reference, int referenceNacionality, int referenceCountry, String identificationDocument, String names, String surnames, String referentialPhoneNumber, String taxAddress, int condition, int removed, int locked, Date dateAdmission, Time checkTime) {
        this.reference = reference;
        this.referenceNacionality = referenceNacionality;
        this.referenceCountry = referenceCountry;
        this.identificationDocument = identificationDocument;
        this.names = names;
        this.surnames = surnames;
        this.referentialPhoneNumber = referentialPhoneNumber;
        this.taxAddress = taxAddress;
        this.condition = condition;
        this.removed = removed;
        this.locked = locked;
        this.dateAdmission = dateAdmission;
        this.checkTime = checkTime;
    }

    public NaturalPerson(int referenceNacionality, int referenceCountry, String identificationDocument, String names, String surnames, String referentialPhoneNumber, String taxAddress, int condition, int removed, int locked, Date dateAdmission, Time checkTime) {
        this.referenceNacionality = referenceNacionality;
        this.referenceCountry = referenceCountry;
        this.identificationDocument = identificationDocument;
        this.names = names;
        this.surnames = surnames;
        this.referentialPhoneNumber = referentialPhoneNumber;
        this.taxAddress = taxAddress;
        this.condition = condition;
        this.removed = removed;
        this.locked = locked;
        this.dateAdmission = dateAdmission;
        this.checkTime = checkTime;
    }

    public NaturalPerson(String identificationDocument, String names, String surnames, String referentialPhoneNumber, String taxAddress) {
        this.identificationDocument = identificationDocument;
        this.names = names;
        this.surnames = surnames;
        this.referentialPhoneNumber = referentialPhoneNumber;
        this.taxAddress = taxAddress;
    }

    public int getReference() {
        return this.reference;
    }

    public void setReference(int reference) {
        this.reference = reference;
    }

    public int getReferenceNacionality() {
        return this.referenceNacionality;
    }

    public void setReferenceNacionality(int referenceNacionality) {
        this.referenceNacionality = referenceNacionality;
    }

    public int getReferenceCountry() {
        return this.referenceCountry;
    }

    public void setReferenceCountry(int referenceCountry) {
        this.referenceCountry = referenceCountry;
    }

    public String getIdentificationDocument() {
        return this.identificationDocument;
    }

    public void setIdentificationDocument(String identificationDocument) {
        this.identificationDocument = identificationDocument;
    }

    public String getNames() {
        return this.names;
    }

    public void setNames(String names) {
        this.names = names;
    }

    public String getSurnames() {
        return this.surnames;
    }

    public void setSurnames(String surnames) {
        this.surnames = surnames;
    }

    public String getReferentialPhoneNumber() {
        return this.referentialPhoneNumber;
    }

    public void setReferentialPhoneNumber(String referentialPhoneNumber) {
        this.referentialPhoneNumber = referentialPhoneNumber;
    }

    public String getTaxAddress() {
        return this.taxAddress;
    }

    public void setTaxAddress(String taxAddress) {
        this.taxAddress = taxAddress;
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
        return "NaturalPerson{" + "reference=" + reference + ", referenceNacionality=" + referenceNacionality + ", referenceCountry=" + referenceCountry + ", identificationDocument=" + identificationDocument + ", names=" + names + ", surnames=" + surnames + ", referentialPhoneNumber=" + referentialPhoneNumber + ", taxAddress=" + taxAddress + ", condition=" + condition + ", removed=" + removed + ", locked=" + locked + ", dateAdmission=" + dateAdmission + ", checkTime=" + checkTime + '}';
    }
    
}
