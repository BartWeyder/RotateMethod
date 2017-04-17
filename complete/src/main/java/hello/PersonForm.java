package hello;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class PersonForm {

    /*@NotNull
    @Size(min=2, max=30)
    private String name;

    @NotNull
    @Min(18)
    private Integer age;

    private String result = "dich";

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String toString() {
        return "Person(Name: " + this.name + ", Age: " + this.age + ")";
    }
    */

    private String result;

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    @NotNull
    private Double  a11, a12, a13,
            a21, a22, a23,
            a31, a32, a33,
            b1, b2, b3;

    public Double getA11() {
        return a11;
    }

    public void setA11(Double a11) {
        this.a11 = a11;
    }

    public Double getA12() {
        return a12;
    }

    public void setA12(Double a12) {
        this.a12 = a12;
    }

    public Double getA13() {
        return a13;
    }

    public void setA13(Double a13) {
        this.a13 = a13;
    }

    public Double getA21() {
        return a21;
    }

    public void setA21(Double a21) {
        this.a21 = a21;
    }

    public Double getA22() {
        return a22;
    }

    public void setA22(Double a22) {
        this.a22 = a22;
    }

    public Double getA23() {
        return a23;
    }

    public void setA23(Double a23) {
        this.a23 = a23;
    }

    public Double getA31() {
        return a31;
    }

    public void setA31(Double a31) {
        this.a31 = a31;
    }

    public Double getA32() {
        return a32;
    }

    public void setA32(Double a32) {
        this.a32 = a32;
    }

    public Double getA33() {
        return a33;
    }

    public void setA33(Double a33) {
        this.a33 = a33;
    }

    public Double getB1() {
        return b1;
    }

    public void setB1(Double b1) {
        this.b1 = b1;
    }

    public Double getB2() {
        return b2;
    }

    public void setB2(Double b2) {
        this.b2 = b2;
    }

    public Double getB3() {
        return b3;
    }

    public void setB3(Double b3) {
        this.b3 = b3;
    }

    public Double[][] generateMainArray() {
        Double[][] generatedArray = {
                {this.a11, this.a12, this.a13},
                {this.a21, this.a22, this.a23},
                {this.a31, this.a32, this.a33}
        };
        return generatedArray;
    }

    public Double[] generateBArray() {
        Double[] generatedArray = {
                this.b1,
                this.b2,
                this.b3
        };
        return generatedArray;
    }
}
