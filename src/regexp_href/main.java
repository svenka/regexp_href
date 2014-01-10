package regexp_href;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class main {

	public static void main(String[] args) {

		String page=loadhtml("test.htm");
		
		Pattern pattern=Pattern.compile("<a.+href=\"(.+?)\"");
		Matcher matcher=pattern.matcher(page);
		
		while(matcher.find())
		{
			
			System.out.println(matcher.group(1));
		}

	}
	
	
	private static String loadhtml(String name)
	{
		StringBuffer out=new StringBuffer();
		try{
			FileReader file=new FileReader(name);
			BufferedReader buff=new BufferedReader(file);
			boolean eof=false;
			while(!eof)
			{
				String line=buff.readLine();
				if(line==null)
					eof=true;
				
				else
					out.append(line +"\n");
			}
			buff.close();
		}

		catch(IOException e)
		{
			System.out.println("Error  "+e.toString());
		}
		
		return out.toString();
	}


	}


