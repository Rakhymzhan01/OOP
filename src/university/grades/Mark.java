package university.grades;

public class Mark {
    private double firstAttestation;
    private double secondAttestation;
    private double finalExam;

    public Mark(double firstAttestation, double secondAttestation, double finalExam) {
        this.firstAttestation = firstAttestation;
        this.secondAttestation = secondAttestation;
        this.finalExam = finalExam;
    }

    public double getFirstAttestation() {
        return firstAttestation;
    }

    public void setFirstAttestation(double firstAttestation) {
        this.firstAttestation = firstAttestation;
    }

    public double getSecondAttestation() {
        return secondAttestation;
    }

    public void setSecondAttestation(double secondAttestation) {
        this.secondAttestation = secondAttestation;
    }

    public double getFinalExam() {
        return finalExam;
    }

    public void setFinalExam(double finalExam) {
        this.finalExam = finalExam;
    }

    public double getTotalMark() {
        return firstAttestation + secondAttestation + finalExam;
    }

    public String getLiteralMark() {
        int a =  firstAttestation + secondAttestation + finalExam;
        if(a>100){String t="A";return t;}
        else if(a>=95 && a<=100){String t="A";return t;}
        else if(a>=90 && a<=94){String t="A-";return t;}
        else if(a>=85 && a<=89){String t="B+";return t;}
        else if(a>=80 && a<=84){String t="B";return t;}
        else if(a>=75 && a<=79){String t="B-";return t;}
        else if(a>=70 && a<=74){String t="C+";return t;}
        else if(a>=65 && a<=69){String t="C";return t;}
        else if(a>=60 && a<=64){String t="C-";return t;}
        else if(a>=55 && a<=59){String t="D+";return t;}
        else if(a>=50 && a<=54){String t="D";return t;}
        else {String t="F";return t;}
    }
}