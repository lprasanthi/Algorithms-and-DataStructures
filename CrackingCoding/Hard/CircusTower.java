import java.util.*;
class Person implements Comparable<Person>{
    public int height;
    public int weight;
    public Person(int height, int weight){
        this.height = height;
        this.weight = weight;
    }
    public boolean isSmaller(Person person){
        return this.height < person.height && this.weight < person.weight;
    }
    @Override
    public int compareTo(Person person) { 
        int a = this.height - person.height;
        if(a == 0){
            return this.weight - person.weight;
        }
        return a;
    }
    @Override
    public String toString(){
        return "("+this.weight+", "+this.height+")";
    }

}
public class CircusTower{
    private static List<Person> longestIncresingSubsequence(List<Person> people, int[] buffer){
        List<Person> tower = new ArrayList<Person>();
        int max = Integer.MIN_VALUE;
        int index = 0;
        for(int i=0; i<people.size(); i++){
            Person current = people.get(i);
            for(int j =0; j<=i; j++){
                if(people.get(j).isSmaller(current)) {
                    buffer[i] = buffer[j] + 1;
                    if(buffer[i] > max){
                        max = buffer[i];
                        index = i;
                    }
                }
            }
        }
        Person current = people.get(index);
        for(int i=0; i<=index; i++){
            if(people.get(i).isSmaller(current)){
                tower.add(people.get(i));
            }
        }
        tower.add(current);
        return tower;
    }
    public static List<Person> buildTower(List<Person> people){
       Collections.sort(people);
       int[] buffer = new int[people.size()];
       for(int i=0; i<people.size(); i++){
         buffer[i] = 1;
       }
       return longestIncresingSubsequence(people, buffer);
    }
    public static void main(String[] args) {
        int heights[] = {5,5,7,6,4};
        int weights[] = {50,32,67,73,45};
        List<Person> people = new ArrayList<Person>();
        for(int i=0; i<heights.length;i++){
            people.add(new Person(heights[i], weights[i]));
        }
        List<Person> tower = buildTower(people);
        System.out.println(tower);
    }
}