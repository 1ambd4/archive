package lttzz.ch7.exp4;

import org.apache.commons.fileupload.DiskFileUpload;
import org.apache.commons.fileupload.FileItem;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

@WebServlet(name = "FileUploadServlet", urlPatterns = "/FileUploadServlet")
public class FileUploadServlet extends javax.servlet.http.HttpServlet {
    public FileUploadServlet() {
        super();
    }

    public void destory() {
        super.destroy();
    }

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");

        PrintWriter out = resp.getWriter();
        String uploadDir = "/home/lttzz/test/tmp";
        out.println("文件上传路径：" + uploadDir);
        File fUploadDir = new File(uploadDir);
        if (!fUploadDir.exists()) {
            out.println("无法创建存储目录：" + uploadDir);
            return ;
        }
        if (!DiskFileUpload.isMultipartContent(req)) {
            out.println("只能处理multipart/form-data类型的数据！");
            return ;
        }

        DiskFileUpload fu = new DiskFileUpload();
        // set max size of upload file.
        fu.setFileSizeMax(1024 * 1024 * 200);
        fu.setSizeThreshold(1024 * 1024);
        fu.setHeaderEncoding("utf-8");
        List fileItems = null;
        try {
            fileItems = fu.parseRequest(req);
        } catch (Exception e) {
            out.println("解析数据时出现问题:");
            e.printStackTrace();
        }

        System.out.println("file ok");

        // fetch and upload file
        Iterator it = fileItems.iterator();
        while(it.hasNext()) {
            FileItem fileItem = (FileItem) it.next();
            if (!fileItem.isFormField()) {
                try {
                    String pathSrc = fileItem.getName();
                    if (pathSrc.trim().equals("")) continue;
                    int start = pathSrc.lastIndexOf('/');
                    String fileName = pathSrc.substring(start + 1);
                    File pathDest = new File(uploadDir, fileName);
                    fileItem.write(pathDest);
                } catch (Exception e) {
                    out.println("文件存储出现问题：");
                    e.printStackTrace();
                }
                finally {
                    fileItem.delete();
                }
            }
        }

        resp.sendRedirect("./ch7/exp4/fileupload_list.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
