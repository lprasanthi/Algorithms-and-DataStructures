import java.util.*;
import java.lang.StringBuffer;

class Attribute{
    public String key;
    public String value;
    public Attribute(String key, String value) {
        this.key=key;
        this.value=value;
    }
    public Attribute(String keyValue){
        String key[] = keyValue.split("=");
        if(key.length > 0){
            this.key = key[0];
            if(key.length >1){
                this.value = key[1];
            }else{
                this.value = "";
            }
        }
    }
    public String toString(){
        return "key: "+key+" value: "+value;
    }
}
class Element{
    public String name;
    public List<Attribute> attributes;
    public List<Element> children;
    public String body;
    public Element(){
        attributes = new ArrayList<Attribute>();
        children = new ArrayList<Element>();
    }
    public Element(String name){
        this.name = name;
        attributes = new ArrayList<Attribute>();
        children = new ArrayList<Element>();
        this.body="";
    }
    public Element(String name, List<Attribute> attributes){
        this.name = name;
        this.attributes = attributes;
        children = new ArrayList<Element>();
        this.body="";
    }
    public Element(String name, List<Attribute> attributes, List<Element> children){
        this.name = name;
        this.attributes = attributes;
        this.children = children;
        this.body="";
    }
    public String toString(){
        
        return name;
    }
}
public class XMLEncoding{
    public static Element XML(String s){
        // String tokens[] = s.split("<");
        // System.out.println(tokens.length);
        // for(int i=1; i<tokens.length; i++){
        //     Element head = new Element();
        //     List<Attribute> attributes = new ArrayList<Attribute>();
        //     String attr[] = tokens[i].split(" ");
        //     head.name = attr[0];
        //     for(int j =1; j<attr.length; j++){
        //         attributes.add(new Attribute(attr[j]));
        //     }
        //     head.attributes = attributes;
        //     System.out.print(head.name+" ");
        //     System.out.println(attributes);
        // }
        // return null;
        // int i=0;
        // while(i<s.length()){
        //     if(s.get(i) == '<'){
        //         Element root= new Element();
        //         StringBuffer sb = new StringBuffer();
        //         for(i=i+1; j<s.length() && s.get(i)!= ' '; i++){
        //             sb.append(s.get(i));
        //         }
        //         root.name= new String(sb);
        //         i++;
        //         List<Attribute> attributes = new ArrayList<Attribute>();
        //         while(s.get(i)!='>'){
        //             StringBuffer sb = new StringBuffer();
        //             for(i=i+1; j<s.length() && s.get(i)!= ' '; i++){
        //                 sb.append(s.get(i));
        //             }
        //             attributes.add(new Attribute(new String(sb)));
        //             i++;
        //         }   
        //     }
        // }
        return null;
    }
    public static Map<String, Integer> buildMap(){
        Map<String, Integer> map= new HashMap<String, Integer>();
        String a[]={"family","person","firstName","lastName","state"};
        for(int i=0; i<a.length;i++)
            map.put(a[i],i+1);
        return map;
    }
    public static Element buildElement(){
        Element root = new Element();
        List<Attribute> attributes = new ArrayList<Attribute>();
        List<Element> children = new ArrayList<Element>();
        attributes.add(new Attribute("lastName","McDowell")); 
        attributes.add(new Attribute("state","CA")); 
        root.name = "family";
        root.attributes = attributes;

        Element element1 = new Element();
        List<Attribute> attributes1 = new ArrayList<Attribute>();
        element1.name = "person";
        attributes1.add(new Attribute("firstName","Gayle"));
        element1.attributes = attributes1;
        element1.body = "Some Message";
        children.add(element1);
        root.children = children;
        return root;
    }
    public static String encodeTag(String name, Map<String,Integer> map){
        StringBuffer encodedTag=new StringBuffer();
        int code = map.getOrDefault(name, -1);
        String tag = (code != -1) ? Integer.toString(code) : name;
        encodedTag.append(tag);
        encodedTag.append(" ");
        return new String(encodedTag); 
    }
    public static String encodeAttributes(List<Attribute> attributes, Map<String,Integer> map){
        StringBuffer encodedAttributes=new StringBuffer();
        for(Attribute attribute : attributes){
            encodedAttributes.append(encodeTag(attribute.key, map));
            encodedAttributes.append(encodeTag(attribute.value, map));
        }
        return new String(encodedAttributes);   
    }
    public static String encodeElement(Element element, Map<String,Integer> map){
        StringBuffer sb= new StringBuffer();
        String tag = encodeTag(element.name, map);
        sb.append(tag);
        String attribute = encodeAttributes(element.attributes,map);
        sb.append(attribute);
        if(element.children.size() > 0){
            for(Element child: element.children)
                sb.append(encodeElement(child,map));
        }else {
            String body = encodeTag(element.body, map);
            sb.append(body);
        }
        
        sb.append(Integer.toString(0));
        sb.append(" ");
        return new String(sb);
    }
    public static void main(String[] args) {
        // String s = "<family lastName='McDowell' state='CA'><person>Hello</person></family>";
        // Element root = XML(s);
        Element root = buildElement();
        Map<String, Integer> map = buildMap();
        String s = encodeElement(root,map);
        System.out.println(s);
    }
}