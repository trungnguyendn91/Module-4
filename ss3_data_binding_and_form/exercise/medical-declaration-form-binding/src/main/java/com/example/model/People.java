package com.example.model;

public class MedicalDeclarant {
    private String id;
    private String name;

    public MedicalDeclarant() {
    }

    public MedicalDeclarant(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
