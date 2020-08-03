package com.bezkoder.spring.jwt.mongodb.models;

import com.bezkoder.spring.jwt.mongodb.cascade.CascadeSave;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "evidence")
public class Evidence {
    @Id
    private String id;

    @CascadeSave
    @DBRef
    private CaseInformation caseInformation;

    @CascadeSave
    @DBRef
    private AssociatedPerson  associatedPerson;

    @CascadeSave
    @DBRef
    private ItemInformation itemInformation;

    private String documentPath;

    public String getDocumentPath() {
        return documentPath;
    }

    public void setDocumentPath(String documentPath) {
        this.documentPath = documentPath;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public CaseInformation getCaseInformation() {
        return caseInformation;
    }

    public void setCaseInformation(CaseInformation caseInformation) {
        this.caseInformation = caseInformation;
    }

    public AssociatedPerson getAssociatedPerson() {
        return associatedPerson;
    }

    public void setAssociatedPerson(AssociatedPerson associatedPerson) {
        this.associatedPerson = associatedPerson;
    }

    public ItemInformation getItemInformation() {
        return itemInformation;
    }

    public void setItemInformation(ItemInformation itemInformation) {
        this.itemInformation = itemInformation;
    }
}
