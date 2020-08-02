package com.bezkoder.spring.jwt.mongodb.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "itemInformation")
public class ItemInformation {

    @Id
    private String id;

    private String details;
    private String recoveryLocation;
    private String itemStatus;
    private String itemType;
    private String itemDescription;
    private String finalDisposition;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getRecoveryLocation() {
        return recoveryLocation;
    }

    public void setRecoveryLocation(String recoveryLocation) {
        this.recoveryLocation = recoveryLocation;
    }

    public String getItemStatus() {
        return itemStatus;
    }

    public void setItemStatus(String itemStatus) {
        this.itemStatus = itemStatus;
    }

    public String getItemType() {
        return itemType;
    }

    public void setItemType(String itemType) {
        this.itemType = itemType;
    }

    public String getItemDescription() {
        return itemDescription;
    }

    public void setItemDescription(String itemDescription) {
        this.itemDescription = itemDescription;
    }

    public String getFinalDisposition() {
        return finalDisposition;
    }

    public void setFinalDisposition(String finalDisposition) {
        this.finalDisposition = finalDisposition;
    }
}
