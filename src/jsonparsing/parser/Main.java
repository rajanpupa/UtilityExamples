package parser;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.IOUtils;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import dto.ABC;
import dto.B;
import dto.TopObject;

public class Main {
		public static void main(String[] args) throws IOException {
			parse1("example.json");
			System.out.println(" ***************** parsing second file with insonsistency in array ***********");
			parse1("example2.json");
		}
		
		private static void parse1(String fileName) throws IOException {
			TopObject top = new TopObject();
			
			String json = readFile(fileName);
			JsonElement obj = new JsonParser().parse(json);
			JsonArray abcObjs = obj.getAsJsonObject().get("abcList").getAsJsonArray();
			
			for(int i=0; i<abcObjs.size(); i++){
				JsonElement abcObj = abcObjs.get(i);
				ABC abc = parseABC(abcObj);
				top.addAbc(abc);
			}
			
			System.out.println(top.toString());
		}

		private static ABC parseABC(JsonElement abcObj) {
			ABC abc = new ABC();
			
			String keyA = abcObj.getAsJsonObject().get("keyA").getAsString();
			abc.setKeyA(keyA);
			
			JsonElement lstB = abcObj.getAsJsonObject().get("lstB");
			if(lstB.isJsonArray()){
				System.out.println("lstb is array");
				List<B> arLstB = parseBArray(lstB);
				abc.setLstB(arLstB);
			}else{
				System.out.println("lstb is not array");
				B b = parseB(lstB);
				abc.addB(b);
			}
			
			return abc;
		}

		private static List<B> parseBArray(JsonElement lstB) {
			JsonArray arr = lstB.getAsJsonArray();
			List<B> lst = new ArrayList();
			
			for(int i=0; i<arr.size(); i++){
				JsonElement elemB = arr.get(i);
				B b = parseB(elemB);
				lst.add(b);
//				abc.addB(b);
			}
			return lst;
		}

		private static B parseB(JsonElement lstB) {
			String keyc = lstB.getAsJsonObject().get("keyC").getAsString();
			B b = new B();
			b.setKeyC(keyc);
			return b;
		}

		// read all the file, and return the string
		private static String readFile(String fileName) throws FileNotFoundException,
				IOException, UnsupportedEncodingException {
			
			InputStream fis = Main.class.getResourceAsStream(fileName);
			
			StringWriter writer = new StringWriter();
			IOUtils.copy(fis, writer);
			
			return writer.toString();
		}
}
