import java.util.*;
public class JsonObject{
	String name;
	JsonValue jVal;
	public JsonObject(){
		name=null;
		jVal=null;
	}
	public void add(String name,JsonValue jVal){
		this.name=name;
		this.jVal=jVal;
	}
	public JsonValue get(String name){
		if(this.name==name){
			return jVal;
		}	
		return null;
	}
	public String toString(){
		return name+jVal.toString();
	}
}
