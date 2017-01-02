package test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.liu.ssm.pojo.ItemsCustom;
import com.liu.ssm.service.impl.ItemsServiceImpl;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/application-*.xml")
public class Test1 {
	@Autowired
	@Qualifier("itemsService")
	private ItemsServiceImpl itemsService;
	
	@Test
	public void test() throws Exception{
		System.out.println(itemsService);
//		List<ItemsCustom> lists = itemsService.findItemsList(null);
//		for(ItemsCustom i:lists)
//			System.out.println(i.getDetail());
			
	}
}
