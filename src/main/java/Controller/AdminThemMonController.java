package Controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import Bean.AdminBean;
import Bean.LoaiHangBean;
import Bo.LoaiHangBo;
import Bo.MonAnBo;

/**
 * Servlet implementation class AdminThemMonController
 */
@WebServlet("/AdminThemMonController")
public class AdminThemMonController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AdminThemMonController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			response.setCharacterEncoding("utf-8");
			request.setCharacterEncoding("utf-8");
			HttpSession session = request.getSession();
			AdminBean ad = (AdminBean) session.getAttribute("ad");
			if (ad != null) {
				DiskFileItemFactory fileItemFactory = new DiskFileItemFactory();
				ServletFileUpload upload = new ServletFileUpload(fileItemFactory);
				LoaiHangBo loai = new LoaiHangBo();
				ArrayList<LoaiHangBean> dsloai = null;
				dsloai = loai.getloai();
				request.setAttribute("dsloai", dsloai);
				MonAnBo mabo = new MonAnBo();
				try {
					String mamon = null, tenmon = null, maloai = null, soluong = null, gia = null, anhupload = null;

					List<FileItem> fileItems = upload.parseRequest(request);
					for (FileItem fileItem : fileItems) {
						if (!fileItem.isFormField()) {// N???u ko ph???i c??c control=>upfile l??n
							String nameimg = fileItem.getName();
							if (!nameimg.equals("")) {
								String dirUrl = request.getServletContext().getRealPath("") + "Images";
								File dir = new File(dirUrl);
								if (!dir.exists()) {// n???u ko c?? th?? m???c th?? t???o ra
									dir.mkdir();
								}
								String fileImg = dirUrl + File.separator + nameimg;
								File file = new File(fileImg);// t???o file
								try {
									fileItem.write(file);// ghi file
									anhupload = "Images/" + nameimg;
									System.out.println(anhupload);
								} catch (Exception e) {
									e.printStackTrace();
								}
							}
						} else {
							String tentk = fileItem.getFieldName();
							if (tentk.equals("txtmamon"))
								mamon = fileItem.getString("UTF-8");
							if (tentk.equals("txttenmon"))
								tenmon = fileItem.getString("UTF-8");
							if (tentk.equals("maloai"))
								maloai = fileItem.getString("UTF-8");
							if (tentk.equals("txtsoluong"))
								soluong = fileItem.getString("UTF-8");
							if (tentk.equals("txtgia"))
								gia = fileItem.getString("UTF-8");

						}
					}
					if (request.getParameter("btnBack") != null) {
						RequestDispatcher rd = request.getRequestDispatcher("AdminQuanLyMonController");
						rd.forward(request, response);
					}

					int check = mabo.addMon(mamon, tenmon, Long.parseLong(gia), Long.parseLong(soluong), maloai,
							anhupload);

					if (check == 0) {
						request.setAttribute("checkadd", check);
						RequestDispatcher rd = request.getRequestDispatcher("AdminQuanLyMonController");
						rd.forward(request, response);
					} else if (check == -1) {
						session.setAttribute("checkadd", check);
						RequestDispatcher rd = request.getRequestDispatcher("AdminQuanLyMonController");
						rd.forward(request, response);
					} else {
						request.setAttribute("tb", check);
						RequestDispatcher rd = request.getRequestDispatcher("AdminQuanLyMonController");
						rd.forward(request, response);

					}

				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}
				// RequestDispatcher rd = request.getRequestDispatcher("Admin/SuaSach.jsp");
				// rd.forward(request, response);
			} else {
				request.setAttribute("tb", "B???n c???n ????ng nh???p");
				RequestDispatcher rd = request.getRequestDispatcher("Admin/AdminLogin.jsp");
				rd.forward(request, response);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
