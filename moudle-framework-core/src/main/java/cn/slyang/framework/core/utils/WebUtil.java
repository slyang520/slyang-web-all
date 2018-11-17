package cn.slyang.framework.core.utils;


import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;


public class WebUtil {

	public static void writeJSONResponse(Object object, HttpServletResponse response) throws Exception {
		ObjectMapper objectMapper = new ObjectMapper();
		response.setContentType("application/json;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.print(objectMapper.writeValueAsString(object));
		out.flush();
		out.close();
	}

}
