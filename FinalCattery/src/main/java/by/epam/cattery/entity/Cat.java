package by.epam.cattery.entity;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

public class Cat extends Entity {
    private static final long serialVersionUID = 8277026855704434661L;
    private String name;
    private String lastname;
    private Gender gender;
    private int ageMonth;
    //photo
    private String description;
    private String bodyColor;
    private String eyesColor;
    private String femaleParent;
    private String maleParent;
    private double price; // ???
    // еще два поля енамы походу


    //конструктор с парам

    public Cat() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getBodyColor() {
        return bodyColor;
    }

    public void setBodyColor(String bodyColor) {
        this.bodyColor = bodyColor;
    }

    public String getEyesColor() {
        return eyesColor;
    }

    public void setEyesColor(String eyesColor) {
        this.eyesColor = eyesColor;
    }

    public String getFemaleParent() {
        return femaleParent;
    }

    public void setFemaleParent(String femaleParent) {
        this.femaleParent = femaleParent;
    }

    public String getMaleParent() {
        return maleParent;
    }

    public void setMaleParent(String maleParent) {
        this.maleParent = maleParent;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getAgeMonth() {
        return ageMonth;
    }

    public void setAgeMonth(int ageMonth) {
        this.ageMonth = ageMonth;
    }

    @Override
    public boolean equals(Object o) {
        if ((o == null) || (getClass() != o.getClass())) return false;
        if (this == o) return true;

        Cat cat = (Cat) o;

        return new EqualsBuilder()
                .appendSuper(super.equals(o))
                .append(getPrice(), cat.getPrice())
                .append(getName(), cat.getName())
                .append(getLastname(), cat.getLastname())
                .append(getGender(), cat.getGender())
                .append(getDescription(), cat.getDescription())
                .append(getBodyColor(), cat.getBodyColor())
                .append(getEyesColor(), cat.getEyesColor())
                .append(getFemaleParent(), cat.getFemaleParent())
                .append(getMaleParent(), cat.getMaleParent())
                .append(getAgeMonth(), cat.getAgeMonth())
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .appendSuper(super.hashCode())
                .append(getName())
                .append(getLastname())
                .append(getGender())
                .append(getDescription())
                .append(getBodyColor())
                .append(getEyesColor())
                .append(getFemaleParent())
                .append(getMaleParent())
                .append(getPrice())
                .append(getAgeMonth())
                .toHashCode();
    }
}
