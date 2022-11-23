
public class member {

	public static void main(String[] args) {
		String textMember="홍길동,광주,010-1111-1111#나길동,서울,010-22222-2222";
		
		String xmlMember="<members>"+
							"<member>"+
								"<name>홍길동</name>"+
								"<address>광주</address>"+
								"<phone>010-1111-1234</phone>"+
							"</member>"+
						 "</members>";
		
		String jsonMember="[{'name':'홍길동','address':'광주','phone':'010-1111-1234'}]";
		
		
		
		System.out.println("text_member:"+textMember);
		
		System.out.println("xmlMember:"+xmlMember);

		System.out.println("jsonMember"+jsonMember);
	}

}
