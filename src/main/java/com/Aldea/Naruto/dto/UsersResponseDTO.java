package com.Aldea.Naruto.dto;

public class UsersResponseDTO {
    private Long id;
    private String name_team;
    private String name_lider;
    private String name_integrante1;
    private String name_integrante2;
    private String name_integrante3;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName_team() {
        return name_team;
    }

    public void setName_team(String name_team) {
        this.name_team = name_team;
    }

    public String getName_lider() {
        return name_lider;
    }

    public void setName_lider(String name_lider) {
        this.name_lider = name_lider;
    }

    public String getName_integrante1() {
        return name_integrante1;
    }

    public void setName_integrante1(String name_integrante1) {
        this.name_integrante1 = name_integrante1;
    }

    public String getName_integrante2() {
        return name_integrante2;
    }

    public void setName_integrante2(String name_integrante2) {
        this.name_integrante2 = name_integrante2;
    }

    public String getName_integrante3() {
        return name_integrante3;
    }

    public void setName_integrante3(String name_integrante3) {
        this.name_integrante3 = name_integrante3;
    }
}
