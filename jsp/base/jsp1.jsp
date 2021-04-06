<%@ page contentType="text/html;charset=utf-8"%>

<%!
    public void jspInit(){ //첫번째 요청에의해 메모리에 올라갈 때 
		System.out.println("jspInit() 호출");
    } 
	public void jspDestroy(){//메모리에 올라갈 때( 페이지가 갱신, 서버에 정책 )
		System.out.println("jspDestroy() 호출");
    } 
%>

<%  //요청할 때 마다 
    System.out.println("_jspService() 호출");
%>