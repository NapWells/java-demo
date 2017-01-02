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
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import db.DBconnect;

/**
 * Servlet implementation class uploadServlet
 */
@WebServlet("/uploadServlet")
public class uploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public uploadServlet() {
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
		DBconnect course1 = new DBconnect("jdbc:oracle:thin:@localhost:1521:orcl","jsp","000000");
		course1.creatConnection();
		
		HttpSession session = request.getSession();
		String author =  (String) session.getAttribute("user");
		String filepath="";
		String []formname=new String[7];
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
			int size = 5*1024*1024;
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
						System.out.println(filepath);
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
			course1.update("insert into course1(course,author,logo,uploadtime,sort,difficult,charge,coursehour,label,courseintro) values"
					+ "('"+formname[0]+"','"+author+"','"+filepath+"','"+date+"','"+formname[1]+"','"+formname[2]+"','"+formname[3]+"'"
							+ ",'"+formname[4]+"','"+formname[5]+"','"+formname[6]+"')");
			course1.close();
			request.setAttribute("course", formname[0]);
		}
		course1.close();
		RequestDispatcher requestDispatcher = request
				.getRequestDispatcher("upload1.jsp");
		requestDispatcher.forward(request, response);
	}

}
