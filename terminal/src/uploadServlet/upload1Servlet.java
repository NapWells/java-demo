package uploadServlet;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import db.DBconnect;

/**
 * Servlet implementation class upload1Servlet
 */
@WebServlet("/upload1Servlet")
public class upload1Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public upload1Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		DBconnect course2 = new DBconnect("jdbc:oracle:thin:@localhost:1521:orcl","jsp","000000");
		course2.creatConnection();
		
		String filepath="";
		String []formname=new String[4];
		int i=0;
		String date=null;
		String adjunctname=null;
		String fileDir =getServletContext().getRealPath("/upload");
		System.out.println(fileDir);
		String address="";
		if (!(new File(fileDir).isDirectory()))
				new File(fileDir).mkdir();
		if(ServletFileUpload.isMultipartContent(request)){
			DiskFileItemFactory factory = new DiskFileItemFactory();
			factory.setSizeThreshold(20*1024);
			ServletFileUpload upload = new ServletFileUpload(factory);
			int size = 1000*1024*1024;
			List formlists=null;
			try {
				formlists = upload.parseRequest(request);
			} catch (FileUploadException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			Iterator iter = formlists.iterator();
			while(iter.hasNext()){
				FileItem formitem = (FileItem)iter.next();
				if(!formitem.isFormField()){
					String name = formitem.getName();
					if(formitem.getSize()>size){
						break;
					}
					
					String adjunctsize = new Long(formitem.getSize()).toString();// 获取上传文件的大小
					if((name ==null)||(name.equals("")&&adjunctsize.equals("0")))
						continue;
					adjunctname = name.substring(name.lastIndexOf("\\")+1,name.length());
					address = fileDir+"\\"+adjunctname;
					File saveFile = new File(address);
					try{
						formitem.write(saveFile);
						filepath = "upload/" + adjunctname;
						SimpleDateFormat df = new SimpleDateFormat("yyyy年MM月dd日 hh:mm:ss");
						date=df.format(new Date());
					}catch(Exception e){
						e.printStackTrace();
					}
				}else{
					
					String name = formitem.getFieldName();
					  //解决普通输入项的数据的中文乱码问题
					 String value = formitem.getString("UTF-8");
					 //System.out.println(name+ "="+value);
					 formname[i]=value;
					 //System.out.println(formname[i]);
					 i++;
				}
			}
			for(int j=0;j<formname.length;j++){
				System.out.println(formname[j]);
			}
			System.out.println(date);
			System.out.println(filepath);
			System.out.println(adjunctname);
			System.out.println("insert into course2(course,name,price,chapter,path,uploadtime,filename) values"
					+ "('"+formname[3]+"','"+formname[0]+"',"+Integer.parseInt(formname[2])+",'"+formname[1]+"','"+filepath+"','"+date+",'"+adjunctname+"')");
			course2.update("insert into course2(course,name,price,chapter,path,uploadtime,filename) values"
					+ "('"+formname[3]+"','"+formname[0]+"',"+Integer.parseInt(formname[2])+",'"+formname[1]+"','"+filepath+"','"+date+"','"+adjunctname+"')");
			request.setAttribute("course", formname[3]);
			RequestDispatcher requestDispatcher = request
					.getRequestDispatcher("upload1.jsp");
			requestDispatcher.forward(request, response);
		}
	}

}
