public class State{

    private String name = " ";
    private String capital = "";
    private String abbreviation = "";


    public State(String a, String n, String c){
        name = n;
        capital = c;
        abbreviation = a;
    }

    public String getName(){
        return name;
    }

    public String getCapital(){
        return capital;
    }

    public String getAbbreviation(){
        return abbreviation;
    }

    public String toString(){
        return name + "\n" + abbreviation + "\n" + capital;
    }
}