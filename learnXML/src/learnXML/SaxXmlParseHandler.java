package learnXML;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class SaxXmlParseHandler extends DefaultHandler{
	Map<String, String> map =null;
	List<Map<String,String>> lists = null;
	//当前标签
	String currentTag = null;
	//当前元素值
	String currentValue = null;
	
	//开始解析的元素
	String nodeName = null;
	public SaxXmlParseHandler(String nodeName){
		this.nodeName = nodeName;
	}
	public List<Map<String,String>> getList(){
		return lists;
	}
	//开始解析
	@Override
	public void startDocument() throws SAXException {
		System.out.println("StartXML");
		lists = new ArrayList<>();
	}
	

	//每个元素开始解析的时候
	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		//判断当前元素是不是要开始解析的
		if(qName.equals(nodeName)){
			map = new HashMap<>();
		}
		//读取属性
		if(attributes != null && map != null){
			for(int i = 0; i < attributes.getLength(); i++){
				map.put(attributes.getQName(i), attributes.getValue(i));
				System.out.println("+++++++"+ attributes.getQName(i)+":"+ attributes.getValue(i));
			}
		}
		currentTag = qName;
		
	}
	
	//解析到每个元素的内容调用
	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		if(currentTag != null && map != null){
			currentValue = new String(ch,start,length);
			//空格和换行去掉
			if(currentValue != null && !currentValue.trim().equals("") && !currentValue.trim().equals("\n")){
				map.put(currentTag, currentValue);
				System.out.println("----"+ currentTag+":"+ currentValue);
			}
			currentTag = null;
			currentValue = null;
		}
	}
	//每个节点的元素结束的时候
	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		
		if(qName.equals(nodeName)){
 			lists.add(map);
 			map = null;
			System.out.println("---------------");
		}
	}


	//当文件读取结束的时候
	@Override
	public void endDocument() throws SAXException {
		System.out.println("end--------------------");
		super.endDocument();
	}



	
}
