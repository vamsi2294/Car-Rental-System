<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.io.InputStream"%>
<%@page import="java.sql.Blob"%>
<%@page import="Item.Item"%>
<%@page import="java.util.List"%>
<%@page import="Item.CommonUtils" %>

<%
               int item_id = Integer.parseInt(request.getParameter("item"));
                Connection conn = CommonUtils.getConnection();                               
                String sql = "select image from items where item_id=(?)";
                PreparedStatement ps=conn.prepareStatement(sql);     
                ps.setInt(1, item_id);
                ResultSet rs=ps.executeQuery();
                Blob blob=null;
                while(rs.next()){
                blob = rs.getBlob("image");
                }
                byte byteArray[] = blob.getBytes(1, (int)blob.length());
                
                ServletOutputStream o = response.getOutputStream();
                response.setContentType("image/jpg");
                InputStream in = blob.getBinaryStream();
                int length = (int) blob.length();
                int bufferSize = 100;
                byte[] buffer = new byte[bufferSize];
                while ((length = in.read(buffer)) != -1) {
                o.write(buffer, 0, length);
                }
                o.flush(); 
                in.close();
                o.close();
            %>  
