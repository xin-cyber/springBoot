package org.example.bean;

/**
 * @Author JX
 * @ClassName: org.example.bean.Pet
 * @Create 2023-09-17 19:51
 * @Description: TODO
 */
public class Pet {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Pet(String name) {
        this.name = name;
    }

    public Pet() {
    }
}
