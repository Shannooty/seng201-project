import java.lang.reflect.*;
import java.util.ArrayList;
import java.util.Random;

public class RandomEvent {
	
	
	private ArrayList<String> randomEvents;
	private Random randomItem;
	
	
	
	public String getRandomEvent() {
		return randomEvents.get(randomItem.nextInt(randomEvents.size()));
	}

	public void runRandomEvent() {
		String randomEvent = getRandomEvent();
		String thing = "MonsterLeaves";
				
		MonsterLeaves leaves = new MonsterLeaves();
		
		String Param1Type = "String";
		String Param2Type = "String";
		String className = "Class1";
		Class cl = Class.forName(className);
		Constructor con = cl.getConstructor(Param1Type.class, Param2Type.class);
		Object xyz = con.newInstance(param1, param2);

//		might be helpful:
//		https://stackoverflow.com/questions/7495785/java-how-to-instantiate-a-class-from-string
		
		
	}
	
	
	
}
