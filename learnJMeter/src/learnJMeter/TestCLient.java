package learnJMeter;

import org.apache.jmeter.protocol.java.sampler.AbstractJavaSamplerClient;
import org.apache.jmeter.protocol.java.sampler.JavaSamplerContext;
import org.apache.jmeter.samplers.SampleResult;

public class TestCLient extends AbstractJavaSamplerClient{
	@Override
	public SampleResult runTest(JavaSamplerContext arg0) { 

		SampleResult sr = new SampleResult(); 
		 try {  
             // Start  
             sr.sampleStart();  
             /** 
              * Start~End内的代码会被JMeter 
              * 纳入计算吞吐量的范围内,为了使 
              * 性能结果合理,无关代码不必放此 
              */  
             System.out.println(Client.n);
             Client.doIt();
             System.out.println("-----------------------------------------------");
             /** 
              * True/False可按测试逻辑传值 
              * JMeter会对失败次数做出统计 
              */  
             sr.setSuccessful(true);  
             // End  
            
     } catch (Exception e) {  
             e.printStackTrace();  
     } finally{
    	 sr.sampleEnd();  
     }

     return sr;  
	}
	

}
