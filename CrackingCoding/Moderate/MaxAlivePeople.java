import java.util.*;
class Person{
    public int birth;
    public int death;
    public Person(int birth, int death){
        this.birth=birth;
        this.death=death;
    }
}
public class MaxAlivePeople{
    public static List<Person> peopleList(){
        int births[] = {12,20,10,01,10,23,13,90,83,75};
        int deaths[] = {15,90,98,72,98,82,98,98,99,94};
        List<Person> people = new ArrayList<Person>();
        for(int i=0; i<births.length; i++)
            people.add(new Person(births[i], deaths[i]));
        return people;
    }
    public static int[] sort(List<Person> people, boolean isBirth){
        int[] sortedPeople = new int[people.size()];
        if(isBirth){
            Collections.sort(people, (a,b) -> a.birth - b.birth);
            for(int i=0; i<people.size(); i++)
                sortedPeople[i] = people.get(i).birth;
        } else {
            Collections.sort(people, (a,b) -> a.death - b.death);
            for(int i=0; i<people.size(); i++)
                sortedPeople[i] = people.get(i).death;
        }
        return sortedPeople;
    }
    public static int maxAliveYear(int[] births, int[] deaths){
        int max = 0;
        int cur=0;
        int maxYear=0;
        int birthIndex =0;
        int deathIndex=0;
        while(birthIndex < births.length) {
            if(births[birthIndex] < deaths[deathIndex]){
                cur++;
                if(cur > max){
                    max = cur;
                    maxYear = births[birthIndex];
                }
                birthIndex++;
            }else {
                cur --;
                deathIndex++;
            }
        }
        return maxYear;
    }
    public static void main(String[] args) {
        List<Person> people = peopleList();
        int births[] = sort(people,true);
        int deaths[] = sort(people,false);
        int year = maxAliveYear(births, deaths);
        System.out.println(year);
    }
}