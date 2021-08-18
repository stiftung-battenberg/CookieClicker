package Polymorph;

class showSample {

    public showSample() {
        Medium[] medium = {new Buch(), new CD(), new DVD(), new GAME()};
        for (Medium value : medium) {
            value.sample();
            value.vorhanden();
        }
    }

    public static void main(String[] args) {
        new showSample();
    }
}

class Medium {
    void sample(){
        System.out.println("sample");
    }

    public boolean vorhanden() {
        return false;
    }
}

class Buch extends Medium {
    @Override
    void sample() {
        System.out.println("sampleBuch");
    }
}

class CD extends Medium {
    @Override
    void sample() {
        System.out.println("sampleCD");
    }
}

class DVD extends Medium {
    @Override
    void sample() {
        System.out.println("sampleDVD");
    }
}
class GAME extends Medium{
    @Override
    void sample() {
        System.out.println("sampleGAME");
    }

    public boolean vorhanden(){
        return true;
    }
}