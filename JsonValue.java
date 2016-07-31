import java.util.*;
public class JsonValue{
	private String str;
	private JsonObject jObj;
	private JsonValue[] jArray;
	private JsonObject[] jObjArray;

	public JsonValue(String str){
		this.str=str;
		jObj=null;
		jArray=null;
		jObjArray=null;
	}
	public JsonValue(JsonObject jObj){
		this.jObj=jObj;
		str=null;
		jArray=null;
		jObjArray=null;
	}
	public JsonValue(JsonValue[] jArray){
		this.jArray=jArray;
		str=null;
		jObj=null;
		jObjArray=null;
	}
	public JsonValue(JsonObject[] jArray){
		this.jObjArray=jArray;
		str=null;
		jObj=null;
		jArray=null;
	}
	public String getString(){
		return str;
	}
	public JsonObject getObj(){
		return jObj;
	}		
	public JsonValue[] getValue(){
		return jArray;
	}
	public JsonObject[] getObjValue(){
		return jObjArray;
	}
	public String toString(){
		if(str!=null)		
			return str;
		else if(jObj!=null)
			return jObj.toString();
		else if(jArray!=null)
		{
			for(JsonValue j:jArray){
				j.toString();
			}
		}
		else if(jObjArray!=null)
		{
			for(JsonObject j:jObjArray){
				j.toString();
			}
		}
		return null;
	}
}
