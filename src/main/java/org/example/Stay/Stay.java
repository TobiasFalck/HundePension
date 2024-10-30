package org.example.Stay;

public class Stay {
    private String vaccine;
    private String fleaTreatment;
    private String insurance;
    private String need;
    private int weight;
    private int duration;


    public Stay(String vaccine, String fleatreament, String insurance, String need, int weight, int duration) {
        this.vaccine = vaccine;
        this.fleaTreatment = fleatreament;
        this.insurance = insurance;
        this.need = need;
        this.weight = weight;
        this.duration = duration;
    }

    public Stay() {
        
    }

    public String getVaccine() {
        return vaccine;
    }

    public void setName(String vaccine) {
        this.vaccine = vaccine;
    }

    public String getFleaTreatment() {
        return fleaTreatment;
    }

    public void setFleaTreatment(String fleaTreatment) {
        this.fleaTreatment = fleaTreatment;
    }

    public String getInsurance() {
        return insurance;
    }

    public void setInsurance(String insurance) {
        this.insurance = insurance;
    }

    public String getNeed() {
        return need;
    }

    public void setNeed(String need) {
        this.need = need;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration)
    {
        this.duration = duration;
    }

    public void setVaccine(String string) {
    }
}