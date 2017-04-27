/**
 * 
 */
package servlet;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * TODO:下载文件
 * 
 * @author zhenying.diao(diaozhenying@tcl.com) 2017年4月27日
 * 
 */
public class ResponseDown extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	public void doGet(HttpServletRequest requeset,HttpServletResponse response) throws ServletException, IOException{
		downloadFile(response);
	}
	private void downloadFile(HttpServletResponse response) throws FileNotFoundException,IOException{
		String path=this.getServletContext().getRealPath("/WEB-INF/image/down.jpg");
		String fileName=path.substring(path.lastIndexOf("\\")+1);
		response.setHeader("content-disposition", "attachment;filename="+fileName);
		InputStream in=new FileInputStream(path);
		int len=0;
		byte[] buffer=new byte[1024];
		OutputStream out=response.getOutputStream();
		
		while( (len=in.read(buffer) ) >0){
			out.write(buffer,0,len);
		}
		
		in.close();
	}
	
	public void doPost(HttpServletRequest requeset,HttpServletResponse response) throws ServletException, IOException{
		doGet(requeset,response);
	}

}
