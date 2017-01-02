package learnXML;

import java.util.List;
import java.util.Map;

public class TestSaxXml {
	
	public static void main(String[] args) {
		try{
			List<Map<String,String>> lists = SaxService.readXml("sample.xml","student");

			for(Map<String,String> map : lists){
				System.out.println(map);
			}
		}catch(Exception e){
			
		}
	}

}
